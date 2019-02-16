package cn.com.iherpai.core.storage.mybatis.mapper;

import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Meeting;

@Component
public interface MeetingMapper {
	public int add(Meeting account) throws DaoException;
	
	public int removeById(String id) throws DaoException;
	
	public int removeBySid(String sid) throws DaoException;
	
	public int remove(Map params) throws DaoException;
	
	public int update(Map params) throws DaoException;
	
	public Map get(Map params) throws DaoException;	

}
