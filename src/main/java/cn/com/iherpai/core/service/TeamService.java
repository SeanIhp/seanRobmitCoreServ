package cn.com.iherpai.core.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Dict;
import cn.com.iherpai.core.storage.mybatis.orm.DictGroup;
import cn.com.iherpai.core.storage.mybatis.orm.Organize;
import cn.com.iherpai.core.storage.mybatis.orm.Team;
import cn.com.iherpai.core.vo.DictGroupVo;
import cn.com.iherpai.core.vo.DictVo;
import cn.com.iherpai.core.vo.OrganizeVo;
import cn.com.iherpai.core.vo.TeamVo;

@Service
@Transactional
public interface TeamService {
	public Team add(TeamVo teamVo, String fields) throws DaoException;
	
	public int remove(TeamVo teamVo) throws DaoException;
	
	public int update(TeamVo teamVo) throws DaoException;
	
	public Team get(TeamVo teamVo, String fields) throws DaoException;
	
	public HashMap<String, Object> list(TeamVo teamVo, String fields) throws DaoException;
	
	
	public Organize add(OrganizeVo organizeVo, String fields) throws DaoException;
	
	public int remove(OrganizeVo organizeVo) throws DaoException;
	
	public int update(OrganizeVo organizeVo) throws DaoException;
	
	public Organize get(OrganizeVo organizeVo, String fields) throws DaoException;
	
	public HashMap<String, Object> list(OrganizeVo organizeVo, String fields) throws DaoException;

}
