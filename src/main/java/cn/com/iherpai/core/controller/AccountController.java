package cn.com.iherpai.core.controller;

import java.util.ArrayList;
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
import cn.com.iherpai.core.exception.AccountRegistInfoErrorException;
import cn.com.iherpai.core.exception.ServerServicingException;
import cn.com.iherpai.core.service.AccountService;
import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Account;
import cn.com.iherpai.core.vo.AccountVo;
import cn.com.iherpai.core.vo.ValueObject;

/*
 * 1. 用户注册 [regist]
 * 2. 用户登录 [login]
 * 3. 用户修改密码 [modifyPassword]
 * 4. 用户信息更新 [update]
 * 5. 
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	// START: [1] 用户注册
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public @ResponseBody ResultObject regist(@RequestBody Account account){
		ResultObject ro = new ResultObject();
		try {
			//校验用户名规则
			//throw new AccountRegistInfoErrorException("用户名填写有误！");
			//校验密码规则
			//throw new AccountRegistInfoErrorException("密码填写有误！");
			//检验mailbox规则
			//throw new AccountRegistInfoErrorException("电子邮箱填写有误！");
			//检查用户名是否可用
			//throw new AccountNameAlreadyExistsException("用户名已被占用");
			account.setNid(1);
			account.setSid(ID.newId(IhpConfig.SID_$ACCOUNT, IhpConfig.ID_DATA_DATABASE_CODE, IhpConfig.ID_DATA_TABLE_CODE));
			if( !DataValidator.isNull(account.getPassword()) ){
				account.setPassword( Sha256.encode(new Md5().getMd5String(account.getPassword())) );
			}
			System.out.println("account: " + account);
			account.setType(100);
			account.setGrade(1);
			account.setPhone("4008000000");
			account.setScore(0L);
			account.setLevel(1);
			account.setCreateTime(DateTime.getCurrentTimestamp());
			account.setStatus(0);
			int res = accountService.regist(account);
			if(res>0){
				ArrayList<String> returnFields = ValueObject.returnFieldsBuild(
						"id, nid, sid, username, mailbox, "
						+ "wxOpenid, wxSessionkey, wxUnionid, wxNickname, wxAvatar, wxGender, "
						+ "wxCity, wxCountry, wxProvince, wxLanguage, "
						+ "type, grade, phone, score, level, createTime, status");
				AccountVo actVo = new AccountVo(account, returnFields);
				ro.setReturnCode(100);
				ro.addData("account", actVo);
			}else{
				ro.setReturnCode(-1);
				ro.addData("resultTip", "无法注册！");
			}
		} catch (DaoException de) {
			de.printStackTrace();
			ro.setReturnCode(-1201);
			ro.addData("resultTip", de.getMessage());
		} catch (ServerServicingException se) {
			se.printStackTrace();
			ro.setReturnCode(-1401);
			ro.addData("resultTip", se.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ro;
	}
	// END: [1] 用户注册
	
	

	// START: [2] 用户登录 
	@RequestMapping(value="login", method=RequestMethod.POST)
	public @ResponseBody ResultObject login(@RequestBody Account account){
		ResultObject ro = new ResultObject();
		try {
			//校验用户名规则
			//throw new AccountLoginInfoErrorException("用户名/密码错误，请检查后重试！");
			//校验密码规则
			//throw new AccountLoginInfoErrorException("用户名/密码错误，请检查后重试！");
			System.out.println("------- "+account.getUsername()+" ------- alpha password: " + account.getPassword());
			if( !DataValidator.isNull(account.getPassword()) ){
				account.setPassword( Sha256.encode(new Md5().getMd5String(account.getPassword())) );
			}
			account.setType(100);
			String returnFieldsDefine = "id, nid, sid, username, mailbox, "
					+ "wxOpenid, wxSessionkey, wxUnionid, wxNickname, wxAvatar, wxGender, "
					+ "wxCity, wxCountry, wxProvince, wxLanguage, "
					+ "type, grade, phone, score, level, createTime, status";
			ArrayList<String> returnFields = ValueObject.returnFieldsBuild(returnFieldsDefine);
			Account theAcount = accountService.login(account, returnFieldsDefine);
			if( theAcount != null ){
				AccountVo actVo = new AccountVo(theAcount, returnFields);
				ro.setReturnCode(100);
				ro.addData("account", actVo);
				System.out.println("[]["+returnFields+"]------- "+actVo.getUsername()+" ------- beta password: " + actVo.getPassword());
			} else {
				ro.setReturnCode(-1);
				ro.addData("resultTip", "用户名或密码错误,登录失败！");
			}
		} catch (DaoException de) {
			de.printStackTrace();
			ro.setReturnCode(-1201);
			ro.addData("resultTip", de.getMessage());;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ro;
	}
	// END: [2] 用户登录
	
	

	// START: [3] 用户修改密码 
	@RequestMapping(value="modifyPassword", method=RequestMethod.POST)
	public @ResponseBody ResultObject modifyPassword(@RequestBody AccountVo accountVo){
		ResultObject ro = new ResultObject();
		try {
			//校验新密码规则
			//throw new AccountLoginInfoErrorException("密码填写有误！");
			if( !DataValidator.isNull(accountVo.getPassword()) ){
				accountVo.setPassword( Sha256.encode(new Md5().getMd5String(accountVo.getPassword())) );
			}
			if( !DataValidator.isNull(accountVo.getNewPassword()) ){
				accountVo.setNewPassword( Sha256.encode(new Md5().getMd5String(accountVo.getNewPassword())) );
			}
			int res = accountService.modifyPassword(accountVo);
			if(res!=-1){
				ro.setReturnCode(200);
				ro.addData("account", res);
			}else{
				ro.setReturnCode(-1);
				ro.addData("resultTip", "用户名或密码错误,登录失败！");
			}
		} catch (DaoException de) {
			de.printStackTrace();
			ro.setReturnCode(-1201);
			ro.addData("resultTip", de.getMessage());;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ro;
	}
	// END: [3] 用户修改密码
	
	

	// START: [4] 用户查询 
	@RequestMapping(value="list", method=RequestMethod.POST)	
	public @ResponseBody Object list(HttpServletRequest request, HttpServletResponse response){
		ResultObject ro = new ResultObject();
//		try {
//			int res = accountService.list(accountVo);
//			if(res!=-1){
//				ro.setReturnCode(200);
//				ro.addData("account", res);
//			}else{
//				ro.setReturnCode(-1);
//				ro.addData("resultTip", "用户名或密码错误,登录失败！");
//			}
//		} catch (DaoException de) {
//			de.printStackTrace();
//			ro.setReturnCode(-1201);
//			ro.addData("resultTip", de.getMessage());;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return ro;
		
		
//		System.out.println("@@@sfsffseff_________list: " + request);
//		
//		accountService.list();
//		Map res = new HashMap();
//		Map p1 = new HashMap();
//		res.put("result", p1);
//		return res;
	}
	// END: [4] 用户修改密码
	
	
}
