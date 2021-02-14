package web.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDao {
	Logger logger = Logger.getLogger(TestDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	public String currentTime() {
	logger.info("currentTime 호출 성공");
	String time = sqlSessionTemplate.selectOne("currentTime");
	return time;
	}
	public List<Map<String, Object>> testList() {
	logger.info("testList 호출 성공");
	List<Map<String, Object>> testList = null;
	return testList;
	}
	
	public int testInsert() {
		logger.info("testInsert 호출 성공");
		int result = 0;
		return result;
	}

}