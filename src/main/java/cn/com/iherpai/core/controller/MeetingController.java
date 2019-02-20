package cn.com.iherpai.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.iherpai.common.consts.IhpConfig;
import cn.com.iherpai.common.utils.DateTime;
import cn.com.iherpai.common.utils.ID;
import cn.com.iherpai.core.entify.ResultObject;
import cn.com.iherpai.core.service.MeetingService;
import cn.com.iherpai.core.storage.mybatis.orm.Meeting;
/*
 * 1. 添加会议 [add]
 * 2. 修改会议 [modify]
 * 3. 获得会议 [get]
 * 4. 查询 [search]
 */
@Controller
@RequestMapping("/meeting")
public class MeetingController {
	
	@Autowired
	private MeetingService meetingService;
	
	
	// START: [1] 添加会议
	@RequestMapping(value="add", method=RequestMethod.POST)
	public @ResponseBody ResultObject regist(@RequestBody Meeting meeting){
		ResultObject ro = new ResultObject();
		try {
			// 校验必填字段规则
			// 敏感词过滤
			meeting.setNid(1);
			meeting.setSid((ID.newId(IhpConfig.SID_$MEETING, IhpConfig.ID_DATA_DATABASE_CODE, IhpConfig.ID_DATA_TABLE_CODE)));
			meeting.setCreateTime(DateTime.getCurrentTimestamp());
			meeting.setStatus(0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ro;
	}
	// END: [1] 添加会议
	

}
