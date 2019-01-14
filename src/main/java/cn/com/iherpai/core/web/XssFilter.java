package cn.com.iherpai.core.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XssFilter implements Filter {
	private String[] xssScriptWord = {
				"javascript", 	"vbscript", 	"expression",	"applet", 		"meta", 
				"xml", 			"blink", 		"link", 		"style", 		"script", 
				"embed",		"object", 		"iframe", 		"frame", 		"frameset", 
				"ilayer",		"layer", 		"bgsound", 		"title", 		"base",
				"livescript",	"eval",			"expression",	"src",			"href",
				"function",		"document",		"location",		"import",		"xml",
				"mocha",		"&{",			"&#"
			};
	//https://detail.tmall.com/item.htm?id=38104130944&spm=a1z10.4-b.w5003-11723820441.4.1HhRBe&scene=taobao_shop
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		//response.setCharacterEncoding("utf-8");
		
    	HttpServletRequest req = (HttpServletRequest)request;
    	HttpServletResponse res = (HttpServletResponse)response;
    	
    	XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(req);  
        chain.doFilter(xssRequest, res);  
    	
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
