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
	public Account add(AccountVo account, String fields) throws DaoException;
	
	public Account regist(AccountVo account, String fields) throws DaoException;
	
	public int remove(AccountVo accountVo) throws DaoException;
	
	public int update(AccountVo accountVo) throws DaoException;
	
	public Account get(AccountVo accountVo, String fields) throws DaoException;
	
	public Account login(AccountVo accountVo, String fields) throws DaoException;
	
	public HashMap<String, Object> list(AccountVo accountVo, String fields) throws DaoException;
}