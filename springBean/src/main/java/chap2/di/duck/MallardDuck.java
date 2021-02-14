package chap2.di.duck;						
						
public class MallardDuck extends Duck{						
	public MallardDuck() {		
		//System.out.println("MallarDuck호출 성공");
		quackBehavior = new Quack();				
		flyBehavior = new FlyWithWings();				
	}
	@Override	
	public void display(){					
		System.out.println("MallarDuck입니다.");				
	}					
}						
