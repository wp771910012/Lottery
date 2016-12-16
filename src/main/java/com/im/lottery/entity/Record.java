package com.im.lottery.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

/**
 * 
 * @author wangpeng
 *    获奖记录实体
 */
@ToString
@Data
public class Record implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long recordId;    
	private String name;                 //姓名
	private Long phone;                  //手机号
	private String address;              //地址
	private Integer prizeId;             //关联奖品名称
	private Integer status;              //状态
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp addTime;       //添加时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp updateTime;    //更新时间

}
