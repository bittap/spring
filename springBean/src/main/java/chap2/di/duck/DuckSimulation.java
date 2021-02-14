package chap2.di.duck;										
										
public class DuckSimulation {										
	public static void main(String[] args) {									
		//MallardDuck myDuck = new MallardDuck();//����, �⺻ - �������� ���� �� ����.	
		//����ο� �����θ� �ٸ��� �ν��Ͻ�ȭ �ϸ� �������� ���� �� �ִ�.
		//�������̶� �����ο� ���� Ŭ���� Ÿ�Կ� ���� ���� �޼ҵ��̴���
		//���� �ٸ��� ����� �����Ǵ� ���� ����
		Duck yourDuck = new MallardDuck();//�������-���յ��� �������� �ڵ� ���� �� �ִ�.								
		yourDuck.performFly();
		/*
		 * myDuck�ּҹ����� DuckŸ���̶� quack�̶�� �޼ҵ带
		 * ���� ȣ���� ���� ����.
		 */
		yourDuck.performQuack();								
		yourDuck.swimming();
		Duck himDuck = new WoodDuck();								
		himDuck.performFly();								
		himDuck.performQuack();								
		himDuck.swimming();	
		/*
		 * Duck herDuck = new RubberDuck(flyNoW); herDuck.performFly();
		 * herDuck.performQuack(); herDuck.swimming();
		 */					
							
	}									
}										
