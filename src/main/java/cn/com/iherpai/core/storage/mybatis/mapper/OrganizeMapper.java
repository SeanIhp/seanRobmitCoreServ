package cn.com.iherpai.core.storage.mybatis.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Organize;

public interface OrganizeMapper {
	public int add(Organize organize) throws DaoException;
	
	public int remove(Map params) throws DaoException;
	
	public int update(Map params) throws DaoException;
	
	public Organize get(Map params) throws DaoException;	
	
	public int getCount(Map params) throws DaoException;
	
	public ArrayList<Organize> list(Map params) throws DaoException;
}
