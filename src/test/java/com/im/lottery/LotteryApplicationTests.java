package com.im.lottery;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.im.lottery.entity.Prize;
import com.im.lottery.entity.Record;
import com.im.lottery.persistence.PrizeMapper;
import com.im.lottery.service.PrizeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LotteryApplication.class)
@WebAppConfiguration
public class LotteryApplicationTests {
	
	@Test
	public void contextLoads() {
	}

}
