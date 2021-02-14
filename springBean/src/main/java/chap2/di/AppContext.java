package chap2.di;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//객체 조립기
@Configuration
public class AppContext {
	
	@Bean
	public Tivoli tivoli() {
		return new Tivoli();
	}
	
	@Bean
	public Map<String,Object> setMap() {
		return new HashMap<String, Object>();
	}
	
	@Bean
	public List<String> list() {
		return new ArrayList<String>();
	}
}

