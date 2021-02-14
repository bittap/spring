package chap2.di.duck;									
									
public abstract class Duck {
	//�������̽��� �����Ͽ���.
	//�ֳ��ϸ� �������̽��� ����ϴ� Ŭ�������� ���δ� ���� ���δ� ���� ����
	//�� ���� ��찡 �����Ƿ� �����ϰ� �����ϴ� ����ü Ŭ�������� ����
	//�ϵ��� �Ͽ���.
	FlyBehavior flyBehavior = null;								
	QuackBehavior quackBehavior = null;
	
	//�߻�Ŭ������ �����ڸ� ���� �� �ִ�.
	//�ֳ��ϸ� �߻�Ŭ���� �����ڰ� ȣ��Ǿ�� ����ü Ŭ������ ���� �ʱ�ȭ
	//�� �޼ҵ� �������̵� ������ �ؼ��ߴ����� Ȯ���� �� �ֱ� ������ �ʿ��ϴ�.
	//Duck me =  new Duck(); X(�̷��Դ� ���� ����.)
	//Duck myDuck = new MallardDuck(); O(�̷��Դ� �����ϴ�.)
	//�̶� �θ�����ڰ� ȣ��ǰ� �ڽ� �����ڰ� �ι�°�� ȣ��ȴ�.
	public Duck(){
		//System.out.println("�߻�Ŭ���� Duck������ ȣ�⼺��");
	}
	
	public abstract void display();								
	public void performFly(){// �������� ����
		//NullPointerException�� �� ���Ͼ�°ɱ�?
		//fly메소드 이름을 직접 쓰는건 좋지 않다.
		//System.out.println("performFlyȣ�� ����");
		flyBehavior.fly();							
	}
	
	public void performQuack(){		
		//quackBehavior�� null�� �����̹Ƿ� NullPointerException�� �߻� �� ���̴�.
		quackBehavior.quack();							
	}	
	
	public void swimming(){								
		System.out.println("물에뜹니다");							
	}								
}									

