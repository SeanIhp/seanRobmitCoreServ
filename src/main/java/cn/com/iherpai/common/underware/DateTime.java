package cn.com.iherpai.common.underware;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTime {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat sdfWholeTail = new SimpleDateFormat("HHmmssms");
	private static SimpleDateFormat sdfTail = new SimpleDateFormat("HHmm");
	private static SimpleDateFormat sdfMsTail = new SimpleDateFormat("ms");
	private static SimpleDateFormat sdf4Id = new SimpleDateFormat("YYMMddHHmmss");
	private static SimpleDateFormat sdf4IdPlus = new SimpleDateFormat("yyyy,MM,dd,HH,mm,ss,ms");
	private static SimpleDateFormat sdfCurt = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdfCurtCn = new SimpleDateFormat("yyyy年MM月dd日");
	private static SimpleDateFormat sdfWhole = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdfWholeCn = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
	private static SimpleDateFormat sdfWholeFullCn = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒ms");
	private static SimpleDateFormat sdfDataTimePath = new SimpleDateFormat("yyyyMMdd\\HHmm\\");
	private static SimpleDateFormat sdfDataTimeUrl = new SimpleDateFormat("yyyyMMdd/HHmm/");
	
	static{		
		sdf.setTimeZone( TimeZone.getTimeZone("GMT+8") );
		sdfWholeTail.setTimeZone( TimeZone.getTimeZone("GMT+8") );
		sdfTail.setTimeZone( TimeZone.getTimeZone("GMT+8") );
		sdfMsTail.setTimeZone( TimeZone.getTimeZone("GMT+8") );
		sdf4Id.setTimeZone( TimeZone.getTimeZone("GMT+8") );
		sdf4IdPlus.setTimeZone( TimeZone.getTimeZone("GMT+8") );
		sdfCurt.setTimeZone( TimeZone.getTimeZone("GMT+8") );
		sdfCurtCn.setTimeZone( TimeZone.getTimeZone("GMT+8") );
		sdfWhole.setTimeZone( TimeZone.getTimeZone("GMT+8") );
		sdfWholeCn.setTimeZone( TimeZone.getTimeZone("GMT+8") );
		sdfWholeFullCn.setTimeZone( TimeZone.getTimeZone("GMT+8") );
		sdfDataTimePath.setTimeZone( TimeZone.getTimeZone("GMT+8") );
		sdfDataTimeUrl.setTimeZone( TimeZone.getTimeZone("GMT+8") );
	}

	public static java.sql.Timestamp getTimestamp(String tts){
		return new java.sql.Timestamp( new Long(tts) );
	}
	public static java.sql.Timestamp getCurrentTimestamp(){
		return new java.sql.Timestamp( System.currentTimeMillis() );
	}
	public static String getTtsDateStr4IdPlus(Long tts){
		return sdf4IdPlus.format(new Date(tts));
	}
	public static long getCurrentTimestampMs(){
		return System.currentTimeMillis();
	}
	public static String getTheDateStr(){
		return sdf.format(new Date());
	}
	public static String getTheDateWholeTailStr(){
		return sdfWholeTail.format(new Date());
	}
	public static String getTheDateTailStr(){
		return sdfTail.format(new Date());
	}
	public static String getTheDateMsTailStr(){
		return sdfMsTail.format(new Date());
	}
	public static String getTheDateStr4Id() throws Exception{
		Date dt = new Date();
		String dtStr = sdf4Id.format(dt);
		String msStr = sdfMsTail.format(dt);
		return dtStr+fillStr(msStr, msStr.length(), 4);
	}
	public static String getTheDateStr4IdPlus(){
		return sdf4IdPlus.format(new Date());
	}
	public static String getTheDateStrCurt(){
		return sdfCurt.format(new Date());
	}
	public static String getTheDateStrCurtCn(){
		return sdfCurtCn.format(new Date());
	}
	public static String getTheDateStrWhole(){
		return sdfWhole.format(new Date());
	}
	public static String getTheDateStrWholeCn(){
		return sdfWholeCn.format(new Date());
	}
	public static String getTheDateStrWholeFullCn(){
		return sdfWholeFullCn.format(new Date());
	}
	public static String getTheDataTimePath(){
		return sdfDataTimePath.format(new Date());
	}
	public static String getTheDataTimeUrl(){
		return sdfDataTimeUrl.format(new Date());
	}
	
	
	public static long getTimesAfterYears(int year){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		c.add(Calendar.YEAR, year);
		return c.getTime().getTime();
	}	
	public static String getTimesAfterYearsStr(int year){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		c.add(Calendar.YEAR, year);
		return df.format(c.getTime());
	}
	
	public static long getTimesAfterMonths(int month){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		c.add(Calendar.MONTH, month);
		return c.getTime().getTime();
	}
	public static String getTimesAfterMonthsStr(int month){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		c.add(Calendar.MONTH, month);
		return df.format(c.getTime());
	}
	
	public static long getTimesAfterDays(int day){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		c.add(Calendar.DATE, day);
		return c.getTime().getTime();
	}
	public static String getTimesAfterDaysStr(int day){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(System.currentTimeMillis());
		c.add(Calendar.DATE, day);
		return df.format(c.getTime());
	}

	/**
	 * @description	为不足位数的数字串前自动补"0"，若超出指定长度，则从其尾部截取指定长度的字串
	 * 				*最多补足15个"0"
	 * @param 	_idNum: 原始数字串
	 * 			_idNumLen: 原始数字串长度
	 * 			_hopeLength: 期望长度
	 * @return
	 * @throws Exception 超出自动补0范围（最多15位）
	 * @see 
	 */
	private static String fillStr(String _idNum, int _idNumLen, int _hopeLength) throws Exception{
		if(_hopeLength-_idNumLen<0){
			return _idNum.substring(_hopeLength-_idNumLen, _idNumLen);
		}else{
			switch(_hopeLength-_idNumLen){
			case 0:
				return _idNum;
			case 1:
				return "0"+_idNum;
			case 2:
				return "00"+_idNum;
			case 3:
				return "000"+_idNum;
			case 4:
				return "0000"+_idNum;
			case 5:
				return "00000"+_idNum;
			case 6:
				return "000000"+_idNum;
			case 7:
				return "0000000"+_idNum;
			case 8:
				return "00000000"+_idNum;
			case 9:
				return "000000000"+_idNum;
			case 10:
				return "0000000000"+_idNum;
			case 11:
				return "00000000000"+_idNum;
			case 12:
				return "000000000000"+_idNum;
			case 13:
				return "0000000000000"+_idNum;
			case 14:
				return "00000000000000"+_idNum;
			case 15:
				return "000000000000000"+_idNum;
			default:
				throw new Exception("超出自动补\"\"范围（最多15位）");
			}
		}
	}
}
