package sist;

import java.util.*;
/*
 * [문제1] 지방(fat), 탄수화물(car), 단백질(protien)
 * 		   칼로리 합계를 구하는 프로그램 작성
 * 			- 총 칼로리 구하기
 * 			* 지방 1그램 : 9kcal
 * 			* 단백질과 탄수화물 1그램 : 4kcal
 * 			* 총 칼로리 : (지방*9) + (탄수화물*4) + (단백질*4)
 */

public class Exam_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("지방의 그램을 입력하세요 : ");
		int fat = sc.nextInt();

		System.out.print("탄수화물의 그램을 입력하세요 : ");
		int car = sc.nextInt();

		System.out.print("단백질의 그램을 입력하세요 : ");
		int pro = sc.nextInt();

		System.out.println("총 칼로리 : " + ((fat * 9) + (car * 4) + (pro * 4)) + "kcal");
	}

}
