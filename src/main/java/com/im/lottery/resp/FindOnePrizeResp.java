package com.im.lottery.resp;

import com.im.lottery.entity.Prize;
public class FindOnePrizeResp extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Prize prize;
	public Prize getPrize() {
		return prize;
	}
	public void setPrize(Prize prize) {
		this.prize = prize;
	}
	
	

}
