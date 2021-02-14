package chap2.di.duck;		
		
public class Squeak implements QuackBehavior {		
	/*
	 *SqueakŬ������ �������̽�QuackBehavior�� ���� ����ü Ŭ�����̴�.
	 *���� �������̽��� ���� �߻�޼ҵ�(quack)�� ������ �ؾ��� �Ѵ�. 
	 * 
	 */
	@Override	
	public void quack() {	
		System.out.println("꾸에엑~~~");
	}	
}		
