package chap2.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TivoliMain {

	public static void main(String[] args) {
		Tivoli myCar = new Tivoli();
		myCar.carColor ="블랙";
		ApplicationContext context = new ClassPathXmlApplicationContext("chap2\\di\\tivoliBean.xml");

		Tivoli yourCar = null;
		yourCar = (Tivoli)context.getBean("tivoli2");
		yourCar.carColor = "레드";
		//두 자동차는 ? 같고 ? 다르다
		//스프링은 싱글톤 객체를 관리한다.
		System.out.println("old : "+myCar);
		myCar = null;
		myCar = new Tivoli();//이것이 싱글톤이다.
		System.out.println("new : "+myCar);
		myCar.carColor ="남색";
		//insert here
		System.out.println(myCar.carColor);
		//insert here에 yourCar의 차색상 레드를 출력하시오.
		System.out.println(yourCar.carColor);
	}

}
