package cn.com.iherpai.common.utils;

import java.util.HashMap;
import java.util.Map;

public class Id36Transfer {
	private static Map<Long, String> _36EncodeMap = new HashMap<Long, String> ();
	private static Map<String, Long> _36DecodeMap = new HashMap<String, Long> ();
	
	static{
		_36EncodeMap.put(0L, "0");
		_36EncodeMap.put(1L, "1");
		_36EncodeMap.put(2L, "2");
		_36EncodeMap.put(3L, "3");
		_36EncodeMap.put(4L, "4");
		_36EncodeMap.put(5L, "5");
		_36EncodeMap.put(6L, "6");
		_36EncodeMap.put(7L, "7");
		_36EncodeMap.put(8L, "8");
		_36EncodeMap.put(9L, "9");
		_36EncodeMap.put(10L, "A");
		_36EncodeMap.put(11L, "B");
		_36EncodeMap.put(12L, "C");
		_36EncodeMap.put(13L, "D");
		_36EncodeMap.put(14L, "E");
		_36EncodeMap.put(15L, "F");
		_36EncodeMap.put(16L, "G");
		_36EncodeMap.put(17L, "H");
		_36EncodeMap.put(18L, "I");
		_36EncodeMap.put(19L, "J");
		_36EncodeMap.put(20L, "K");
		_36EncodeMap.put(21L, "L");
		_36EncodeMap.put(22L, "M");
		_36EncodeMap.put(23L, "N");
		_36EncodeMap.put(24L, "O");
		_36EncodeMap.put(25L, "P");
		_36EncodeMap.put(26L, "Q");
		_36EncodeMap.put(27L, "R");
		_36EncodeMap.put(28L, "S");
		_36EncodeMap.put(29L, "T");
		_36EncodeMap.put(30L, "U");
		_36EncodeMap.put(31L, "V");
		_36EncodeMap.put(32L, "W");
		_36EncodeMap.put(33L, "X");
		_36EncodeMap.put(34L, "Y");
		_36EncodeMap.put(35L, "Z");

		_36DecodeMap.put("0", 0L);
		_36DecodeMap.put("1", 1L);
		_36DecodeMap.put("2", 2L);
		_36DecodeMap.put("3", 3L);
		_36DecodeMap.put("4", 4L);
		_36DecodeMap.put("5", 5L);
		_36DecodeMap.put("6", 6L);
		_36DecodeMap.put("7", 7L);
		_36DecodeMap.put("8", 8L);
		_36DecodeMap.put("9", 9L);
		_36DecodeMap.put("A", 10L);
		_36DecodeMap.put("B", 11L);
		_36DecodeMap.put("C", 12L);
		_36DecodeMap.put("D", 13L);
		_36DecodeMap.put("E", 14L);
		_36DecodeMap.put("F", 15L);
		_36DecodeMap.put("G", 16L);
		_36DecodeMap.put("H", 17L);
		_36DecodeMap.put("I", 18L);
		_36DecodeMap.put("J", 19L);
		_36DecodeMap.put("K", 20L);
		_36DecodeMap.put("L", 21L);
		_36DecodeMap.put("M", 22L);
		_36DecodeMap.put("N", 23L);
		_36DecodeMap.put("O", 24L);
		_36DecodeMap.put("P", 25L);
		_36DecodeMap.put("Q", 26L);
		_36DecodeMap.put("R", 27L);
		_36DecodeMap.put("S", 28L);
		_36DecodeMap.put("T", 29L);
		_36DecodeMap.put("U", 30L);
		_36DecodeMap.put("V", 31L);
		_36DecodeMap.put("W", 32L);
		_36DecodeMap.put("X", 33L);
		_36DecodeMap.put("Y", 34L);
		_36DecodeMap.put("Z", 35L);
	}
	
	
	
	public static String toEncode36(Long xCode){
		StringBuffer res = null;
		if(xCode!=null && xCode>=0L){
			res = new StringBuffer("");
			long _tempNum = xCode;
			long _tempRst = 0L;
			while(true){
				_tempRst = _tempNum / 36L;
				long _tempMod = _tempNum % 36L;
				res.append( _36EncodeMap.get(_tempMod) );
				if(_tempRst>=36L){
					_tempNum = _tempRst;
				}else{
					res.append( _36EncodeMap.get(_tempRst) );
					break;
				}
			}
		}else{
			throw new NumberFormatException();
		}
		return res.reverse().toString();
	}
	
	
	
	public static Long toDecode36(String xCode){
		Long res = null;
		if(xCode!=null && !xCode.trim().equals("")){
			res = 0L;
			for(int idx=0; idx<xCode.length(); idx++){
				res = res + ( _36DecodeMap.get(xCode.substring(idx, idx+1)) * getPow(36L, (xCode.length()-1-idx)) );
			}
		}else{
			throw new NumberFormatException();
		}
		return res;
	}
	
	
	
	private static long getPow(long x, long y){
        if(y == 0) return 1;
        if(y == 1) return x;
        return x*getPow(x, y-1);
    }
	
	
	
	public static void main(String[] args){
		Id36Transfer ifer = new Id36Transfer();
		long xx0 = 2013010123595999L;
		System.out.println(xx0+" to 36Encode: "+ ifer.toEncode36(xx0));
		long xx1 = 2014010123595999L;
		System.out.println(xx1+" to 36Encode: "+ ifer.toEncode36(xx1));
		long xx2 = 2014070123595999L;
		System.out.println(xx2+" to 36Encode: "+ ifer.toEncode36(xx2));
		long xx3 = 2015010123595999L;
		System.out.println(xx3+" to 36Encode: "+ ifer.toEncode36(xx3));
		long xx4 = 2015040123595999L;
		System.out.println(xx4+" to 36Encode: "+ ifer.toEncode36(xx4));
		long xx5 = 2015040123595999L;
		System.out.println(xx5+" to 36Encode: "+ ifer.toEncode36(xx5));
		long xx6 = 2015080123595999L;
		System.out.println(xx6+" to 36Encode: "+ ifer.toEncode36(xx6));
		long xx7 = 2016010123595999L;
		System.out.println(xx7+" to 36Encode: "+ ifer.toEncode36(xx7));
		long xx8 = 2016020123595999L;
		System.out.println(xx8+" to 36Encode: "+ ifer.toEncode36(xx8));
		long xx9 = 2016020123595999L;
		System.out.println(xx9+" to 36Encode: "+ ifer.toEncode36(xx9));
		long xx10 = 2016030123595999L;
		System.out.println(xx10+" to 36Encode: "+ ifer.toEncode36(xx10));
		long xx11 = 2016040123595999L;
		System.out.println(xx11+" to 36Encode: "+ ifer.toEncode36(xx11));
		long xx12 = 2016050123595999L;
		System.out.println(xx12+" to 36Encode: "+ ifer.toEncode36(xx12));
		long xx13 = 2016060123595999L;
		System.out.println(xx13+" to 36Encode: "+ ifer.toEncode36(xx13));
		long xx14 = 2016070123595999L;
		System.out.println(xx14+" to 36Encode: "+ ifer.toEncode36(xx14));
		long xx15 = 2016080123595999L;
		System.out.println(xx15+" to 36Encode: "+ ifer.toEncode36(xx15));
		long xx16 = 2016090123595999L;
		System.out.println(xx16+" to 36Encode: "+ ifer.toEncode36(xx16));
		long xx17 = 2016100123595999L;
		System.out.println(xx17+" to 36Encode: "+ ifer.toEncode36(xx17));
		long xx18 = 2016110123595999L;
		System.out.println(xx18+" to 36Encode: "+ ifer.toEncode36(xx18));
		long xx19 = 2016120123595999L;
		System.out.println(xx19+" to 36Encode: "+ ifer.toEncode36(xx19));
		
	}
}


