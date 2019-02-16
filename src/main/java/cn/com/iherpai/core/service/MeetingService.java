package cn.com.iherpai.core.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Meeting;
import cn.com.iherpai.core.vo.MeetingVo;

@Service
@Transactional
public interface MeetingService {
	public String add(Meeting meeting) throws DaoException;
	
	public String remove(MeetingVo meetingVo) throws DaoException;
	
	public String modify(MeetingVo meetingVo) throws DaoException;
	
	public MeetingVo get(MeetingVo meetingVo) throws DaoException;
	
	public Object list();

}
