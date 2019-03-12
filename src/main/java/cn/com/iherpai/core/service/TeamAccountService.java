package cn.com.iherpai.core.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.MapTeamAccount;
import cn.com.iherpai.core.vo.MapTeamAccountVo;
import cn.com.iherpai.core.vo.ViewTeamAccountVo;

@Service
@Transactional
public interface TeamAccountService {
	public MapTeamAccount add(MapTeamAccountVo mapTeamAccountVo, String fields) throws DaoException;
	
	public int remove(MapTeamAccountVo mapTeamAccountVo) throws DaoException;
	
	public int update(MapTeamAccountVo mapTeamAccountVo) throws DaoException;
	
	public ViewTeamAccountVo get(ViewTeamAccountVo viewTeamAccountVo, String fields) throws DaoException;
	
	public HashMap<String, Object> list(ViewTeamAccountVo viewTeamAccountVo, String fields) throws DaoException;

}
