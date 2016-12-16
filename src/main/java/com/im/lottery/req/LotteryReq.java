package com.im.lottery.req;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LotteryReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lotteryTime;                
	private String sign;                  

}
