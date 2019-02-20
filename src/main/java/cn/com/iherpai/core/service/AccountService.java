package cn.com.iherpai.core.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.mapper.AccountMapper;
import cn.com.iherpai.core.storage.mybatis.orm.Account;
import cn.com.iherpai.core.vo.AccountVo;

@Service
@Transactional
public interface AccountService {
	public int regist(Account account) throws DaoException;
	
	public Account login(Account account, String fields) throws DaoException;
	
	public int modifyPassword(AccountVo accountVo) throws DaoException;
	
	public String add(Account account);
	
	public List<Account> search(AccountVo accountVo) throws DaoException;
	
	public List<Account> searchIn(AccountVo accountVo) throws DaoException;
}