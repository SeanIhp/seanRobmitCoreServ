package cn.com.iherpai.common.utils;

import javax.servlet.http.HttpSession;

public class ExceptionReporter {
	
	public static final void procErrorInfo(HttpSession session, String errorResult,
			String errorOperate, String errorOperateUrl,
			String errorElseOperate, String errorElseOperateUrl) {
		session.setAttribute("errorResult", errorResult);
		session.setAttribute("errorOperate", errorOperate);
		session.setAttribute("errorOperateUrl", errorOperateUrl);
		session.setAttribute("errorElseOperate", errorElseOperate);
		session.setAttribute("errorElseOperateUrl", errorElseOperateUrl);
	}
	
	
	
	public static final void printStackTrace(Exception e) {
		e.printStackTrace();
	}
	
	
}
