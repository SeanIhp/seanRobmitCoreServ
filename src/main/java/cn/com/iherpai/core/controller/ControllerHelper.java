package cn.com.iherpai.core.controller;

import java.io.InputStream;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import cn.com.iherpai.core.vo.AccountVo;
import cn.com.iherpai.core.vo.DictGroupVo;
import cn.com.iherpai.core.vo.DictVo;
import cn.com.iherpai.core.vo.OrganizeVo;
import cn.com.iherpai.core.vo.TeamVo;

public class ControllerHelper {

	public static void voValidate(DictVo dictVo, String schemaPath) throws Exception {
		JSONObject jsonObject=new JSONObject(dictVo);
		InputStream inputStream = dictVo.getClass().getResourceAsStream(schemaPath);
		JSONObject Schema = new JSONObject(new JSONTokener(inputStream));
		Schema schema = SchemaLoader.load(Schema);
		schema.validate(jsonObject);
	}

	public static  void voValidate(DictGroupVo dictGroupVo, String schemaPath)  throws Exception {
		JSONObject jsonObject=new JSONObject(dictGroupVo);
		InputStream inputStream = dictGroupVo.getClass().getResourceAsStream(schemaPath);
		JSONObject Schema = new JSONObject(new JSONTokener(inputStream));
		Schema schema = SchemaLoader.load(Schema);
		schema.validate(jsonObject);
	}

	public static  void voValidate(AccountVo accountVo, String schemaPath)  throws Exception {
		JSONObject jsonObject=new JSONObject(accountVo);
		InputStream inputStream = accountVo.getClass().getResourceAsStream(schemaPath);
		JSONObject Schema = new JSONObject(new JSONTokener(inputStream));
		Schema schema = SchemaLoader.load(Schema);
		schema.validate(jsonObject);
	}

	public static  void voValidate(TeamVo teamVo, String schemaPath)  throws Exception {
		JSONObject jsonObject=new JSONObject(teamVo);
		InputStream inputStream = teamVo.getClass().getResourceAsStream(schemaPath);
		JSONObject Schema = new JSONObject(new JSONTokener(inputStream));
		Schema schema = SchemaLoader.load(Schema);
		schema.validate(jsonObject);
	}

	public static  void voValidate(OrganizeVo organizeVo, String schemaPath)  throws Exception {
		JSONObject jsonObject=new JSONObject(organizeVo);
		InputStream inputStream = organizeVo.getClass().getResourceAsStream(schemaPath);
		JSONObject Schema = new JSONObject(new JSONTokener(inputStream));
		Schema schema = SchemaLoader.load(Schema);
		schema.validate(jsonObject);
	}

}
