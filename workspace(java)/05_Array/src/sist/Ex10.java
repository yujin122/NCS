package sist;

import java.util.Scanner;

// 배열에 데이터 저장
// 내림차순 정렬하는 방법
// 예) 19, 43, 6, 97, 65
//	==> 97, 65, 43, 19, 6
public class Ex10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력해주세요 : ");
		
		int[] arr = new int[sc.nextInt()];
		
		System.out.println("배열의 크기만큼 정수값을 입력하세요");
		for(int i=0;i<arr.length;i++) {
			System.out.print("["+i+"] : ");
			arr[i] = sc.nextInt();
		}
		
		// 내림차순으로 정렬 
		int temp;
		for(int i=arr.length;i>0;i--) {
			for(int j = 1;j<arr.length;j++) {
				if(arr[j] > arr[j-1]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
			
		}
		
		for(int i : arr) {
			System.out.print(i+" ");
		}
		
		sc.close();

	}

}
