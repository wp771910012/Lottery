package com.im.lottery.resp;

import java.util.List;

import com.im.lottery.entity.Prize;
public class FindAllPrizeResp extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Prize> prizes;
	public List<Prize> getPrizes() {
		return prizes;
	}
	public void setPrizes(List<Prize> prizes) {
		this.prizes = prizes;
	}

}
