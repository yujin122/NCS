package sist;

import java.util.*;

public class Exam_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor, eng, mat;
		
		while(true) {
			// 키보드로 이름, 국어, 영어, 수학 점수를 입력을 받자.
			System.out.print("이름을 입력하세요 : ");
			name = sc.next();
			System.out.print("국어 점수를 입력하세요 : ");
			kor = sc.nextInt();
			System.out.print("영어 점수를 입력하세요 : ");
			eng = sc.nextInt();
			System.out.print("수학 점수를 입력하세요 : ");
			mat = sc.nextInt();
			System.out.println();
			
			// 총점을 구하자.
			int total = kor+eng+mat;
			
			// 평균을 구하자.
			double avg = total/3.0;			
			
			// 학점을 구하자.
			String grade;
			
			if(avg >= 90) {
				grade = "A학점";
			}else if(avg >= 80) {
				grade = "B학점";
			}else if(avg >= 70) {
				grade = "C학점";
			}else if(avg >=60) {
				grade = "D학점";
			}else {
				grade = "F학점";
			}
			
			// 성적을 화면에 출력해 보자.
			System.out.println("이름 : " + name );
			System.out.println("국어 점수 : " + kor + "점");
			System.out.println("영어 점수 : " + eng+ "점");
			System.out.println("수학 점수 : " + mat+ "점");
			System.out.println("총      점 : " + total+ "점");
			System.out.printf("평      균 : %.2f점\n", avg );
			System.out.println("학      점 : " + grade);
			System.out.println(":::::::::::::::::::::::::");
			System.out.println();
					
			// 계속할지 아닐지를 확인하자.
			
			System.out.print("계속할까요?(Y:계속 / N:종료) : ");
			String code = sc.next();
			
			if(code.equalsIgnoreCase("N")) {
				break;
			}	
		}
		
		System.out.println("수고 많이 하셨습니다.");
		
		sc.close();

	}

}
