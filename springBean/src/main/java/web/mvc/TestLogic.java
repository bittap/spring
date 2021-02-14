package web.mvc;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestLogic {
   Logger logger = Logger.getLogger(TestLogic.class);
   
   @Autowired
   public TestDao testDao = null;
   
   public List<Map<String, Object>> testList() {
      logger.info("testList 호출 성공");
      List<Map<String,Object>> testList = null;
      testList = testDao.testList();
      String time = testDao.currentTime();
      logger.info("time: " + time);
      return testList;
   }

   public int testInsert() {
      logger.info("testInsert 호출 성공");
      int result = 0;
      result = testDao.testInsert();
      return result;
   }
   
}