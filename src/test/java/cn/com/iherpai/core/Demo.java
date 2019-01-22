package cn.com.iherpai.core;

import cn.com.iherpai.common.underware.DateTime;
import cn.com.iherpai.common.underware.Id62Transfer;
import cn.com.iherpai.common.underware.Id63Transfer;

public class Demo {
	public static void main(String[] args) throws Exception{

		//01~05	YYYYMMDD			max: 16,777,279
//		String idPart1st = Id63Transfer.toEncode63( Long.parseLong( DateTime.getTheDateStr() ) );
//		//06~11 HHmmSSms			max: 1,073,741,887
//		String idPart2st = Id63Transfer.toEncode63( Long.parseLong( DateTime.getTheDateWholeTailStr() ) );
//		
//		for(int i=0; i<10; i++) {
//			Thread.sleep(11);
//			System.out.println(DateTime.getTheDateStr4Id() + "\t" + DateTime.getTheDateMsTailStr());
//		}
//		System.out.println("--------------- " + Id62Transfer.toEncode62( Long.parseLong( DateTime.getTheDateStr4Id() ) ) );
		System.out.println("---------++------ " + DateTime.getTheDateStr() );
	}
}
