package cn.com.iherpai.common.utils.fetch;

import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.HTMLCodepageDetector;
import info.monitorenter.cpdetector.io.JChardetFacade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class WebPageEncoding {
	private static Logger log = Logger.getLogger(WebPageEncoding.class.getName());
	private static CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
	static {
		detector.add(new HTMLCodepageDetector(false));
		detector.add(JChardetFacade.getInstance());
	}

	/**
	 * 测试用例
	 * @param args
	 */
	public static void main(String[] args) {
		WebPageEncoding web = new WebPageEncoding();
		try {
			System.out.println(web.getTheCharset("http://www.360buy.com/product/654983.html"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getTheCharset(String url) throws IOException, Exception {
		String charSet = getCharset(url);
		if (charSet == null || charSet.trim().equalsIgnoreCase("gb2312") || charSet.trim().equalsIgnoreCase("gbk")) {
			charSet = "GB18030";
		}
		return charSet;
	}

	/**
	 * @param strurl
	 *            页面url地址,需要以 http://开始，例：http://www.iherpai.com
	 * @return
	 * @throws IOException
	 */
	private static String getCharset(String strurl) throws IOException, Exception {
		// 定义URL对象
		URL url = new URL(strurl);
		// 获取http连接对象
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		urlConnection.connect();
		// 网页编码
		String strencoding = null;
		
		/**
		 * 首先根据header信息，判断页面编码
		 */
		// map存放的是header信息(url页面的头信息)
		Map<String, List<String>> map = urlConnection.getHeaderFields();
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();
		// 遍历,查找字符编码
		String key = null;
		String tmp = null;
		while (iterator.hasNext()) {
			key = iterator.next();
			tmp = map.get(key).toString().toLowerCase();
			// 获取content-type charset
			if (key != null && key.equalsIgnoreCase("Content-Type")) {
				int m = tmp.indexOf("charset=");
				if (m != -1) {
					strencoding = tmp.substring(m + 8).replace("]", "");
					return strencoding;
				}
			}
		}

		/**
		 * 通过解析meta得到网页编码
		 */
		// 获取网页源码(英文字符和数字不会乱码，所以可以得到正确<meta/>区域)
		StringBuffer sb = new StringBuffer();
		String line;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(url
					.openStream()));
			while ((line = in.readLine()) != null) {
				sb.append(line);
			}
			in.close();
		} catch (Exception e) { // Report any errors that arise
			System.err.println(e);
			System.err.println("Usage:   java   HttpClient   <URL>   [<filename>]");
		}
		String htmlcode = sb.toString();
		// 解析html源码，取出<meta />区域，并取出charset
		String strbegin = "<meta";
		String strend = ">";
		String strtmp;
		int begin = htmlcode.indexOf(strbegin);
		int end = -1;
		int inttmp;
		while (begin > -1) {
			end = htmlcode.substring(begin).indexOf(strend);
			if (begin > -1 && end > -1) {
				strtmp = htmlcode.substring(begin, begin + end).toLowerCase();
				inttmp = strtmp.indexOf("charset");
				if (inttmp > -1) {
					/* 【JavaEye】虚客_zZ 建议修改
					strencoding = strtmp.substring(inttmp + 7, end).replace(
							"=", "").replace("/", "").replace("\"", "")
							.replace("\'", "").replace(" ", "");
					*/
					String strChasetStart = "=";
					String strChasetEnd = " ";
					String strCharset = strtmp.substring(inttmp);
					int charsetStart = strCharset.indexOf(strChasetStart);
					int charsetEnd = strCharset.indexOf(strChasetEnd);
					strencoding =  strCharset.substring(charsetStart, charsetEnd).replace(
					"=", "").replace("/", "").replace("\"", "").replace("\'", "").replace(" ", "");
					return strencoding;
				}
			}
			htmlcode = htmlcode.substring(begin);
			begin = htmlcode.indexOf(strbegin);
		}
		/**
		 * 分析字节得到网页编码
		 */
		strencoding = getFileEncoding(url);
		// 设置默认网页字符编码
		if (strencoding == null) {
			strencoding = "GBK";
		}
		System.out.println("strencoding: "+strencoding);
		return strencoding;
	}

	/**
	 * 方法说明：通过网页内容识别网页编码
	 * 输入参数：strUrl 网页链接; timeout 超时设置
	 * 返回类型：网页编码
	 */
	public static String getFileEncoding(URL url) throws Exception {
		java.nio.charset.Charset charset = null;
		try {
			charset = detector.detectCodepage(url);
		} catch (Exception e) {
			log.warn("[utils_webPageEncoding---getFileEncoding] 分析网页编码失败！  PROTOCOL："+url.getProtocol()+" HOST："+url.getHost()+" PORT："+url.getPort()+" PATH："+url.getPath()+" FILE："+url.getFile()+" QUERY："+url.getQuery()+"   ！---"+e.getMessage());
			log.debug(e.getMessage());
			throw new Exception("[utils_webPageEncoding---getFileEncoding]");
		}
		if (charset != null)
			return charset.name().trim();
		return null;
	}
	
	
	
	
	
	
	/*
	 * CX追加的功能：
	 * 获得网页源码中所有<img/>标签里src的值，即图片url
	 */
	public static List<String> getImgStr(String htmlStr){
		String img="";
		Pattern p_image;
		Matcher m_image;
		List<String> pics = new ArrayList<String>(0);
		//String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址 
		String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>"; 
		p_image = Pattern.compile(regEx_img,Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlStr); 
		while(m_image.find()){
			img = img + "," + m_image.group();   
			// Matcher m  = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); //ƥ��src
			Matcher m  = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
			while(m.find()){
				pics.add(m.group(1));
			}
		}
		//getGoodsData4Tmall(htmlStr);		//130426 貌似实际运行中该方式无实际意义
		return pics;
	}
	
	
	
	
	
	
	/*
	 * CX追加的功能：专门用于“天猫”
	 * 获得网页源码中所有<img/>标签里src的值，即图片url
	 */
	public static List<String> getMiniImgStr4Tmall(String htmlStr){
		String img="";
		Pattern p_image;
		Matcher m_image;
		List<String> pics = new ArrayList<String>(0);
		//String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址  
		/* 取得所有图片URL
		 * String regEx_img = "<\\s*div class=\"\\s*tb-pic tb-s40\\s*\">\\s*<\\s*a href=\\s*\"#\"\\s*>\\s*<img.*src\\s*=\\s*(.*?)[^>]*?>"; 
		 */
		//取得天猫商品图集信息
		//全部缩略图
		/*
		 * 注：130605 发现该段代码无法匹配和取得图片信息
		String regEx_img1 = "<\\s*div\\s*class=\"\\s*tb-pic tb-s\\d*\\s*\">\\s*<\\s*a\\s*href=\\s*\"#\"\\s*>\\s*<img.*src\\s*=(.*)J_FrmBid";
		p_image = Pattern.compile(regEx_img1,Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlStr); 
		while(m_image.find()){
			img = img + "," + m_image.group();   
			// Matcher m  = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); //ƥ��src
			Matcher m  = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
			while(m.find()){
				String imgName = m.group(1).replaceAll("_\\d*x\\d*.jpg", "");
				System.out.println("}}}}} "+imgName);
				//限制只获取所有商品缩略图中的第一个，避免出现部分缩略图不能及时访问，加载到loading.gif
				if(imgName.toLowerCase().indexOf(".jpg")!=-1){
					pics.add(imgName);
					if(pics.size()>0){
						break;
					}
				}
			}
		}
		*/
		String regEx_img2 = "class=\"\\s*tb-gallery\\s*\"(.*)J_FrmBid";
		//String regEx_img2 = "tb-gallery(.*)J_FrmBid";
		p_image = Pattern.compile(regEx_img2,Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlStr); 
		while(m_image.find()){
			img = img + "," + m_image.group();   
			// Matcher m  = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); //ƥ��src
			Matcher m  = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
			while(m.find()){
				String imgName = m.group(1).replaceAll("_\\d*x\\d*.jpg", "");
				System.out.println("}}}}} "+imgName);
				//限制只获取所有商品缩略图中的第一个，避免出现部分缩略图不能及时访问，加载到loading.gif
				if(imgName.toLowerCase().indexOf(".jpg")!=-1){
					pics.add(imgName);
					if(pics.size()>0){
						break;
					}
				}
			}
		}
		//getGoodsData4Tmall(htmlStr);		//130426 貌似实际运行中该方式无实际意义
		return pics;
	}
	

	/* 130426 貌似实际运行中该方式无实际意义
	public static Map<String, Object> getGoodsData4Tmall(String htmlStr){
		Map<String, Object> res = null;
		String div="";
		Pattern p_image;
		Matcher m_image;
		List<String> tits = new ArrayList<String>(0);
//		String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
		String regEx_div = "<div class=\"tb-detail-hd\".*<div>";
		p_image = Pattern.compile(regEx_div,Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlStr); 
		while(m_image.find()){
			div = div + "," + m_image.group();   
			// Matcher m  = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); //ƥ��src
			Matcher m  = Pattern.compile("href\\s*=.*(\"|>|\\s+).*</a>").matcher(div);
			while(m.find()){
				tits.add(m.group(1));
			}
		}
		System.out.println("&&&&TITLE&&&&&: "+tits);
//		res = new HashMap();
//		res.put("gdsImages", imgStrList);
		return res;
	}
	*/
	
	/*
	 * CX追加的功能： 专门用于“天猫”
	 * 获得网页源码中所有<img/>标签里src的值，即图片url
	 */
	public static List<String> getGoodsTitleStr4Tmall(String htmlStr){
		List<String> res = new ArrayList<String>(0);
		String div="";
		Pattern p_image;
		Matcher m_tit;
		//取得天猫商品标题
		//String regEx_div = "<\\s*div\\s*class\\s*=\\s*\"tb-detail-hd\"\\s*>\\s*<\\s*h3\\s*>\\s*<\\s*a\\s*target\\s*=\\s*\"_blank\"\\s*href\\s*=[^>]*>.*<\\s*/a\\s*>\\s*<\\s*/h3\\s*>";
		//String regEx_div = "<\\s*div\\s*class\\s*=\\s*\"tb-detail-hd\"\\s*>\\s*<\\s*h3\\s*>\\s*<\\s*a\\s*target\\s*=\\s*\"_blank\"\\s*href\\s*=[^>]*>.*J_StrPrice";
		String regEx_div = "class\\s*=\\s*\"tb-detail-hd\"(.*)J_StrPriceModBox";
		p_image = Pattern.compile(regEx_div,Pattern.CASE_INSENSITIVE);
		m_tit = p_image.matcher(htmlStr); 
		while(m_tit.find()){
			div = div + "," + m_tit.group();
			Matcher m  = Pattern.compile("data-spm\\s*=[^>]*>(.*)<\\s*/h[1-6]\\s*>").matcher(div);
			while(m.find()){
				res.add(m.group(1));
			}
		}
		//System.out.println("--��"+strencoding1+"��-------��"+xUrl+"��------");		System.out.println("--��SOURCE CODE��-- "+pageSrcCode);		System.out.println("--��IMAGES LIST��-- "+imgStrList);
		return res;
	}

	
	
	
	
	
	
	
	
	/*
	 * CX追加的功能： 专门用于“当当”
	 * 获得网页源码中所有<img/>标签里src的值，即图片url
	 */
	public static List<String> getMiniImgStr4Dangdang(String htmlStr){
		String img="";
		Pattern p_image;
		Matcher m_image;
		List<String> pics = new ArrayList<String>(0);
		//取得当当商品图集信息
		//全部缩略图
//		String regEx_img = "<\\s*div\\s*class=\"\\s*tb-pic tb-s\\d*\\s*\">\\s*<\\s*a\\s*href=\\s*\"#\"\\s*>\\s*<img.*src\\s*=(.*)J_FrmBid";
//		String regEx_img = "class=\"\\s*show_pic_small__d\\s*\">\\s*<\\s*img(.*)prd_share";
		String regEx_img = "class=\"\\s*pic_list\\s*(.*)查看大图";
		p_image = Pattern.compile(regEx_img,Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(htmlStr); 
		while(m_image.find()){
			img = img + "," + m_image.group();   
			// Matcher m  = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); //ƥ��src
			Matcher m  = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
			while(m.find()){
				String imgName = m.group(1);
				System.out.println("}}}}} "+imgName);
				pics.add( imgName );
				if(pics.size()>0){
					break;
				}
			}
		}
		return pics;
	}
	
	/*
	 * CX追加的功能： 专门用于“当当”
	 * 获得网页源码中所有<img/>标签里src的值，即图片url
	 */
	public static List<String> getGoodsTitleStr4Dangdang(String htmlStr){
		List<String> res = new ArrayList<String>(0);
		String div="";
		Pattern p_image;
		Matcher m_tit;
		//取得当当商品标题
		//String regEx_div = "<\\s*div\\s*class\\s*=\\s*\"tb-detail-hd\"\\s*>\\s*<\\s*h3\\s*>\\s*<\\s*a\\s*target\\s*=\\s*\"_blank\"\\s*href\\s*=[^>]*>.*J_StrPrice";
		//String regEx_div = "<\\s*div\\s*class\\s*=\\s*\"h1_title\"\\s*>\\s*<\\s*h1\\s*>.*dp_presell";
		String regEx_div = "class=\"\\s*head\\d*\\s*(.*)class=\"\\s*sale";						
		p_image = Pattern.compile(regEx_div,Pattern.CASE_INSENSITIVE);
		m_tit = p_image.matcher(htmlStr); 
		while(m_tit.find()){
			div = div + "," + m_tit.group();
			Matcher m  = Pattern.compile("<\\s*h1\\s*>(.*)<\\s*span\\s*class=\"\\s*subtitle").matcher(div);
			while(m.find()){
				res.add(m.group(1));
			}
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
