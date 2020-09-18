package classes;

import java.util.Scanner;

class Person_1 {
	private String name;
	private String gender;
	private int age;
	
	public Person_1(String name, String sex, int age) {
		this.name = name;
		this.gender = sex;
		this.age = age;
	}	
	
	public void output() {
		System.out.println("=====================");
		System.out.println("이름 : " + name);
		if(gender.equals("male")) {
			System.out.println("성별 : 남자");
		}else {
			System.out.println("성별 : 여자");
		}
			
		System.out.println("나이 : " + age);
	}
	
}

public class Ex_Person {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름, 성별(male/female), 나이를 입력하세요.");
		
		Person_1 person = new Person_1(sc.next(),sc.next(),sc.nextInt());
		
		person.output();
		
		sc.close();
	}

}
