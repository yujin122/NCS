package sist;

import java.util.Scanner;

// 숫자 맞추기 게임

public class Ex31 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*** 숫자 맞추기 게임 ***");
		
		int num = (int)(Math.random()*99)+1;
		
		System.out.println("1 ~ 99 사이의 숫자 중에서 하나의 숫자를 맞추세요.");
		
		int count = 0; 	// 몇번만에 맟주는지 카운트하는 변수
		int no = 0;		// 입력한 숫자
		
		while(no != num) {
			System.out.print("숫자를 입력해주세요 : ");
			no = sc.nextInt();
			
			if(num > no) {
				System.out.println(no + "보다 큰 숫자입니다..");
			}else if(num < no) {
				System.out.println(no + "보다 작은 숫자입니다.");
			}
			System.out.println("::::::::::::::::");
			count++;
		}
		
		System.out.println("축하합니다.... 정답입니다.!!!");
		System.out.println("정답숫자 >>> " + num);
		System.out.println("정답 소요 횟수 >>> "+ count);
		
		sc.close();

	}

}
