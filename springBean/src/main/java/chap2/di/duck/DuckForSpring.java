package chap2.di.duck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chap2.di.AppContext;

public class DuckForSpring {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DuckContext.class);
		MallardDuck mDuck = (MallardDuck) ctx.getBean("setMallardDuck");
		WoodDuck wDuck = (WoodDuck)ctx.getBean("setWoodDuck");
		//RubberDuck rDuck = null;
//		RubberDuck rDuck = (RubberDuck)ctx.getBean("setRubberDuck");
		//ApplicationContext context = 
		//		new ClassPathXmlApplicationContext("chap2\\di\\duck\\duckBean.xml");
		
		//rDuck = (RubberDuck)context.getBean("rubberDuck");
		
		mDuck.performFly();
		mDuck.performQuack();
		
		wDuck.performFly();
		wDuck.performQuack();
		
		//rDuck.performFly();
		
		
	}

}
