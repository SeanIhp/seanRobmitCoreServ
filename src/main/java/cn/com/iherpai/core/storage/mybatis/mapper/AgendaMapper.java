package cn.com.iherpai.core.storage.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Agenda;

@Component
public interface AgendaMapper {	
	public int add(Agenda agenda) throws DaoException;
	
	public int removeById(String id) throws DaoException;
	
	public int removeBySid(String sid) throws DaoException;
	
	public int remove(Map params) throws DaoException;
	
	public int update(Map params) throws DaoException;
	
	public Map get(Map params) throws DaoException;	
	
	public long getCount(Map params) throws DaoException;
	
	public List<Agenda> list(Map params, String fields) throws DaoException;
	
	public List<Agenda> listAll() throws DaoException;

}
