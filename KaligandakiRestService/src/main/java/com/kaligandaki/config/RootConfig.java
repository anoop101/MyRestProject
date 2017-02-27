package com.kaligandaki.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.kaligandaki.dao.ProductDAO;
import com.kaligandaki.service.ProductService;

@Configuration
@EnableCaching
@ComponentScan(basePackages = { "com.kaligandaki.config", "com.kaligandaki.dao" }, excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
@EnableTransactionManagement
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
		hibernateProps.setProperty("hibernate.show_sql", "true");
		hibernateProps.setProperty("hibernate.hbm2ddl.auto", "validate");
		hibernateProps.setProperty("hibernate.cache.use_query_cache", "true");
		hibernateProps.setProperty("hibernate.cache.use_second_level_cache", "true");
		hibernateProps.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		
		return hibernateProps;
	}

	@Bean
	public ProductService productService(ProductDAO productDAO){
		ProductService prodService = new ProductService();
		prodService.setProductDAO(productDAO);
		return prodService;
	}
	
	@Bean
	public ProductDAO productDAO(SessionFactory sessionFactory){
		ProductDAO productDAO = new ProductDAO();
		productDAO.setSessionFactory(sessionFactory);
		return productDAO;
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
	
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}

	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	}
}
