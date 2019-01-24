package cn.com.iherpai.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Id61Transfer {
	private static Map<Long, String> _61EncodeMap = new HashMap<Long, String>();
	private static Map<String, Long> _61DecodeMap = new HashMap<String, Long>();
	
	static{
		_61EncodeMap.put(0L, "1");
		_61EncodeMap.put(1L, "2");
		_61EncodeMap.put(2L, "3");
		_61EncodeMap.put(3L, "4");
		_61EncodeMap.put(4L, "5");
		_61EncodeMap.put(5L, "6");
		_61EncodeMap.put(6L, "7");
		_61EncodeMap.put(7L, "8");
		_61EncodeMap.put(8L, "9");
		_61EncodeMap.put(9L, "A");
		_61EncodeMap.put(10L, "B");
		_61EncodeMap.put(11L, "C");
		_61EncodeMap.put(12L, "D");
		_61EncodeMap.put(13L, "E");
		_61EncodeMap.put(14L, "F");
		_61EncodeMap.put(15L, "G");
		_61EncodeMap.put(16L, "H");
		_61EncodeMap.put(17L, "I");
		_61EncodeMap.put(18L, "J");
		_61EncodeMap.put(19L, "K");
		_61EncodeMap.put(20L, "L");
		_61EncodeMap.put(21L, "M");
		_61EncodeMap.put(22L, "N");
		_61EncodeMap.put(23L, "O");
		_61EncodeMap.put(24L, "P");
		_61EncodeMap.put(25L, "Q");
		_61EncodeMap.put(26L, "R");
		_61EncodeMap.put(27L, "S");
		_61EncodeMap.put(28L, "T");
		_61EncodeMap.put(29L, "U");
		_61EncodeMap.put(30L, "V");
		_61EncodeMap.put(31L, "W");
		_61EncodeMap.put(32L, "X");
		_61EncodeMap.put(33L, "Y");
		_61EncodeMap.put(34L, "Z");
		_61EncodeMap.put(35L, "a");
		_61EncodeMap.put(36L, "b");
		_61EncodeMap.put(37L, "c");
		_61EncodeMap.put(38L, "d");
		_61EncodeMap.put(39L, "e");
		_61EncodeMap.put(40L, "f");
		_61EncodeMap.put(41L, "g");
		_61EncodeMap.put(42L, "h");
		_61EncodeMap.put(43L, "i");
		_61EncodeMap.put(44L, "j");
		_61EncodeMap.put(45L, "k");
		_61EncodeMap.put(46L, "l");
		_61EncodeMap.put(47L, "m");
		_61EncodeMap.put(48L, "n");
		_61EncodeMap.put(49L, "o");
		_61EncodeMap.put(50L, "p");
		_61EncodeMap.put(51L, "q");
		_61EncodeMap.put(52L, "r");
		_61EncodeMap.put(53L, "s");
		_61EncodeMap.put(54L, "t");
		_61EncodeMap.put(55L, "u");
		_61EncodeMap.put(56L, "v");
		_61EncodeMap.put(57L, "w");
		_61EncodeMap.put(58L, "x");
		_61EncodeMap.put(59L, "y");
		_61EncodeMap.put(60L, "z");

		_61DecodeMap.put("1", 0L);
		_61DecodeMap.put("2", 1L);
		_61DecodeMap.put("3", 2L);
		_61DecodeMap.put("4", 3L);
		_61DecodeMap.put("5", 4L);
		_61DecodeMap.put("6", 5L);
		_61DecodeMap.put("7", 6L);
		_61DecodeMap.put("8", 7L);
		_61DecodeMap.put("9", 8L);
		_61DecodeMap.put("A", 9L);
		_61DecodeMap.put("B", 10L);
		_61DecodeMap.put("C", 11L);
		_61DecodeMap.put("D", 12L);
		_61DecodeMap.put("E", 13L);
		_61DecodeMap.put("F", 14L);
		_61DecodeMap.put("G", 15L);
		_61DecodeMap.put("H", 16L);
		_61DecodeMap.put("I", 17L);
		_61DecodeMap.put("J", 18L);
		_61DecodeMap.put("K", 19L);
		_61DecodeMap.put("L", 20L);
		_61DecodeMap.put("M", 21L);
		_61DecodeMap.put("N", 22L);
		_61DecodeMap.put("O", 23L);
		_61DecodeMap.put("P", 24L);
		_61DecodeMap.put("Q", 25L);
		_61DecodeMap.put("R", 26L);
		_61DecodeMap.put("S", 27L);
		_61DecodeMap.put("T", 28L);
		_61DecodeMap.put("U", 29L);
		_61DecodeMap.put("V", 30L);
		_61DecodeMap.put("W", 31L);
		_61DecodeMap.put("X", 32L);
		_61DecodeMap.put("Y", 33L);
		_61DecodeMap.put("Z", 34L);
		_61DecodeMap.put("a", 35L);
		_61DecodeMap.put("b", 36L);
		_61DecodeMap.put("c", 37L);
		_61DecodeMap.put("d", 38L);
		_61DecodeMap.put("e", 39L);
		_61DecodeMap.put("f", 40L);
		_61DecodeMap.put("g", 41L);
		_61DecodeMap.put("h", 42L);
		_61DecodeMap.put("i", 43L);
		_61DecodeMap.put("j", 44L);
		_61DecodeMap.put("k", 45L);
		_61DecodeMap.put("l", 46L);
		_61DecodeMap.put("m", 47L);
		_61DecodeMap.put("n", 48L);
		_61DecodeMap.put("o", 49L);
		_61DecodeMap.put("p", 50L);
		_61DecodeMap.put("q", 51L);
		_61DecodeMap.put("r", 52L);
		_61DecodeMap.put("s", 53L);
		_61DecodeMap.put("t", 54L);
		_61DecodeMap.put("u", 55L);
		_61DecodeMap.put("v", 56L);
		_61DecodeMap.put("w", 57L);
		_61DecodeMap.put("x", 58L);
		_61DecodeMap.put("y", 59L);
		_61DecodeMap.put("z", 60L);
	}
	
	
	
	public static String toEncode61(Long xCode){
		StringBuffer res = null;
		if(xCode!=null && xCode>=0L){
			res = new StringBuffer("");
			long _tempNum = xCode;
			long _tempRst = 0L;
			while(true){
				_tempRst = _tempNum / 61L;
				long _tempMod = _tempNum % 61L;
				res.append( _61EncodeMap.get(_tempMod) );
				if(_tempRst>=61L){
					_tempNum = _tempRst;
				}else{
//					res.append( _61EncodeMap.get(_tempRst) );
					break;
				}
			}
		}else{
			throw new NumberFormatException();
		}
		return res.reverse().toString();
	}
	
	
	
	public static Long toDecode61(String xCode){
		Long res = null;
		if(xCode!=null && !xCode.trim().equals("")){
			res = 0L;
			for(int idx=0; idx<xCode.length(); idx++){
				res = res + ( _61DecodeMap.get(xCode.substring(idx, idx+1)) * getPow(61L, (xCode.length()-1-idx)) );
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
	
	
	
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		Id61Transfer iferx = new Id61Transfer();
		//long xx = 2099123123595999L;
		long xx = 16777215L;
//		long xx = 1000123123595999L;		201212161519121912
//		long xx =99999L;
//		long xx =9999999L;
//		long xx =9999999L;
		System.out.println("to 61Encode: "+ iferx.toEncode61(xx));
		String yy = iferx.toEncode61(xx);
		System.out.println("to 61Decode: "+ iferx.toDecode61(yy));
		/*
		int i=0;
		while(i<1000){
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long beginMs = DateTime.getCurrentTimestampMs();
//			String xid = IdGenerator.generate63("AABBCCDDEEFFGGCOMPUTER");
//			System.out.println("xid length: "+xid.length()+"\tId Generate: "+ xid);
			i++;
			long endMs = DateTime.getCurrentTimestampMs();
			System.out.println("TOTAL MS: "+(endMs-beginMs));
		}
		*/
		
		Thread th = Thread.currentThread();
		System.out.println("th.getId(): " + th.getId());
		System.out.println(iferx.toDecode61("111111"));
		System.out.println(iferx.toDecode61("1zzzzzz"));
		System.out.println(iferx.toEncode61(56800235583L));
		System.out.println(iferx.toDecode61("1fF2xFa"));
		System.out.println(iferx.toEncode61(37783795570L));
		System.out.println(iferx.toDecode61("zzzzz"));
		System.out.println(iferx.toEncode61(916132832L));
		System.out.println("___________________________________________________________________________");
		System.out.println(iferx.toDecode61("z"));
		System.out.println(iferx.toDecode61("zz"));
		System.out.println(iferx.toDecode61("zzz"));
		System.out.println(iferx.toDecode61("zzzz"));
		System.out.println(iferx.toDecode61("zzzzz"));
		System.out.println(iferx.toDecode61("zzzzzz"));
		System.out.println("..................................");
		System.out.println(iferx.toEncode61(61L));
		System.out.println(iferx.toEncode61(3843L));
		System.out.println(iferx.toEncode61(238327L));
		System.out.println(iferx.toEncode61(14776335L));
		System.out.println(iferx.toEncode61(916132831L));
		System.out.println(iferx.toEncode61(56800235583L));
		
		System.out.println("___________________________________________________________________________");
		int xxx=0;
		int uu = 0;
		long mxx = 56800235583L;
		Random rn = new Random();
		while(xxx<0){
			long sk = Math.abs(rn.nextLong());
			if(sk>=mxx){
				long pp = sk%mxx;
				String ww = iferx.toEncode61(pp);
				if(ww.length()>6){
					uu++;
					System.out.println(sk+"\t\t"+ww+"\t\t"+pp+"\t\t"+(pp-mxx));
				}
				System.out.println(pp+"\t\t"+ww);
				xxx++;				
			}			
		}
		System.out.println("____________________________________________________________________________________________________________________   "+ uu);
		

		Id61Transfer ifer = new Id61Transfer();
		long xx0 = 2013010123595999L;
		System.out.println(xx0+" to 61Encode: "+ ifer.toEncode61(xx0));
		long xx1 = 2014010123595999L;
		System.out.println(xx1+" to 61Encode: "+ ifer.toEncode61(xx1));
		long xx2 = 2014070123595999L;
		System.out.println(xx2+" to 61Encode: "+ ifer.toEncode61(xx2));
		long xx3 = 2015010123595999L;
		System.out.println(xx3+" to 61Encode: "+ ifer.toEncode61(xx3));
		long xx4 = 2015040123595999L;
		System.out.println(xx4+" to 61Encode: "+ ifer.toEncode61(xx4));
		long xx5 = 2015040123595999L;
		System.out.println(xx5+" to 61Encode: "+ ifer.toEncode61(xx5));
		long xx6 = 2015080123595999L;
		System.out.println(xx6+" to 61Encode: "+ ifer.toEncode61(xx6));
		long xx7 = 2016010123595999L;
		System.out.println(xx7+" to 61Encode: "+ ifer.toEncode61(xx7));
		long xx8 = 2016020123595999L;
		System.out.println(xx8+" to 61Encode: "+ ifer.toEncode61(xx8));
		long xx9 = 2016020123595999L;
		System.out.println(xx9+" to 61Encode: "+ ifer.toEncode61(xx9));
		long xx10 = 2016030123595999L;
		System.out.println(xx10+" to 61Encode: "+ ifer.toEncode61(xx10));
		long xx11 = 2016040123595999L;
		System.out.println(xx11+" to 61Encode: "+ ifer.toEncode61(xx11));
		long xx12 = 2016050123595999L;
		System.out.println(xx12+" to 61Encode: "+ ifer.toEncode61(xx12));
		long xx13 = 2016060123595999L;
		System.out.println(xx13+" to 61Encode: "+ ifer.toEncode61(xx13));
		long xx14 = 2016070123595999L;
		System.out.println(xx14+" to 61Encode: "+ ifer.toEncode61(xx14));
		long xx15 = 2016080123595999L;
		System.out.println(xx15+" to 61Encode: "+ ifer.toEncode61(xx15));
		long xx16 = 2016090123595999L;
		System.out.println(xx16+" to 61Encode: "+ ifer.toEncode61(xx16));
		long xx17 = 2016100123595999L;
		System.out.println(xx17+" to 61Encode: "+ ifer.toEncode61(xx17));
		long xx18 = 2016110123595999L;
		System.out.println(xx18+" to 61Encode: "+ ifer.toEncode61(xx18));
		long xx19 = 2016120123595999L;
		System.out.println(xx19+" to 61Encode: "+ ifer.toEncode61(xx19));
		long xx20 = 20991231L;
		System.out.println(xx20+" to 61Encode: "+ ifer.toEncode61(xx20));
		long xx21 = 2099123L;
		System.out.println(xx21+" to 61Encode: "+ ifer.toEncode61(xx21));
		long xx22 = 209912L;
		System.out.println(xx22+" to 61Encode: "+ ifer.toEncode61(xx22));
		System.out.println(Thread.currentThread().getId());
		long xx23 = 8999999;
		System.out.println(xx23+" to 61Encode: "+ ifer.toEncode61(xx23));
	}

}
