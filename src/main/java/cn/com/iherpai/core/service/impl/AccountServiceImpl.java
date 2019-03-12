package cn.com.iherpai.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.iherpai.common.utils.EntityUtil;
import cn.com.iherpai.common.utils.Sql;
import cn.com.iherpai.core.service.AccountService;
import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.mapper.AccountMapper;
import cn.com.iherpai.core.storage.mybatis.orm.Account;
import cn.com.iherpai.core.storage.mybatis.orm.Dict;
import cn.com.iherpai.core.storage.mybatis.orm.Entity;
import cn.com.iherpai.core.vo.AccountVo;
import cn.com.iherpai.core.vo.DictVo;
import cn.com.iherpai.core.vo.ValueObject;

/*
 * 1. 用户注册 [regist]
 * 2. 用户登录 [login]
 * 3. 用户修改密码 [modifyPassword]
 * 4. 用户信息更新 [update]
 * 5. 
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountMapper accountMapper;
	

	@Override
	public Account add(AccountVo accountVo, String fields) throws DaoException {
		Account res = null;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		ArrayList<HashMap> __alphaCondi = new ArrayList<HashMap>(0);
		Sql.addCondi(__alphaCondi, "username", "e", accountVo.getUsername(), 1);
		Sql.addCondi(__alphaCondi, "mailbox", "e", accountVo.getMailbox(), -1);
		ArrayList<HashMap> __alphaAddi = new ArrayList<HashMap>(0);
		Sql.newAddi(__alphaAddi, "type", "e", accountVo.getType(), 18);
		__alpha.put("conditons", Sql.generate(__alphaCondi, __alphaAddi));
		__alpha.put("fields", EntityUtil.toUnderScoreName(fields));
		Account r1 = accountMapper.get(__alpha);
		if( r1 == null ){
			int r2 = accountMapper.add(accountVo);
			if( r2 > 0 ){
				res = accountVo;
			}
		}else{
			if( r1.equals(accountVo.getUsername()) ) {
				throw new DaoException("用户名已被占用！");
			}else if( r1.equals(accountVo.getMailbox()) ){
				throw new DaoException("邮箱已被占用！");
			}
		}
		return res;
	}
	

	// START: [1] 用户注册
	@Override
	public Account regist(AccountVo accountVo, String fields) throws DaoException{
		Account res = null;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		ArrayList<HashMap> __alphaCondi = new ArrayList<HashMap>(0);
		Sql.addCondi(__alphaCondi, "username", "e", accountVo.getUsername(), 1);
		Sql.addCondi(__alphaCondi, "mailbox", "e", accountVo.getMailbox(), -1);
		ArrayList<HashMap> __alphaAddi = new ArrayList<HashMap>(0);
		Sql.newAddi(__alphaAddi, "type", "e", accountVo.getType(), 18);
		__alpha.put("conditons", Sql.generate(__alphaCondi, __alphaAddi));
		__alpha.put("fields", EntityUtil.toUnderScoreName(fields));
		Account r1 = accountMapper.get(__alpha);
		if( r1 == null ){
			int r2 = accountMapper.add(accountVo);
			if( r2 > 0 ){
				res = accountVo;
			}
		}else{
			if( r1.equals(accountVo.getUsername()) ) {
				throw new DaoException("用户名已被占用！");
			}else if( r1.equals(accountVo.getMailbox()) ){
				throw new DaoException("邮箱已被占用！");
			}
		}
		return res;
	}
	// END: [1] 用户注册
	
	
	
	@Override
	public int remove(AccountVo accountVo) throws DaoException {
		int res = -1;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		__alpha.put("conditions", Sql.generate(accountVo.getMaz(), accountVo.getMazAddition()));
		res = accountMapper.remove(__alpha);
		return res;
	}
	
	
	
	// START: [3] 用户修改密码 
	@Override
	public int update(AccountVo accountVo) throws DaoException {
		int res = -1;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		String sql = Sql.generate(accountVo.getMaz(), accountVo.getMazAddition());
		__alpha.put("conditions", sql);
		__alpha.put("password", accountVo.getNewPassword());
		__alpha.put("question", accountVo.getQuestion());
		__alpha.put("answer", accountVo.getAnswer());
		__alpha.put("mailbox", accountVo.getMailbox());
		__alpha.put("grade", accountVo.getGrade());
		__alpha.put("phone", accountVo.getPhone());
		__alpha.put("score", accountVo.getScore());
		__alpha.put("level", accountVo.getLevel());
		__alpha.put("status", accountVo.getStatus());
		res = accountMapper.update(__alpha);
		return res;
	}
	// END: [3] 用户修改密码
	
	

	@Override
	public Account get(AccountVo accountVo, String fields) throws DaoException {
		Account res = null;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		ArrayList<HashMap> __alphaCondi = Sql.newSqlExp();
		Sql.addCondi(__alphaCondi, "sid", "e", accountVo.getSid(), 1);
		__alpha.put("conditions", Sql.generate(__alphaCondi, null));
		__alpha.put("fields", EntityUtil.toUnderScoreName(fields));
		res = accountMapper.get(__alpha);
		return null;
	}
	
	


	// START: [2] 用户登录 
	@Override
	public Account login(AccountVo accountVo, String fields) throws DaoException{
		Map<String, Object> param = new HashMap<String, Object>();
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		ArrayList<HashMap> __alphaCondi = Sql.newSqlExp();
		Sql.addCondi(__alphaCondi, "username", "e", accountVo.getUsername(), 1);
		ArrayList<HashMap> __alphaAddi = Sql.newSqlExp();
		Sql.newAddi(__alphaAddi, "type", "e", Account.TYPE_USER, 18);
		__alpha.put("conditions", Sql.generate(__alphaCondi, __alphaAddi));
		Account r1 = accountMapper.get(__alpha);
		if( r1 != null ){
			if(r1.getPassword().equals(accountVo.getPassword())){
				return r1;
			}else{
				// 密码不正确
				return null;
			}
		}else{
			//用户名/密码不正确
			return null;
		}
	}
	// END: [2] 用户登录
	


	@Override
	public HashMap<String, Object> list(AccountVo accountVo, String fields) throws DaoException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		ArrayList<Account> list = new ArrayList<Account>(0);
		res.put("pageSize", accountVo.getPageSize());
		res.put("pageNo", accountVo.getPageNo());
		res.put("totalAll", 0);
		res.put("totalPage", 0);
		// 查询符合条件的记录数量
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		HashMap<String, String> __alphaSqlMap = Sql.generateMap(accountVo.getMaz(), accountVo.getMazAddition());
		__alpha.put("conditions", __alphaSqlMap.get("conditions"));
		int r1 = accountMapper.getCount(__alpha);
		res.put("totalAll", r1);
		if(r1>0){
			//字段列表转下划线分隔
			HashMap<String, Object> __beta = Sql.newSqlBox();
			__beta.put("fields", EntityUtil.toUnderScoreName(fields));
			__beta.put("pageOff", accountVo.getPageNo()>1 ? (accountVo.getPageNo()-1) * accountVo.getPageSize(): 1);
			__beta.put("conditions", __alphaSqlMap.get("conditions"));
			__beta.put("orderBy", __alphaSqlMap.get("orderBy"));
			list = accountMapper.list(__beta);
			res.put("totalPage", (r1-accountVo.getPageSize())/accountVo.getPageSize() );
		}
		System.out.println("++++++++++++++++++++++++  " + list + "  ["+list.size()+"]");
		res.put("list", list );
		return res;
	}


//	public Object list(){
////		System.out.println("AccountServiceImpl!!!! sfsffseff_________list: " + accountMapper);
//
//		System.out.println("AccountMapper!!!! ----------list!!!!-------"+ accountMapper );
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("fields", "id, nid, sid, username, mailbox, wxOpenid, wxNickname, wxAvatar, type, grade, phone, score, level, createTime, status");
////		List<Account> accoutList = null;
//		List<Account> accoutList = null;
//		try {
//			accoutList = accountMapper.listAll();
//		} catch (DaoException e) {
//			e.printStackTrace();
//			System.out.println("AccountMapper!!!! " + e);
//		}
//		System.out.println("AccountMapper!!!!LIST LIST LIST LIST~~~ " + accoutList);
//		for(int i=0; i<accoutList.size(); i++){
//			Account act = accoutList.get(i);
//			System.out.println("account: " + act.getUsername() + "   " + act.getMailbox() + "   " + act.getCreateTime() );
//		}
//		Map<String, Map> res = new HashMap<String, Map>();
//		Map<String, String> p1 = new HashMap<String, String>();
//		p1.put("cat", "tom");
//		p1.put("whattime", "5.12");
//		res.put("result", p1);
//		return res;
//	}

}
