package com.im.lottery.utils;

public class SignCheckUtil {
	public static boolean check(String sign,String attach,String value){
		if(MD5Util.MD5Encode(value+attach, "utf-8").equals(sign)){
			return true;
		}else {
			return false;
		}
	}

}
