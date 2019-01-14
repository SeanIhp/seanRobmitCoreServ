/**
 * Copyright (C), 2003-2014, 
 * FileName:	TestTimer.java
 * Author:		Sean
 * Date:		2014-04-19	10:00
 * Description:	
 * History:
 * <author>		<time>			<version>		<description> * 
 */
package cn.com.iherpai.common.utils;

import java.text.SimpleDateFormat;
import org.apache.log4j.Logger;

/**
 * @author		Sean
 * @description	���ڿ������Խ׶εļ�ʱ�� * 
 */
public class TestTimer {
	private static Logger log = Logger.getLogger(TestTimer.class.getName());
	public static final int ZERO = 0;
	public static final int ONE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6;
	public static final int SEVEN = 7;
	public static final int EIGHT = 8;
	public static final int NINE = 9;
	
	private static String[] taskCode = new String[10];		//������
	private static String[] taskIntro = new String[10];		//��������
	private static long[] startMs = new long[10];
	private static long[] endMs = new long[10];
	private static long[] resultMs = new long[10];
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.ms");	

	/**
	 * @description	��ʼ�����ʱ
	 * @param 	_timerIndex: ��ʱ�����
	 * 			_taskCode: ������
	 * 			_taskIntro: ��������
	 * @return
	 * @throws Exception
	 * @see 
	 */
	public static void start(int _timerIndex, String _taskCode, String _taskIntro){
		startMs[_timerIndex] = 0L;
		endMs[_timerIndex] = 0L;
		resultMs[_timerIndex] = 0L;
		taskCode[_timerIndex] = _taskCode;
		taskIntro[_timerIndex] = _taskIntro;
		startMs[_timerIndex] = DateTime.getCurrentTimestampMs();
		log.debug("TestTimer<"+_timerIndex+">--[CODE: "+taskCode[_timerIndex]+"]--[MISSION: "+taskIntro[_timerIndex]+"--��ʼ�ڣ�"+sdf.format(startMs[_timerIndex])+"]");
	}

	
	/**
	 * @description	ȡ�õ�ǰʱ��
	 * @param 	
	 * @return
	 * @throws Exception
	 * @see 
	 */
	public static String getTimestamp(){
		return DateTime.getTheDateStrWholeFullCn();
	}

	
	/**
	 * @description	���������ʱ
	 * @param 	_timerIndex: ��ʱ�����
	 * @return
	 * @throws Exception
	 * @see 
	 */
	public static void end(int _timerIndex){
		endMs[_timerIndex] = DateTime.getCurrentTimestampMs();
		TestTimer.showResult(_timerIndex);
	}


	/**
	 * @description	����(���е�)�����ʱ
	 * @param 
	 * @return
	 * @throws Exception
	 * @see 
	 */
	public static void endAll(){
		for(int i=0; i<10; i++){
			if(taskCode[i]!=null && taskCode[i]!=""){
				TestTimer.end(i);
			}
		}
	}

	/**
	 * @description	�����ʱ���
	 * @param 	_timerIndex: ��ʱ�����
	 * @return
	 * @throws Exception
	 * @see 
	 */
	private static void showResult(int _timerIndex){
		//resultMs[_timerIndex] = startMs[_timerIndex]-endMs[_timerIndex];
		resultMs[_timerIndex] = endMs[_timerIndex] - startMs[_timerIndex];
		log.debug("TestTimer<"+_timerIndex+">--[CODE: "+taskCode[_timerIndex]+"]--[MISSION: "+taskIntro[_timerIndex]+"]\n--����ʱ: \n\t"+((int)resultMs[_timerIndex]/1000)+"��  \n\t"+resultMs[_timerIndex]+"����");
	}
}
