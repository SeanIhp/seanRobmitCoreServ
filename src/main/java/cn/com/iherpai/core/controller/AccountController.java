package cn.com.iherpai.core.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.iherpai.common.consts.IhpConfig;
import cn.com.iherpai.common.underware.DataValidator;
import cn.com.iherpai.common.underware.secure.Md5;
import cn.com.iherpai.common.underware.secure.Sha256;
import cn.com.iherpai.common.utils.DateTime;
import cn.com.iherpai.common.utils.ID;
import cn.com.iherpai.core.entify.ResultObject;
import cn.com.iherpai.core.service.AccountService;
import cn.com.iherpai.core.storage.mybatis.orm.Account;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public @ResponseBody ResultObject regist(@RequestBody Account account){
		ResultObject ro = new ResultObject();
		try {
			account.setNid(100);
			account.setSid(ID.newId(IhpConfig.ID_USER__$USERACCOUNT, IhpConfig.ID_GENERATOR_DATA_DATABASE_CODE, IhpConfig.ID_GENERATOR_DATA_TABLE_CODE));
//			account.setSerialId(ID.newUuid());
			if( !DataValidator.isNull(account.getPassword()) ){
				account.setPassword( Sha256.encode(new Md5().getMd5String(account.getPassword())) );
			}
			account.setType(100);
			account.setGrade(1);
			account.setPhone("4008000000");
			account.setScore(0L);
			account.setLevel(1);
			account.setCreateTime(DateTime.getCurrentTimestamp());
			account.setStatus(0);
			int res = accountService.regist(account);
			if(res>0){
				ro.setReturnCode(200);
				ro.addData("account", account);
			}else{
				ro.setReturnCode(-1);
				ro.addData("resultTip", "无法注册！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ro;
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public @ResponseBody ResultObject login(@RequestBody Account account){
		ResultObject ro = new ResultObject();
		try {
			if( !DataValidator.isNull(account.getPassword()) ){
				account.setPassword( Sha256.encode(new Md5().getMd5String(account.getPassword())) );
			}
			account.setType(100);
			Account res = accountService.login(account);
			if(res!=null){
				ro.setReturnCode(200);
				ro.addData("account", res);
			}else{
				ro.setReturnCode(-1);
				ro.addData("resultTip", "无法登录！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ro;
	}
	
	@RequestMapping("new")
	public String add(HttpServletRequest request, HttpServletResponse response){
		System.out.println("@@@sfsffseff");
		return "new account";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Object list(HttpServletRequest request, HttpServletResponse response){
		System.out.println("@@@sfsffseff_________list: " + accountService);
		accountService.list();
		Map res = new HashMap();
		Map p1 = new HashMap();
//		p1.put("女主", "大美妞宝宝");
//		p1.put("男主", "哆啦枪枪哥");
		p1.put("Since", "5.12");
		p1.put("从此", "大美妞宝宝和哆啦枪枪哥，这对儿欢喜猴幸福快乐的生活在一起.....=^^=~");
		res.put("result", p1);
		return res;
	}
}
