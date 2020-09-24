package sist;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * 다중 catch문
 * - catch문을 여러 개 사용하여 예외를 처리하는 방식
 * - catch문은 순차적으로 실행된다.
 * - 예외를 처리하는 가장 상위의 Exception 클래스는
 * 	  맨 마지막 줄에 나와야 한다.
 * 	 (만약 첫 문장에 나오면 error 발생)
 */

public class Ex07 {

	public static void main(String[] args) {

		System.out.println("프로그램 시작");
		
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		String str = "korea";
		
		int[] arr = {10, 20, 30, 40, 50};
		
		try {
			num = sc.nextInt();

			System.out.println("str 문자열 길이 : " + str.length());

			arr[5] =100;
			
		}catch(InputMismatchException e) {
			System.out.println("타입 불일치 오류 발생");
			System.out.println("예외 정보 : " + e);
		}catch(NullPointerException e) {
			System.out.println("값이 없는 예외 발생");
			System.out.println("예외 정보 : " + e);
		}catch(Exception e) {
			System.out.println("모르는 예외 발생");
			System.out.println("예외 정보 : " + e);
		}finally {
			sc.close();
		}
		
		System.out.println("num >>> " + num);
		System.out.println("프로그램 종료");
	}

}
