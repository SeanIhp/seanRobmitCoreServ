/**
 * Copyright (C), 2003-2014, 
 * FileName:	IdGenerator.java
 * Author:		Sean
 * Date:		2014-04-19	14:30
 * Description:	
 * History:
 * <author>		<time>			<version>		<description>  
 */
package cn.com.iherpai.common.utils;

import java.util.LinkedList;
import java.util.Random;

import org.apache.log4j.Logger;

import cn.com.iherpai.common.consts.IhpConfig;
import cn.com.iherpai.common.underware.DateTime;
import cn.com.iherpai.common.underware.Id62Transfer;
import cn.com.iherpai.common.underware.Id63Transfer;

public class IdGenerator {
	private static Logger log = Logger.getLogger(IdGenerator.class.getName());
	private static final int MINSEED = IhpConfig.ID_GENERATOR_MINSEED;
	private static final int MAXSEED = IhpConfig.ID_GENERATOR_MAXSEED;
	private static LinkedList<Long> randSeed = new LinkedList<Long>();
	private static Random rnd = new Random();
	private static long maxRnd = 56800235583L;
	{
		long temp = 0;
		long tempLong = 0;
		while(randSeed.size()<IdGenerator.MAXSEED){
			temp = Math.abs(rnd.nextLong());
			if(temp>maxRnd){				
				tempLong = Math.abs(temp%maxRnd);
			}else{
				tempLong = Math.abs(temp);
			}
			if(!randSeed.contains(tempLong)){
				randSeed.addFirst(tempLong);
			}else{
				continue;
			}
		}
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

	/**
	 * @description	为不足位数的数字串前自动补"_"，若超出指定长度，则从其尾部截取指定长度的字串
	 * 				*最多补足15个"_"
	 * @param 	_idNum: 原始数字串
	 * 			_idNumLen: 原始数字串长度
	 * 			_hopeLength: 期望长度
	 * @return
	 * @throws Exception 超出自动补0范围（最多15位）
	 * @see 
	 */
	private static String fillNumStr(String _idNum, int _idNumLen, int _hopeLength) throws Exception{
		if(_hopeLength-_idNumLen<0){
			System.out.println(_idNum+"\t\t\t"+_idNumLen+_hopeLength+"\t\t\t");
			//return _idNum.substring(_hopeLength-_idNumLen, _idNumLen);
			return _idNum.substring(_idNum.length()-_hopeLength, _hopeLength);
		}else{
			switch(_hopeLength-_idNumLen){
			case 0:
				return _idNum;
			case 1:
				return "_"+_idNum;
			case 2:
				return "__"+_idNum;
			case 3:
				return "___"+_idNum;
			case 4:
				return "____"+_idNum;
			case 5:
				return "_____"+_idNum;
			case 6:
				return "______"+_idNum;
			case 7:
				return "_______"+_idNum;
			case 8:
				return "________"+_idNum;
			case 9:
				return "_________"+_idNum;
			case 10:
				return "__________"+_idNum;
			case 11:
				return "___________"+_idNum;
			case 12:
				return "____________"+_idNum;
			case 13:
				return "_____________"+_idNum;
			case 14:
				return "______________"+_idNum;
			case 15:
				return "_______________"+_idNum;
			default:
				throw new Exception("超出自动补\"_\"范围（最多15位）");
			}
		}
	}
	
	

	/**
	 * @author		Sean
	 * @description	通用的数据ID生成器，生成由32个(64进制)字符组成的ID字符串，其各组成部分如下：
	 * 				01~05	YYYYMMDD				占5位	max: 16,777,279
	 * 				06~11	HHmmSSms				占6位	max: 1,073,741,887
	 * 				12~15	ID生成器所在服务器		占4位	max: 262,207
	 * 				16~19	数据用途					占4位	max: 262,207
	 * ·			20~23	数据库服务器				占4位	max: 262,207
	 * 				24~27	数据表					占4位	max: 262,207
	 * 				28~32	随机数					占5位	max: 16,777,279
	 */
	public static String generate(long _databaseCode, long _datatableCode) throws Exception{	
		//初始化随机数种子
		if (randSeed==null) {
			randSeed = new LinkedList<Long>();
		}
		//生成不少于IdGenerator.MINSEED且不多于IdGenerator.MAXSEED的备用随机数
		if (randSeed.size() < IdGenerator.MINSEED) {
			long temp = 0;
			long tempLong = 0;
			while(randSeed.size()<IdGenerator.MAXSEED){
				temp = Math.abs(rnd.nextLong());
				if(temp>maxRnd){				
					tempLong = Math.abs(temp%maxRnd);
				}else{
					tempLong = Math.abs(temp);
				}
				if(!randSeed.contains(tempLong)){
					randSeed.addFirst(tempLong);
				}else{
					continue;
				}
			}
		}
		//取用随机数
		Long randNum = randSeed.removeLast();
		//01~07	YYYYMMDD			min: 20150101[1337755]		max: 29991231[1C9A13F]
		String idPart1st = Id62Transfer.toEncode62( Long.parseLong( DateTime.getTheDateStr() ) );
		//06~11 HHmmSSms			min: 000000000				max: 916,132,831
		String idPart2st = Id62Transfer.toEncode62( Long.parseLong( DateTime.getTheDateWholeTailStr() ) );
		//12~16	ID生成器所在服务器	min:						max: 916,132,831
		String idPart3st = Id62Transfer.toEncode62( IhpConfig.ID_GENERATOR_SERVER_CODE );
		//17~21	数据库服务器			min:						max: 916,132,831
		String idPart5st = Id62Transfer.toEncode62( _databaseCode );
		//22~26	数据表				min:						max: 916,132,831
		String idPart6st = Id62Transfer.toEncode62( _datatableCode );
		//27~32	随机数				min:						max: 56,800,235,583
//		log.debug("["+TestTimer.getTimestamp()+"] 随机值："+Long.parseLong(randNum.toString()));
		String idPart7st = Id62Transfer.toEncode62( Long.parseLong(randNum.toString()) );
		/*
		//22~26	数据表				min:			max: 1,048,575
		String idPart6st = Id62Transfer.toEncode62( 1048575L );
		//27~32	随机数				min:			max: 268,435,455
		//String idPart7st = Id62Transfer.toEncode62( 1268435455L );		 
		*/
		
//		log.debug("["+TestTimer.getTimestamp()+"] 生成ID基础值：");
//		log.debug("\tidPart1st: "+idPart1st+"\tidPart2st: "+idPart2st+"\tidPart3st: "+idPart3st+"\tidPart5st: "+idPart5st+"\tidPart6st: "+idPart6st+"\tidPart7st: "+idPart7st);
//		System.out.println("["+TestTimer.getTimestamp()+"] 生成ID基础值：");
//		System.out.println("\tidPart1st: "+idPart1st+"\tidPart2st: "+idPart2st+"\tidPart3st: "+idPart3st+"\tidPart5st: "+idPart5st+"\tidPart6st: "+idPart6st+"\tidPart7st: "+idPart7st);
		
		try {
			idPart1st = fillStr(idPart1st, idPart1st.length(), 5);
			idPart2st = fillStr(idPart2st, idPart2st.length(), 6);
			idPart3st = fillStr(idPart3st, idPart3st.length(), 5);
			idPart5st = fillStr(idPart5st, idPart5st.length(), 5);
			idPart6st = fillStr(idPart6st, idPart6st.length(), 5);
			idPart7st = fillStr(idPart7st, idPart7st.length(), 6);
		} catch (Exception e) {
			throw e;
		}
		
//		log.debug("["+TestTimer.getTimestamp()+"] 调整ID各组成部分长度：");
//		log.debug("\tidPart1st: "+idPart1st+"\tidPart2st: "+idPart2st+"\tidPart3st: "+idPart3st+"\tidPart5st: "+idPart5st+"\tidPart6st: "+idPart6st+"\tidPart7st: "+idPart7st);
//		System.out.println("["+TestTimer.getTimestamp()+"] 调整ID各组成部分长度：");
//		System.out.println("\tidPart1st: "+idPart1st+"\tidPart2st: "+idPart2st+"\tidPart3st: "+idPart3st+"\tidPart5st: "+idPart5st+"\tidPart6st: "+idPart6st+"\tidPart7st: "+idPart7st);
//		log.debug("["+TestTimer.getTimestamp()+"] 最终生成ID：");
//		log.debug("ID: " + idPart1st + idPart2st + idPart3st + idPart4st + idPart5st + idPart6st + idPart7st);
		
		return idPart1st + idPart2st + idPart3st + idPart5st + idPart6st + idPart7st;
	}
	
	
	public static void main(String[] args) {
		String id = null;
		try {
			for(int i=0; i<10000; i++){
				id = IdGenerator.generate(IhpConfig.ID_GENERATOR_DATA_DATABASE_CODE, IhpConfig.ID_GENERATOR_DATA_TABLE_CODE);
				System.out.println("--< "+i+" >----------------[ "+id+" ]------------------------------------------------------------------------------------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(id);
	}
	
	
	

	/**
	 * @author		Sean
	 * @description	通用的数据ID生成器，生成由32个(64进制)字符组成的ID字符串，其各组成部分如下：
	 * 				01~05	YYYYMMDD				占5位	max: 16,777,279
	 * 				06~11	HHmmSSms				占6位	max: 1,073,741,887
	 * 				12~15	ID生成器所在服务器		占4位	max: 262,207
	 * 				16~19	数据用途					占4位	max: 262,207
	 * ·			20~23	数据库服务器				占4位	max: 262,207
	 * 				24~27	数据表					占4位	max: 262,207
	 * 				28~32	随机数					占5位	max: 16,777,279
	 */
	public static String generate63(long _idUse, long _databaseCode, long _datatableCode) throws Exception{	
		//初始化随机数种子
		if (randSeed==null) {
			randSeed = new LinkedList<Long>();
		}
		//生成不少于IdGenerator.MINSEED且不多于IdGenerator.MAXSEED的备用随机数
		if (randSeed.size() < IdGenerator.MINSEED) {
			long temp = 0;
			long tempLong = 0;
			while(randSeed.size()<IdGenerator.MAXSEED){
				temp = Math.abs(rnd.nextLong());
				if(temp>maxRnd){				
					tempLong = Math.abs(temp%maxRnd);
				}else{
					tempLong = Math.abs(temp);
				}
				if(!randSeed.contains(tempLong)){
					randSeed.addFirst(tempLong);
				}else{
					continue;
				}
			}
		}
		//取用随机数
		Long randNum = randSeed.removeLast();
		//01~05	YYYYMMDD			max: 16,777,279
		String idPart1st = Id63Transfer.toEncode63( Long.parseLong( DateTime.getTheDateStr() ) );
		//06~11 HHmmSSms			max: 1,073,741,887
		String idPart2st = Id63Transfer.toEncode63( Long.parseLong( DateTime.getTheDateWholeTailStr() ) );
		//12~15	ID生成器所在服务器		max: 262,207
		String idPart3st = Id63Transfer.toEncode63( IhpConfig.ID_GENERATOR_SERVER_CODE );
		//16~19	数据用途				max: 262,207
		String idPart4st = Id63Transfer.toEncode63( _idUse );
		//20~23	数据库服务器			max: 262,207
		String idPart5st = Id63Transfer.toEncode63( _databaseCode );
		//24~27	数据表				max: 262,207
		String idPart6st = Id63Transfer.toEncode63( _datatableCode );
		//28~32	随机数				max: 16,777,279
		String idPart7st = Id63Transfer.toEncode63( Long.parseLong(randNum.toString()) );
		
		//log.debug("["+TestTimer.getTimestamp()+"] 生成ID基础值：");
		//log.debug("\tidPart1st: "+idPart1st+"\tidPart2st: "+idPart2st+"\tidPart3st: "+idPart3st+"\tidPart4st: "+idPart4st+"\tidPart5st: "+idPart5st+"\tidPart6st: "+idPart6st+"\tidPart7st: "+idPart7st);
		
		try {
			idPart1st = fillNumStr(idPart1st, idPart1st.length(), 5);
			idPart2st = fillNumStr(idPart2st, idPart2st.length(), 6);
			idPart3st = fillNumStr(idPart3st, idPart3st.length(), 4);
			idPart4st = fillNumStr(idPart4st, idPart4st.length(), 4);
			idPart5st = fillNumStr(idPart5st, idPart5st.length(), 4);
			idPart6st = fillNumStr(idPart6st, idPart6st.length(), 4);
			idPart7st = fillNumStr(idPart7st, idPart7st.length(), 5);
		} catch (Exception e) {
			throw e;
		}
		
		//log.debug("["+TestTimer.getTimestamp()+"] 调整ID各组成部分长度：");
		//log.debug("\tidPart1st: "+idPart1st+"\tidPart2st: "+idPart2st+"\tidPart3st: "+idPart3st+"\tidPart4st: "+idPart4st+"\tidPart5st: "+idPart5st+"\tidPart6st: "+idPart6st+"\tidPart7st: "+idPart7st);
//		log.debug("["+TestTimer.getTimestamp()+"] 最终生成ID：");
//		log.debug("ID: " + idPart1st + idPart2st + idPart3st + idPart4st + idPart5st + idPart6st + idPart7st);
		
		return idPart1st + idPart2st + idPart3st + idPart4st + idPart5st + idPart6st + idPart7st;
	}
	
	

	/**
	 * @description	生成(指定用途的)ID号
	 * @param 	_idUse: ID用途
	 * 			_taskCode: 任务编号
	 * 			_taskIntro: 作务描述
	 * @return
	 * @throws Exception
	 * @see 
	 */
	public static String generateToken63(String _sessionId) throws Exception{	
		//初始化随机数种子
		if (randSeed==null) {
			randSeed = new LinkedList<Long>();
		}
		//生成不少于IdGenerator.MINSEED且不多于IdGenerator.MAXSEED的备用随机数
		if (randSeed.size() < IdGenerator.MINSEED) {
			long temp = 0;
			long tempLong = 0;
			while(randSeed.size()<IdGenerator.MAXSEED){
				temp = Math.abs(rnd.nextLong());
				if(temp>maxRnd){				
					tempLong = Math.abs(temp%maxRnd);
				}else{
					tempLong = Math.abs(temp);
				}
				if(!randSeed.contains(tempLong)){
					randSeed.addFirst(tempLong);
				}else{
					continue;
				}
			}
		}
		//01~05	YYYYMMDD			max: 16,777,279
		String idPart1st = Id63Transfer.toEncode63( Long.parseLong( DateTime.getTheDateStr() ) );
		//06~11 HHmmSSms			max: 1,073,741,887
		String idPart2st = Id63Transfer.toEncode63( Long.parseLong( DateTime.getTheDateWholeTailStr() ) );
//		//12~15	ID生成器所在服务器		max: 262,207
//		String idPart3st = Id63Transfer.toEncode63( IhpConfig.ID_GENERATOR_SERVER_CODE );
//		//16~19	数据用途				max: 262,207
//		String idPart4st = Id63Transfer.toEncode63( _idUse );
//		//20~23	数据库服务器			max: 262,207
//		String idPart5st = Id63Transfer.toEncode63( _databaseCode );
//		//24~27	数据表				max: 262,207
//		String idPart6st = Id63Transfer.toEncode63( _datatableCode );

		//取用随机数
		//28~32	随机数				max: 16,777,279
		Long randNum = randSeed.removeLast();
		String idPart3st = Id63Transfer.toEncode63( Long.parseLong(randNum.toString()) );
		//28~32	随机数				max: 16,777,279
		randNum = randSeed.removeLast();
		String idPart4st = Id63Transfer.toEncode63( Long.parseLong(randNum.toString()) );
		//28~32	sessionPart				pos: 5 25 1 21 9 29
		String idPart5st = _sessionId.substring(5, 6)+_sessionId.substring(25, 26)+_sessionId.substring(1, 2)+_sessionId.substring(21, 22)+_sessionId.substring(9, 10)+_sessionId.substring(29, 30);
		//28~32	随机数				max: 16,777,279
		randNum = randSeed.removeLast();
		String idPart6st = Id63Transfer.toEncode63( Long.parseLong(randNum.toString()) );
		
//		log.warn("["+TestTimer.getTimestamp()+"] 生成TOKEN基础值：");
//		log.warn("\tidPart1st: "+idPart1st+"\tidPart2st: "+idPart2st+"\tidPart3st: "+idPart3st+"\tidPart4st: "+idPart4st+"\tidPart5st: "+idPart5st+"\tidPart6st: ");
		
		try {
			idPart1st = fillNumStr(idPart1st, idPart1st.length(), 5);
			idPart2st = fillNumStr(idPart2st, idPart2st.length(), 6);
			idPart3st = fillNumStr(idPart3st, idPart3st.length(), 5);
			idPart4st = fillNumStr(idPart4st, idPart4st.length(), 5);
			idPart5st = fillNumStr(idPart5st, idPart5st.length(), 6);
			idPart6st = fillNumStr(idPart6st, idPart6st.length(), 5);
		} catch (Exception e) {
			throw e;
		}
		
//		log.debug("["+TestTimer.getTimestamp()+"] 调整TOKEN各组成部分长度：");
//		log.debug("\tidPart1st: "+idPart1st+"\tidPart2st: "+idPart2st+"\tidPart3st: "+idPart3st+"\tidPart4st: "+idPart4st+"\tidPart5st: "+idPart5st+"\tidPart6st: ");
//		log.warn("["+TestTimer.getTimestamp()+"] 最终生成TOKEN：");
//		log.warn("ID: " + idPart1st + idPart2st + idPart3st + idPart4st + idPart5st + idPart6st);
		
		return idPart1st + idPart2st + idPart3st + idPart4st + idPart5st + idPart6st;
	}
	
	
	
	
	
	
}
