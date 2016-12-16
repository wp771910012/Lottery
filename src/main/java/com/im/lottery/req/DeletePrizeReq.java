package com.im.lottery.req;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class DeletePrizeReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sign;
	private Integer prizeId;

}
