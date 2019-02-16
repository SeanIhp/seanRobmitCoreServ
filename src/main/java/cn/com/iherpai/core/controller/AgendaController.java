package cn.com.iherpai.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.iherpai.core.service.AgendaService;

/*
 * 1. 用户注册 [regist]
 * 2. 用户登录 [login]
 * 3. 用户修改密码 [modifyPassword]
 * 4. 用户信息更新 [update]
 * 5. 
 */
@Controller
@RequestMapping("/agenda")
public class AgendaController {
	
	@Autowired
	private AgendaService agendaService;
	

}
