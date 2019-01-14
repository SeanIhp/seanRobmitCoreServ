package cn.com.iherpai.core.storage.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.com.iherpai.core.storage.mybatis.exception.DaoException;

public class MtsBaseDao {
	public static final String ACCOUNT					= "com.iherpai.ihp.storage.mybatis.orm.user.Account";
	public static final String FANS						= "com.iherpai.ihp.storage.mybatis.orm.user.Fans";
	public static final String FOLLOW					= "com.iherpai.ihp.storage.mybatis.orm.user.Follow";
	
	public static final String GROUP						= "com.iherpai.ihp.storage.mybatis.orm.group.Group";
	public static final String GROUPMEMBER				= "com.iherpai.ihp.storage.mybatis.orm.group.GroupMember";
	public static final String GROUPMEMBERRECORD		= "com.iherpai.ihp.storage.mybatis.orm.group.GroupMemberRecord";
	public static final String TOPIC						= "com.iherpai.ihp.storage.mybatis.orm.group.Topic";
	public static final String REPLY						= "com.iherpai.ihp.storage.mybatis.orm.group.Reply";
	
	
	protected static Logger log = Logger.getLogger(MtsBaseDao.class.getName());
	protected SqlSession session = null;
	
	public MtsBaseDao(SqlSession session){
		this.session = session;
	}
	
	protected SqlSession getSession(){
		return this.session;
	}
	
	/*
	protected SqlSession getSession(){
		return SessionFactory.getSession();
	}
	
	protected void closeSession(){
		SessionFactory.closeSession();
	}
	*/
	
	
	
	/*
	 * 
	 */
	public int save(String alias, String mappingId, Object theOne) throws DaoException{
		int res = 0;
		try {
			res = session.insert(alias+"."+mappingId, theOne);
		} catch (Exception e) {
			log.debug(e);
			throw new DaoException();
		}
		return res;
	}	
	
	
	
	/*
	 * 
	 */
	public int remove(String alias, String mappingId, Map args) throws DaoException{
		int res = 0;
		try {
			res = session.delete(alias+"."+mappingId, args);
		} catch (Exception e) {
			log.debug(e);
			throw new DaoException();
		}
		return res;
	}
	
	
	
	/*
	 * 
	 */
	public int update(String alias, String mappingId, Map args) throws DaoException{
		int res = 0;
		try {
			res = session.update(alias+"."+mappingId, args);
		} catch (Exception e) {
			log.debug(e);
			throw new DaoException();
		}
		return res;
	}
	
	
	
	/*
	 * 
	 */
	public long count(String alias, String mappingId, Map args) throws DaoException{
		long res = 0L;
		try {
			Map result = session.selectOne(alias+"."+mappingId, args);
			res = (Long)result.get("theCount");
		} catch (Exception e) {
			log.debug(e);
			throw new DaoException();
		}
		return res;
	}
	
	
	
	/*
	 * 
	 */
	public Map get(String alias, String mappingId, Map args) throws DaoException{
		Map res = null;
		try {
			res = session.selectOne(alias+"."+mappingId, args);
		} catch (Exception e) {
			log.debug(e);
			throw new DaoException();
		}
		return res;
	}
	
	
	
	/*
	 * 
	 */
	public List<Map> list(String alias, String mappingId, Map args) throws DaoException{
		List<Map> res = null;
		try {
			res = session.selectOne(alias+"."+mappingId, args);
		} catch (Exception e) {
			log.debug(e);
			throw new DaoException();
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
}
