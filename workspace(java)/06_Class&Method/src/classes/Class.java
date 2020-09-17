package classes;

/*
 * 객체(object)?
 * - 실세계에서 우리 주변에 있는 모든 것이 객체임.
 * 	  예) TV, 컴퓨터, 책, 건물, 의자, 사람 등등
 * - 실세계의 객체들은 자신만의 고유한 특성(속성)과 행동(기능)을 가지고 있음.
 * - 이러한 객체들은 다른 객체들에게 행동을 요청하거나
 * 	  정보를 주고 받는 등 상호작용을 하면서 존재함.
 */

/*
 * 클래스(class)?
 * 1. 클래스는 객체를 만들기 위한 설계도(틀, 도면)이다.
 * 2. 자바는 클래스 단위로 프로그래밍을 한다.
 * 3. 클래스를 구성하는 것을 멤버(member)라고 한다.
 * 4. 멤버 = 속성(멤버변수) + 기능(멤버메서드)
 * 			=> 속성 : 멤버변수 = 클래스의 특징 ==> 명사적 개념
 * 			=> 기능 : 멤버메서드 = 클래스의 행위(동작) ==> 동사적 개념
 * 5. 클래스 구성 : 클래스 헤더, 멤버변수, 멤버메서드, 생성자
 * 
 * [클래스 형식]
 * 		[접근제한] class 클래스이름{
 * 			멤버변수;
 * 			생성자();
 * 			멤버메서드();
 * 		}
 * - 클래스 이름 : 대문자로 시작(식별자)
 */

public class Class {
	
	// 멤버변수는 초기값을 설정하지 않으면 JVM이
	// 객체 생성 시점에 해당 테이터 타입(자료형)에 맞게 알아서
	// 해당 자료형의 default 값을 할당해 줌.
	int num;	// 멤버변수 - 전역변수
	String str;	// 멤버변수 
	
	void display() {	// 멤버메서드
		int su = 10;	// 지역변수
		System.out.println("멤버변수(num) >>> " + num);
		System.out.println("멤버변수(str) >>> " + str);
		System.out.println("변수(지역변수) >>> " + su);
	}
	
	public static void main(String[] args) {
		
		// 클래스를 객체로 만들어 보자
		// 1단계 : 클래스 선언
		// 형식) 클래스이름  참조변수;
		// 참조변수 : heap 메모리에 객체가 만들어지는데 민들어지는 주소값을 가지는 변수.
		//Class ex;
		
		// 2단계 : 클래스를 메모리에 생성
		// 형식) 참조변수 = new 클래스이름();	==> 생성자
		//ex = new Class();
		
		// 1단계 + 2단계 : 클래스 선언 및 클래스 객체 생성
		Class ex = new Class();
		
		System.out.println("ex >>> " + ex);
		
		// 3단계 : 참조변수를 이용하여 객체에 접근,
		//		  객체에 접근 시 . 연산자를 이용
		ex.display();
		System.out.println();
		
		ex.num = 100;
		ex.str = "홍길동";
		ex.display();
		
		Class ex1 = new Class();
		System.out.println("ex1 >>> "+ex1);
		System.out.println();
		
		ex1.num = 350;
		ex1.str = "유관순";
		ex1.display();
		
	}

}
