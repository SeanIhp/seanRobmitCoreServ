package cn.com.iherpai.core.storage.mybatis.das;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.iherpai.core.storage.mybatis.mapper.AccountMapper;

public class BaseDas {
	protected static Logger log = Logger.getLogger(BaseDas.class.getName());
	protected ApplicationContext applicationContext;

	protected AccountMapper  				accountDao; 
	
	public BaseDas(){
		applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

		accountDao = (AccountMapper) this.applicationContext.getBean("accountMapper");
	}

}
