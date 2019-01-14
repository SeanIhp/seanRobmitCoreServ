package cn.com.iherpai.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private static SimpleDateFormat sdfWholeTail = new SimpleDateFormat("HHmmssms");
	private static SimpleDateFormat sdfTail = new SimpleDateFormat("HHmm");
	private static SimpleDateFormat sdf4Id = new SimpleDateFormat("yyyyMMddHHmmssms");
	private static SimpleDateFormat sdf4IdPlus = new SimpleDateFormat("yyyy,MM,dd,HH,mm,ss,ms");
	private static SimpleDateFormat sdfCurt = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdfCurtCn = new SimpleDateFormat("yyyy年MM月dd日");
	private static SimpleDateFormat sdfWhole = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat sdfWholeCn = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
	private static SimpleDateFormat sdfWholeFullCn = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒ms");
	private static SimpleDateFormat sdfDataTimePath = new SimpleDateFormat("yyyyMMdd\\HHmm\\");
	private static SimpleDateFormat sdfDataTimeUrl = new SimpleDateFormat("yyyyMMdd/HHmm/");
	

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
	public static String getTheDateStr4Id(){
		return sdf4Id.format(new Date());
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
}
