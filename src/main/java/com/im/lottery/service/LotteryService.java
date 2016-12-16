package com.im.lottery.service;

import com.im.lottery.req.FillInfomationReq;
import com.im.lottery.req.FindPageReq;
import com.im.lottery.req.LotteryReq;
import com.im.lottery.resp.Response;

public interface LotteryService {
	public Response lottery(LotteryReq lotteryReq);
	public Response fillInfomation(FillInfomationReq fillInfomationReq);
	public Response findAll(FindPageReq findPageReq);

}
