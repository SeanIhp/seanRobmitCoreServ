package cn.com.iherpai.core.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import cn.com.iherpai.core.storage.mybatis.orm.Dict;
import cn.com.iherpai.core.vo.AccountVo;
import cn.com.iherpai.core.vo.DictVo;
import cn.com.iherpai.core.vo.ValueObject;
import org.codehaus.jackson.JsonParser;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

/*
 * 1. 用户注册 [regist]
 * 2. 用户登录 [login]
 * 3. 用户修改密码 [modifyPassword]
 * 4. 用户列表 [list]
 * 5. 
 */
@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	

	@RequestMapping(value="add", method=RequestMethod.POST)
	public @ResponseBody ResultObject add(@RequestBody AccountVo accountVo){
		ResultObject ro = new ResultObject();
		try {
			ControllerHelper.voValidate(accountVo, "/cn/com/iherpai/core/vo/schema/Account__regist.json");
//			com.alibaba.fastjson.JSONObject accountVoJson = com.alibaba.fastjson.JSONObject.parseObject(cn.com.iherpai.common.utils.JsonParser.jsonFromObject(account));
			//校验用户名规则
			//throw new AccountRegistInfoErrorException("用户名填写有误！");
			//校验密码规则
			//throw new AccountRegistInfoErrorException("密码填写有误！");
			//检验mailbox规则
			//throw new AccountRegistInfoErrorException("电子邮箱填写有误！");
			//检查用户名是否可用
			//throw new AccountNameAlreadyExistsException("用户名已被占用");
			accountVo.setNid(1);
			accountVo.setSid(ID.newId(IhpConfig.SID_$ACCOUNT, IhpConfig.ID_DATA_DATABASE_CODE, IhpConfig.ID_DATA_TABLE_CODE));
			if( !DataValidator.isNull(accountVo.getPassword()) ){
				accountVo.setPassword( Sha256.encode(new Md5().getMd5String(accountVo.getPassword())) );
			}
			accountVo.setType(Account.TYPE_USER);
			accountVo.setGrade(1);
			accountVo.setPhone("4008000000");
			accountVo.setScore(0L);
			accountVo.setLevel(1);
			accountVo.setCreateTime(DateTime.getCurrentTimestamp());
			accountVo.setStatus(Account.STATUS_DEFAULT);
			Account res = accountService.add(accountVo, Account.fieldsDefault);
			if( res != null ){
				ArrayList<String> returnFields = ValueObject.returnFieldsBuild(Account.fieldsDefault);
				AccountVo actVo = new AccountVo(accountVo, returnFields);
				ro.addData("account", actVo);
			}else{
				ro.setReturnCode(-1);
				ro.addData("resultTip", "添加失败！");
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			//throw new AccountNameAlreadyExistsException("用户名已被占用");
			ro.setReturnCode(-100);
			ro.addData("resultTip", "帐户信息填写有误！");
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
	
	
	// START: [1] 用户注册
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public @ResponseBody ResultObject regist(@RequestBody AccountVo accountVo){
		ResultObject ro = new ResultObject();
		try {
			ControllerHelper.voValidate(accountVo, "/cn/com/iherpai/core/vo/schema/Account__regist.json");
//			com.alibaba.fastjson.JSONObject accountVoJson = com.alibaba.fastjson.JSONObject.parseObject(cn.com.iherpai.common.utils.JsonParser.jsonFromObject(account));
			//校验用户名规则
			//throw new AccountRegistInfoErrorException("用户名填写有误！");
			//校验密码规则
			//throw new AccountRegistInfoErrorException("密码填写有误！");
			//检验mailbox规则
			//throw new AccountRegistInfoErrorException("电子邮箱填写有误！");
			//检查用户名是否可用
			//throw new AccountNameAlreadyExistsException("用户名已被占用");
			accountVo.setNid(1);
			accountVo.setSid(ID.newId(IhpConfig.SID_$ACCOUNT, IhpConfig.ID_DATA_DATABASE_CODE, IhpConfig.ID_DATA_TABLE_CODE));
			if( !DataValidator.isNull(accountVo.getPassword()) ){
				accountVo.setPassword( Sha256.encode(new Md5().getMd5String(accountVo.getPassword())) );
			}
			accountVo.setType(Account.TYPE_USER);
			accountVo.setGrade(1);
			accountVo.setPhone("4008000000");
			accountVo.setScore(0L);
			accountVo.setLevel(1);
			accountVo.setCreateTime(DateTime.getCurrentTimestamp());
			accountVo.setStatus(Account.STATUS_DEFAULT);
			Account res = accountService.regist(accountVo, Account.fieldsDefault);
			if( res != null ){
				ArrayList<String> returnFields = ValueObject.returnFieldsBuild(Account.fieldsDefault);
				AccountVo actVo = new AccountVo(accountVo, returnFields);
				ro.addData("account", actVo);
			}else{
				ro.setReturnCode(-1);
				ro.addData("resultTip", "无法注册！");
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			//throw new AccountNameAlreadyExistsException("用户名已被占用");
			ro.setReturnCode(-100);
			ro.addData("resultTip", "注册信息填写有误！");
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
	

	
	// START: [103] 删除用户 [remove]
	@RequestMapping(value="remove", method=RequestMethod.POST)
	public @ResponseBody ResultObject remove(@RequestBody AccountVo accountVo){
		ResultObject ro = new ResultObject();
		try{
			ControllerHelper.voValidate(accountVo, "/cn/com/iherpai/core/vo/schema/Account.json");
			accountVo.addAddition("status", "e", Account.STATUS_DENY, 18);
			int res = accountService.remove(accountVo);
			if(res>0){
				ro.addData("sid", accountVo.getSid());	
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "帐户不存在！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [103] 删除用户 [remove]
	

	
	// START: [2] 修改帐户 [update]
	@RequestMapping(value="update", method=RequestMethod.POST)
	public @ResponseBody ResultObject update(@RequestBody AccountVo accountVo){
		ResultObject ro = new ResultObject();
		try{
//			ControllerHelper.voValidate(accountVo, "/cn/com/iherpai/core/vo/schema/Account.json");
			//校验字典组code/name/description规则
			int res = accountService.update(accountVo);
			if(res>0){
				ro.addData("sid", accountVo.getSid());	
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "帐户修改失败！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [2] 修改帐户 [update]
	
	

	// START: [3] 用户修改密码 
	@RequestMapping(value="modifyPassword", method=RequestMethod.POST)
	public @ResponseBody ResultObject modifyPassword(@RequestBody AccountVo accountVo){
		ResultObject ro = new ResultObject();
		try {
//			ControllerHelper.voValidate(accountVo, "/cn/com/iherpai/core/vo/schema/Account.json");
			//校验新密码规则
			//throw new AccountLoginInfoErrorException("密码填写有误！");
			if( !DataValidator.isNull(accountVo.getPassword()) ){
				accountVo.setPassword( Sha256.encode(new Md5().getMd5String(accountVo.getPassword())) );
			}
			if( !DataValidator.isNull(accountVo.getNewPassword()) ){
				accountVo.setNewPassword( Sha256.encode(new Md5().getMd5String(accountVo.getNewPassword())) );
			}
			int res = accountService.update(accountVo);
			if( res > 0 ){
				ro.addData("account", accountVo.getSid());
			}else{
				ro.setReturnCode(-1);
				ro.addData("resultTip", "密码修改失败！");
			}
			ro.setReturnCode(100);
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
	

	
	// START: [5] 获取帐户 [get]
	@RequestMapping(value="get", method=RequestMethod.POST)
	public @ResponseBody ResultObject get(@RequestBody AccountVo accountVo){
		ResultObject ro = new ResultObject();
		try{
//			ControllerHelper.voValidate(accountVo, "/cn/com/iherpai/core/vo/schema/Account.json");
			Account res = accountService.get(accountVo, Account.fieldsDefault);
			if(res!=null){
				ArrayList<String> returnFields = ValueObject.returnFieldsBuild(Account.fieldsDefault);
				AccountVo aVo = new AccountVo(res, returnFields);
				ro.addData("account", aVo);
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "查询条件有误！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [5] 获取帐户 [get]
	
	

	// START: [2] 用户登录 
	@RequestMapping(value="login", method=RequestMethod.POST)
	public @ResponseBody ResultObject login(@RequestBody AccountVo account){
		ResultObject ro = new ResultObject();
		try {
//			ControllerHelper.voValidate(accountVo, "/cn/com/iherpai/core/vo/schema/Account.json");
			//校验用户名规则
			//throw new AccountLoginInfoErrorException("用户名/密码错误，请检查后重试！");
			//校验密码规则
			//throw new AccountLoginInfoErrorException("用户名/密码错误，请检查后重试！");
			if( !DataValidator.isNull(account.getPassword()) ){
				account.setPassword( Sha256.encode(new Md5().getMd5String(account.getPassword())) );
			}
			Account theAcount = accountService.login(account, Account.fieldsDefaultWithPassword);
			if( theAcount != null ){
				AccountVo actVo = new AccountVo(theAcount, ValueObject.returnFieldsBuild(Account.fieldsDefault));
				ro.addData("account", actVo);
			} else {
				ro.setReturnCode(-1);
				ro.addData("resultTip", "用户名或密码错误,登录失败！");
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "帐户信息填写有误！");
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
	
	

	// START: [4] 用户查询 
	@RequestMapping(value="list", method=RequestMethod.POST)	
	public @ResponseBody ResultObject list(@RequestBody AccountVo accountVo){
		ResultObject ro = new ResultObject();
		try {
//			ControllerHelper.voValidate(accountVo, "/cn/com/iherpai/core/vo/schema/Account.json");
			HashMap<String, Object> res = accountService.list(accountVo, Account.fieldsDefault);
			ArrayList<Account> resList = (ArrayList<Account>)res.get("list");
			ArrayList<String> returnFields = ValueObject.returnFieldsBuild(Account.fieldsDefault);
			ArrayList<AccountVo> resVoList = ValueObject.getAccountVos(resList, returnFields);
			ro.addData("accountList", resVoList);
			ro.addData("totalAll", (Integer)res.get("totalAll"));
			ro.addData("totalPage", (Integer)res.get("totalPage"));
			ro.addData("pageSize", (Integer)res.get("pageSize"));
			ro.addData("pageNo", (Integer)res.get("pageNo"));
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "查询条件有误！");
		} catch (DaoException de) {
			de.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ro;
	}
	// END: [4] 用户修改密码
	
	
}
