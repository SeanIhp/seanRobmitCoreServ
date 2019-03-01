package cn.com.iherpai.core.service;

import java.util.ArrayList;
import java.util.HashMap;

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
	public Dict add(DictVo meeting, String fields) throws DaoException;
	
	public int remove(DictVo dictVo) throws DaoException;
	
	public int update(DictVo dictVo) throws DaoException;
	
	public Dict get(DictVo dictVo, String fields) throws DaoException;
	
	public HashMap<String, Object> list(DictVo dictVo, String fields) throws DaoException;
	
	
	public DictGroup add(DictGroupVo dictGroup, String fields) throws DaoException;
	
	public int remove(DictGroupVo dictGroupVo) throws DaoException;
	
	public int update(DictGroupVo dictGroupVo) throws DaoException;
	
	public DictGroup get(DictGroupVo dictGroupVo, String fields) throws DaoException;
	
	public HashMap<String, Object> list(DictGroupVo dictGroupVo, String fields) throws DaoException;

}
