package com.im.lottery.req;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@ToString
@Data
public class CreatePrizeReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sign; 
	private String name;                 //奖项
	private String detail;               //奖品类容
	private String text;                 //二维码
	private Integer inventory;
}
