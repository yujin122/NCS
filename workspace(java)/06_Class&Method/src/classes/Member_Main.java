package classes;

import java.util.Scanner;

/*
 * 생성자 다중정의(constructor overloading)
 * - 동일한 클래스에서 동일한 이름의 생성자를 여러 개 정의하는 문법
 * - 조건 : 매개변수의 자료형 또는 매개변수의 갯수가 달라야 함
 * 
 * 생성자의 역할
 * 1. 객체를 생성하는 역할
 * 2. 멤버변수의 초기값을 설정하는 역할
 * 3. 객체를 생성하는 시점에 자동으로 처리해야 할 내용을 설정하는 역할
 */

class Member{
	
	// 멤버변수
	String name;
	int age;
	String phone;
	String job;
	
	// 기본생성자
	public Member() { }
	
	// 인자생성자
	public Member(String n, int a, String p, String j) {
		name = n;
		age = a;
		phone = p;
		job = j;
	}
	
	void output() {
		System.out.println("회원 이름 >>> " + name);
		System.out.println("회원 나이 >>> " + age);
		System.out.println("회원 연락처 >>> " + phone);
		System.out.println("회원 직업 >>> " + job);
		
	}
	
}

public class Member_Main {

	public static void main(String[] args) {
		Member mem1 = new Member();
		mem1.name = "홍길동";
		mem1.age = 25;
		mem1.phone = "010-7546-4566";
		mem1.job = "은행원";
		
		mem1.output();
		System.out.println();
		
		Member mem2 = new Member("이유리",28,"010-6531-5466","개발자");
		mem2.output();
		System.out.println();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름, 나이, 연락처, 직업을 입력하세요...");
		Member mem3 = new Member(sc.next(),sc.nextInt(),sc.next(),sc.next());
		mem3.output();
		
		sc.close();
	}

}
