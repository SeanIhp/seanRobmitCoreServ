package cn.com.iherpai.core.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.iherpai.core.service.AccountService;
import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.mapper.AccountMapper;
import cn.com.iherpai.core.storage.mybatis.orm.Account;
import cn.com.iherpai.core.storage.mybatis.orm.Entity;
import cn.com.iherpai.core.vo.AccountVo;
import cn.com.iherpai.core.vo.ValueObject;

/*
 * 1. 用户注册 [regist]
 * 2. 用户登录 [login]
 * 3. 用户修改密码 [modifyPassword]
 * 4. 用户信息更新 [update]
 * 5. 
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountMapper accountMapper;

	// START: [1] 用户注册
	@Override
	public int regist(Account account) throws DaoException{
		return accountMapper.regist(account);
	}
	// END: [1] 用户注册
	


	// START: [2] 用户登录 
	@Override
	public Account login(Account account, String fields) throws DaoException{
		Map<String, Object> param = new HashMap<String, Object>();
		//补充查询的字段列表
		fields += " ,password";
		//字段列表转下划线分隔
		String the_fields = ValueObject.accountOrmKeys(fields);
		//Mapper参数准备
		param.put("fields", the_fields);
		param.put("username", account.getUsername());
		param.put("type", account.getType());
		Account theAccount = accountMapper.getOnLogin(param);
		if(theAccount!=null){
			if(theAccount.getPassword().equals(account.getPassword())){
				return theAccount;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	// END: [2] 用户登录
	


	// START: [3] 用户修改密码 
	@Override
	public int modifyPassword(AccountVo accountVo) throws DaoException {
		Map<String, Object> param = new HashMap<String, Object>();
//		AccountVo accountVo = (AccountVo)account;
		param.put("password", accountVo.getPassword());
		param.put("newPassword", accountVo.getNewPassword());
		param.put("sid", accountVo.getSid());
		System.out.println("Param: " + param);
		return accountMapper.modifyPassword((Account)accountVo);
	}
	// END: [3] 用户修改密码
	
	
	

	@Override
	public String add(Account account){
		System.out.println("AccountServiceImpl!!!! sfsffseff");
		return "new account";
	}



	@Override
	public Object list(){
//		System.out.println("AccountServiceImpl!!!! sfsffseff_________list: " + accountMapper);

		System.out.println("AccountMapper!!!! ----------list!!!!-------"+ accountMapper );
		Map<String, String> param = new HashMap<String, String>();
		param.put("fields", "id, nid, sid, username, mailbox, wxOpenid, wxNickname, wxAvatar, type, grade, phone, score, level, createTime, status");
//		List<Account> accoutList = null;
		List<Account> accoutList = null;
		try {
			accoutList = accountMapper.listAll();
		} catch (DaoException e) {
			e.printStackTrace();
			System.out.println("AccountMapper!!!! " + e);
		}
		System.out.println("AccountMapper!!!!LIST LIST LIST LIST~~~ " + accoutList);
		for(int i=0; i<accoutList.size(); i++){
			Account act = accoutList.get(i);
			System.out.println("account: " + act.getUsername() + "   " + act.getMailbox() + "   " + act.getCreateTime() );
		}
		Map<String, Map> res = new HashMap<String, Map>();
		Map<String, String> p1 = new HashMap<String, String>();
		p1.put("cat", "tom");
		p1.put("whattime", "5.12");
		res.put("result", p1);
		return res;
	}

}
