package sist;

import java.util.Scanner;

/*
 * switch ~ case 문 - 조건문
 * 	- 식(정수 또는 char)을 사용해서 다중분기하는 명령문
 * 	- jdk 1.7 버전 이상부터는 식에 String 사용이 가능함.
 * 	   형식)
 * 			switch(식 또는 값){
 * 				case 값1 : 
 * 						실행문;
 * 						break; //switch~case 블럭 탈출
 * 				case 값2 : 
 * 						실행문;
 * 						break;
 * 				case 값3 : 
 * 						실행문;
 * 						break;
 * 				default : // 생략도 가능함.
 * 						값 1 ~ 값3 이외의 값이 들어온 경우 실행문;
 * 			}
 */

public class Ex20 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("1 ~ 3 사이의 숫자 중에서 하나 선택 : ");
		int su = sc.nextInt();

		switch (su) {
			case 1:
				System.out.println("입력받은 숫자는 1입니다.");
				break;
			case 2:
				System.out.println("입력받은 숫자는 2입니다.");
				break;
			case 3:
				System.out.println("입력받은 숫자는 3입니다.");
				break;
			default:
				System.out.println("1 ~ 3 이외의 숫자입니다.");
		}
		
		sc.close();
	}

}
