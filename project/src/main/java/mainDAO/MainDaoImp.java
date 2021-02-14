package mainDAO;

import java.io.IOException;
import java.util.List;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import mainDTO.MainDTO;

public class MainDaoImp implements MainDAO {
	
	
	private SqlSessionTemplate sessionTemplate;
	
	public MainDaoImp() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int today_price() {
		return sessionTemplate.selectOne("main.today_price");
	}
	
	@Override
	public int today_order_count() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("main.today_order_count");
	}
	
	@Override
	public int before_order_count() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("main.before_order_count");
	}
	
	@Override
	public int before_price() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectOne("main.before_price");
	}
	
	@Override
	public List<MainDTO> month_order_list() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("main.month_order_list");
	}
	
	@Override
	public List<MainDTO> month_member_list() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("main.month_member_list");
	}

	public SqlSessionTemplate getSessionTemplate() {
		return sessionTemplate;
	}

	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		System.out.println("setSessionTemplate 생성");
		this.sessionTemplate = sessionTemplate;
	}
	
	
	

	
	
}
