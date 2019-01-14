package cn.com.iherpai.core.storage.mybatis.das;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.core.storage.mybatis.exception.AccountNameAlreadyExistsException;
import cn.com.iherpai.core.storage.mybatis.exception.AccountSaveFailedException;
import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Account;

//@SuppressWarnings({ "unchecked", "rawtypes" })
//Service("accountDas")
public class AccountDas extends BaseDas implements EntityDas {

	public AccountDas() {
	} 
	
	/*
	 * 用户注册
	 * @account	新用户资料
	 * @return	用户ID
	 */
	//Transactional
	public Long add(Account account) throws AccountNameAlreadyExistsException, DaoException, AccountSaveFailedException {
		Long res = null; 
		Map<String, String> params = new HashMap<String, String>();
		// params.put("account$name", account.getName());
		long _nameCount = accountDao.getCount(params);
		if(_nameCount>0){
			throw new AccountNameAlreadyExistsException();
		}
		accountDao.add(account);
		res = account.getId();
		return res;
	}
	
	/*
	 * 用户删除
	 * @id	用户ID
	 */
	//Transactional
	public int removeById(String id) throws DaoException {
		int res = 0;
		res = accountDao.removeById(id);
		return res;
	}

	//Transactional
	public int remove(Map params) throws DaoException {
		int res = 0;
		res = accountDao.remove(params);
		return res;
	}
	
	/*
	 * 用户更新
	 * @account	用户资料
	 */
	//Transactional
	public int update(Map params) throws DaoException {
		int res = 0;
		res = accountDao.update(params);
		return res;
	}
	
	/*
	 * 用户查询
	 * @name	用户名
	 */
	@Transactional
	public Map get(Map params) throws DaoException {
		Map res = null; 
		res = accountDao.get(params);
		return res;
	}
	
	/*
	 * 用户名占用情况查询
	 * @name	查询映射ID
	 */
	@Transactional
	public long getCount(Map params) throws DaoException {
		long res = 0; 
		res = accountDao.getCount(params);
		return res;
	}
	
	/*
	 * 用户查询
	 * @selectId	查询映射ID
	 * @params		查询参数
	 */
	@Transactional
	public List<Account> list(Map params) throws DaoException {
		List<Account> res = null;
		res = accountDao.list(params);
		return res;
	}

}
