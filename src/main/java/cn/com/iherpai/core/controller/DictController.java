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
import cn.com.iherpai.core.service.DictService;
import cn.com.iherpai.core.storage.mybatis.orm.Dict;
import cn.com.iherpai.core.storage.mybatis.orm.DictGroup;

/*
 * 1. 新建字典 [add]
 * 2. 修改字典 [update]
 * 3. 删除字典 [remove]
 * 4. 删除字典(批量) [removeAll]
 * 5. 查询字典 [search]
 * 6. 新建字典组 [group/add]
 * 7. 修改字典组 [group/update]
 * 8. 删除字典组 [group/remove]
 * 9. 删除字典组(批量) [group/removeAll]
 * 10. 查询字典组 [group/search]
 */
@Controller
@RequestMapping("/dict")
public class DictController {
	
	@Autowired
	private DictService dictService;
	
	// START: [1] 新建字典 [add]
	@RequestMapping(value="add", method=RequestMethod.POST)
	public @ResponseBody ResultObject add(@RequestBody Dict dict){
		ResultObject ro = new ResultObject();
		try{
			//校验字典code/name/description规则
			//校验指定dictGroupSid中code/name/sortno是否冲突
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [1] 新建字典 [add]
		

	
	// START: [2] 修改字典 [update]
	// END: [2] 修改字典 [update]
	

	
	// START: [3] 删除字典 [remove]
	// END: [3] 删除字典 [remove]
	

	
	// START: [4] 删除字典(批量) [removeAll]
	// END: [4] 删除字典(批量) [removeAll]
	

	
	// START: [5] 查询字典 [search]
	// END: [5] 查询字典 [search]
	

	
	// START: [6] 新建字典组 [group/add]
	@RequestMapping(value="group/add", method=RequestMethod.POST)
	public @ResponseBody ResultObject add(@RequestBody DictGroup dictGroup){
		ResultObject ro = new ResultObject();
		try{
			//校验字典组code/name/description规则
			//校验指定parentId中code/name/sortno是否冲突
			dictGroup.setNid(1);
			dictGroup.setSid(ID.newId(IhpConfig.SID_$DICTGROUP, IhpConfig.ID_DATA_DATABASE_CODE, IhpConfig.ID_DATA_TABLE_CODE));
			dictGroup.setCreateTime(DateTime.getCurrentTimestamp());
			dictGroup.setStatus(0);
			int res = dictService.add(dictGroup);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [6] 新建字典组 [group/add]
	

	
	// START: [7] 修改字典组 [group/update]
	// END: [7] 修改字典组 [group/update]
	

	
	// START: [8] 删除字典组 [group/remove]
	// END: [8] 删除字典组 [group/remove]
	

	
	// START: [9] 删除字典组(批量) [group/removeAll]
	// END: [9] 删除字典组(批量) [group/removeAll]
	

	
	// START: [10] 查询字典组 [group/search]
	// END: [10] 查询字典组 [group/search]
	
	
	
	
	
	
	
	

}
