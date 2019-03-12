package cn.com.iherpai.core.storage.mybatis.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Dict;
import cn.com.iherpai.core.storage.mybatis.orm.MapTeamAccount;
import cn.com.iherpai.core.storage.mybatis.orm.Team;

public interface MapTeamAccountMapper {
	public int add(MapTeamAccount mapTeamAccount) throws DaoException;
	
	public int remove(Map params) throws DaoException;
	
	public int update(Map params) throws DaoException;
	
	public Team get(Map params) throws DaoException;	
	
	public int getCount(Map params) throws DaoException;
	
	public ArrayList<MapTeamAccount> list(Map params) throws DaoException;
}
