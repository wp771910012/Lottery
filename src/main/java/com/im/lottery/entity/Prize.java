package com.im.lottery.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

/**
 * 
 *  @author wangpeng
 *    奖品实体
 */
@Data
@ToString
public class Prize implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer prizeId;
    private String name;                 //奖项
    private String detail;               //奖品类容
    private String text;                 //二维码
    private Integer inventory;           //库存
    private Integer status;              //状态
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp addTime;       //添加时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;    //更新时间
}
