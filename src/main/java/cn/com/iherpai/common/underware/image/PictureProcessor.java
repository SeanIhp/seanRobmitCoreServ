package cn.com.iherpai.common.underware.image;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

public class PictureProcessor {
	private static Logger log = Logger.getLogger(PictureProcessor.class.getName());
	
	public File receiveRemotePicture(String remotePicUrl, String dinaryTempImageFilePath, String imageFileName, String imageExtName) throws IOException{
		File res = null;
		File dinayTempImageFileDir = new File(dinaryTempImageFilePath);
		if(!dinayTempImageFileDir.exists()){
			dinayTempImageFileDir.mkdir();
		}
		URL xUrl = new URL(remotePicUrl);
		File srcFile = new File(dinaryTempImageFilePath+imageFileName+imageExtName);
		BufferedInputStream bis = new BufferedInputStream(xUrl.openStream());
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(srcFile));
		int tByte = -1;
		while((tByte=bis.read())!=-1){
			bos.write(tByte);
		}
		bis.close();
		bos.flush();
		bos.close();
		res = srcFile;
		System.out.println("IMAGE FILE SIZE: "+res.length());
		return res;
	}
	
	public File receiveRemoteSSLPicture(String remotePicUrl, String dinaryTempImageFilePath, String imageFileName, String imageExtName) throws IOException{
		File res = null;
		File dinayTempImageFileDir = new File(dinaryTempImageFilePath);
		if(!dinayTempImageFileDir.exists()){
			dinayTempImageFileDir.mkdir();
		}
		
		CloseableHttpClient httpclient = null;
		HttpGet httpget = null;
		CloseableHttpResponse response = null;
		try {
			@SuppressWarnings("deprecation")
			SSLContext sslcontext = new SSLContextBuilder().loadTrustMaterial(null,
					new TrustStrategy() {// 信任所有
						public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
							return true;
						}
					}).build();

			// Allow TLSv1 protocol only
			/*
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					sslcontext, new String[] { "TLSv1" }, null,
					SSLConnectionSocketFactory.getDefaultHostnameVerifier());
			*/
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					sslcontext, new String[] { "SSLv3" }, null, null);
			httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			String ss = "";
			
			if(remotePicUrl.toLowerCase().indexOf("https:")!=0){
				remotePicUrl = "https:"+remotePicUrl;
			}
			System.out.println(remotePicUrl);
			httpget = new HttpGet(remotePicUrl);
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();
			File srcFile = new File(dinaryTempImageFilePath+imageFileName+imageExtName);
			BufferedInputStream bis = new BufferedInputStream(entity.getContent());
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(srcFile));
			int tByte = -1;
			while((tByte=bis.read())!=-1){
				bos.write(tByte);
			}
			bis.close();
			bos.flush();
			bos.close();
			res = srcFile;
			System.out.println("IMAGE FILE SIZE: "+res.length());
			EntityUtils.consume(entity);
		} catch(Exception e){
			log.debug("[common.utils.images.PictureProcessor--receiveRemoteSSLPicture] 获取SSL图片！异常："+e.getMessage());
			throw new IOException();
		} finally {
			if(response!=null){
				response.close();
			}
			if(httpclient!=null){
				httpclient.close();
			}
		}
		return res;
	}
	
}
