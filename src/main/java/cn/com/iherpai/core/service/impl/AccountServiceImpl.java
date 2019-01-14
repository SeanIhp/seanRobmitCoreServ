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

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public Account login(Account account) throws DaoException{
		Map<String, Object> param = new HashMap();
		param.put("username", account.getUsername());
		param.put("type", account.getType());
		Account theAccount = accountMapper.getOnLogin(param);
		System.out.println("~~~~~~~~~~~theAccount: " + theAccount);
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

	@Override
	public int regist(Account account) throws DaoException{
		return accountMapper.regist(account);
	}

	@Override
	public String add(Account account){
		System.out.println("AccountServiceImpl!!!! sfsffseff");
		return "new account";
	}

	@Override
	public Object list(){
//		System.out.println("AccountServiceImpl!!!! sfsffseff_________list: " + accountMapper);

		System.out.println("AccountMapper!!!! ----------list!!!!-------"+ accountMapper );
		Map param = new HashMap();
		param.put("fields", Account.DEFAULT_ALL_FIELDS);
		List<Account> accoutList = null;
		try {
			accoutList = accountMapper.list(param);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("AccountMapper!!!! " + e);
		}
		System.out.println("AccountMapper!!!!LIST LIST LIST LIST~~~ " + accoutList);
		for(int i=0; i<accoutList.size(); i++){
			Account act = accoutList.get(i);
			System.out.println("account: " + act.getWx_nickname() + "   " + act.getWx_sessionkey() );
		}
		Map res = new HashMap();
		Map p1 = new HashMap();
		p1.put("cat", "tom");
		p1.put("whattime", "5.12");
		res.put("result", p1);
		return res;
	}

}
