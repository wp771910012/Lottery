package com.im.lottery.service.impl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.im.lottery.entity.Prize;
import com.im.lottery.persistence.PrizeMapper;
import com.im.lottery.req.CreatePrizeReq;
import com.im.lottery.req.DeletePrizeReq;
import com.im.lottery.req.FindAllReq;
import com.im.lottery.req.FindPrizeByIdReq;
import com.im.lottery.req.UpdatePrizeReq;
import com.im.lottery.resp.FindAllPrizeResp;
import com.im.lottery.resp.FindOnePrizeResp;
import com.im.lottery.resp.Response;
import com.im.lottery.service.PrizeService;
import com.im.lottery.utils.ResponseUtil;
import com.im.lottery.utils.SignCheckUtil;
@Service("prizeService")
public class PrizeServiceImpl implements PrizeService {
	@Autowired
	private PrizeMapper prizeMapper;
	@Value("${MD5.ATTACH}")
	private String attach;


	@Override
	public Response InsertPrize(CreatePrizeReq createPrizeReq) {
		// TODO Auto-generated method stub
		if(!SignCheckUtil.check(createPrizeReq.getSign(),attach,createPrizeReq.getName())){
			return ResponseUtil.createSignErrorResult();
		}
		Prize prize=new Prize();
		prize.setName(createPrizeReq.getName());
		prize.setDetail(createPrizeReq.getDetail());
		prize.setText(createPrizeReq.getText());
		prize.setInventory(createPrizeReq.getInventory());
		prize.setStatus(1);
		prize.setAddTime(Timestamp.valueOf(LocalDateTime.now()));
		if(prizeMapper.insert(prize)==1){
			return ResponseUtil.createSuccessResponseResult();
		}else{
			return ResponseUtil.createUnknownResult();
		}
	}


	@Override
	public Response delete(DeletePrizeReq deletePrizeReq) {
		// TODO Auto-generated method stub
		if(!SignCheckUtil.check(deletePrizeReq.getSign(),attach,deletePrizeReq.getPrizeId()+"")){
			return ResponseUtil.createSignErrorResult();
		}
		int flag=prizeMapper.delete(deletePrizeReq.getPrizeId());
		if(flag==1){
			return ResponseUtil.createSuccessResponseResult();
		}else if(flag==0){
			return ResponseUtil.createUSERNOTEXISTResult("该奖品不存在");
		}else{
			return ResponseUtil.createUnknownResult();
		}
	}


	@Override
	public Response update(UpdatePrizeReq updatePrizeReq) {
		// TODO Auto-generated method stub
		if(!SignCheckUtil.check(updatePrizeReq.getSign(),attach,updatePrizeReq.getName())){
			return ResponseUtil.createSignErrorResult();
		}
		Prize prize=new Prize();
		prize.setPrizeId(updatePrizeReq.getPrizeId());
		prize.setName(updatePrizeReq.getName());
		prize.setDetail(updatePrizeReq.getDetail());
		prize.setText(updatePrizeReq.getText());
		prize.setInventory(updatePrizeReq.getInventory());
		prize.setStatus(1);
		prize.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
	    int flag=prizeMapper.update(prize);
	    if(flag==1){
			return ResponseUtil.createSuccessResponseResult();
		}else if(flag==0){
			return ResponseUtil.createUSERNOTEXISTResult("该奖品不存在");
		}else{
			return ResponseUtil.createUnknownResult();
		}
	}


	@Override
	public Response findAll(FindAllReq findAllReq) {
		// TODO Auto-generated method stub
		if(!SignCheckUtil.check(findAllReq.getSign(),attach,findAllReq.getQueryTime())){
			return ResponseUtil.createSignErrorResult();
		}
		FindAllPrizeResp response=new FindAllPrizeResp();
		response.setResultCode("1");
		response.setResultMessage("成功");
		response.setPrizes(prizeMapper.findAll());	
		return response;
	}


	@Override
	public Response findById(FindPrizeByIdReq findPrizeByIdReq) {
		// TODO Auto-generated method stub
		if(!SignCheckUtil.check(findPrizeByIdReq.getSign(),attach,findPrizeByIdReq.getPrizeId()+"")){
			return ResponseUtil.createSignErrorResult();
		}
		FindOnePrizeResp response=new FindOnePrizeResp();
		response.setResultCode("1");
		response.setResultMessage("成功");
		response.setPrize(prizeMapper.findById(findPrizeByIdReq.getPrizeId()));	
		return response;
	}


}
