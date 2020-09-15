package sist;

import java.util.*;

// 키보드로 배열의 크기를 입력을 받자.

public class Ex06 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력하세요 : ");
		//int size=sc.nextInt();
		
		//int[] arr = new int[size];
		int[] arr = new int[sc.nextInt()];
		
		System.out.println("정수 값을 입력해주세요.");
		for(int i=0;i<arr.length;i++) {
			System.out.print("["+i+"] : ");
			arr[i] = sc.nextInt();
		}
		System.out.println();
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr["+i+"] : "+arr[i]);
		}
		
		sc.close();
	}

}
