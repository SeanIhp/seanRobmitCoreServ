package cn.com.iherpai.core.storage.mybatis.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Account;

@Component
public interface AccountMapper {
	public Account getOnLogin(Map<String, Object> param) throws DaoException;
	
	public int regist(Account account) throws DaoException;
	
	public int add(Account account) throws DaoException;
	
	public int removeById(String id) throws DaoException;
	
	public int removeBySid(String sid) throws DaoException;
	
	public int remove(Map params) throws DaoException;
	
	public int update(Map params) throws DaoException;
	
	public Map get(Map params) throws DaoException;	
	
	public long getCount(Map params) throws DaoException;
	
	public List<Account> list(Map params) throws DaoException;
}
