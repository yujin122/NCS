package sist;

import java.util.*;

//[문제] 키보드로 문자열 배열 크기를 입력받아서
//		배열에 저장 후 화면에 출력해 보자.
public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력해주세요 : ");
		
		String[] str = new String[sc.nextInt()];
		
		System.out.println("문자열을 입력해주세요.");
		for(int i=0;i<str.length;i++) {
			System.out.print((i+1)+"번째 문자열 : ");
			str[i] = sc.next();
		}
		System.out.println();
		
		for(int i=0;i<str.length;i++) {
			System.out.println((i+1)+"번째 문자열 : " + str[i]);
		}
		
		sc.close();

	}

}
