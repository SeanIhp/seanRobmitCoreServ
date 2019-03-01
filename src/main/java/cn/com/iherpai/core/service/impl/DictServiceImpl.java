package cn.com.iherpai.core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.iherpai.common.utils.SqlHelper;
import cn.com.iherpai.core.service.DictService;
import cn.com.iherpai.core.storage.mybatis.exception.DaoException;
import cn.com.iherpai.core.storage.mybatis.mapper.DictGroupMapper;
import cn.com.iherpai.core.storage.mybatis.mapper.DictMapper;
import cn.com.iherpai.core.storage.mybatis.orm.Dict;
import cn.com.iherpai.core.storage.mybatis.orm.DictGroup;
import cn.com.iherpai.core.vo.DictGroupVo;
import cn.com.iherpai.core.vo.DictVo;
import cn.com.iherpai.core.vo.ValueObject;

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
		//字段列表转下划线分隔
		String the_fields = ValueObject.dictOrmKeys(fields);
		//校验指定parentSid是否存在
		Map<String, Object> p1 = new HashMap<String, Object>();
		p1.put("fields", "*");
		p1.put("sid", dictVo.getDictGroupSid());		
		DictGroup r1 = dictGroupMapper.get(p1);	
		//检查所属字典组是否可用、是否允许添加子节点
		if (r1 != null 
			&& r1.getStatus() != DictGroup.STATUS_DISABLED
			&& r1.getStatus().intValue() != DictGroup.STATUS_LOCKED_CHILD
			&& r1.getStatus().intValue() != DictGroup.STATUS_LOCKED_LEAF
		  ) {
			Map<String, Object> p2 = new HashMap<String, Object>();
			p2.put("fields", the_fields);
			p2.put("dictGroupSid", r1.getSid());
			p2.put("code", dictVo.getCode());
			p2.put("sortno", dictVo.getSortno());
			Dict r2 = dictMapper.get(p2);
			if (r2 != null) {
				throw new DaoException("字典数据冲突！");
			} else {
				Map<String, Object> p3 = new HashMap<String, Object>();
				p3.put("dictGroupSid", r1.getSid());
				int r3 = dictMapper.getCount(p3);
				dictVo.setSortno(r3 + 1);
				int result = dictMapper.add(dictVo);
				if (result > 0) {
					if(!r1.getHasChild()){
						//更新父节点hasChild为true
						Map<String, Object> p4 = new HashMap<String, Object>();
						p4.put("hasChild", true);
						p4.put("sid", r1.getSid());
						dictGroupMapper.update(p4);
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
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sid", dictVo.getSid());
		params.put("hasChild", false);
		res = dictMapper.remove(params);
		if( res > 0 ) {
			String fields = "sid";
			String the_fields = ValueObject.dictOrmKeys(fields);
			// 查询尚存的同级字典组数量
			Map<String, Object> p1 = new HashMap<String, Object>();
			p1.put("fields", the_fields);
			p1.put("dictGroupSid", dictVo.getDictGroupSid());
			int r1 = dictMapper.getCount(p1);
			if( r1 <= 0 ) {
				// 上级字典组hasChild改为false
				Map<String, Object> p2 = new HashMap<String, Object>();
				p2.put("hasChild", false);
				p2.put("dictGroupSid", dictVo.getDictGroupSid());
				dictGroupMapper.update(p2);
			}
		}
		return res;
	}

	@Override
	public int update(DictVo dictVo) throws DaoException {
		int res = -1;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("_code", dictVo.getCode());
		params.put("_name", dictVo.getCode());
		params.put("_constCode", dictVo.getConstCode());
		params.put("_constType", dictVo.getConstType());
		params.put("_constValue", dictVo.getConstValue());
		params.put("_constText", dictVo.getConstText());
		params.put("_sortno", dictVo.getSortno());		
		params.put("_description", dictVo.getDescription());
		params.put("_status", dictVo.getStatus());
		/* memo[19-02-25:Sean]: 暂不支持字黄在节点树上的移动（修改所属字典组）功能  */
//		params.put("_dictGroupId", dictVo.getParentId());
//		params.put("_dictGroupNid", dictVo.getParentNid());
//		params.put("_dictGroupSid", dictVo.getParentSid());

		params.put("id", dictVo.getId());
		params.put("nid", dictVo.getNid());
		params.put("sid", dictVo.getSid());
		params.put("code", dictVo.getCode());
		params.put("name", dictVo.getCode());
		params.put("constCode", dictVo.getConstCode());
		params.put("constType", dictVo.getConstType());
		params.put("constValue", dictVo.getConstValue());
		params.put("constText", dictVo.getConstText());
		params.put("sortno", dictVo.getSortno());
		params.put("sortnoMin", dictVo.getSortnoMin());
		params.put("sortnoMax", dictVo.getSortnoMax());
		params.put("description", dictVo.getDescription());
		params.put("status", dictVo.getStatus());
		params.put("statusMin", dictVo.getStatusMin());
		params.put("statusMax", dictVo.getStatusMax());
		res = dictGroupMapper.update(params);
		return res;
	}

	@Override
	public Dict get(DictVo dictVo, String fields) throws DaoException {
		Dict res = null;
		//字段列表转下划线分隔
		String the_fields = ValueObject.dictGroupOrmKeys(fields);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fields", the_fields);
		params.put("sid", dictVo.getSid());
		res = dictMapper.get(params);
		return res;
	}

	@Override
	public HashMap<String, Object> list(DictVo dictVo, String fields) throws DaoException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		ArrayList<DictGroup> list = new ArrayList<DictGroup>(0);
		res.put("totalAll", 0);
		res.put("totalPage", 0);
		res.put("pageSize", dictVo.getPageSize());
		res.put("pageNo", dictVo.getPageNo());
		// 查询符合条件的记录数量
		Map<String, Object> p1 = new HashMap<String, Object>();
		p1.put("id", dictVo.getId());
		p1.put("nid", dictVo.getNid());
		p1.put("sid", dictVo.getSid());
		p1.put("code", dictVo.getCode());
		p1.put("name", dictVo.getName());
		p1.put("dictGroupId", dictVo.getDictGroupId());
		p1.put("dictGroupNid", dictVo.getDictGroupNid());
		p1.put("dictGroupSid", dictVo.getDictGroupSid());
		p1.put("constCode", dictVo.getConstCode());
		p1.put("constType", dictVo.getConstType());
		p1.put("constValue", dictVo.getConstValue());
		p1.put("constText", dictVo.getConstText());
		p1.put("sortno", dictVo.getSortno());
		p1.put("sortnoMin", dictVo.getSortnoMin());
		p1.put("sortnoMax", dictVo.getSortnoMax());
		p1.put("description", dictVo.getDescription());
		p1.put("status", dictVo.getStatus());
		p1.put("statusMin", dictVo.getStatusMin());
		p1.put("statusMax", dictVo.getStatusMax());
		int r1 = dictGroupMapper.getCount(p1);
		res.put("totalAll", r1);
		if(r1>0){
			//字段列表转下划线分隔
			String the_fields = ValueObject.dictGroupOrmKeys(fields);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("fields", the_fields);
			params.put("id", dictVo.getId());
			params.put("nid", dictVo.getNid());
			params.put("sid", dictVo.getSid());
			params.put("code", dictVo.getCode());
			params.put("name", dictVo.getName());
			params.put("dictGroupId", dictVo.getDictGroupId());
			params.put("dictGroupNid", dictVo.getDictGroupNid());
			params.put("dictGroupSid", dictVo.getDictGroupSid());
			params.put("constCode", dictVo.getConstCode());
			params.put("constType", dictVo.getConstType());
			params.put("constValue", dictVo.getConstValue());
			params.put("constText", dictVo.getConstText());
			params.put("sortno", dictVo.getSortno());
			params.put("sortnoMin", dictVo.getSortnoMin());
			params.put("sortnoMax", dictVo.getSortnoMax());
			params.put("description", dictVo.getDescription());
			params.put("status", dictVo.getStatus());
			params.put("statusMin", dictVo.getStatusMin());
			params.put("statusMax", dictVo.getStatusMax());
			params.put("pageSize", dictVo.getPageSize());
			params.put("pageOff", (dictVo.getPageNo() - 1) * dictVo.getPageSize());
			list = dictGroupMapper.list(params);
			res.put("totalPage", (r1-dictVo.getPageSize())/dictVo.getPageSize() );
		}
		res.put("list", list );
		return res;
	}

	@Override
	public DictGroup add(DictGroupVo dictGroupVo, String fields) throws DaoException {
		DictGroup res = null;
		//字段列表转下划线分隔
		String the_fields = ValueObject.dictGroupOrmKeys(fields);
		//校验指定parentSid是否存在
		Map<String, Object> p1 = new HashMap<String, Object>();
		p1.put("fields", the_fields);
		p1.put("sid", dictGroupVo.getParentSid());		
		DictGroup r1 = dictGroupMapper.get(p1);	
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
			Map<String, Object> p2 = new HashMap<String, Object>();
			p2.put("fields", the_fields);
			p2.put("parentSid", r1.getSid());
			p2.put("code", dictGroupVo.getCode());
			p2.put("sortno", dictGroupVo.getSortno());
			DictGroup r2 = dictGroupMapper.get(p2);
			if (r2 != null) {
				throw new DaoException("字典组数据冲突！");
			} else {
				Map<String, Object> p3 = new HashMap<String, Object>();
				p3.put("parentSid", r1.getSid());
				int r3 = dictGroupMapper.getCount(p3);
				dictGroupVo.setSortno(r3 + 1);
				int result = dictGroupMapper.add(dictGroupVo);
				if (result > 0) {
					if(!r1.getHasChild()){
						//更新父节点hasChild为true
						Map<String, Object> p4 = new HashMap<String, Object>();
						p4.put("_hasChild", true);
						p4.put("sid", r1.getSid());
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
		ArrayList<HashMap> maz = dictGroupVo.getMaz();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("conditions", SqlHelper.generate(dictGroupVo.getMaz()));
		
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("sid", dictGroupVo.getSid());
//		params.put("hasChild", false);
		res = dictGroupMapper.remove(params);
		if( res > 0 ) {
			String fields = "sid";
			String the_fields = ValueObject.dictGroupOrmKeys(fields);
			// 查询尚存的同级字典组数量
			Map<String, Object> p1 = new HashMap<String, Object>();
			p1.put("fields", the_fields);
			p1.put("paraentSid", dictGroupVo.getSid());
			int r1 = dictGroupMapper.getCount(p1);
			if( r1 <= 0 ) {
				// 上级字典组hasChild改为false
				Map<String, Object> p2 = new HashMap<String, Object>();
				p2.put("hasChild", false);
				p2.put("sid", dictGroupVo.getParentSid());
				dictGroupMapper.update(p2);
			}
		} else {
			// 字典组不存在/其不为空/status不为0
		}
		return res;
	}

	@Override
	public int update(DictGroupVo dictGroupVo) throws DaoException {
		int res = -1;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("_code", dictGroupVo.getCode());
		params.put("_name", dictGroupVo.getCode());
		params.put("_scode", dictGroupVo.getScode());
		params.put("_sname", dictGroupVo.getSname());
		params.put("_type", dictGroupVo.getType());
		params.put("_hasChild", dictGroupVo.getHasChild());
		params.put("_level", dictGroupVo.getLevel());
		params.put("_sortno", dictGroupVo.getSortno());		
		params.put("_description", dictGroupVo.getDescription());
		params.put("_status", dictGroupVo.getStatus());
		/* memo[19-02-23:Sean]: 暂不支持字黄组在节点树上的移动（修改父节点）功能  */
//		params.put("_parentId", dictGroupVo.getParentId());
//		params.put("_parentNid", dictGroupVo.getParentNid());
//		params.put("_parentSid", dictGroupVo.getParentSid());

		params.put("id", dictGroupVo.getId());
		params.put("nid", dictGroupVo.getNid());
		params.put("sid", dictGroupVo.getSid());
		params.put("code", dictGroupVo.getCode());
		params.put("name", dictGroupVo.getCode());
		params.put("scode", dictGroupVo.getScode());
		params.put("sname", dictGroupVo.getSname());
		params.put("type", dictGroupVo.getType());
		params.put("hasChild", dictGroupVo.getHasChild());
		params.put("level", dictGroupVo.getLevel());
//		params.put("levelMin", dictGroupVo.getLevelMin());
//		params.put("levelMax", dictGroupVo.getLevelMax());
		params.put("sortno", dictGroupVo.getSortno());
//		params.put("sortnoMin", dictGroupVo.getSortnoMin());
//		params.put("sortnoMax", dictGroupVo.getSortnoMax());
		params.put("parentId", dictGroupVo.getParentId());
		params.put("parentNid", dictGroupVo.getParentNid());
		params.put("parentSid", dictGroupVo.getParentSid());
		params.put("description", dictGroupVo.getDescription());
		params.put("status", dictGroupVo.getStatus());
//		params.put("statusMin", dictGroupVo.getStatusMin());
//		params.put("statusMax", dictGroupVo.getStatusMax());
		res = dictGroupMapper.update(params);
		return res;
	}

	@Override
	public DictGroup get(DictGroupVo dictGroupVo, String fields) throws DaoException {
		DictGroup res = null;
		//字段列表转下划线分隔
		String the_fields = ValueObject.dictGroupOrmKeys(fields);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fields", the_fields);
		params.put("sid", dictGroupVo.getSid());
		res = dictGroupMapper.get(params);
		return res;
	}

	@Override
	public HashMap<String, Object> list(DictGroupVo dictGroupVo, String fields) throws DaoException {
		HashMap<String, Object> res = new HashMap<String, Object>();
		ArrayList<DictGroup> list = new ArrayList<DictGroup>(0);
		res.put("totalAll", 0);
		res.put("totalPage", 0);
		res.put("pageSize", dictGroupVo.getPageSize());
		res.put("pageNo", dictGroupVo.getPageNo());
		// 查询符合条件的记录数量
		Map<String, Object> p1 = new HashMap<String, Object>();
		p1.put("id", dictGroupVo.getId());
		p1.put("nid", dictGroupVo.getNid());
		p1.put("sid", dictGroupVo.getSid());
		p1.put("code", dictGroupVo.getCode());
		p1.put("name", dictGroupVo.getName());
		p1.put("scode", dictGroupVo.getScode());
		p1.put("sname", dictGroupVo.getSname());
		p1.put("type", dictGroupVo.getType());
		p1.put("hasChild", dictGroupVo.getHasChild());
		p1.put("level", dictGroupVo.getLevel());
//		p1.put("levelMin", dictGroupVo.getLevelMin());
//		p1.put("levelMax", dictGroupVo.getLevelMax());
		p1.put("sortno", dictGroupVo.getSortno());
//		p1.put("sortnoMin", dictGroupVo.getSortnoMin());
//		p1.put("sortnoMax", dictGroupVo.getSortnoMax());
		p1.put("parentId", dictGroupVo.getParentId());
		p1.put("parentNid", dictGroupVo.getParentNid());
		p1.put("parentSid", dictGroupVo.getParentSid());
		p1.put("description", dictGroupVo.getDescription());
		p1.put("status", dictGroupVo.getStatus());
//		p1.put("statusMin", dictGroupVo.getStatusMin());
//		p1.put("statusMax", dictGroupVo.getStatusMax());
		int r1 = dictGroupMapper.getCount(p1);
		res.put("totalAll", r1);
		if(r1>0){
			//字段列表转下划线分隔
			String the_fields = ValueObject.dictGroupOrmKeys(fields);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("fields", the_fields);
			params.put("id", dictGroupVo.getId());
			params.put("nid", dictGroupVo.getNid());
			params.put("sid", dictGroupVo.getSid());
			params.put("code", dictGroupVo.getCode());
			params.put("name", dictGroupVo.getName());
			params.put("scode", dictGroupVo.getScode());
			params.put("sname", dictGroupVo.getSname());
			params.put("type", dictGroupVo.getType());
			params.put("hasChild", dictGroupVo.getHasChild());
			params.put("level", dictGroupVo.getLevel());
//			params.put("levelMin", dictGroupVo.getLevelMin());
//			params.put("levelMax", dictGroupVo.getLevelMax());
			params.put("sortno", dictGroupVo.getSortno());
//			params.put("sortnoMin", dictGroupVo.getSortnoMin());
//			params.put("sortnoMax", dictGroupVo.getSortnoMax());
			params.put("parentId", dictGroupVo.getParentId());
			params.put("parentNid", dictGroupVo.getParentNid());
			params.put("parentSid", dictGroupVo.getParentSid());
			params.put("description", dictGroupVo.getDescription());
			params.put("status", dictGroupVo.getStatus());
//			params.put("statusMin", dictGroupVo.getStatusMin());
//			params.put("statusMax", dictGroupVo.getStatusMax());
			params.put("pageSize", dictGroupVo.getPageSize());
			params.put("pageOff", (dictGroupVo.getPageNo() - 1) * dictGroupVo.getPageSize());
			list = dictGroupMapper.list(params);
			res.put("totalPage", (r1-dictGroupVo.getPageSize())/dictGroupVo.getPageSize() );
		}
		res.put("list", list );
		return res;
	}

}
