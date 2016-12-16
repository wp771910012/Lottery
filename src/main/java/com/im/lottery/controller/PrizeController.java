package com.im.lottery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.im.lottery.req.CreatePrizeReq;
import com.im.lottery.req.DeletePrizeReq;
import com.im.lottery.req.FillInfomationReq;
import com.im.lottery.req.FindAllReq;
import com.im.lottery.req.FindPageReq;
import com.im.lottery.req.FindPrizeByIdReq;
import com.im.lottery.req.LotteryReq;
import com.im.lottery.req.UpdatePrizeReq;
import com.im.lottery.resp.Response;
import com.im.lottery.service.LotteryService;
import com.im.lottery.service.PrizeService;

@RestController
public class PrizeController {
	@Autowired
	private PrizeService prizeService;
	@Autowired
	private LotteryService lotteryService;
	
	@RequestMapping(value="/createPrize",method=RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public Response createPrize(@RequestBody CreatePrizeReq createPrizeReq){
		return prizeService.InsertPrize(createPrizeReq);
	}
	@RequestMapping(value="/deletePrize",method=RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public Response deletePrize(@RequestBody DeletePrizeReq deletePrizeReq){
		return prizeService.delete(deletePrizeReq);
	}
	@RequestMapping(value="/updatePrize",method=RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public Response updatePrize(@RequestBody UpdatePrizeReq updatePrizeReq){
		return prizeService.update(updatePrizeReq);
	}
	@RequestMapping(value="/findAllPrize",method=RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public Response findAllPrize(@RequestBody FindAllReq findAllReq){
		return prizeService.findAll(findAllReq);
	}
	@RequestMapping(value="/FindPrizeById",method=RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public Response FindPrizeById(@RequestBody FindPrizeByIdReq FindPrizeByIdReq){
		return prizeService.findById(FindPrizeByIdReq);
	}
	@RequestMapping(value="/lottery",method=RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public Response lottery(@RequestBody LotteryReq lotteryReq){
		return lotteryService.lottery(lotteryReq);
	}
	@RequestMapping(value="/fillInfomation",method=RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public Response fillInfomation(@RequestBody FillInfomationReq fillInfomationReq){
		return lotteryService.fillInfomation(fillInfomationReq);
	}
	@RequestMapping(value="/findAllRecord",method=RequestMethod.POST,produces = "application/json; charset=UTF-8")
    public Response findAllRecord(@RequestBody FindPageReq findPageReq){
		return lotteryService.findAll(findPageReq);
	}
}
