package chap3.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 스프링에서는 클래스에 대한 자원관리를 대신 해줌
 * 단 클래스 선언은 개발자가 해야함 - 대신할 수 없다. - xml
 * helloBean.xml - HelloBeanImpl.java
 * HelloBeanImple helloBean = null;
 * 스프링에서는 helloBean.xml문서를 스캔하여 어떤 클래스가 선언되었는지
 * 정보를 수집해야 함.
 * 필요한 시점에 스프링프레임워크에서 객체를 대신 주입해줌.
 * helloBean = new HelloBeanImpl();
 * ApplicationContext - 빈을 관리하는 공장임.
 * BeanFactory
 */
public class HelloMain {
	public static void main(String[] args) {
		//spring-context.jar
		ApplicationContext context = new ClassPathXmlApplicationContext("chap3\\di\\helloBean.xml");
		
		HelloBean helloBean = null;
		helloBean = new HelloBeanImpl();
		System.out.println(helloBean.getGreenting("안녕"));
		
		
		HelloBean helloBean2=(HelloBean)context.getBean("helloBean");
		System.out.println(helloBean2.getGreenting("안녕"));
	}
}
