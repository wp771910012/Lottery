package com.im.lottery.req;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FillInfomationReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long recordId;    
	private String name;                 //姓名
	private Long phone;                  //手机号
	private String address;              //地址 
	private String sign;
}
