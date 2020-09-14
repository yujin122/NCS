package sist;

import java.util.Scanner;

/*
 * [문제] 배열 5개의 정수를 키보드를 이용하여 저장 후,
 * 		  배열에 저장된 정수를 화면에 출력해 보세요.
 * 		  조건) 일반 for문과 단축 for문을 이용하여 출력할 것.
 */

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 배열 선언 및 배열 메모리 생성
		int[] num = new int[5];
		System.out.println("정수 5개를 입력하시오.");
		// 배열 초기화 작업
		for(int i = 0;i<5;i++) {
			System.out.print((i+1)+"번째 정수 : ");
			num[i]=sc.nextInt();
		}
		System.out.println("----------------");
		// 일반 for문
		for(int i=0;i<5;i++) {
			System.out.println((i+1)+"번째 정수 : " + num[i]);
		}
		System.out.println("----------------");
		// 단축 for문
		for(int i : num) {
			System.out.println("5개의 정수 : " + i);
		}

	}

}
