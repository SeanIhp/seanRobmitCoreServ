package cn.com.iherpai.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Agenda;
import cn.com.iherpai.core.vo.AgendaVo;

@Service
@Transactional
public interface AgendaService {
	public String add(Agenda agenda) throws DaoException;
	
	public String remove(AgendaVo agendaVo) throws DaoException;
	
	public String modify(AgendaVo agendaVo) throws DaoException;
	
	public AgendaVo get(AgendaVo agendaVo) throws DaoException;
	
	public Object list();

}
