package com.ecomm;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import entity.MyCategory;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm")
public class DBConn 
{
	@Bean(name="dataSource")
	public DataSource getMySQLDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/S210075PGP");
		dataSource.setUsername("root");
		dataSource.setPassword("Password@123");
		System.out.println("==Data Source Created===");
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp=new Properties();
		hibernateProp.put("hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		
		LocalSessionFactoryBuilder factoryMgr=new LocalSessionFactoryBuilder(getMySQLDataSource());
		factoryMgr.addProperties(hibernateProp);
		
		factoryMgr.addAnnotatedClass(MyCategory.class);
		
		System.out.println("=== SessionFactory Object Created====");
		
		return factoryMgr.buildSessionFactory();
	}
	
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager tranMgr=new HibernateTransactionManager(sessionFactory);
		System.out.println("==== Transaction Manager Object Created====");
		return tranMgr;
	}
}
