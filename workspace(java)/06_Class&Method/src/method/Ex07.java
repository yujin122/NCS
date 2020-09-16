package method;

import java.util.Scanner;

public class Ex07 {

	public static void total(int[] array) {
		int sum = 0;
		
		for(int i=0;i<array.length;i++) {
			sum+=array[i];
		}
		
		System.out.println("sum >>> " + sum);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int[] score = new int[sc.nextInt()];
		
		// 키보드로 점수를 배열의 크기만큼 입력받자.
		System.out.println(score.length+" 수 만큼 정수를 입력하세요...");
		
		for(int i=0;i<score.length;i++) {
			score[i] = sc.nextInt();
		} 
		
		// 총점 메서드를 호출해 보자.
		total(score);

		sc.close();
	}

}
