package com.im.lottery.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.im.lottery.entity.Record;

public interface RecordMapper {
	public Integer insert(Record record);
	public Record findById(@Param("recordId") Long recordId);
	public List<Record> findAll();
	public Integer update(Record record);

}
