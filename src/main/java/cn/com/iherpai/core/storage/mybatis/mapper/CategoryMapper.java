package cn.com.iherpai.core.storage.mybatis.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Category;

@Component
public interface CategoryMapper {
	public int add(Category category) throws DaoException;
	
	public int removeById(String id) throws DaoException;
	
	public int remove(Map params) throws DaoException;
	
	public int update(Map params) throws DaoException;
	
	public Map get(Map params) throws DaoException;	
	
	public long getCount(Map params) throws DaoException;
	
	public List<Category> list(Map params) throws DaoException;
}
