package com.im.lottery.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.im.lottery.entity.Record;
import com.im.lottery.persistence.PrizeMapper;
import com.im.lottery.persistence.RecordMapper;
import com.im.lottery.req.FillInfomationReq;
import com.im.lottery.req.FindPageReq;
import com.im.lottery.req.LotteryReq;
import com.im.lottery.resp.FindAllRecordResp;
import com.im.lottery.resp.LotteryResp;
import com.im.lottery.resp.Response;
import com.im.lottery.service.LotteryService;
import com.im.lottery.utils.LotteryUtil;
import com.im.lottery.utils.ResponseUtil;
import com.im.lottery.utils.SignCheckUtil;

@Service("lotteryService")
public class LotteryServiceImpl implements LotteryService {
	@Value("${MD5.ATTACH}")
	private String attach;
	@Autowired
	private RedisTemplate<String, Object> redis;
	@Autowired
	private RecordMapper recordMapper;
	@Autowired
	private PrizeMapper prizeMapper;

	@Override
	public Response lottery(LotteryReq lotteryReq) {
		// TODO Auto-generated method stub
		if(!SignCheckUtil.check(lotteryReq.getSign(),attach,lotteryReq.getLotteryTime())){
			return ResponseUtil.createSignErrorResult();
		}
		Record record=new Record();
		record.setStatus(1);
		record.setAddTime(Timestamp.valueOf(LocalDateTime.now()));
		redis.opsForList().rightPush("t_lottery", record);
		if(redis.opsForList().size("t_lottery")>0){
			Record r=(Record) redis.opsForList().leftPop("t_lottery");
			r=LotteryUtil.lotteryDistribution(r);
			for(int i=r.getPrizeId();i<7;i++){
				if(checkInventory(i)){
					try {
						recordMapper.insert(r);
						prizeMapper.minusInventort(i);
						LotteryResp lotteryResp=new LotteryResp();
						lotteryResp.setResultCode("1");
						lotteryResp.setResultMessage("成功");
						lotteryResp.setRecord(r);
						lotteryResp.setPrize(prizeMapper.findById(i));
						return lotteryResp;		
					} catch (Exception e) {
						// TODO: handle exception
						TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
						return ResponseUtil.createUnknownResult(e.getMessage());
					}
				}
			}
			return new Response("0005", "奖品已分发完");
		}else {
			return ResponseUtil.createUnknownResult("系统繁忙请稍后");
		}
	}
	public boolean checkInventory(int prizeId){
		if(prizeMapper.getInventory(prizeId).getInventory()>0){
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Response fillInfomation(FillInfomationReq fillInfomationReq) {
		// TODO Auto-generated method stub
		if(!SignCheckUtil.check(fillInfomationReq.getSign(),attach,fillInfomationReq.getRecordId()+"")){
			return ResponseUtil.createSignErrorResult();
		}
		Record record=recordMapper.findById(fillInfomationReq.getRecordId());
		if(record!=null){
			record.setName(fillInfomationReq.getName());
			record.setPhone(fillInfomationReq.getPhone());
			record.setStatus(2);
			record.setAddress(fillInfomationReq.getAddress());
			record.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
			recordMapper.update(record);
			return ResponseUtil.createSuccessResponseResult();
		}else {
			return ResponseUtil.createUSERNOTEXISTResult("该获奖记录不存在");
		}
	}
	@Override
	public Response findAll(FindPageReq findPageReq) {
		// TODO Auto-generated method stub
		if(!SignCheckUtil.check(findPageReq.getSign(),attach,findPageReq.getQueryTime())){
			return ResponseUtil.createSignErrorResult();
		}
		FindAllRecordResp findAllRecordResp=new FindAllRecordResp();
		Page<Record> pages=PageHelper.startPage(findPageReq.getIndex(), findPageReq.getPageSize())
				.doSelectPage(()->recordMapper.findAll());
		findAllRecordResp.setRecords(pages);
		findAllRecordResp.setPageNum(pages.getPages());
		findAllRecordResp.setResultCode("1");
		findAllRecordResp.setResultMessage("成功");
		return findAllRecordResp;
	}

}
