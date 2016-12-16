package com.im.lottery.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.im.lottery.entity.InventoryCount;
import com.im.lottery.entity.Prize;

public interface PrizeMapper {
	Integer insert(Prize prize);
	Integer delete(@Param("prizeId") Integer prizeId);
	Integer update(Prize prize);
	List<Prize> findAll();
	Prize findById(@Param("prizeId")Integer prizeId);
	InventoryCount getInventory(@Param("prizeId")Integer prizeId);
	Integer minusInventort(@Param("prizeId")Integer prizeId);
	

}
