package chap2.di;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TivoliMainForSpring {

	public static void main(String[] args) {
		Tivoli yourCar = null;
		//객체를 주입받으려면 받드시 아래 코드를 실행하고 파라미터에 
		//조립기의; 클래스를 등록한다.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		//이 코드로 객체가 생성되고 필요한 순간에 사용할 수 있음.
		yourCar = (Tivoli)ctx.getBean("tivoli");
		//위에서 생성되니까 NullPointerException안일어남
		yourCar.carColor = "보라";
		yourCar.speed = 100;
		System.out.println(yourCar);
		yourCar.speedUp();
		Map<String,Object> map =
				 (Map<String,Object>)ctx.getBean("setMap");
		map.put("mem_id","haha");
		System.out.println(map.get("mem_id"));
		List<String> list = (List<String>)ctx.getBean("list");
		list.add("김유신");
		System.out.println(list.get(0));
		
	}

}
