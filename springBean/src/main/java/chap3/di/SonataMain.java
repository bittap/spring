package chap3.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SonataMain {

	public static void main(String[] args) {
		//spring-context.jar
		ApplicationContext context = new ClassPathXmlApplicationContext("chap3\\di\\myCar.xml");		
		Car herCar=(Car)context.getBean("herCar");
		herCar.speedUp();
		
		
		Car gnomCar=(Car)context.getBean("gnomCar");
		System.out.println(gnomCar);
	}

}
