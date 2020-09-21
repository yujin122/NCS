package inheritance;

/*
 * 상속(inheritance)?
 * - 객체지향 프로그램 4대 특징 중 하나.
 * - 기존의 이미 잘 만들어진 클래스를 재사용하여 새로운 클래스를 
 * 	  생성하는 자바 문법 	- 아주 중요함
 * 	  즉, 특정 클래스를 만들 때 기존의 클래스의 데이터(속성)와 
 * 	  기능(메서드)을 그대로 물려 받아서 중복적인 코드를 없애줌.
 * 	 (클래스의 재사용, 코드 중복을 없애줌)
 * - 자식과 부모의 관계로 형성
 * 	 => 부모클래스 : Super, Parent 클래스라고 하기도 함
 * 	 => 자식클래스 : Sub, Child 클래스라고 하기도 함
 * 	 => 자식은 부모의 멤버보다 같거나 많다.
 * - 상속의 대상은 멤버(멤버변수, 멤버메서드)
 * 	 => 단, 생성자, private 접근 제한을 갖는 멤버변수와
 * 		멤버메서드는 상속에서 제외됨
 * - 상속 시 사용되는 키워드 : extends
 * - 상속은 단일상속만 가능함
 * 	 => 상속을 받을 수 있는 클래스는 하나이다.
 * - 상속의 장점은 클래스의 수정을 최소화 시킬 수 있는 장점
 * 	  또한 유지보수의 시간을 최소화 시켜준다는 장점이 있음
 * 	  형식)
 * 			[접근제한] class 자식클래스 extends 부모클래스{  }
 * - 상속관계 : '~은 ~이다.(is a)'
 * 	 포함관계 : '~은 ~을 가지고 있다.(has a)
 * 			 => 사람은(name, age, id) 를 가지고 있다.
 * - 주의) 부모클래스는 반드시 기존에 미리 정의되어 있어야 함
 */

class Car{
	// 멤버변수
	int cc;			// 차량 배기량
	int door;		// 차량 문짝 수 
}

class Sonata extends Car{
	
	//int cc;
	//int door;
	String model;	// 차량 모델명
	
	void prn() {
		System.out.println("모델명 >>> " + model);
		System.out.println("배기량 >>> " + cc);
		System.out.println("문짝 수 >>> " + door);
	}
}

public class Car_Main {

	public static void main(String[] args) {
		
		/*
		 * Sonata 클래스 객체 생성 과정
		 * Sonata 클래스 객체 생성 시 JVM이 
		 * 우선적으로 Car 부모클래스를 객체 생성 후
		 * Sonata 자식클래스의 객체 생성.
		 */
		Sonata sonata = new Sonata();
		
		sonata.model = "소나타";
		sonata.cc = 2000;
		sonata.door = 4;
		
		sonata.prn();

	}

}
