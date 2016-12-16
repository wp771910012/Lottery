package com.im.lottery.service;

import com.im.lottery.req.CreatePrizeReq;
import com.im.lottery.req.DeletePrizeReq;
import com.im.lottery.req.FindAllReq;
import com.im.lottery.req.FindPrizeByIdReq;
import com.im.lottery.req.UpdatePrizeReq;
import com.im.lottery.resp.Response;

public interface PrizeService {
	public Response InsertPrize(CreatePrizeReq createPrizeReq);
	public Response delete(DeletePrizeReq deletePrizeReq);
	public Response update(UpdatePrizeReq updatePrizeReq);
	public Response findAll(FindAllReq findAllReq);
	public Response findById(FindPrizeByIdReq findPrizeByIdReq);

}
