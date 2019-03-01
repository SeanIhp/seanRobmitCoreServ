package cn.com.iherpai.core.storage.mybatis.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Dict;

public interface DictMapper {
	public int add(Dict dict) throws DaoException;
	
	public int remove(Map params) throws DaoException;
	
	public int removeIn(Map params) throws DaoException;
	
	public int update(Map params) throws DaoException;
	
	public Dict get(Map params) throws DaoException;	
	
	public int getCount(Map params) throws DaoException;
	
	public ArrayList<Dict> list(Map params) throws DaoException;
}
