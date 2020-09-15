package sist;

import java.util.*;

public class Exam_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		
		System.out.println("5개의 숫자를 입력하세요");
		for(int i =0; i < arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		
		System.out.println("===내림차순으로 정렬===");
		int temp;
		for(int i = arr.length;i>0;i--) {
			for(int j = 1;j<i;j++) {
				if(arr[j-1]<arr[j]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j]=temp;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
		}
		
		sc.close();
	}

}
