package cn.com.iherpai.core.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Dict;
import cn.com.iherpai.core.storage.mybatis.orm.DictGroup;
import cn.com.iherpai.core.vo.DictGroupVo;
import cn.com.iherpai.core.vo.DictVo;

@Service
@Transactional
public interface DictService {
	public String add(Dict meeting) throws DaoException;
	
	public String remove(DictVo dictVo) throws DaoException;
	
	public String update(DictVo dictVo) throws DaoException;
	
	public DictVo get(DictVo dictVo) throws DaoException;
	
	public ArrayList<Dict> search(DictVo dictVo) throws DaoException;
	
	public String addGroup(DictGroup dictGroup) throws DaoException;
	
	public String removeGroup(DictGroupVo dictGroupVo) throws DaoException;
	
	public String updateGroup(DictGroupVo dictGroupVo) throws DaoException;
	
	public DictVo getGroup(DictGroupVo dictGroupVo) throws DaoException;
	
	public ArrayList<DictGroup> search(DictGroupVo dictGroupVo) throws DaoException;

}
