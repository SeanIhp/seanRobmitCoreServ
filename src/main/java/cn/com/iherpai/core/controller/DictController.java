package cn.com.iherpai.core.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
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
import cn.com.iherpai.core.vo.DictGroupVo;
import cn.com.iherpai.core.vo.DictVo;
import cn.com.iherpai.core.vo.ValueObject;

/*
 * 1. 新建字典 [add]
 * 2. 修改字典 [update]
 * 3. 删除字典 [remove]
 * 4. 删除字典(批量) [removeAll]
 * 5. 获取字典 [get]
 * 6. 查询字典 [list]
 * 101. 新建字典组 [group/add]
 * 102. 修改字典组 [group/update]
 * 103. 删除字典组 [group/remove]
 * 104. 删除字典组(by <condi>) [group/removeAll]
 * 105. 删除字典组(in <range>) [group/removeIn]
 * 106. 获取字典组[group/get]
 * 107. 查询字典组 [group/list]
 */
@Controller
@RequestMapping("/dict")
public class DictController {
	
	@Autowired
	private DictService dictService;
	
	// START: [1] 新建字典 [add]
	@RequestMapping(value="add", method=RequestMethod.POST)
	public @ResponseBody ResultObject add(@RequestBody DictVo dictVo){
		ResultObject ro = new ResultObject();
		try{
			ControllerHelper.voValidate(dictVo, "/cn/com/iherpai/core/vo/schema/Dict__add.json");
			//校验字典code/name/description规则
			//校验指定dictGroupSid中code/name/sortno是否冲突
	        Dict res = dictService.add(dictVo, Dict.fieldsDefault);
	        if(res!=null){
	        	ArrayList<String> returnFields = ValueObject.returnFieldsBuild(Dict.fieldsDefault);
	        	DictVo dVo = new DictVo(res, returnFields);
	        	ro.addData("dict", dVo);
	        }
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "字典定义填写有误！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [1] 新建字典 [add]
	

	
	// START: [3] 删除字典 [remove]
	@RequestMapping(value="remove", method=RequestMethod.POST)
	public @ResponseBody ResultObject remove(@RequestBody DictVo dictVo){
		ResultObject ro = new ResultObject();
		try{
	//		ControllerHelper.voValidate(dictGroupVo, "/cn/com/iherpai/core/vo/schema/Dict.json");
			dictVo.addAddition("status", "e", 0, 18);
			int res = dictService.remove(dictVo);
			if(res>0){
				ro.addData("sid", dictVo.getSid());	
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "字典不存在！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [3] 删除字典 [remove]
	

	
	// START: [2] 修改字典 [update]
	@RequestMapping(value="update", method=RequestMethod.POST)
	public @ResponseBody ResultObject update(@RequestBody DictVo dictVo){
		ResultObject ro = new ResultObject();
		try{
//			ControllerHelper.voValidate(dictGroupVo, "/cn/com/iherpai/core/vo/schema/Dict.json");
			//校验字典组code/name/description规则
			int res = dictService.update(dictVo);
			if( res > 0 ){
				ro.addData("sid", dictVo.getSid());	
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "字典定义填写有误！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [2] 修改字典 [update]
	

	
	// START: [5] 获取字典 [get]
	@RequestMapping(value="get", method=RequestMethod.POST)
	public @ResponseBody ResultObject get(@RequestBody DictVo dictVo){
		ResultObject ro = new ResultObject();
		try{
//			ControllerHelper.voValidate(dictGroupVo, "/cn/com/iherpai/core/vo/schema/Dict.json");
			Dict res = dictService.get(dictVo, Dict.fieldsDefault);
			if(res!=null){
				ArrayList<String> returnFields = ValueObject.returnFieldsBuild(Dict.fieldsDefault);
				DictVo dVo = new DictVo(res, returnFields);
				ro.addData("dict", dVo);
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "查询条件有误！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [5] 获取字典 [get]
	

	
	// START: [6] 查询字典 [list]
	@RequestMapping(value="list", method=RequestMethod.POST)
	public @ResponseBody ResultObject list(@RequestBody DictVo dictVo){
		ResultObject ro = new ResultObject();
		try{
//			ControllerHelper.voValidate(dictGroupVo, "/cn/com/iherpai/core/vo/schema/DictGroup.json");
			HashMap<String, Object> res = dictService.list(dictVo, Dict.fieldsDefault);
			ArrayList<Dict> resList = (ArrayList<Dict>)res.get("list");
			ArrayList<String> returnFields = ValueObject.returnFieldsBuild(Dict.fieldsDefault);
			ArrayList<DictVo> resVoList = ValueObject.getDictVos(resList, returnFields);
			ro.addData("dictList", resVoList);
			ro.addData("totalAll", (Integer)res.get("totalAll"));
			ro.addData("totalPage", (Integer)res.get("totalPage"));
			ro.addData("pageSize", (Integer)res.get("pageSize"));
			ro.addData("pageNo", (Integer)res.get("pageNo"));
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "查询条件有误！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [6] 查询字典 [list]
	

	
	// START: [101] 新建字典组 [group/add]
	@RequestMapping(value="group/add", method=RequestMethod.POST)
	public @ResponseBody ResultObject add(@RequestBody DictGroupVo dictGroupVo){
		ResultObject ro = new ResultObject();
		try{
//			ControllerHelper.voValidate(dictGroupVo, "/cn/com/iherpai/core/vo/schema/DictGroup__add.json");
			//校验字典组code/name/description规则
			dictGroupVo.setNid(1);
			dictGroupVo.setSid(ID.newId(IhpConfig.SID_$DICTGROUP, IhpConfig.ID_DATA_DATABASE_CODE, IhpConfig.ID_DATA_TABLE_CODE));
			if(dictGroupVo.getScode()==null){
				dictGroupVo.setScode( dictGroupVo.getCode() );
			}
			if(dictGroupVo.getSname()==null){
				dictGroupVo.setSname( dictGroupVo.getName() );
			}
			dictGroupVo.setType(1);
			dictGroupVo.setHasChild(false);
			dictGroupVo.setCreateTime(DateTime.getCurrentTimestamp());
			dictGroupVo.setStatus(DictGroup.STATUS_CREATED);
			DictGroup res = dictService.add(dictGroupVo, DictGroup.fieldsDefault);
			if(res!=null){
				ArrayList<String> returnFields = ValueObject.returnFieldsBuild(DictGroup.fieldsDefault);
				DictGroupVo dgVo = new DictGroupVo(res, returnFields);
				ro.addData("dictGroup", dgVo);	
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "字典组定义填写有误！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [101] 新建字典组 [group/add]
	

	
	// START: [103] 删除字典组 [group/remove]
	@RequestMapping(value="group/remove", method=RequestMethod.POST)
	public @ResponseBody ResultObject remove(@RequestBody DictGroupVo dictGroupVo){
		ResultObject ro = new ResultObject();
		try{
//			ControllerHelper.voValidate(dictGroupVo, "/cn/com/iherpai/core/vo/schema/DictGroup.json");
//	        dictGroupVo.absMsk(3, false);	//栓查糁数数量，禁用“or”运算
//	        dictGroupVo.addCondition("status", "e", 0, 18);	//增加where条件
//			dictGroupVo.addAddition("xxbb", "e", "vs11", 1);	//增加whereAddition附加条件
			dictGroupVo.addAddition("status", "e", 0, 18);
//			dictGroupVo.addAddition("code", "e", "avvs", 31);
			int res = dictService.remove(dictGroupVo);
			if(res>0){
				ro.addData("sid", dictGroupVo.getSid());	
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "字典组定义填写有误！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [103] 删除字典组 [group/remove]
	

	
	// START: [102] 修改字典组 [group/update]
	@RequestMapping(value="group/update", method=RequestMethod.POST)
	public @ResponseBody ResultObject update(@RequestBody DictGroupVo dictGroupVo){
		ResultObject ro = new ResultObject();
		try{
//			ControllerHelper.voValidate(dictGroupVo, "/cn/com/iherpai/core/vo/schema/DictGroup.json");
			//校验字典组code/name/description规则
			int res = dictService.update(dictGroupVo);
			if(res>0){
				ro.addData("sid", dictGroupVo.getSid());	
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "字典组定义填写有误！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [102] 修改字典组 [group/update]
	

	
	// START: [106] 获取字典组 [group/get]
	@RequestMapping(value="group/get", method=RequestMethod.POST)
	public @ResponseBody ResultObject get(@RequestBody DictGroupVo dictGroupVo){
		ResultObject ro = new ResultObject();
		try{
//			ControllerHelper.voValidate(dictGroupVo, "/cn/com/iherpai/core/vo/schema/DictGroup.json");
			DictGroup res = dictService.get(dictGroupVo, DictGroup.fieldsDefault);
			if(res!=null){
				ArrayList<String> returnFields = ValueObject.returnFieldsBuild(DictGroup.fieldsDefault);
				DictGroupVo dgVo = new DictGroupVo(res, returnFields);
				ro.addData("dictGroup", dgVo);
			}
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "查询条件有误！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [106] 新获娶字典组 [group/get]
	

	
	// START: [107] 查询字典组 [group/list]
	@RequestMapping(value="group/list", method=RequestMethod.POST)
	public @ResponseBody ResultObject list(@RequestBody DictGroupVo dictGroupVo){
		ResultObject ro = new ResultObject();
		try{
//			ControllerHelper.voValidate(dictGroupVo, "/cn/com/iherpai/core/vo/schema/DictGroup.json");
			HashMap<String, Object> res = dictService.list(dictGroupVo, DictGroup.fieldsDefault);
			ArrayList<DictGroup> resList = (ArrayList<DictGroup>)res.get("list");
			ArrayList<String> returnFields = ValueObject.returnFieldsBuild(DictGroup.fieldsDefault);
			ArrayList<DictGroupVo> resVoList = ValueObject.getDictGroupVos(resList, returnFields);
			ro.addData("dictGroupList", resVoList);
			ro.addData("totalAll", (Integer)res.get("totalAll"));
			ro.addData("totalPage", (Integer)res.get("totalPage"));
			ro.addData("pageSize", (Integer)res.get("pageSize"));
			ro.addData("pageNo", (Integer)res.get("pageNo"));
			ro.setReturnCode(100);
		} catch (ValidationException ve) {
			ve.printStackTrace();
			ro.setReturnCode(-100);
			ro.addData("resultTip", "查询条件有误！");
		}catch(Exception e){
			e.printStackTrace();
		}
		return ro;
	}
	// END: [107] 查询字典组 [group/search]
	
	
	
	
	
	
	
	

}
