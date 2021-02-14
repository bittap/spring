package com.javalec.main.controller;

import java.io.IOException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.zipcode.test.ServiceImpl;
import com.javalec.zipcode.test.Test;

@Controller
public class MainController {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private ServiceImpl serviceImpl;
	private Test test;
	

	public ServiceImpl getService() {
		return serviceImpl;
	}


	public void setService(ServiceImpl serviceImpl) {
		this.serviceImpl = serviceImpl;
	}


	public Test getTest() {
		return test;
	}


	public void setTest(Test test) {
		this.test = test;
	}
	
	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {

		System.out.println("sqlSessionTemplateÈ£Ãâ");
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public int test() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:oracle:thin:@localhost:1521/root", "c##scott", "tiger");

		try {
			SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
			sqlSessionFactory.setDataSource(dataSource);
			Resource[] resourcePropertySources = new PathMatchingResourcePatternResolver().getResources("classpath:**/mybatis/*.xml");
			for (Resource resource : resourcePropertySources) {
				System.out.println(resource.getURL());
				System.out.println(resource.getURI());
			}
			sqlSessionFactory.setMapperLocations(resourcePropertySources);
			
			SqlSessionTemplate sqTemplate = new SqlSessionTemplate(sqlSessionFactory.getObject());
			
			return sqTemplate.selectOne("main.zipcode");
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return 1;
	}
	public int count() {
		try {
			System.out.println("SqlSession ===> " + sqlSessionTemplate);
			return sqlSessionTemplate.selectOne("main.zipcode");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	@RequestMapping(value = "/main.do")
	public String list() {
		System.out.println(count());
		System.out.println(serviceImpl.getTest().sum());
		//ApplicationContext applicationContext = new GenericXmlApplicationContext("context:");
		return "main/main";
	}


}
	