package classes;

import java.util.Scanner;

/*
 * 1. 클래스를 대상으로 객체 생성하는 과정
 * 	    형식) 클래스명 참조변수 = new 클래스명(); --> (X)
 * 		      클래스명 참조변수 = new 생성자(); --> (O)
 * 
 * 2. 생성자(Constructor)?
 * 	  1) 클래스를 대상으로 객체를 생성하는 역할을 함
 * 	  2) 클래스의 이름과 동일함.
 * 	  3) 클래스에 포함되어 있으며, 객체를 생성할 때 자동으로 딱 한 번만 호출이 됨.
 * 	  4) 클래스는 생성자를 통해서 객체로 생성이 됨.
 * 	  	  생성자 형식)
 * 				[접근제한] 생성자이름(매개변수){
 * 					생성자 호출 시 실행될 문장;
 * 				}
 * 	  5) 생성자는 메서드 형태를 가지고 있음.
 * 		 => 리턴타입(반환형) X, void X, 매개변수 O
 * 	  6) 모든 클래스는 반드시 한 개 이상의 생성자를 가지고 있음.
 * 	  7) 사용자가 생성자를 정의하지 않으면, JVM이 컴파일 시점에
 * 		  자동으로 기본생성자를 만들어 줌.
 * 
 * 3. 생성자의 목적 : 멤버변수들의 초기화를 목적으로 사용
 * 
 * 4. 생성자의 특징
 * 	  1) 생성자 이름 == 클래스 이름
 * 	  2) 메서드와 다르게 반환형이 없음
 * 	  3) 클래스는 반드시 한 개 이상의 생성자를 가지고 있음
 * 	  4) 생성자 오버로딩이 가능함(즉, 여러 개의 생성자가 존재할 수 있음)
 * 	  5) 생성자가 보이지 않으면 기본생성자가 숨어 있음.
 * 	  6) 기본생성자라 함은 매개변수가 없는 생성자를 말함
 * 	  7) 기본 생성자 외에 다른 생성자를 만들면, 숨어 있던 기본생성자는 사라짐.
 * 	  8) 기본 생성자 외에 다른 생성자를 만들면, 무조건 기본 생성자를 만들어 줄 것.
 * 		 (만약 기본 생성자를 만들지 않으면 상속에서 문제가 발생함 ==> 상속에서 추후 설명 예정) 
 */
public class Student {
	
	int hakbun;
	String name;
	String major;
	String addr;
	
	public Student() {
		
	} 
	
	public Student(int h,String n, String m, String a) {
		hakbun = h;
		name = n;
		major = m;
		addr = a;
		
	}// 인자 생성자
	
	void display() {
		System.out.println("학     번 : " + hakbun);
		System.out.println("이     름 : " + name);
		System.out.println("학     과 : " + major);
		System.out.println("주     소 : " + addr);		
	}
	
	public static void main(String[] args) {
		
		// 기본생성자로 객체 생성
		Student std = new Student();
		std.hakbun = 20091701;
		std.name = "홍길동";
		std.major = "경제학과";
		std.addr = "서울 마포구";

		std.display();
		System.out.println();
		
		// 인자생성자로 객체 생성
		Student std1 = new Student(20091702, "유관순", "회계학과", "인천 부평구");
		
		std1.display();
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("학번, 이름, 학과, 주소를 입력하세요...");
		
		Student str2 = new Student(sc.nextInt(),sc.next(),sc.next(),sc.next());
		
		str2.display();
		
		sc.close();
	}

}
