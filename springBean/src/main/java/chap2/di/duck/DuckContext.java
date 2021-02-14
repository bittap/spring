package chap2.di.duck;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 갹체 조립기
 */
@Configuration
public class DuckContext {
	@Bean
	public RubberDuck setRubberDuck(FlyBehavior flyNoWay) {
		return new RubberDuck(flyNoWay);
	}
	@Bean
	public MallardDuck setMallardDuck() {
		return new MallardDuck();
	}
	@Bean
	public WoodDuck setWoodDuck() {
		return new WoodDuck();
	}
	@Bean
	public FlyBehavior flyWithWings() {
		return new FlyWithWings();
	}
	@Bean
	public FlyBehavior flyNoWay() {
		return new FlyNoWay();
	}
	  
}
