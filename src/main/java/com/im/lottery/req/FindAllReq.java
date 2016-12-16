package com.im.lottery.req;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class FindAllReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sign;
	private String queryTime;
	

}
