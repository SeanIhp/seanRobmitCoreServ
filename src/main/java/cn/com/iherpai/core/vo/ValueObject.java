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
	
	
	
	public static String agendaOrmKeys(String theKeys) {
		String the_keys = new String(theKeys);
		the_keys = Pattern.compile("\\bmeetingId\\b").matcher(the_keys).replaceAll("meeting_id");
		the_keys = Pattern.compile("\\bmeetingNid\\b").matcher(the_keys).replaceAll("meeting_nid");
		the_keys = Pattern.compile("\\bmeetingSid\\b").matcher(the_keys).replaceAll("meeting_sid");
		the_keys = Pattern.compile("\\bdurationExpect\\b").matcher(the_keys).replaceAll("duration_expect");
		the_keys = Pattern.compile("\\baccountId\\b").matcher(the_keys).replaceAll("account_id");
		the_keys = Pattern.compile("\\baccountNid\\b").matcher(the_keys).replaceAll("account_nid");
		the_keys = Pattern.compile("\\baccountSid\\b").matcher(the_keys).replaceAll("account_sid");
		the_keys = Pattern.compile("\\bcreateTime\\b").matcher(the_keys).replaceAll("create_time");
		return the_keys;
	}
	
	
	
	public static String categoryOrmKeys(String theKeys) {
		String the_keys = new String(theKeys);
		the_keys = Pattern.compile("\\basRoot\\b").matcher(the_keys).replaceAll("as_root");
		the_keys = Pattern.compile("\\bhasChild\\b").matcher(the_keys).replaceAll("has_child");
		the_keys = Pattern.compile("\\bsequenceNumber\\b").matcher(the_keys).replaceAll("sequence_number");
		the_keys = Pattern.compile("\\brootId\\b").matcher(the_keys).replaceAll("root_id");
		the_keys = Pattern.compile("\\brootNid\\b").matcher(the_keys).replaceAll("root_nid");
		the_keys = Pattern.compile("\\brootSid\\b").matcher(the_keys).replaceAll("root_sid");
		the_keys = Pattern.compile("\\bparentId\\b").matcher(the_keys).replaceAll("parent_id");
		the_keys = Pattern.compile("\\bparentNid\\b").matcher(the_keys).replaceAll("parent_nid");
		the_keys = Pattern.compile("\\bparentSid\\b").matcher(the_keys).replaceAll("parent_sid");
		the_keys = Pattern.compile("\\bcreateTime\\b").matcher(the_keys).replaceAll("create_time");
		return the_keys;
	}
	
	
	
	public static String dictOrmKeys(String theKeys) {
		String the_keys = new String(theKeys);
		the_keys = Pattern.compile("\\bdictGroupId\\b").matcher(the_keys).replaceAll("dict_group_id");
		the_keys = Pattern.compile("\\bdictGroupNid\\b").matcher(the_keys).replaceAll("dict_group_nid");
		the_keys = Pattern.compile("\\bdictGroupSid\\b").matcher(the_keys).replaceAll("dict_group_sid");
		the_keys = Pattern.compile("\\bconstCode\\b").matcher(the_keys).replaceAll("const_code");
		the_keys = Pattern.compile("\\bconstType\\b").matcher(the_keys).replaceAll("const_type");
		the_keys = Pattern.compile("\\bconstValue\\b").matcher(the_keys).replaceAll("const_value");
		the_keys = Pattern.compile("\\bconstText\\b").matcher(the_keys).replaceAll("const_text");
		the_keys = Pattern.compile("\\bcreateTime\\b").matcher(the_keys).replaceAll("create_time");
		return the_keys;
	}
	
	
	
	public static String dictGroupOrmKeys(String theKeys) {
		String the_keys = new String(theKeys);
		the_keys = Pattern.compile("\\bhasChild\\b").matcher(the_keys).replaceAll("has_child");
		the_keys = Pattern.compile("\\bparentId\\b").matcher(the_keys).replaceAll("parent_id");
		the_keys = Pattern.compile("\\bparentNid\\b").matcher(the_keys).replaceAll("parent_nid");
		the_keys = Pattern.compile("\\bparentSid\\b").matcher(the_keys).replaceAll("parent_sid");
		the_keys = Pattern.compile("\\bcreateTime\\b").matcher(the_keys).replaceAll("create_time");
		return the_keys;
	}
	
	
	
	public static String mappingOrganizeTeamOrmKeys(String theKeys) {
		String the_keys = new String(theKeys);
		the_keys = Pattern.compile("\\borganizeId\\b").matcher(the_keys).replaceAll("organize_id");
		the_keys = Pattern.compile("\\borganizeNid\\b").matcher(the_keys).replaceAll("organize_nid");
		the_keys = Pattern.compile("\\borganizeSid\\b").matcher(the_keys).replaceAll("organize_sid");
		the_keys = Pattern.compile("\\bteamId\\b").matcher(the_keys).replaceAll("team_id");
		the_keys = Pattern.compile("\\bteamNid\\b").matcher(the_keys).replaceAll("team_nid");
		the_keys = Pattern.compile("\\bteamSid\\b").matcher(the_keys).replaceAll("team_sid");
		the_keys = Pattern.compile("\\baccountId\\b").matcher(the_keys).replaceAll("account_id");
		the_keys = Pattern.compile("\\baccountNid\\b").matcher(the_keys).replaceAll("account_nid");
		the_keys = Pattern.compile("\\baccountSid\\b").matcher(the_keys).replaceAll("account_sid");
		the_keys = Pattern.compile("\\bcreateTime\\b").matcher(the_keys).replaceAll("create_time");
		return the_keys;
	}
	
	
	
	public static String mappingTeamAccountOrmKeys(String theKeys) {
		String the_keys = new String(theKeys);
		the_keys = Pattern.compile("\\borganizeId\\b").matcher(the_keys).replaceAll("organize_id");
		the_keys = Pattern.compile("\\borganizeNid\\b").matcher(the_keys).replaceAll("organize_nid");
		the_keys = Pattern.compile("\\borganizeSid\\b").matcher(the_keys).replaceAll("organize_sid");
		the_keys = Pattern.compile("\\bteamId\\b").matcher(the_keys).replaceAll("team_id");
		the_keys = Pattern.compile("\\bteamNid\\b").matcher(the_keys).replaceAll("team_nid");
		the_keys = Pattern.compile("\\bteamSid\\b").matcher(the_keys).replaceAll("team_sid");
		the_keys = Pattern.compile("\\baccountId\\b").matcher(the_keys).replaceAll("account_id");
		the_keys = Pattern.compile("\\baccountNid\\b").matcher(the_keys).replaceAll("account_nid");
		the_keys = Pattern.compile("\\baccountSid\\b").matcher(the_keys).replaceAll("account_sid");
		the_keys = Pattern.compile("\\bcreateTime\\b").matcher(the_keys).replaceAll("create_time");
		return the_keys;
	}
	
	
	
	public static String meetingOrmKeys(String theKeys) {
		String the_keys = new String(theKeys);
		the_keys = Pattern.compile("\\bsubTitle\\b").matcher(the_keys).replaceAll("sub_title");
		the_keys = Pattern.compile("\\blevelAlpha\\b").matcher(the_keys).replaceAll("level_alpha");
		the_keys = Pattern.compile("\\blevelBeta\\b").matcher(the_keys).replaceAll("level_beta");
		the_keys = Pattern.compile("\\blevelCharlie\\b").matcher(the_keys).replaceAll("level_charlie");
		the_keys = Pattern.compile("\\bjoinTime\\b").matcher(the_keys).replaceAll("join_time");
		the_keys = Pattern.compile("\\bstartTime\\b").matcher(the_keys).replaceAll("start_time");
		the_keys = Pattern.compile("\\bendTime\\b").matcher(the_keys).replaceAll("end_time");
		the_keys = Pattern.compile("\\bminJoin\\b").matcher(the_keys).replaceAll("min_join");
		the_keys = Pattern.compile("\\binvitedCount\\b").matcher(the_keys).replaceAll("invited_count");
		the_keys = Pattern.compile("\\bjoinedCount\\b").matcher(the_keys).replaceAll("joined_count");
		the_keys = Pattern.compile("\\bisHost\\b").matcher(the_keys).replaceAll("is_host");
		the_keys = Pattern.compile("\\bisVote\\b").matcher(the_keys).replaceAll("is_vote");
		the_keys = Pattern.compile("\\bisDelineation\\b").matcher(the_keys).replaceAll("is_delineation");
		the_keys = Pattern.compile("\\bisInvite\\b").matcher(the_keys).replaceAll("is_invite");
		the_keys = Pattern.compile("\\bcanAgent\\b").matcher(the_keys).replaceAll("can_agent");
		the_keys = Pattern.compile("\\baccountId\\b").matcher(the_keys).replaceAll("account_id");
		the_keys = Pattern.compile("\\baccountNid\\b").matcher(the_keys).replaceAll("account_nid");
		the_keys = Pattern.compile("\\baccountSid\\b").matcher(the_keys).replaceAll("account_sid");
		the_keys = Pattern.compile("\\bhostAccountId\\b").matcher(the_keys).replaceAll("host_account_id");
		the_keys = Pattern.compile("\\bhostAccountNid\\b").matcher(the_keys).replaceAll("host_account_nid");
		the_keys = Pattern.compile("\\bhostAccountSid\\b").matcher(the_keys).replaceAll("host_account_sid");
		the_keys = Pattern.compile("\\bsecretaryAccountId\\b").matcher(the_keys).replaceAll("secretary_account_id");
		the_keys = Pattern.compile("\\bsecretaryAccountNid\\b").matcher(the_keys).replaceAll("secretary_account_nid");
		the_keys = Pattern.compile("\\bsecretaryAccountSid\\b").matcher(the_keys).replaceAll("secretary_account_sid");
		the_keys = Pattern.compile("\\bcreateTime\\b").matcher(the_keys).replaceAll("create_time");
		return the_keys;
	}
	
	
	
	public static String menuOrmKeys(String theKeys) {
		String the_keys = new String(theKeys);
		the_keys = Pattern.compile("\\basParent\\b").matcher(the_keys).replaceAll("as_parent");
		the_keys = Pattern.compile("\\bhasChild\\b").matcher(the_keys).replaceAll("has_child");
		the_keys = Pattern.compile("\\baccountId\\b").matcher(the_keys).replaceAll("account_id");
		the_keys = Pattern.compile("\\baccountNid\\b").matcher(the_keys).replaceAll("account_nid");
		the_keys = Pattern.compile("\\baccountSid\\b").matcher(the_keys).replaceAll("account_sid");
		the_keys = Pattern.compile("\\bcreateTime\\b").matcher(the_keys).replaceAll("create_time");
		return the_keys;
	}
	
	
	
	public static String menuAuthenticOrmKeys(String theKeys) {
		String the_keys = new String(theKeys);
		the_keys = Pattern.compile("\\basParent\\b").matcher(the_keys).replaceAll("as_parent");
		the_keys = Pattern.compile("\\bhasChild\\b").matcher(the_keys).replaceAll("has_child");
		the_keys = Pattern.compile("\\bmenuId\\b").matcher(the_keys).replaceAll("menu_id");
		the_keys = Pattern.compile("\\bmenuNid\\b").matcher(the_keys).replaceAll("menu_nid");
		the_keys = Pattern.compile("\\bmenuSid\\b").matcher(the_keys).replaceAll("menu_sid");
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
