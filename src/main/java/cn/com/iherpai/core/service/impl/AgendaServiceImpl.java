package cn.com.iherpai.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.core.service.AgendaService;
import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.mapper.AgendaMapper;
import cn.com.iherpai.core.storage.mybatis.orm.Agenda;
import cn.com.iherpai.core.vo.AgendaVo;

@Service
@Transactional
public class AgendaServiceImpl implements AgendaService {
	
	@Autowired
	private AgendaMapper agendaMapper;

	@Override
	public String add(Agenda agenda) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String remove(AgendaVo agendaVo) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modify(AgendaVo agendaVo) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgendaVo get(AgendaVo agendaVo) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

}
