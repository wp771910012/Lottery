package com.im.lottery.resp;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Response implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resultCode;
	private String resultMessage;
	public Response(String resultCode, String resultMessage) {
		super();
		this.resultCode = resultCode;
		this.resultMessage = resultMessage;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
