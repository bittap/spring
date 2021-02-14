package chap2.di.duck;				
				
public class WoodDuck extends Duck {				
	public WoodDuck(){			
		flyBehavior = new FlyNoWay();		
		quackBehavior = new Mute();		
	}			
	@Override			
	public void display() {			
		System.out.println("WoodDuck입니다.");		
	}			
}				
