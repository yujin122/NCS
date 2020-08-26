package sist;

import java.util.Scanner;

public class Ex23 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("직급을 입력하세요. : ");
		String position = sc.next();

		switch (position) {
			case "사장":
				System.out.println("사장의 월급은 1,000만원입니다.");
				break;
			case "전무":
				System.out.println("전무의 월급은 700만원입니다.");
				break;
			case "부장":
				System.out.println("부장의 월급은 600만원입니다.");
				break;
			case "차장":
				System.out.println("차장의 월급은 450만원입니다.");
				break;
			case "과장":
				System.out.println("과장의 월급은 350만원입니다.");
				break;
			case "대리":
				System.out.println("대리의 월급은 300만원입니다.");
				break;
			case "사원":
				System.out.println("사원의 월급은 200만원입니다.");
				break;
		}
		
		sc.close();
		
	}

}
