package cn.com.iherpai.core.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class ValueObject implements Serializable {
	private static final long serialVersionUID = -3385090885493168457L;
	
	public static String accountOrmKeys(String theKeys) {
		String the_keys = new String(theKeys);
		the_keys = Pattern.compile("\\bwxOpenid\\b").matcher(the_keys).replaceAll("wx_openid");
		the_keys = Pattern.compile("\\bwxSessionkey\\b").matcher(the_keys).replaceAll("wx_sessionkey");
		the_keys = Pattern.compile("\\bwxUnionid\\b").matcher(the_keys).replaceAll("wx_unionid");
		the_keys = Pattern.compile("\\bwxNickname\\b").matcher(the_keys).replaceAll("wx_nickname");
		the_keys = Pattern.compile("\\bwxAvatar\\b").matcher(the_keys).replaceAll("wx_avatar");
		the_keys = Pattern.compile("\\bwxGender\\b").matcher(the_keys).replaceAll("wx_gender");
		the_keys = Pattern.compile("\\bwxCity\\b").matcher(the_keys).replaceAll("wx_city");
		the_keys = Pattern.compile("\\bwxCountry\\b").matcher(the_keys).replaceAll("wx_country");
		the_keys = Pattern.compile("\\bwxProvince\\b").matcher(the_keys).replaceAll("wx_province");
		the_keys = Pattern.compile("\\bwxLanguage\\b").matcher(the_keys).replaceAll("wx_language");
		the_keys = Pattern.compile("\\bcreateTime\\b").matcher(the_keys).replaceAll("create_time");
		return the_keys;
	}
	
	//生成取值返回字段列表
	public static ArrayList<String> returnFieldsBuild(String returnFieldsString){
		ArrayList<String> returnFields = new ArrayList<String>(0);
		String[] returnFieldsStrs = returnFieldsString.split(",");
		for(int i=0; i<returnFieldsStrs.length; i++){
			returnFields.add(returnFieldsStrs[i].replace(" ", ""));
		}
		return returnFields;
	}
	
}
