package cn.com.iherpai.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SqlMaker {
	
	public HashMap<String, HashMap<String, Object>> sqlMag = new HashMap<String, HashMap<String, Object>>();
	public HashMap<String, ArrayList<HashMap>> condiMag = new HashMap<String, ArrayList<HashMap>>();
	public HashMap<String, ArrayList<HashMap>> addiMag = new HashMap<String, ArrayList<HashMap>>();
	
	private String[] sqlKey = new String[]{
			"alpha", 	"bravo", 	"charlie", 		"delta", 	"echo", 	"fox", 
			"golf", 	"hotel",	"india", 		"juliet", 	"kilo",		"lima",
			"monkey",	"nancy",	"oscar",		"polo",		"quebec",	"romeo",
			"sierra",	"tango",	"uniform",		"victor",	"whiskey",	"xray",
			"yankee",	"zulu"
	};
	
	public SqlMaker(int magzineSize) {
		for(int i=0; i<magzineSize; i++){
			HashMap<String, Object> p = new HashMap<String, Object>();
			ArrayList<HashMap> c = new ArrayList<HashMap>(0);
			ArrayList<HashMap> a = new ArrayList<HashMap>(0);
			sqlMag.put(this.sqlKey[i], p);
			condiMag.put(this.sqlKey[i], c);
			addiMag.put(this.sqlKey[i], a);
		}
	}
	
	public void addCondi(String sqlKey, String key, String operate, String value, Integer msk) {
		ArrayList<HashMap> c = (ArrayList<HashMap>)condiMag.get(sqlKey);
		HashMap condi = new HashMap();
		condi.put("key", key);
		condi.put("op", operate);
		condi.put("val", value);
		condi.put("msk", msk);
		c.add(condi);
	}
	
	public void addCondi(String sqlKey, String key, String operate, Integer value, Integer msk) {
		ArrayList<HashMap> c = (ArrayList<HashMap>)condiMag.get(sqlKey);
		HashMap condi = new HashMap();
		condi.put("key", key);
		condi.put("op", operate);
		condi.put("val", value);
		condi.put("msk", msk);
		c.add(condi);
	}
	
	public void addCondi(String sqlKey, String key, String operate, Float value, Integer msk) {
		ArrayList<HashMap> c = (ArrayList<HashMap>)condiMag.get(sqlKey);
		HashMap condi = new HashMap();
		condi.put("key", key);
		condi.put("op", operate);
		condi.put("val", value);
		condi.put("msk", msk);
		c.add(condi);
	}
	
	public void newAddi(String sqlKey, String key, String operate, String value, Integer msk) {
		ArrayList<HashMap> a = (ArrayList<HashMap>)addiMag.get(sqlKey);
		HashMap addi = new HashMap();
		addi.put("key", key);
		addi.put("op", operate);
		addi.put("val", value);
		addi.put("msk", msk);
		a.add(addi);
	}
	
	public void newAddi(String sqlKey, String key, String operate, Integer value, Integer msk) {
		ArrayList<HashMap> a = (ArrayList<HashMap>)addiMag.get(sqlKey);
		HashMap addi = new HashMap();
		addi.put("key", key);
		addi.put("op", operate);
		addi.put("val", value);
		addi.put("msk", msk);
		a.add(addi);
	}
	
	public void newAddi(String sqlKey, String key, String operate, Float value, Integer msk) {
		ArrayList<HashMap> a = (ArrayList<HashMap>)addiMag.get(sqlKey);
		HashMap addi = new HashMap();
		addi.put("key", key);
		addi.put("op", operate);
		addi.put("val", value);
		addi.put("msk", msk);
		a.add(addi);
	}
	
	public void addExp(String sqlKey, String expKey, Object expCondition){
		HashMap<String, Object> p = (HashMap<String, Object>)sqlMag.get(sqlKey);
		if( expKey.equals("conditions") ){
//			p.put(expKey, SqlHelper.generate((ArrayList<HashMap>)condiMag.get(sqlKey), (ArrayList<HashMap>)addiMag.get(sqlKey)))
		}else if( expKey.equals("conditionsMap") ){
			
		}else if( expKey.equals("fields") ){
			
		}else {
			p.put(expKey, expCondition);
		}
	}
}
