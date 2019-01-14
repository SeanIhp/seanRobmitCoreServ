package cn.com.iherpai.common.underware;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Id62Transfer {
	private static Map<Long, String> _62EncodeMap = new HashMap<Long, String>();
	private static Map<String, Long> _62DecodeMap = new HashMap<String, Long>();
	
	static{
		_62EncodeMap.put(0L, "_");
		_62EncodeMap.put(1L, "1");
		_62EncodeMap.put(2L, "2");
		_62EncodeMap.put(3L, "3");
		_62EncodeMap.put(4L, "4");
		_62EncodeMap.put(5L, "5");
		_62EncodeMap.put(6L, "6");
		_62EncodeMap.put(7L, "7");
		_62EncodeMap.put(8L, "8");
		_62EncodeMap.put(9L, "9");
		_62EncodeMap.put(10L, "A");
		_62EncodeMap.put(11L, "B");
		_62EncodeMap.put(12L, "C");
		_62EncodeMap.put(13L, "D");
		_62EncodeMap.put(14L, "E");
		_62EncodeMap.put(15L, "F");
		_62EncodeMap.put(16L, "G");
		_62EncodeMap.put(17L, "H");
		_62EncodeMap.put(18L, "I");
		_62EncodeMap.put(19L, "J");
		_62EncodeMap.put(20L, "K");
		_62EncodeMap.put(21L, "L");
		_62EncodeMap.put(22L, "M");
		_62EncodeMap.put(23L, "N");
		_62EncodeMap.put(24L, "O");
		_62EncodeMap.put(25L, "P");
		_62EncodeMap.put(26L, "Q");
		_62EncodeMap.put(27L, "R");
		_62EncodeMap.put(28L, "S");
		_62EncodeMap.put(29L, "T");
		_62EncodeMap.put(30L, "U");
		_62EncodeMap.put(31L, "V");
		_62EncodeMap.put(32L, "W");
		_62EncodeMap.put(33L, "X");
		_62EncodeMap.put(34L, "Y");
		_62EncodeMap.put(35L, "Z");
		_62EncodeMap.put(36L, "a");
		_62EncodeMap.put(37L, "b");
		_62EncodeMap.put(38L, "c");
		_62EncodeMap.put(39L, "d");
		_62EncodeMap.put(40L, "e");
		_62EncodeMap.put(41L, "f");
		_62EncodeMap.put(42L, "g");
		_62EncodeMap.put(43L, "h");
		_62EncodeMap.put(44L, "i");
		_62EncodeMap.put(45L, "j");
		_62EncodeMap.put(46L, "k");
		_62EncodeMap.put(47L, "l");
		_62EncodeMap.put(48L, "m");
		_62EncodeMap.put(49L, "n");
		_62EncodeMap.put(50L, "o");
		_62EncodeMap.put(51L, "p");
		_62EncodeMap.put(52L, "q");
		_62EncodeMap.put(53L, "r");
		_62EncodeMap.put(54L, "s");
		_62EncodeMap.put(55L, "t");
		_62EncodeMap.put(56L, "u");
		_62EncodeMap.put(57L, "v");
		_62EncodeMap.put(58L, "w");
		_62EncodeMap.put(59L, "x");
		_62EncodeMap.put(60L, "y");
		_62EncodeMap.put(61L, "z");

		_62DecodeMap.put("_", 0L);
		_62DecodeMap.put("1", 1L);
		_62DecodeMap.put("2", 2L);
		_62DecodeMap.put("3", 3L);
		_62DecodeMap.put("4", 4L);
		_62DecodeMap.put("5", 5L);
		_62DecodeMap.put("6", 6L);
		_62DecodeMap.put("7", 7L);
		_62DecodeMap.put("8", 8L);
		_62DecodeMap.put("9", 9L);
		_62DecodeMap.put("A", 10L);
		_62DecodeMap.put("B", 11L);
		_62DecodeMap.put("C", 12L);
		_62DecodeMap.put("D", 13L);
		_62DecodeMap.put("E", 14L);
		_62DecodeMap.put("F", 15L);
		_62DecodeMap.put("G", 16L);
		_62DecodeMap.put("H", 17L);
		_62DecodeMap.put("I", 18L);
		_62DecodeMap.put("J", 19L);
		_62DecodeMap.put("K", 20L);
		_62DecodeMap.put("L", 21L);
		_62DecodeMap.put("M", 22L);
		_62DecodeMap.put("N", 23L);
		_62DecodeMap.put("O", 24L);
		_62DecodeMap.put("P", 25L);
		_62DecodeMap.put("Q", 26L);
		_62DecodeMap.put("R", 27L);
		_62DecodeMap.put("S", 28L);
		_62DecodeMap.put("T", 29L);
		_62DecodeMap.put("U", 30L);
		_62DecodeMap.put("V", 31L);
		_62DecodeMap.put("W", 32L);
		_62DecodeMap.put("X", 33L);
		_62DecodeMap.put("Y", 34L);
		_62DecodeMap.put("Z", 35L);
		_62DecodeMap.put("a", 36L);
		_62DecodeMap.put("b", 37L);
		_62DecodeMap.put("c", 38L);
		_62DecodeMap.put("d", 39L);
		_62DecodeMap.put("e", 40L);
		_62DecodeMap.put("f", 41L);
		_62DecodeMap.put("g", 42L);
		_62DecodeMap.put("h", 43L);
		_62DecodeMap.put("i", 44L);
		_62DecodeMap.put("j", 45L);
		_62DecodeMap.put("k", 46L);
		_62DecodeMap.put("l", 47L);
		_62DecodeMap.put("m", 48L);
		_62DecodeMap.put("n", 49L);
		_62DecodeMap.put("o", 50L);
		_62DecodeMap.put("p", 51L);
		_62DecodeMap.put("q", 52L);
		_62DecodeMap.put("r", 53L);
		_62DecodeMap.put("s", 54L);
		_62DecodeMap.put("t", 55L);
		_62DecodeMap.put("u", 56L);
		_62DecodeMap.put("v", 57L);
		_62DecodeMap.put("w", 58L);
		_62DecodeMap.put("x", 59L);
		_62DecodeMap.put("y", 60L);
		_62DecodeMap.put("z", 61L);
	}
	
	
	
	public static String toEncode62(Long xCode){
		StringBuffer res = null;
		if(xCode!=null && xCode>=0L){
			res = new StringBuffer("");
			long _tempNum = xCode;
			long _tempRst = 0L;
			while(true){
				_tempRst = _tempNum / 62L;
				long _tempMod = _tempNum % 62L;
				res.append( _62EncodeMap.get(_tempMod) );
				if(_tempRst>=36L){
					_tempNum = _tempRst;
				}else{
//					res.append( _62EncodeMap.get(_tempRst) );
					break;
				}
			}
		}else{
			throw new NumberFormatException();
		}
		return res.reverse().toString();
	}
	
	
	
	public static Long toDecode62(String xCode){
		Long res = null;
		if(xCode!=null && !xCode.trim().equals("")){
			res = 0L;
			for(int idx=0; idx<xCode.length(); idx++){
				res = res + ( _62DecodeMap.get(xCode.substring(idx, idx+1)) * getPow(62L, (xCode.length()-1-idx)) );
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
		Id62Transfer iferx = new Id62Transfer();
		//long xx = 2099123123595999L;
		long xx = 16777215L;
//		long xx = 1000123123595999L;		201212161519121912
//		long xx =99999L;
//		long xx =9999999L;
//		long xx =9999999L;
		System.out.println("to 62Encode: "+ iferx.toEncode62(xx));
		String yy = iferx.toEncode62(xx);
		System.out.println("to 62Decode: "+ iferx.toDecode62(yy));
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
		System.out.println(th.getId());
		System.out.println(iferx.toDecode62("______"));
		System.out.println(iferx.toDecode62("_zzzzzz"));
		System.out.println(iferx.toEncode62(56800235583L));
		System.out.println(iferx.toDecode62("_fF2xFa"));
		System.out.println(iferx.toEncode62(37783795570L));
		System.out.println(iferx.toDecode62("zzzzz"));
		System.out.println(iferx.toEncode62(916132832L));
		System.out.println("___________________________________________________________________________");
		System.out.println(iferx.toDecode62("z"));
		System.out.println(iferx.toDecode62("zz"));
		System.out.println(iferx.toDecode62("zzz"));
		System.out.println(iferx.toDecode62("zzzz"));
		System.out.println(iferx.toDecode62("zzzzz"));
		System.out.println(iferx.toDecode62("zzzzzz"));
		System.out.println("..................................");
		System.out.println(iferx.toEncode62(61L));
		System.out.println(iferx.toEncode62(3843L));
		System.out.println(iferx.toEncode62(238327L));
		System.out.println(iferx.toEncode62(14776335L));
		System.out.println(iferx.toEncode62(916132831L));
		System.out.println(iferx.toEncode62(56800235583L));
		
		System.out.println("___________________________________________________________________________");
		int xxx=0;
		int uu = 0;
		long mxx = 56800235583L;
		Random rn = new Random();
		while(xxx<0){
			long sk = Math.abs(rn.nextLong());
			if(sk>=mxx){
				long pp = sk%mxx;
				String ww = iferx.toEncode62(pp);
				if(ww.length()>6){
					uu++;
					System.out.println(sk+"\t\t"+ww+"\t\t"+pp+"\t\t"+(pp-mxx));
				}
				System.out.println(pp+"\t\t"+ww);
				xxx++;				
			}			
		}
		System.out.println("____________________________________________________________________________________________________________________   "+ uu);
		

		Id62Transfer ifer = new Id62Transfer();
		long xx0 = 2013010123595999L;
		System.out.println(xx0+" to 63Encode: "+ ifer.toEncode62(xx0));
		long xx1 = 2014010123595999L;
		System.out.println(xx1+" to 63Encode: "+ ifer.toEncode62(xx1));
		long xx2 = 2014070123595999L;
		System.out.println(xx2+" to 63Encode: "+ ifer.toEncode62(xx2));
		long xx3 = 2015010123595999L;
		System.out.println(xx3+" to 63Encode: "+ ifer.toEncode62(xx3));
		long xx4 = 2015040123595999L;
		System.out.println(xx4+" to 63Encode: "+ ifer.toEncode62(xx4));
		long xx5 = 2015040123595999L;
		System.out.println(xx5+" to 63Encode: "+ ifer.toEncode62(xx5));
		long xx6 = 2015080123595999L;
		System.out.println(xx6+" to 63Encode: "+ ifer.toEncode62(xx6));
		long xx7 = 2016010123595999L;
		System.out.println(xx7+" to 63Encode: "+ ifer.toEncode62(xx7));
		long xx8 = 2016020123595999L;
		System.out.println(xx8+" to 63Encode: "+ ifer.toEncode62(xx8));
		long xx9 = 2016020123595999L;
		System.out.println(xx9+" to 63Encode: "+ ifer.toEncode62(xx9));
		long xx10 = 2016030123595999L;
		System.out.println(xx10+" to 63Encode: "+ ifer.toEncode62(xx10));
		long xx11 = 2016040123595999L;
		System.out.println(xx11+" to 63Encode: "+ ifer.toEncode62(xx11));
		long xx12 = 2016050123595999L;
		System.out.println(xx12+" to 63Encode: "+ ifer.toEncode62(xx12));
		long xx13 = 2016060123595999L;
		System.out.println(xx13+" to 63Encode: "+ ifer.toEncode62(xx13));
		long xx14 = 2016070123595999L;
		System.out.println(xx14+" to 63Encode: "+ ifer.toEncode62(xx14));
		long xx15 = 2016080123595999L;
		System.out.println(xx15+" to 63Encode: "+ ifer.toEncode62(xx15));
		long xx16 = 2016090123595999L;
		System.out.println(xx16+" to 63Encode: "+ ifer.toEncode62(xx16));
		long xx17 = 2016100123595999L;
		System.out.println(xx17+" to 63Encode: "+ ifer.toEncode62(xx17));
		long xx18 = 2016110123595999L;
		System.out.println(xx18+" to 63Encode: "+ ifer.toEncode62(xx18));
		long xx19 = 2016120123595999L;
		System.out.println(xx19+" to 63Encode: "+ ifer.toEncode62(xx19));
		long xx20 = 20991231L;
		System.out.println(xx20+" to 63Encode: "+ ifer.toEncode62(xx20));
		long xx21 = 2099123L;
		System.out.println(xx21+" to 63Encode: "+ ifer.toEncode62(xx21));
		long xx22 = 209912L;
		System.out.println(xx22+" to 63Encode: "+ ifer.toEncode62(xx22));
		System.out.println(Thread.currentThread().getId());
		long xx23 = 8999999;
		System.out.println(xx23+" to 63Encode: "+ ifer.toEncode62(xx23));
	}

}
