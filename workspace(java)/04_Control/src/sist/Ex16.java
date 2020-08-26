package sist;

import java.util.Scanner;

/*
 * 키보드로 데이터를 입력받는 방법
 * 1. main(String[] args)를 이욯하는 방법
 * 2. JOptionPane 클래스를 이용하는 방법(GUI방식) - 13장
 * 3. Scanner 클래스를 이용하는 방법
 * 4. 파일 입출력을 이용하는 방법 - 11장
 */

public class Ex16 {
	
	public static void main(String[] args) {
		
		// 키보드로 데이터를 입력받는 방법
		// 3. Scanner 클래스를 이용하는 방법
		// System.in : 표준입력장치(키보드)
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요. : "); 
		
		//int su = sc.nextInt(); // 키보드로 숫자 값을 입력 받을때 사용하는 메서드
		int su = Integer.parseInt(sc.nextLine());
		
		System.out.println("입력받은 숫자 >>> " + su);
		System.out.println();
		
		System.out.print("주소를 입력하세요. : ");
		String address = sc.nextLine();
		System.out.println("입력받은 주소 >>> " + address);
		
		sc.close();
		
		// nextInt() : 키보드로부터 숫자 값을 입력받을 때 사용한다.
		// next() : 키보드로부터 문자열을 입력받을 때 사용한다.
		// 			중간에 공백이 있으면 공백 앞까지만 인식
	}
}
