package sist;

import java.util.Scanner;

/*
 * 1 ~ 100 사이의 정수 중에서
 * 키보드로 5개의 정수를 입력받아서
 * 그 정수 중에서 최대값을 화면에 출력해 보자.
 * 예) 17, 34, 8, 93, 77
 */

public class Ex30 {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		int max=0, init = 1;	// 최대값 변수 : 항상 가장 작은 값을 넣어줄 것, 반복문에서 초기식
		int num;
		
		while(init <=5) {
			System.out.println(init + "번째 숫자 입력 : ");
			num = sc.nextInt();
			if(max <= num) {
				max =num;
			}
			init++;
		}
		
		System.out.println("최댓값 >>> " + max);

		sc.close();
	}

}
