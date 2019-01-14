package cn.com.iherpai.core.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import cn.com.iherpai.common.underware.HTMLInputFilter;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private HttpServletRequest request = null;
	public XssHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	private static String xssEncode(String _str, HTMLInputFilter _filter){
		String res = "";
		if(_str==null || "".equals(_str)){
			return res;
		}
		res = _filter.filter(_str);
		return res;
	}

	@Override
	public String getHeader(String name) {
		String res = request.getHeader(name);
		if(res!=null){
			HTMLInputFilter filter = new HTMLInputFilter(false);
			res = XssHttpServletRequestWrapper.xssEncode(res, filter);
		}
		return res;
	}

	@Override
	public Enumeration<String> getHeaderNames() {
		// TODO Auto-generated method stub
		return request.getHeaderNames(); 
	}

	@Override
	public String getQueryString() {
		String res = request.getQueryString();
		if(res!=null){
			HTMLInputFilter filter = new HTMLInputFilter(false);
			try {
				res = URLDecoder.decode(res, "utf-8");
			} catch (UnsupportedEncodingException e) {
				res = "";
			}
			res = XssHttpServletRequestWrapper.xssEncode(res, filter);
		}
		return res;
	}

	@Override
	public String getParameter(String name) {
		String res = request.getParameter(name);
		if(res!=null){
			if(!name.equals("url")){
				HTMLInputFilter filter = new HTMLInputFilter(false);
				try {
					res = URLDecoder.decode(res, "utf-8");
				} catch (UnsupportedEncodingException e) {
					res = "";
				}
				res = XssHttpServletRequestWrapper.xssEncode(res, filter);
			}
		}
		return res;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return request.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String name) {
		String res[] = request.getParameterValues(name);
		if(res!=null){
			if(!name.equals("url")){
				HTMLInputFilter filter = new HTMLInputFilter(false);
				for(int i=0; i<res.length; i++){
					try {
						res[i] = URLDecoder.decode(res[i], "utf-8");
					} catch (UnsupportedEncodingException e) {
						res[i] = "";
					}
					res[i] = XssHttpServletRequestWrapper.xssEncode(res[i], filter);
				}
			}
		}
		return res;
	}

}
