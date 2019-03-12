package cn.com.iherpai.core.storage.mybatis.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Account;

@Component
public interface AccountMapper {	
	public int add(Account account) throws DaoException;
	
	public int remove(Map params) throws DaoException;
	
	public int update(Map params) throws DaoException;
	
	public Account get(Map params) throws DaoException;	
	
	public int getCount(Map params) throws DaoException;
	
	public ArrayList<Account> list(Map params) throws DaoException;
}
