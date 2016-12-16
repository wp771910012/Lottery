package com.im.lottery.resp;

import com.github.pagehelper.Page;
import com.im.lottery.entity.Record;

public class FindAllRecordResp extends Response{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Page<Record> records;
	private Integer pageNum;
	public Page<Record> getRecords() {
		return records;
	}
	public void setRecords(Page<Record> records) {
		this.records = records;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
	
	

}
