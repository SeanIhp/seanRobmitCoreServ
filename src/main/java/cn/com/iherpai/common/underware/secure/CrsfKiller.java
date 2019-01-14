package cn.com.iherpai.common.underware.secure;

import java.util.Random;

import cn.com.iherpai.common.underware.TestTimer;


public class CrsfKiller {
	private static char[] xChars = new char[]{
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '_' 
	};
	private static Random rnd = new Random();
	
	
	/*
	 * 密钥【数据ID】
	 */
	private static String idkeyPassword  = "u9xK2_a1l7Z_goQ3mvWg";
	/*
	 * 加密【数据ID】
	 */
	public static String encryptIdKey(String id){
		String keyStr;
		byte[] encryptResult = AesCrypter.encrypt(new String(id), CrsfKiller.idkeyPassword);  
		keyStr = AesCrypter.parseByte2HexStr(encryptResult);
		return keyStr;
	}
	/*
	 * 解密【数据ID】
	 */
	public static String decryptIdKey(String idkeyStr){
		byte[] decryptFrom = AesCrypter.parseHexStr2Byte(idkeyStr);  
		byte[] decryptResult = AesCrypter.decrypt(decryptFrom,CrsfKiller.idkeyPassword);  
		return new String(decryptResult);
	}
	
	
	
	
	/*
	 * 密钥【反CRSF原始授权码】
	 */
	private static String pubkeyPassword = "lV3_biz9Te3r0Ou7f98w";
	/*
	 * 加密【反CRSF原始授权码】
	 */
	public static String encryptPublicKey(){
		String keyStr = null;
		char[] keyChars = new char[16];
		for(int i=0; i<keyChars.length; i++){
			keyChars[i] = xChars[rnd.nextInt(63)];
		}
		byte[] encryptResult = AesCrypter.encrypt(new String(keyChars), CrsfKiller.pubkeyPassword);  
		keyStr = AesCrypter.parseByte2HexStr(encryptResult);  
		return keyStr;
	}
	/*
	 * 解密【反CRSF原始授权码】
	 */
	public static String decryptPublicKey(String pubkeyStr){
		byte[] decryptFrom = AesCrypter.parseHexStr2Byte(pubkeyStr);  
		byte[] decryptResult = AesCrypter.decrypt(decryptFrom,CrsfKiller.pubkeyPassword);  
		return new String(decryptResult);
	}
		
	
	
	
	/*
	 * 密钥【授权校验码】
	 */
	private static String prikeyPassword = "zfDgH8_Kj9q0wOVfx4pn";
	/*
	 * 加密【授权校验码】
	 */
	public static String encryptPrivateKeyBy(){
		String keyStr = null;
		char[] keyChars = new char[16];
		for(int i=0; i<keyChars.length; i++){
			keyChars[i] = xChars[rnd.nextInt(63)];
		}
		byte[] encryptResult = AesCrypter.encrypt(new String(keyChars), CrsfKiller.prikeyPassword);  
		keyStr = AesCrypter.parseByte2HexStr(encryptResult);  
		return keyStr;
	}
	/*
	 * 解密【授权校验码】
	 */
	public static String decryptPrivateKey(String prikeyStr){
		byte[] decryptFrom = AesCrypter.parseHexStr2Byte(prikeyStr);  
		byte[] decryptResult = AesCrypter.decrypt(decryptFrom,CrsfKiller.prikeyPassword);  
		return new String(decryptResult);
	}
	
	
	
	
	/*
	 * 根据公钥【反CRSF原始授权码】原文生成私钥【反CRSF授权校验码】
	 */
	public static String encryptPublic2PrivateKey(String pubkeyText){
		String keyStr = null;
		byte[] encryptResult = AesCrypter.encrypt(pubkeyText, CrsfKiller.prikeyPassword);  
		keyStr = AesCrypter.parseByte2HexStr(encryptResult);  
		return keyStr;
	}
	
	
	
	public static void main(String[] args){
		TestTimer.start(1, "alpha", "反CRSF授权码");
		String pubkey = encryptPublicKey();
		System.out.println("生成公钥"+pubkey);
		String decryptPubkey = decryptPublicKey(pubkey);
		System.out.println("解密公钥"+decryptPubkey);
		String prikey = encryptPublic2PrivateKey(decryptPubkey);
		System.out.println("根据公钥原文生成私钥："+prikey);
		System.out.println("解密私钥"+decryptPrivateKey(prikey));
		TestTimer.end(1);
	}

}



