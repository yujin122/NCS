package sist;

import java.util.*;

// 배열공유

public class Ex09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수형 배열 크기 입력 : ");
		
		int[] arr = new int[sc.nextInt()];
		int[] arrCopy = arr;	// 상당히 중요한 개념(Call by Reference)
		System.out.println("배열의 크기만큼 정수값을 입력하세요...");
		// 정수형 배열에 키보드로 정수값을 입력하자.
		for(int i=0;i<arrCopy.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		// 저장된 정수 값을 출력하자
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr["+i+"] >>> " + arr[i]);
		}

		sc.close();
	}

}
