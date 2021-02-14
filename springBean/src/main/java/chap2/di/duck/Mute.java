package chap2.di.duck;		
		
public class Mute implements QuackBehavior {		
	@Override	
	public void quack() {	
		System.out.println("소리가 없어요!");
	}	
}		
