package com.im.lottery.req;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class FindPageReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer index;
	private Integer pageSize;
	private String queryTime;
	private String sign;

}
