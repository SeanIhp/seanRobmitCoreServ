package cn.com.iherpai.common.utils;

import cn.com.iherpai.common.underware.Base64;

public class ID {
	
	public static String newId(long useFor, long dbNum, long tableNum) throws Exception{
		return IdGenerator.generate63(useFor, dbNum, tableNum);
	}
	
	public static String newUuid(){
		return UuidGenerator.getUUID();
	}
	
	public static String idEncode64(String id){
		return Base64.transToBase64(id);
	}
	
	public static String idDecode64(String id64){
		return Base64.transFromBase64(id64);
	}
	
	public static String serialEncode64(String serial){
		return Base64.transToBase64(serial);
	}
	
	public static String serialDecode64(String serial64){
		return Base64.transFromBase64(serial64);
	}
}
