package cn.com.iherpai.core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.common.consts.IhpConfig;
import cn.com.iherpai.common.utils.DateTime;
import cn.com.iherpai.common.utils.EntityUtil;
import cn.com.iherpai.common.utils.ID;
import cn.com.iherpai.common.utils.Sql;
import cn.com.iherpai.core.service.TeamService;
import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.mapper.AccountMapper;
import cn.com.iherpai.core.storage.mybatis.mapper.MapTeamAccountMapper;
import cn.com.iherpai.core.storage.mybatis.mapper.OrganizeMapper;
import cn.com.iherpai.core.storage.mybatis.mapper.TeamMapper;
import cn.com.iherpai.core.storage.mybatis.orm.Account;
import cn.com.iherpai.core.storage.mybatis.orm.DictGroup;
import cn.com.iherpai.core.storage.mybatis.orm.MapTeamAccount;
import cn.com.iherpai.core.storage.mybatis.orm.Organize;
import cn.com.iherpai.core.storage.mybatis.orm.Team;
import cn.com.iherpai.core.vo.OrganizeVo;
import cn.com.iherpai.core.vo.TeamVo;

@Service
@Transactional
public class TeamServiceImpl implements TeamService {
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Autowired
	private TeamMapper teamMapper;
	
	@Autowired
	private OrganizeMapper organizeMapper;
	
	@Autowired
	private MapTeamAccountMapper mapTeamAccountMapper;

	@Override
	public Team add(TeamVo teamVo, String fields) throws DaoException {
		Team res = null;
		//team名是否存在
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		ArrayList<HashMap> __alphaCondi = Sql.newSqlExp();
		Sql.addCondi(__alphaCondi, "name", "e", teamVo.getName(), 1);
		Sql.addCondi(__alphaCondi, "type", "e", teamVo.getType(), 18);
		if ( teamVo.getOrganizeSid()!=null ) {
			Sql.addCondi(__alphaCondi, "organizeSid", "e", teamVo.getOrganizeSid(), 1);
		} 	
		__alpha.put("conditions", Sql.generate(__alphaCondi, null));
		int r1 = teamMapper.getCount(__alpha);		
		if( r1 == 0 ){
			int r2 = teamMapper.add(teamVo);
			if( r2 > 0) {
				if ( teamVo.getOrganizeSid()!=null ) {
					//更新所属组织的childCount
					HashMap<String, Object> __beta = Sql.newSqlBox();
					ArrayList<HashMap> __betaCondi = Sql.newSqlExp();
					Sql.addCondi(__betaCondi, "sid", "e", teamVo.getOrganizeSid(), 1);
					__beta.put("conditions", Sql.generate(__alphaCondi, null));
					int r3 = organizeMapper.update(__beta);
				} 
				//取得帐户、组织、团队
				HashMap<String, Object> __charlie = Sql.newSqlBox();
				ArrayList<HashMap> __charlieCondi = Sql.newSqlExp();
				HashMap<String, Object> __delta = Sql.newSqlBox();
				ArrayList<HashMap> __deltaCondi = Sql.newSqlExp();
				HashMap<String, Object> __echo = Sql.newSqlBox();
				ArrayList<HashMap> __echoCondi = Sql.newSqlExp();
				Sql.addCondi(__charlieCondi, "sid", "e", teamVo.getAccount_sid(), 1);
				__charlie.put("conditions", Sql.generate(__charlieCondi, null));
				Account r4 = accountMapper.get(__charlie);
				Sql.addCondi(__deltaCondi, "sid", "e", teamVo.getSid(), 1);
				__charlie.put("conditions", Sql.generate(__deltaCondi, null));
				Team r5 = teamMapper.get(__delta);
				Sql.addCondi(__echoCondi, "sid", "e", teamVo.getOrganizeSid(), 1);
				__charlie.put("conditions", Sql.generate(__echoCondi, null));
				Organize r6 = organizeMapper.get(__echo);
				if(r4!=null && r5!=null && r6!=null){
					try {
						MapTeamAccount mta = new MapTeamAccount();
						mta.setNid(1);
						mta.setSid(ID.newId(IhpConfig.SID_$ACCOUNT, IhpConfig.ID_DATA_DATABASE_CODE, IhpConfig.ID_DATA_TABLE_CODE));
						mta.setOrganizeId(r6.getId());
						mta.setOrganizeNid(r6.getNid());
						mta.setOrganizeSid(r6.getSid());
						mta.setTeamId(r5.getId());
						mta.setTeamNid(r5.getNid());
						mta.setTeamSid(r5.getSid());
						mta.setAccountId(r4.getId());
						mta.setAccountNid(r4.getNid());
						mta.setAccountSid(r4.getSid());
						mta.setNickname(r4.getUsername());
						mta.setType(1);
						mta.setGrade(1);
						mta.setScore(0L);
						mta.setRole(1);
						mta.setCreateTime(DateTime.getCurrentTimestamp());
						mta.setStatus(1);
						int r7 = mapTeamAccountMapper.add(mta);
						if( r7 > 0 ){
							res = teamVo;
						} 
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					throw new DaoException("团队保存失败！");
				}
			} else {
				throw new DaoException("团队保存失败！");
			}
		} else {
			throw new DaoException("团队名称已被占用！");
		}
		return res;
	}

	@Override
	public int remove(TeamVo teamVo) throws DaoException {
		int res = -1;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		__alpha.put("conditions", Sql.generate(teamVo.getMaz(), teamVo.getMazAddition()));
		res = teamMapper.remove(__alpha);
		if( res > 0 ) {
			// 查询尚存的同级团队数量
			HashMap<String, Object> __bravo = Sql.newSqlBox();
			ArrayList<HashMap> __bravoCondi = Sql.newSqlExp();
			Sql.addCondi(__bravoCondi, "organizeSid", "e", teamVo.getOrganizeSid(), 1);
			__bravo.put("conditions", Sql.generate(__bravoCondi, null));
			int r1 = teamMapper.getCount(__bravo);
			// 所属组织childCount更新
			HashMap<String, Object> __chork = Sql.newSqlBox();
			ArrayList<HashMap> __chorkCondi = Sql.newSqlExp();
			Sql.addCondi(__chorkCondi, "sid", "e", teamVo.getOrganizeSid(), 1);
			__chork.put("conditions", Sql.generate(__chorkCondi, null));
			if( r1 <= 0 ) {
				__chork.put("childCount", 0);
			}else{
				__chork.put("childCount", r1);
			}
			organizeMapper.update(__chork);
		}
		return res;
	}

	@Override
	public int update(TeamVo teamVo) throws DaoException {
		int res = -1;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		String sql = Sql.generate(teamVo.getMaz(), teamVo.getMazAddition());
		__alpha.put("conditions", sql);
		__alpha.put("code", teamVo.getCode());
		__alpha.put("name", teamVo.getName());
		__alpha.put("type", teamVo.getType());
		__alpha.put("icon", teamVo.getIcon());
		__alpha.put("intro", teamVo.getIntro());
		__alpha.put("grade", teamVo.getGrade());
		__alpha.put("gradeAccu", 1);
		__alpha.put("gradeDeeg", 1);
		__alpha.put("gradeTitle", teamVo.getGradeTitle());		
		__alpha.put("total", teamVo.getTotal());
		__alpha.put("totalAccu", 1);
		__alpha.put("totalDeeg", 1);
		__alpha.put("settingMessage", teamVo.getSettingMessage());
		__alpha.put("settingTop", teamVo.getSettingTop());
		__alpha.put("settingJoin", teamVo.getSettingJoin());
		__alpha.put("settingVisit", teamVo.getSettingVisit());
		__alpha.put("settingSpeak", teamVo.getSettingSpeak());
		__alpha.put("settingAlias", teamVo.getSettingAlias());
		__alpha.put("level", teamVo.getLevel());
		__alpha.put("levelAccu", 1);
		__alpha.put("levelDeeg", 1);
		__alpha.put("status", teamVo.getStatus());
		res = teamMapper.update(__alpha);
		return res;
	}

	@Override
	public Team get(TeamVo teamVo, String fields) throws DaoException {
		Team res = null;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		ArrayList<HashMap> __alphaCondi = Sql.newSqlExp();
		Sql.addCondi(__alphaCondi, "sid", "e", teamVo.getSid(), 1);
		__alpha.put("conditions", Sql.generate(__alphaCondi, null));
		__alpha.put("fields", EntityUtil.toUnderScoreName(fields));
		res = teamMapper.get(__alpha);
		return res;
	}

	@Override
	public HashMap<String, Object> list(TeamVo teamVo, String fields) throws DaoException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		ArrayList<Team> list = new ArrayList<Team>(0);
		res.put("pageSize", teamVo.getPageSize());
		res.put("pageNo", teamVo.getPageNo());
		res.put("totalAll", 0);
		res.put("totalPage", 0);
		// 查询符合条件的记录数量
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		HashMap<String, String> __alphaSqlMap = Sql.generateMap(teamVo.getMaz(), teamVo.getMazAddition());
		__alpha.put("conditions", __alphaSqlMap.get("conditions"));
		int r1 = teamMapper.getCount(__alpha);
		res.put("totalAll", r1);
		if(r1>0){
			//字段列表转下划线分隔
			HashMap<String, Object> __beta = Sql.newSqlBox();
			__beta.put("fields", EntityUtil.toUnderScoreName(fields));
			__beta.put("pageOff", teamVo.getPageNo()>1 ? (teamVo.getPageNo()-1) * teamVo.getPageSize(): 1);
			__beta.put("conditions", __alphaSqlMap.get("conditions"));
			__beta.put("orderBy", __alphaSqlMap.get("orderBy"));
			list = teamMapper.list(__beta);
			res.put("totalPage", (r1-teamVo.getPageSize())/teamVo.getPageSize() );
		}
		res.put("list", list );
		return res;
	}

	@Override
	public Organize add(OrganizeVo organizeVo, String fields) throws DaoException {
		Organize res = null;
		Organize r1 = null;
		boolean needCheckParent = false;
		if(organizeVo.getParentSid()!=null){
			needCheckParent = true;
			//校验指定parentSid是否存在
			HashMap<String, Object> __alpha = Sql.newSqlBox();
			ArrayList<HashMap> __alphaCondi = Sql.newSqlExp();
			Sql.newAddi(__alphaCondi, "sid", "e", organizeVo.getParentSid(), 1);
			__alpha.put("conditions", Sql.generate(__alphaCondi, null));
			__alpha.put("fields", EntityUtil.toUnderScoreName(DictGroup.fieldsAll));
			r1 = organizeMapper.get(__alpha);	
		}
		//检查parent是否可用、是否允许添加子节点，是否符合层级要求
		if (!needCheckParent || 
			(r1 != null 
			&& r1.getStatus().intValue() != DictGroup.STATUS_LOCKED_CHILD
			&& r1.getStatus().intValue() != DictGroup.STATUS_LOCKED_SUB
			&& r1.getStatus().intValue() != DictGroup.STATUS_LOCKED_LEAF
			&& r1.getChildCount() < Organize.CHILDCOUNT_MAX)
		  ) {
			if(r1!=null){
				organizeVo.setParentId( r1.getId() );
				organizeVo.setParentNid( r1.getNid() );
				organizeVo.setParentSid( r1.getSid() );
			}
			//校验指定parentSid中name/code是否冲突
			HashMap<String, Object> __beta = Sql.newSqlBox();
			ArrayList<HashMap> __betaCondi = Sql.newSqlExp();
			Sql.addCondi(__betaCondi, "name", "e", organizeVo.getCode(), 1);
			Sql.addCondi(__betaCondi, "code", "e", organizeVo.getCode(), -1);
			ArrayList<HashMap> __betaAddi = Sql.newSqlExp();
			if(r1!=null){
				Sql.newAddi(__betaAddi, "parentSid", "e", organizeVo.getParentSid(), 1);
			}else{
				Sql.newAddi(__betaAddi, "parentSid", "e", "##NULL##", 1);
			}
			__beta.put("conditions", Sql.generate(__betaCondi, __betaAddi));
			__beta.put("fields", EntityUtil.toUnderScoreName(fields));
			Organize r2 = organizeMapper.get(__beta);
			if (r2 != null) {
				throw new DaoException("组织数据冲突！");
			} else {				
				int result = organizeMapper.add(organizeVo);
				if (result > 0) {
					if( r1!=null ){
						//更新父节点 childCount
						HashMap<String, Object> __chork = new HashMap<String, Object>();
						ArrayList<HashMap> __chorkCondi = new ArrayList<HashMap>(0);
						Sql.addCondi(__chorkCondi, "sid", "e", r1.getSid(), 1);
						__chork.put("conditions", Sql.generate(__chorkCondi, null));
						__chork.put("childCountAccu", 1);
						organizeMapper.update(__chork);
					}
					res = organizeVo;					
				}
			}
		} else {
			throw new DaoException("上级组织已锁定，不可添加！");
		}
		return res;
	}

	@Override
	public int remove(OrganizeVo organizeVo) throws DaoException {
		int res = -1;		
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		__alpha.put("conditions", Sql.generate(organizeVo.getMaz(), organizeVo.getMazAddition()));
		res = organizeMapper.remove(__alpha);
		if( res > 0 ) {
			// 查询尚存的同级组织数量	
			HashMap<String, Object> __bravo = Sql.newSqlBox();
			ArrayList<HashMap> __bravoCondi = Sql.newSqlExp();
			Sql.addCondi(__bravoCondi, "parentSid", "e", organizeVo.getSid(), 1);
			__bravo.put("conditions", Sql.generate(__bravoCondi, null));
			int r1 = organizeMapper.getCount(__bravo);
			if( r1 <= 0 ) {
				// 上级字典组childCount减1
				HashMap<String, Object> __chork = Sql.newSqlBox();
				ArrayList<HashMap> __chorkCondi = Sql.newSqlExp();
				Sql.addCondi(__chorkCondi, "sid", "e", organizeVo.getParentSid(), 1);
				__chork.put("conditions", Sql.generate(__chorkCondi, null));		
				__chork.put("childCountDeeg", 1);
				organizeMapper.update(__chork);
			}
		} else {
			// 字典组不存在/其不为空/status不为0
		}
		return res;
	}

	@Override
	public int update(OrganizeVo organizeVo) throws DaoException {
		int res = -1;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		String sql = Sql.generate(organizeVo.getMaz(), organizeVo.getMazAddition());
		__alpha.put("conditions", sql);
		__alpha.put("isValid", organizeVo.getIsValid());
		__alpha.put("childCount", organizeVo.getChildCount());
		__alpha.put("childCountAccu", 1);
		__alpha.put("childCountDeeg", 1);
		__alpha.put("name", organizeVo.getCode());
		__alpha.put("code", organizeVo.getCode());
		__alpha.put("type", organizeVo.getType());
		__alpha.put("icon", organizeVo.getIcon());
		__alpha.put("intro", organizeVo.getIntro());
		__alpha.put("grade", organizeVo.getGrade());
		__alpha.put("gradeAddu", 1);
		__alpha.put("gradeDeeg", 1);
		__alpha.put("gradeTitle", organizeVo.getGradeTitle());
		__alpha.put("total", organizeVo.getTotal());
		__alpha.put("totalAccu", 1);
		__alpha.put("totalDeeg", 1);
		__alpha.put("settingMessage", organizeVo.getSettingMessage());
		__alpha.put("settingTop", organizeVo.getSettingTop());
		__alpha.put("settingJoin", organizeVo.getSettingJoin());
		__alpha.put("settingVisit", organizeVo.getSettingVisit());
		__alpha.put("settingSpeak", organizeVo.getSettingSpeak());		
		__alpha.put("level", organizeVo.getLevel());		
		__alpha.put("levelAccu", 1);		
		__alpha.put("levelDeeg", 1);
		__alpha.put("status", organizeVo.getStatus());
		/* memo[19-03-11:Sean]: 暂不支持组织在节点树上的移动（修改父节点）功能  */
//		__alpha.put("parentId", organizeVo.getParentId());
//		__alpha.put("parentNid", organizeVo.getParentNid());
//		__alpha.put("parentSid", organizeVo.getParentSid());
		res = organizeMapper.update(__alpha);
		return res;
	}

	@Override
	public Organize get(OrganizeVo organizeVo, String fields) throws DaoException {
		Organize res = null;
		//字段列表转下划线分隔
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		__alpha.put("fields", EntityUtil.toUnderScoreName(fields));
		__alpha.put("conditions", Sql.generate(organizeVo.getMaz(), organizeVo.getMazAddition()));
		res = organizeMapper.get(__alpha);
		return res;
	}

	@Override
	public HashMap<String, Object> list(OrganizeVo organizeVo, String fields) throws DaoException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		ArrayList<Organize> list = new ArrayList<Organize>(0);
		res.put("pageSize", organizeVo.getPageSize());
		res.put("pageNo", organizeVo.getPageNo());
		res.put("totalAll", 0);
		res.put("totalPage", 0);
		// 查询符合条件的记录数量
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		HashMap<String, String> __alphaSqlMap = Sql.generateMap(organizeVo.getMaz(), organizeVo.getMazAddition());
		__alpha.put("conditions", __alphaSqlMap.get("conditions"));
		int r1 = organizeMapper.getCount(__alpha);
		res.put("totalAll", r1);
		if(r1>0){
			//字段列表转下划线分隔
			HashMap<String, Object> __beta = Sql.newSqlBox();
			__beta.put("fields", EntityUtil.toUnderScoreName(fields));
			__beta.put("pageOff", organizeVo.getPageNo()>1 ? (organizeVo.getPageNo()-1) * organizeVo.getPageSize(): 1);
			__beta.put("conditions", __alphaSqlMap.get("conditions"));
			__beta.put("orderBy", __alphaSqlMap.get("orderBy"));
			list = organizeMapper.list(__beta);
			res.put("totalPage", (r1-organizeVo.getPageSize())/organizeVo.getPageSize() );
		}
		res.put("list", list );
		return res;
	}

}
