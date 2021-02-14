package chap2.di.duck;		
		
public class Quack  implements QuackBehavior {		
	@Override	
	public void quack() {	
		System.out.println("꿱!~~~");
	}	
}		
