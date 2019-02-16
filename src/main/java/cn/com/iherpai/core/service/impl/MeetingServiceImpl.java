package cn.com.iherpai.core.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.core.service.MeetingService;
import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.orm.Meeting;
import cn.com.iherpai.core.vo.MeetingVo;

@Service
@Transactional
public class MeetingServiceImpl implements MeetingService {

	@Override
	public String add(Meeting meeting) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String remove(MeetingVo meetingVo) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modify(MeetingVo meetingVo) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MeetingVo get(MeetingVo meetingVo) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

}
