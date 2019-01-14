package cn.com.iherpai.core.storage.mybatis.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MtsSessionFactory {
    private static String CONFIG_FILE_LOCATION = "mybatis_config.xml";
	private static final ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    private static String configFile = CONFIG_FILE_LOCATION;
    private static SqlSessionFactory sessionFactory = null;
    
    static{
    	//加载 mybatis 的配置文件（它也加载关联的映射文件）
    	Reader reader;
		try {
			reader = Resources.getResourceAsReader(configFile);
	    	//构建 sqlSession 的工厂
	    	sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// 读取mybatis配置文件失败
			e.printStackTrace();
		}
    }
    
    private MtsSessionFactory() {
	}
    
    public static SqlSession getSession() {
    	SqlSession session = (SqlSession)threadLocal.get();
		if (session == null) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession() : null;
			threadLocal.set(session);
		}
		return session;
    }
    
    public static void rebuildSessionFactory() {
    	//加载 mybatis 的配置文件（它也加载关联的映射文件）
    	Reader reader;
		try {
			reader = Resources.getResourceAsReader(configFile);
	    	//构建 sqlSession 的工厂
	    	sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// 读取mybatis配置文件失败
			e.printStackTrace();
		}
    }
    
    public static void closeSession() {
        SqlSession session = (SqlSession) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }
    
	public static SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
