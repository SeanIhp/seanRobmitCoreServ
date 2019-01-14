package cn.com.iherpai.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.com.iherpai.common.consts.FetchConfig;


public class DataValidator {

	public static char[] xCharMail = new char[] { '|', '\'', '=', '#', '*',
			'&', '~', '^', '+', '\\', '!', '<', '>' };
	public static char[] xChar = new char[] { '|', '\'', '=', '+', '\\' };
	public static char[] xChar2 = new char[] {
	// '|', '\'', '^', '+', '\\', '<', '>','*'
	};
	public static char[] xChars = new char[] { '|', '.', '\'', ',', '=', ' ',
			'[', ']', '(', ')', '#', '@', '*', '&', '~', '^', '+', '\\', '/',
			'!', '?', '<', '>' };
	public static char[] xMail = new char[] { '\'', ',', '=', ' ', '[', ']',
			'(', ')', '#', '*', '&', '~', '^', '+', '\\', '!', '?', '<', '>' };
	public static String[] filterWords = new String[] { "法轮", "江泽民", "胡锦涛",
			"代办职业资格证书", "网站推广", "龙兴", "加密狗", "新开传世私服", "白小姐", "六合彩", "成人用品性用品",
			"保健品", "蓝猫保健品", "肖虎", "搬家公司", "裸体美女", "博彩", "泰国圣荷野葛根丰胸", "深圳辦证",
			"老虎机", "京客网", "征稿启事", "稻城", "离心机", "搬场", "征途私服", "成人用品", "自慰器",
			"人造阳具", "淫女俱乐部", "淫民俱乐部", "dell工作站", "缩阴", "私服", "热血", "信息群发",
			"去你妈的", "Refresh", "操你妈", "法轮", "falun", "falundafa", "zhuanfalu",
			"六四", "民运", "dafa", "唐人电视台", "大法", "新唐人电视台", "李洪志", "转法轮", "共铲党",
			"六合彩", "六合采", "共铲党", "九评", "九评共产党", "人民报", "退党", "明慧", "明慧网",
			"大纪元", "退党", "六四", "天安门事件", "自由亚州", "无界浏览", "极景", "无界", "无网界浏览",
			"无网界", "美国之音", "自由亚洲", "色情网站", "色情", "情色", "口交", "阴茎", "阴毛", "性虐待",
			"黄色网站", "成人网站", "成人小说", "成人文学", "成人电影", "成人影视", "黄色电影", "黄色影视",
			"黄色小说", "黄色文学", "成人图片", "黄色图片", "黄色漫画", "成人漫画", "成人电影", "三级片",
			"黄色电影", "坐台", "应召", "应招", "妓女", "成人论坛", "手机铃声下载", "铃声下载", "手机铃声",
			"手机游戏", "性免费电影", "小电影", "六合彩", "成人用品性用品", "保健品", "蓝猫保健品", "肖虎",
			"搬家公司", "裸体美女", "博彩", "泰国圣荷野葛根丰胸", "深圳辦证", "老虎机", "京客网", "征稿启事",
			"稻城", "离心机", "搬场", "征途私服", "成人用品", "自慰器", "人造阳具", "淫女俱乐部", "淫民俱乐部",
			"dell工作站", "缩阴", "私服", "热血", "信息群发", "传销" };

	public static String[] keywords = new String[] { "admin", "administrator",
			"master", "webmaster", "vloto", "visuallotoery", "evan", "and ",
			"where ", "or ", "select ", "update ", "set", "delete ", "drop ",
			"exec ", "insert ", "create ", "return", "close", "javascript",
			"sqlserver", "server", "vbscript", "script" };

	public static String[] keywords2 = new String[] { "admin", "administrator",
			"master", "webmaster", "vloto", "visuallotoery", "evan", " and ",
			"where", "select", "update", "set", "delete", "drop", "exec",
			"insert", "create", "return", "close", "javascript", "sqlserver",
			"server", "vbscript", "script" };

	public static boolean paramValidate(DataItem... items) {
		boolean res = false;
		for (DataItem data : items) {
			String theData = data.getData();
			if (theData == null || theData.trim().equals("")) {
				return false;
			}
			String theRule = data.getRuleName();

			String theConfig = data.getRuleConfig();
		}
		return res;
	}

	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		}
		return false;
	}

	public static boolean isNullString(String str) {
		boolean res = false;
		int temp;
		if (str == null) {
			temp = 0;
		} else {
			if (str.trim().length() == 0) {
				temp = 0;
			} else {
				temp = 1;
			}
		}
		if (temp == 0) {
			res = true;
		} else {
			res = false;
		}
		return res;
	}

	public static boolean ckLength(String str, int minLength, int maxLength) {
		boolean res = false;
		int len = str.trim().length();
		if (minLength != -1 && maxLength != -1) {
			if (len >= minLength && len <= maxLength) {
				res = true;
			} else {
				res = false;
			}
		} else if (minLength != -1) {
			if (len >= minLength) {
				res = true;
			} else {
				res = false;
			}
		} else if (maxLength != -1) {
			if (len <= maxLength) {
				res = true;
			} else {
				res = false;
			}
		} else {
			res = true;
		}
		return res;
	}

	public static boolean ckValidate(String str, char[] illegals) {
		boolean res = true;
		if (illegals != null) {
			char[] x = str.toCharArray();
			for (int i = 0; i < x.length; i++) {
				for (int j = 0; j < illegals.length; j++) {
					if (x[i] == illegals[j]) {
						res = false;
					}
				}
			}
		}
		return res;
	}

	public static boolean ckNumberic(String str) {
		boolean res = true;
		String tempStr = str.trim();
		try {
			Double.parseDouble(tempStr);
		} catch (NumberFormatException e) {
			res = false;
		}
		return res;
	}

	public static boolean ckRange(String str, double minValue, double maxValue) {
		boolean res = false;
		double number = Double.parseDouble(str.trim());
		if (minValue != -99999 && maxValue != -99999) {
			if (number >= minValue && number <= maxValue) {
				res = true;
			} else {
				res = false;
			}
		} else if (minValue != -99999) {
			if (number >= minValue) {
				res = true;
			} else {
				res = false;
			}
		} else if (maxValue != -99999) {
			if (number <= maxValue) {
				res = true;
			} else {
				res = false;
			}
		}
		return res;
	}

	public static boolean ckDecimalRange(String str, int minValue, int maxValue) {
		boolean res = false;
		int number = Integer.parseInt(str.trim());
		if (minValue != -99999 && maxValue != -99999) {
			if (number >= minValue && number <= maxValue) {
				res = true;
			} else {
				res = false;
			}
		} else if (minValue != -99999) {
			if (number >= minValue) {
				res = true;
			} else {
				res = false;
			}
		} else if (maxValue != -99999) {
			if (number <= maxValue) {
				res = true;
			} else {
				res = false;
			}
		}
		return res;
	}

	public static boolean ckIntRange(String str, int minValue, int maxValue) {
		boolean res = false;
		int number = Integer.parseInt(str.trim());
		if (minValue != -99999 && maxValue != -99999) {
			if (number >= minValue && number <= maxValue) {
				res = true;
			} else {
				res = false;
			}
		} else if (minValue != -99999) {
			if (number >= minValue) {
				res = true;
			} else {
				res = false;
			}
		} else if (maxValue != -99999) {
			if (number <= maxValue) {
				res = true;
			} else {
				res = false;
			}
		}
		return res;
	}

	public static boolean ckLongRange(String str, long minValue, long maxValue) {
		boolean res = false;
		long number = Long.parseLong(str.trim());
		if (minValue != -99999 && maxValue != -99999) {
			if (number >= minValue && number <= maxValue) {
				res = true;
			} else {
				res = false;
			}
		} else if (minValue != -99999) {
			if (number >= minValue) {
				res = true;
			} else {
				res = false;
			}
		} else if (maxValue != -99999) {
			if (number <= maxValue) {
				res = true;
			} else {
				res = false;
			}
		}
		return res;
	}

	public static boolean ckEmail(String str) {
		boolean res = false;
		String tempStr = str.trim();
		int aPos = tempStr.indexOf("@");
		int pPos = tempStr.indexOf(".");
		if (aPos != -1 && pPos != -1) {
			if (aPos != 0) {
				return true;
			} else {
				return false;
			}
		} else {
			res = false;
		}
		return res;
	}

	public static boolean ckEquals(String str, String targetStr) {
		boolean res = false;
		String tempStr = str.trim();
		if (tempStr.equals(targetStr)) {
			res = true;
		} else {
			res = false;
		}
		return res;
	}

	public static boolean ckEqualsIgnoreCase(String str, String targetStr) {
		boolean res = false;
		String tempStr = str.trim();
		if (tempStr.equalsIgnoreCase(targetStr)) {
			res = true;
		} else {
			res = false;
		}
		return res;
	}

	public static boolean ckKeyword(String str, String[] keywords) {
		boolean res = false;
		if (keywords != null) {
			String tempStr = str.trim();
			for (int i = 0; i < keywords.length; i++) {
				if (tempStr.equals(keywords[i])) {
					res = true;
					break;
				}
			}
		}
		return res;
	}

	public static boolean ckDate(String str, String sep) {
		boolean res = false;
		String tempStr = str.trim();
		int len = tempStr.length();
		if (len >= 6 && len <= 10) {
			String[] datePart = tempStr.split(sep);
			for (int i = 0; i < datePart.length; i++) {
				datePart[i] = datePart[i].trim();
			}

			String tempYear;
			String tempMonth;
			String tempDay;

			if (datePart.length == 3) {
				tempYear = datePart[0];
				tempMonth = datePart[1];
				tempDay = datePart[2];
			} else {
				return false;
			}

			int tYear = -1;
			int tMonth = -1;
			int tDay = -1;
			try {
				tYear = Integer.parseInt(tempYear);
				tMonth = Integer.parseInt(tempMonth);
				tDay = Integer.parseInt(tempDay);
			} catch (NumberFormatException e) {
				return false;
			}

			if (tYear > 1900 && tYear < 2500 && tMonth > 0 && tMonth < 13
					&& tDay > 0 && tDay < 32) {
				boolean sepYear;
				if (tYear % 4 == 0 && tYear % 100 == 0) {
					sepYear = true;
				} else {
					sepYear = false;
				}

				switch (tMonth) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					if (tDay > 31) {
						return false;
					}
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					if (tDay > 30) {
						return false;
					}
					break;
				case 2:
					if (sepYear) {
						if (tDay > 29) {
							return false;
						}
					} else {
						if (tDay > 28) {
							return false;
						}
					}
					break;
				default:
					return false;
				}
				res = true;
			} else {
				return false;
			}
		}

		return res;
	}

	public static boolean ckFilterWords(String theWords) {
		boolean res = false;
		if (theWords != null && !theWords.equals("")) {
			int i = 0;
			for (i = 0; i < filterWords.length; i++) {
				if (theWords.indexOf(filterWords[i]) != -1) {
					break;
				}
			}
			if (i == filterWords.length) {
				res = true;
			}
		}
		return res;
	}

	public static boolean ckTheEmail(String str, int minLength, int maxLength) {
		boolean res = false;
		if (!isNullString(str)) {
			if (ckLength(str, minLength, maxLength)) {
				if (ckEmail(str)) {
					res = true;
				}
			}
		}
		return res;
	}

	public static boolean ckTheString(String str, int minLength, int maxLength) {
		boolean res = false;
		if (!isNullString(str)) {
			if (ckLength(str, minLength, maxLength)) {
				res = true;
			}
		}
		return res;
	}

	public static boolean ckTheString(String str, int minLength, int maxLength,
			char[] illegals) {
		boolean res = false;
		if (!isNullString(str)) {
			if (ckLength(str, minLength, maxLength)) {
				if (ckValidate(str, illegals)) {
					res = true;
				}
			}
		}
		return res;
	}

	public static boolean ckTheString(String str, int minLength, int maxLength,
			String[] keywords) {
		boolean res = false;
		if (!isNullString(str)) {
			if (ckLength(str, minLength, maxLength)) {
				if (!ckKeyword(str, keywords)) {
					res = true;
				}
			}
		}
		return res;
	}

	public static boolean ckTheString(String str, int minLength, int maxLength,
			char[] illegals, String[] keywords) {
		boolean res = false;
		if (!isNullString(str)) {
			if (ckLength(str, minLength, maxLength)) {
				if (!ckKeyword(str, keywords) && ckValidate(str, illegals)) {
					res = true;
				}
			}
		}
		return res;
	}

	public static boolean ckTheString(String str, int minLength, int maxLength,
			char[] illegals, String[] keywords, String filterFlag) {
		boolean res = false;
		if (!isNullString(str)) {
			if (ckLength(str, minLength, maxLength)) {
				if (!ckKeyword(str, keywords) && ckValidate(str, illegals)
						&& ckFilterWords(str)) {
					res = true;
				}
			}
		}
		return res;
	}

	public static boolean ckTheNumber(String str, int minLength, int maxLength) {
		boolean res = false;
		if (!isNullString(str)) {
			if (ckLength(str, minLength, maxLength)) {
				if (ckNumberic(str)) {
					res = true;
				}
			}
		}
		return res;
	}

	public static boolean ckTheNumber(String str, int minLength, int maxLength,
			double minValue, double maxValue) {
		boolean res = false;
		if (!isNullString(str)) {
			if (ckLength(str, minLength, maxLength)) {
				if (ckNumberic(str)) {
					if (ckRange(str, minValue, maxValue)) {
						res = true;
					}
				}
			}
		}
		return res;
	}

	public static int ckTheFetchGoodsUrl(String str) {
		int res = -1;
		if (!isNullString(str)) {
			if (str.indexOf(FetchConfig.FETCH__goodsFix__TAOBAO_ALPHA__T) == 0
					|| str.indexOf(FetchConfig.FETCH__goodsFix__TAOBAO_BRAVO__T) == 0) {
				res = FetchConfig.FETCH__goodsFix__TAOBAO_CODE__V;
			} else if (str.indexOf(FetchConfig.FETCH__goodsFix__TMALL_ALPHA__T) == 0
					|| str.indexOf(FetchConfig.FETCH__goodsFix__TMALL_BRAVO__T) == 0
					|| str.indexOf(FetchConfig.FETCH__goodsFix__TMALL_CHARLIE__T) == 0) {
				res = FetchConfig.FETCH__goodsFix__TMALL_CODE__V;
			} else if (str
					.indexOf(FetchConfig.FETCH__goodsFix__PAIPAI_ALPHA__T) == 0
					|| str.indexOf(FetchConfig.FETCH__goodsFix__PAIPAI_BRAVO__T) == 0) {
				res = FetchConfig.FETCH__goodsFix__PAIPAI_CODE__V;
			} else if (str
					.indexOf(FetchConfig.FETCH__goodsFix__360BUY_ALPHA__T) == 0
					|| str.indexOf(FetchConfig.FETCH__goodsFix__360BUY_BRAVO__T) == 0) {
				res = FetchConfig.FETCH__goodsFix__360BUY_CODE__V;
			} else if (str
					.indexOf(FetchConfig.FETCH__goodsFix__DANGDANG_ALPHA__T) == 0
					|| str.indexOf(FetchConfig.FETCH__goodsFix__DANGDANG_BRAVO__T) == 0
					|| str.indexOf(FetchConfig.FETCH__goodsFix__DANGDANG_CHARLIE__T) != -1) {
				res = FetchConfig.FETCH__goodsFix__DANGDANG_CODE__V;
			}
		}
		return res;
	}

	/**
	 * ------------------------------------------------------------------------
	*/
	/**
	 * 验证邮箱
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isEmail(String str) {
		String regex = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		return match(regex, str);
	}

	/**
	 * 验证完整日期时间串
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isDatetime(String str) {
		boolean res = false;
		SimpleDateFormat sdfWhole = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			sdfWhole.parse(str);
			res = true;
		} catch (ParseException e) {
			res = false;
		}
		return res;
	}

	/**
	 * 验证布尔串
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isBoolean(String str) {
		boolean res = false;
		try {
			Boolean.parseBoolean(str);
			res = true;
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	/**
	 * 验证IP地址
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isIP(String str) {
		String num = "(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)";
		String regex = "^" + num + "\\." + num + "\\." + num + "\\." + num
				+ "$";
		return match(regex, str);
	}

	/**
	 * 验证网址Url
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsUrl(String str) {
		String regex = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%:&=]*)?";
		return match(regex, str);
	}

	/**
	 * 验证电话号码
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsTelephone(String str) {
		String regex = "^(\\d{3,4}-)?\\d{6,8}$";
		return match(regex, str);
	}

	/**
	 * 验证输入密码条件(字符与数据同时出现)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsPassword(String str) {
		String regex = "[A-Za-z]+[0-9]";
		return match(regex, str);
	}

	/**
	 * 验证输入密码长度 (6-18位)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsPasswLength(String str) {
		String regex = "^\\d{6,18}$";
		return match(regex, str);
	}

	/**
	 * 验证输入邮政编号
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsPostalcode(String str) {
		String regex = "^\\d{6}$";
		return match(regex, str);
	}

	/**
	 * 验证输入手机号码
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsHandset(String str) {
		String regex = "^[1]+[3,5]+\\d{9}$";
		return match(regex, str);
	}

	/**
	 * 验证输入身份证号
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsIDcard(String str) {
		String regex = "(^\\d{18}$)|(^\\d{15}$)";
		return match(regex, str);
	}

	/**
	 * 验证输入两位小数
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsDecimal(String str) {
		String regex = "^[0-9]+(.[0-9]{2})?$";
		return match(regex, str);
	}

	/**
	 * 验证输入一年的12个月
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsMonth(String str) {
		String regex = "^(0?[[1-9]|1[0-2])$";
		return match(regex, str);
	}

	/**
	 * 验证输入一个月的31天
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsDay(String str) {
		String regex = "^((0?[1-9])|((1|2)[0-9])|30|31)$";
		return match(regex, str);
	}

	/**
	 * 验证日期时间
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合网址格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean isDate(String str) {
		// 严格验证时间格式的(匹配[2002-01-31], [1997-04-30],
		// [2004-01-01])不匹配([2002-01-32], [2003-02-29], [04-01-01])
		// String regex =
		// "^((((19|20)(([02468][048])|([13579][26]))-02-29))|((20[0-9][0-9])|(19[0-9][0-9]))-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((01,3-9])|(1[0-2]))-(29|30)))))$";
		// 没加时间验证的YYYY-MM-DD
		// String regex =
		// "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$";
		// 加了时间验证的YYYY-MM-DD 00:00:00
		String regex = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-)) (20|21|22|23|[0-1]?\\d):[0-5]?\\d:[0-5]?\\d$";
		return match(regex, str);
	}

	/**
	 * 验证数字输入
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsNumber(String str) {
		String regex = "^[0-9]*$";
		return match(regex, str);
	}

	/**
	 * 验证非零的正整数
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsIntNumber(String str) {
		String regex = "^\\+?[1-9][0-9]*$";
		return match(regex, str);
	}
	
	/**
	 * 验证密码串
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsPasswordStr(String str){
		String regex = "^[A-Za-z0-9~`!@#\\$%^&*.]{6,48}$";
		return match(regex, str);
	}

	/**
	 * 验证大写字母
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsUpChar(String str) {
		String regex = "^[A-Z]+$";
		return match(regex, str);
	}

	/**
	 * 验证小写字母
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsLowChar(String str) {
		String regex = "^[a-z]+$";
		return match(regex, str);
	}

	/**
	 * 验证验证输入字母
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsLetter(String str) {
		String regex = "^[A-Za-z]+$";
		return match(regex, str);
	}

	/**
	 * 验证验证输入汉字
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsChinese(String str) {
		String regex = "^[\u4e00-\u9fa5],{0,}$";
		return match(regex, str);
	}

	/**
	 * 验证验证输入字符串
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsLength(String str) {
		String regex = "^.{8,}$";
		return match(regex, str);
	}

	/**
	 * 验证验证输入字符串 (数字、字母、下划线)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsIdStr(String str) {
		String regex = "^([A-Za-z0-9_])*$";
		return match(regex, str);
	}

	/**
	 * 验证验证输入字符串 (中文、数字、字母、下划线)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsNameStr(String str) {
		String regex = "^([A-Za-z0-9_\u4e00-\u9fa5])*$";
		return match(regex, str);
	}

	/**
	 * 验证验证输入字符串 (中文、数字、字母、下划线、空格)
	 * 
	 * @param 待验证的字符串
	 * @return 如果是符合格式的字符串,返回 <b>true </b>,否则为 <b>false </b>
	 */
	public static boolean IsLabelStr(String str) {
		String regex = "^([A-Z a-z0-9_\u4e00-\u9fa5])*$";
		return match(regex, str);
	}

	/**
	 * @param regex
	 *            正则表达式字符串
	 * @param str
	 *            要匹配的字符串
	 * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	 */
	private static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

}
