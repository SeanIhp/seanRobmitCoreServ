package cn.com.iherpai.core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.common.utils.EntityUtil;
import cn.com.iherpai.common.utils.Sql;
import cn.com.iherpai.core.service.DictService;
import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.mapper.DictGroupMapper;
import cn.com.iherpai.core.storage.mybatis.mapper.DictMapper;
import cn.com.iherpai.core.storage.mybatis.orm.Dict;
import cn.com.iherpai.core.storage.mybatis.orm.DictGroup;
import cn.com.iherpai.core.vo.DictGroupVo;
import cn.com.iherpai.core.vo.DictVo;

@Service
@Transactional
public class DictServiceImpl implements DictService {
	
	@Autowired
	private DictMapper dictMapper;
	@Autowired
	private DictGroupMapper dictGroupMapper;

	@Override
	public Dict add(DictVo dictVo, String fields) throws DaoException {
		Dict res = null;
		//校验指定parentSid是否存在	
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		ArrayList<HashMap> __alphaCondi = Sql.newSqlExp();
		Sql.addCondi(__alphaCondi, "sid", "e", dictVo.getDictGroupSid(), 1);
		__alpha.put("conditions", Sql.generate(__alphaCondi, null));
		__alpha.put("fields", EntityUtil.toUnderScoreName(DictGroup.fieldsAll));		
		DictGroup r1 = dictGroupMapper.get(__alpha);	
		//检查所属字典组是否可用、是否允许添加子节点
		if (r1 != null 
			&& r1.getStatus() != DictGroup.STATUS_DISABLED
			&& r1.getStatus().intValue() != DictGroup.STATUS_LOCKED_CHILD
			&& r1.getStatus().intValue() != DictGroup.STATUS_LOCKED_LEAF
		  ) {
			HashMap<String, Object> __bravo = Sql.newSqlBox();
			ArrayList<HashMap> __bravoCondi = new ArrayList<HashMap>(0);
			Sql.addCondi(__bravoCondi, "dictGroupSid", "e", r1.getSid(), 1);
			Sql.addCondi(__bravoCondi, "code", "e", dictVo.getCode(), 1);
			Sql.addCondi(__bravoCondi, "sortno", "e", dictVo.getSortno(), 18);
			__bravo.put("conditions", Sql.generate(__bravoCondi, null));
			__bravo.put("fields", EntityUtil.toUnderScoreName(fields));
			Dict r2 = dictMapper.get(__bravo);
			if (r2 != null) {
				throw new DaoException("字典数据冲突！");
			} else {	
				HashMap<String, Object> __chork = Sql.newSqlBox();
				ArrayList<HashMap> __chorkCondi = Sql.newSqlExp();
				Sql.addCondi(__chorkCondi, "dictGroupSid", "e", r1.getSid(), 1);			
				__chork.put("conditions", Sql.generate(__chorkCondi, null));
				int r3 = dictMapper.getMaxSortno(__chork);
				dictVo.setSortno(r3 + 1);
				int result = dictMapper.add(dictVo);
				if (result > 0) {
					if(!r1.getHasChild()){
						//更新父节点hasChild为true
						HashMap<String, Object> __delta = Sql.newSqlBox();
						ArrayList<HashMap> __deltaCondi = new ArrayList<HashMap>(0);
						Sql.addCondi(__deltaCondi, "sid", "e", r1.getSid(), 1);
						__delta.put("conditions", Sql.generate(__deltaCondi, null));
						__delta.put("hasChild", true);
						dictGroupMapper.update(__delta);
					}
					res = dictVo;					
				}
			}
		} else {
			throw new DaoException("字典组已锁定，不可添加！");
		}
		return res;
	}

	@Override
	public int remove(DictVo dictVo) throws DaoException {
		int res = -1;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		__alpha.put("conditions", Sql.generate(dictVo.getMaz(), dictVo.getMazAddition()));
		res = dictMapper.remove(__alpha);
		if( res > 0 ) {
			// 查询尚存的同级字典组数量
			HashMap<String, Object> __bravo = Sql.newSqlBox();
			ArrayList<HashMap> __bravoCondi = Sql.newSqlExp();
			Sql.addCondi(__bravoCondi, "dictGroupSid", "e", dictVo.getDictGroupSid(), 1);
			__bravo.put("conditions", Sql.generate(__bravoCondi, null));
			int r1 = dictMapper.getCount(__bravo);
			if( r1 <= 0 ) {
				// 上级字典组hasChild改为false
				HashMap<String, Object> __chork = Sql.newSqlBox();
				ArrayList<HashMap> __chorkCondi = Sql.newSqlExp();
				Sql.addCondi(__chorkCondi, "sid", "e", dictVo.getDictGroupSid(), 1);
				__chork.put("conditions", Sql.generate(__chorkCondi, null));
				__chork.put("hasChild", false);
				dictGroupMapper.update(__chork);
			}
		}
		return res;
	}

	@Override
	public int update(DictVo dictVo) throws DaoException {
		int res = -1;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		String sql = Sql.generate(dictVo.getMaz(), dictVo.getMazAddition());
		__alpha.put("conditions", sql);
		__alpha.put("code", dictVo.getCode());
		__alpha.put("name", dictVo.getName());
		__alpha.put("constCode", dictVo.getConstCode());
		__alpha.put("constType", dictVo.getConstType());
		__alpha.put("constValue", dictVo.getConstValue());
		__alpha.put("constText", dictVo.getConstText());
		__alpha.put("sortno", dictVo.getSortno());		
		__alpha.put("description", dictVo.getDescription());
		__alpha.put("status", dictVo.getStatus());
		/* memo[19-02-25:Sean]: 暂不支持字黄在节点树上的移动（修改所属字典组）功能  */
//		__alpha.put("_dictGroupId", dictVo.getParentId());
//		__alpha.put("_dictGroupNid", dictVo.getParentNid());
//		__alpha.put("_dictGroupSid", dictVo.getParentSid());
		res = dictMapper.update(__alpha);
		return res;
	}

	@Override
	public Dict get(DictVo dictVo, String fields) throws DaoException {
		Dict res = null;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		ArrayList<HashMap> __alphaCondi = Sql.newSqlExp();
		Sql.addCondi(__alphaCondi, "sid", "e", dictVo.getSid(), 1);
		__alpha.put("conditions", Sql.generate(__alphaCondi, null));
		__alpha.put("fields", EntityUtil.toUnderScoreName(fields));
		res = dictMapper.get(__alpha);
		return res;
	}

	@Override
	public HashMap<String, Object> list(DictVo dictVo, String fields) throws DaoException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		ArrayList<Dict> list = new ArrayList<Dict>(0);
		res.put("pageSize", dictVo.getPageSize());
		res.put("pageNo", dictVo.getPageNo());
		res.put("totalAll", 0);
		res.put("totalPage", 0);
		// 查询符合条件的记录数量
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		HashMap<String, String> __alphaSqlMap = Sql.generateMap(dictVo.getMaz(), dictVo.getMazAddition());
		__alpha.put("conditions", __alphaSqlMap.get("conditions"));
		int r1 = dictMapper.getCount(__alpha);
		res.put("totalAll", r1);
		if(r1>0){
			//字段列表转下划线分隔
			HashMap<String, Object> __beta = Sql.newSqlBox();
			__beta.put("fields", EntityUtil.toUnderScoreName(fields));
			__beta.put("pageOff", dictVo.getPageNo()>1 ? (dictVo.getPageNo()-1) * dictVo.getPageSize(): 1);
			__beta.put("conditions", __alphaSqlMap.get("conditions"));
			__beta.put("orderBy", __alphaSqlMap.get("orderBy"));
			list = dictMapper.list(__beta);
			res.put("totalPage", (r1-dictVo.getPageSize())/dictVo.getPageSize() );
		}
		res.put("list", list );
		return res;
	}

	@Override
	public DictGroup add(DictGroupVo dictGroupVo, String fields) throws DaoException {
		DictGroup res = null;
		//校验指定parentSid是否存在
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		ArrayList<HashMap> __alphaCondi = Sql.newSqlExp();
		Sql.newAddi(__alphaCondi, "sid", "e", dictGroupVo.getParentSid(), 1);
		__alpha.put("conditions", Sql.generate(__alphaCondi, null));
		__alpha.put("fields", EntityUtil.toUnderScoreName(DictGroup.fieldsAll));
		DictGroup r1 = dictGroupMapper.get(__alpha);	
		//检查parent是否可用、是否允许添加子节点，是否符合层级要求
		if (r1 != null 
			&& r1.getStatus().intValue() != DictGroup.STATUS_LOCKED_CHILD
			&& r1.getStatus().intValue() != DictGroup.STATUS_LOCKED_SUB
			&& r1.getStatus().intValue() != DictGroup.STATUS_LOCKED_LEAF
			&& r1.getLevel().intValue() < DictGroup.LEVEL_MAX
		  ) {
			dictGroupVo.setLevel( r1.getLevel()+1 );
			dictGroupVo.setParentId( r1.getId() );
			dictGroupVo.setParentNid( r1.getNid() );
			//校验指定parentSid中code/sortno是否冲突
			HashMap<String, Object> __beta = Sql.newSqlBox();
			ArrayList<HashMap> __betaCondi = Sql.newSqlExp();
			Sql.addCondi(__betaCondi, "parentSid", "e", r1.getSid(), 1);
			Sql.addCondi(__betaCondi, "code", "e", r1.getCode(), 1);
			Sql.addCondi(__betaCondi, "sortno", "e", r1.getSortno(), 18);
			__beta.put("conditions", Sql.generate(__betaCondi, null));
			__beta.put("fields", EntityUtil.toUnderScoreName(fields));
			DictGroup r2 = dictGroupMapper.get(__beta);
			if (r2 != null) {
				throw new DaoException("字典组数据冲突！");
			} else {
				ArrayList<HashMap> c3 = new ArrayList<HashMap>(0);
				Sql.addCondi(c3, "parentSid", "e", r1.getSid(), 1);
				HashMap<String, Object> p3 = new HashMap<String, Object>();
				p3.put("conditions", Sql.generate(c3, null));
				int r3 = dictGroupMapper.getMaxSortno(p3);
				dictGroupVo.setSortno(r3 + 1);
				int result = dictGroupMapper.add(dictGroupVo);
				if (result > 0) {
					if(!r1.getHasChild()){
						//更新父节点hasChild为true
						ArrayList<HashMap> c4 = new ArrayList<HashMap>(0);
						Sql.addCondi(c4, "sid", "e", r1.getSid(), 1);
						HashMap<String, Object> p4 = new HashMap<String, Object>();
						p4.put("conditions", Sql.generate(c4, null));
						p4.put("hasChild", true);
						dictGroupMapper.update(p4);
					}
					res = dictGroupVo;					
				}
			}
		} else {
			throw new DaoException("上级字典组已锁定，不可添加！");
		}
		return res;
	}

	@Override
	public int remove(DictGroupVo dictGroupVo) throws DaoException {
		int res = -1;		
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		__alpha.put("conditions", Sql.generate(dictGroupVo.getMaz(), dictGroupVo.getMazAddition()));
		res = dictGroupMapper.remove(__alpha);
		if( res > 0 ) {
			// 查询尚存的同级字典组数量	
			HashMap<String, Object> __bravo = Sql.newSqlBox();
			ArrayList<HashMap> __bravoCondi = Sql.newSqlExp();
			Sql.addCondi(__bravoCondi, "parentSid", "e", dictGroupVo.getSid(), 1);
			__bravo.put("conditions", Sql.generate(__bravoCondi, null));
			int r1 = dictGroupMapper.getCount(__bravo);
			if( r1 <= 0 ) {
				// 上级字典组hasChild改为false
				HashMap<String, Object> __chork = Sql.newSqlBox();
				ArrayList<HashMap> __chorkCondi = Sql.newSqlExp();
				Sql.addCondi(__chorkCondi, "sid", "e", dictGroupVo.getParentSid(), 1);
				__chork.put("conditions", Sql.generate(__chorkCondi, null));		
				__chork.put("hasChild", false);		
				dictGroupMapper.update(__chork);
			}
		} else {
			// 字典组不存在/其不为空/status不为0
		}
		return res;
	}

	@Override
	public int update(DictGroupVo dictGroupVo) throws DaoException {
		int res = -1;
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		String sql = Sql.generate(dictGroupVo.getMaz(), dictGroupVo.getMazAddition());
		__alpha.put("conditions", sql);
		__alpha.put("code", dictGroupVo.getCode());
		__alpha.put("name", dictGroupVo.getCode());
		__alpha.put("scode", dictGroupVo.getScode());
		__alpha.put("sname", dictGroupVo.getSname());
		__alpha.put("type", dictGroupVo.getType());
		__alpha.put("hasChild", dictGroupVo.getHasChild());
		__alpha.put("level", dictGroupVo.getLevel());
		__alpha.put("sortno", dictGroupVo.getSortno());		
		__alpha.put("description", dictGroupVo.getDescription());
		__alpha.put("status", dictGroupVo.getStatus());
		/* memo[19-02-23:Sean]: 暂不支持字黄组在节点树上的移动（修改父节点）功能  */
//		__alpha.put("parentId", dictGroupVo.getParentId());
//		__alpha.put("parentNid", dictGroupVo.getParentNid());
//		__alpha.put("parentSid", dictGroupVo.getParentSid());
		res = dictGroupMapper.update(__alpha);
		return res;
	}

	@Override
	public DictGroup get(DictGroupVo dictGroupVo, String fields) throws DaoException {
		DictGroup res = null;
		//字段列表转下划线分隔
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		__alpha.put("fields", EntityUtil.toUnderScoreName(fields));
		__alpha.put("conditions", Sql.generate(dictGroupVo.getMaz(), dictGroupVo.getMazAddition()));
		res = dictGroupMapper.get(__alpha);
		return res;
	}

	@Override
	public HashMap<String, Object> list(DictGroupVo dictGroupVo, String fields) throws DaoException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		ArrayList<DictGroup> list = new ArrayList<DictGroup>(0);
		res.put("pageSize", dictGroupVo.getPageSize());
		res.put("pageNo", dictGroupVo.getPageNo());
		res.put("totalAll", 0);
		res.put("totalPage", 0);
		// 查询符合条件的记录数量
		HashMap<String, Object> __alpha = Sql.newSqlBox();
		HashMap<String, String> __alphaSqlMap = Sql.generateMap(dictGroupVo.getMaz(), dictGroupVo.getMazAddition());
		__alpha.put("conditions", __alphaSqlMap.get("conditions"));
		int r1 = dictGroupMapper.getCount(__alpha);
		res.put("totalAll", r1);
		if(r1>0){
			//字段列表转下划线分隔
			HashMap<String, Object> __beta = Sql.newSqlBox();
			__beta.put("fields", EntityUtil.toUnderScoreName(fields));
			__beta.put("pageOff", dictGroupVo.getPageNo()>1 ? (dictGroupVo.getPageNo()-1) * dictGroupVo.getPageSize(): 1);
			__beta.put("conditions", __alphaSqlMap.get("conditions"));
			__beta.put("orderBy", __alphaSqlMap.get("orderBy"));
			list = dictGroupMapper.list(__beta);
			res.put("totalPage", (r1-dictGroupVo.getPageSize())/dictGroupVo.getPageSize() );
		}
		res.put("list", list );
		return res;
	}

}
