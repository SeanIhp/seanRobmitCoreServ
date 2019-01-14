package cn.com.iherpai.common.utils;

import javax.servlet.http.HttpServletRequest;

public class IPHunter {
	public static String getClientIpAddress(HttpServletRequest request) {    
	    String ip = request.getHeader("x-forwarded-for");
	    if(ip!=null && ip.length()!=0 && !("unknown".equalsIgnoreCase(ip)) ){
	    	String[] tmpIps = ip.split(",");
	    	for(int x=0; x<tmpIps.length; x++){
	    		if(tmpIps[x]!=null && tmpIps[x].trim().equalsIgnoreCase("unknown") ){
	    			ip = tmpIps[x];
	    			break;
	    		}
	    	}
	    }
	    if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)) {    
	        ip = request.getHeader("Proxy-Client-IP");    
	    }    
	    if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)) {    
	        ip = request.getHeader("WL-Proxy-Client-IP");    
	    }    
	    if(ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)) {    
	        ip = request.getRemoteAddr();    
	    }    
	    return ip;    
	} 
}
