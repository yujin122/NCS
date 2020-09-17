package classes;

/*
 * - 하나의 파일 안에 클래스 이름에 public 접근제어자는 하나만 사용할 수 있음.
 * - public 접근제어자를 가지는 클래스는 파일의 이름을 파일명으로 지정해야 함.
 * - main() 메서드를 포함하는 클래스에 public 접근제어자를 지정해 주어야 함.
 */
class CarDemo{
	static String kind = "중형차";
	
	int number;
	int speed;
	String color;
	
	public static void kind() {
		System.out.println("중형 차량입니다...");
	}
	
	public void speedUp() {
		speed += 10;
	}
	
	public void speedDown() {
		speed -= 5;
	}
}
public class Car_Main {
	
	// JVM main() 메서드를 호출하는데 미리 메모리에 로딩되어 있지 않다면
	// 인스턴스(객체)를 생성을 하고 main() 메서드를 호출해야 하므로, 기본적으로 
	// main() 메서드를 자동으로 호출하기 위해서 static을 붙인 것임.
	public static void main(String[] args) {
		
		System.out.println("차량 종류 >>> " + CarDemo.kind);
		
		CarDemo myCar = new CarDemo();
		
		for(int i = myCar.speed; i <= 10;i++) {
			myCar.speedUp();	// speed = 110
		}
		System.out.println("myCar의 스피드 >>> " + myCar.speed);
		
		myCar.speedDown();
		myCar.speedDown();
	
		System.out.println("myCar의 스피드 >>> " + myCar.speed);
	}
}
