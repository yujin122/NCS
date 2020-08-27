package sist;

import java.util.Scanner;

// 별을 찍어 보자.

public class Ex29 {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		System.out.print("별의 최대 갯수를 입력하세요. : ");
		int star = sc.nextInt();
		System.out.println();
		
		if(star > 0) {
			int count = 1;
			
			while(count <= star) {
				System.out.print("*");
				count++;
			}
		}else {
			System.out.println("0보다 큰 값을 입력해주세요.");
		}
		
		sc.close();
		
	}

}
