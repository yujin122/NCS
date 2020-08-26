package sist;

import java.util.Scanner;

public class Ex17 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요. : ");
		int su = Integer.parseInt(sc.nextLine());
		
		System.out.print("주소를 입력하세요 : ");
		String address = sc.nextLine();
		
		System.out.println("입력받은수 >>> " + su);
		System.out.println("입력받은 주소 : " + address);
		
		sc.close();
	}

}
