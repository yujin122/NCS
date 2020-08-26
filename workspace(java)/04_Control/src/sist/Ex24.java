package sist;

import java.util.Scanner;

public class Ex24 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력해주세요 : ");
		String name = sc.nextLine();

		System.out.print("국어점수를 입력해주세요 : ");
		int kor = Integer.parseInt(sc.nextLine());

		System.out.print("영어점수를 입력해주세요 : ");
		int eng = Integer.parseInt(sc.nextLine());

		System.out.print("수학점수를 입력해주세요 : ");
		int mat = Integer.parseInt(sc.nextLine());

		System.out.print("자바점수를 입력해주세요 : ");
		int java = Integer.parseInt(sc.nextLine());

		int total = kor + eng + mat + java;

		float avg = total / 4.0f;

		String grade;

		/*if (avg >= 90) {
			grade = "A학점";
		} else if (avg >= 80) {
			grade = "B학점";
		} else if (avg >= 70) {
			grade = "C학점";
		} else if (avg >= 60) {
			grade = "D학점";
		} else {
			grade = "F학점";
		}*/
		
		// 학점을 구할 때 switch~case문을 이용해 보자.
		switch((int)(avg/10)) {
			case 10 :
			case 9 :
				grade = "A학점";
				break;
			case 8 :
				grade = "B학점";
				break;
			case 7 :
				grade = "C학점";
				break;
			case 6 :
				grade = "D학점";
				break;
			default :
				grade = "F학점";
		}

		System.out.println("이름: " + name);
		System.out.println("국어점수: " + kor + "점");
		System.out.println("영어점수: " + eng + "점");
		System.out.println("수학점수: " + mat + "점");
		System.out.println("자바점수: " + java + "점");
		System.out.println("총점: " + total + "점");
		System.out.printf("평균: %.2f점\n", avg);
		System.out.println("학점: " + grade);

		sc.close();


	}

}
