package cn.com.iherpai.core.storage.mybatis.das;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;

@SuppressWarnings({ "unchecked", "rawtypes" })
public interface EntityDas {
	
	@Transactional
	public int removeById(String id) throws DaoException;
	
	@Transactional
	public int remove(Map params) throws DaoException;
	
	@Transactional
	public int update(Map params) throws DaoException;
	
	@Transactional
	public Map get(Map params) throws DaoException;
	
	@Transactional
	public long getCount(Map params) throws DaoException;
	
	@Transactional
	public List list(Map params) throws DaoException;
}
