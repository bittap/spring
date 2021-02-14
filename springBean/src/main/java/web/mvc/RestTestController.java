package web.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/test/*")
public class RestTestController {
	Logger logger = Logger.getLogger(RestTestController.class);
	@GetMapping(value="jsonTestList.sp4",produces="application/json;charset=UTF-8")
	public String jsonTestList() {
		logger.info("jsonTestList 호출 성공");
		String text = null;
		List<Map<String, Object>> memList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		map.put("mem_id", "kim");
		map.put("mem_pw", "123");
		map.put("mem_name", "김진호");
		memList.add(map);
		map = new HashMap<>();
		map.put("mem_id", "lee");
		map.put("mem_pw", "123");
		map.put("mem_name", "이한샘");
		memList.add(map);
		Gson g = new Gson();
		text = g.toJson(memList);
		return text;
	}
}
