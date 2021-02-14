package chap2.di.duck;		
		
public class RubberDuck extends Duck {
	public FlyBehavior flyBehavior =null;
	
	public RubberDuck(FlyBehavior flyNoWay) {
	}

	@Override	
	public void display() {	
		System.out.println("RubberDuck입니다.");
	}
	
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}	
}		

