package com.im.lottery.resp;

import com.im.lottery.entity.Prize;
import com.im.lottery.entity.Record;

public class LotteryResp extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Record record;
	private Prize prize;
	public Record getRecord() {
		return record;
	}
	public void setRecord(Record record) {
		this.record = record;
	}
	public Prize getPrize() {
		return prize;
	}
	public void setPrize(Prize prize) {
		this.prize = prize;
	}
	

}
