package com.im.lottery.utils;

import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;

import com.im.lottery.entity.Record;

public class LotteryUtil {
	public static LongAdder addr=new LongAdder();
	private static Integer[] sixPrize={4,5,6,10,11,12,17,18,23,24,29,30,34,35,39,40,42,43,48,49,54,55,59};
	private static Integer[] fivePrize={1,2,7,8,13,14,19,20,26,27,31,32,36,37,44,45,51,52,56,57};
	private static Integer[] fourPrize={3,9,16,21,22,28,33,41,46,47,53,58};
	private static Integer[] threePrize={15,38};
	private static Integer[] twoPrize={25,50};
	private static Integer[] onePrize={60};
	
	public static Record lotteryDistribution(Record record){
		addr.increment();
		System.out.println("----"+addr.intValue()+"--------------");
		if(Arrays.asList(sixPrize).contains(addr.intValue())){
			record.setPrizeId(6);
		}else if(Arrays.asList(fivePrize).contains(addr.intValue())){
			record.setPrizeId(5);
		}else if(Arrays.asList(fourPrize).contains(addr.intValue())){
			record.setPrizeId(4);
		}else if(Arrays.asList(threePrize).contains(addr.intValue())){
			record.setPrizeId(3);
		}else if(Arrays.asList(twoPrize).contains(addr.intValue())){
			record.setPrizeId(2);
		}else if(Arrays.asList(onePrize).contains(addr.intValue())){
			record.setPrizeId(1);
		}
		if(addr.intValue()==60){
			addr=new LongAdder();
		}
		return record;
	}
 
}
