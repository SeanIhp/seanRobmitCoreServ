package cn.com.iherpai.core.storage.mybatis.mapper;

import java.util.List;
import java.util.Map;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Dict;
import cn.com.iherpai.core.storage.mybatis.orm.DictGroup;

public interface DictGroupMapper {
	public int add(DictGroup dictGroup) throws DaoException;
	
	public int removeById(String id) throws DaoException;
	
	public int remove(Map params) throws DaoException;
	
	public int update(Map params) throws DaoException;
	
	public Map get(Map params) throws DaoException;	
	
	public long getCount(Map params) throws DaoException;
	
	public List<DictGroup> list(Map params) throws DaoException;
}
