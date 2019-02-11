package cn.com.iherpai.core.storage.mybatis.mapper;

import org.springframework.stereotype.Component;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Agenda;

@Component
public class AgendaMapper {	
	public int add(Agenda agenda) throws DaoException;

}
