package chap3.di;
/*
 * 아빠가 가지고 있는 생성자는 추상클래스의 생성자 이므로 상징적인
 * 의미만 있을 뿐 실제 누릴 수 있는 생성자가 아니다.
 * Car c = new Car()할 수 없다는 것을 생각해보자.
 * 
 */
public class Sonata extends Car {
	/*
	 * 생성자가 아무것도 없으면 자바 가상머신이 대신 만들어주지만
	 * 생성자가 한개라도 선언되어 있으면 대신 만들어 주지않는다.
	 * Car클래스가 생성자가 두 개 이었으니깐 상속받은 Sonata클래스도 
	 * 생성자가 똑같이 두 개 있어야 한다.
	 * 왜냐하면 파라미터를 갖는 생성자는 개발자 마음대로 선언할 수 있으므로
	 * 대신 만들어주는 것은 불가능한 일임.
	 * Sonata생성자가 호출될 때 Car생성자가 먼저 호출되고 그 다음으로
	 * Sonata생성자가 호출된다.
	 * 이런 과정을 거치므로 아빠 클래스의 메소드의 원형을 파악할 수 있고
	 * 오버라이딩 조건을 지키는지 여부를 알 수 있는 것임.
	 * 
	 */
	public Sonata() {}
	
	public Sonata(String carColor, int speed) {
		this.speed= speed;
		this.carColor =carColor;
	}
	
	public String toString() {
		return "그녀의 자동차는"+this.carColor+"이고 , 현재속도는" +this.speed+" 입니다.";
	}
	
	@Override
	public void speedUp() {
		System.out.println("나는 " + (speed+20) +"속도로 달리고 있다.");
	}

}
