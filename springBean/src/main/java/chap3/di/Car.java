package chap3.di;

public abstract class Car {
	int speed = 0;
	String carColor="빨강";
	
	public Car() {}
	
	public Car(String carColor, int speed) {
		this.carColor = carColor;
		this.speed =speed;
	}
	
	public void speedUp() {
		System.out.println("나는 " + speed+"속도로 달리고 있다.");
	}
	
}

