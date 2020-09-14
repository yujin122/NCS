package sist;

import java.util.*;

/*
 * length 속성
 * - 배열의 크기(길이)를 알려주는 키워드.
 * - 배열의 크기(길이)를 정수값으로 알려줌
 * 	형식) 배열명.length
 * 	예) int size = arr.length;
 */

public class Ex05 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int[] arr = new int[3];
		
		System.out.println("arr 배열의 크기 >>> " + arr.length);
		
		for(int i=0;i<arr.length;i++) {
			System.out.println((i+1) + "번째 정수 입력 >>");
			arr[i] = sc.nextInt();
		}
		System.out.println();
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr 배열 원소 >>> " + arr[i]);
		}
		
		sc.close();
	}

}
