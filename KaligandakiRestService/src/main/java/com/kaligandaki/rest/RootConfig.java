package com.kaligandaki.rest;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = { "com.kaligandaki.rest", "com.kaligandaki.dao" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class RootConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/kaligandaki");
		//dataSource.setUrl("jdbc:mysql://localhost:3306/my_test_db");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan("com.kaligandaki.dto");
		sessionFactoryBean.setHibernateProperties(getHibernateProperties());
		return sessionFactoryBean;

	}
	
	private Properties getHibernateProperties(){
		Properties hibernateProps = new Properties();
		hibernateProps.setProperty("hibernate.connection.pool_size", "2");
		hibernateProps.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProps.setProperty("hibernate.current_session_context_class", "thread");
		hibernateProps.setProperty("hibernate.show_sql", "true");
		hibernateProps.setProperty("hibernate.hbm2ddl.auto", "validate");
		return hibernateProps;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}
}
