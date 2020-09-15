package sist;

import java.util.Scanner;

public class Ex08 {

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
		
		// str 배열에 저장된 문자열 검색
		System.out.print("검색할 문자열을 입력해주세요 : ");
		String search = sc.next();
		
		for(int i =0;i<str.length;i++) {
			if(str[i].equals(search)) {
				System.out.println("찾은 문자열 : " + str[i]);
				System.out.println(i+"번째 인덱스에 존재합니다.");
				break;
			}
		}
		
		sc.close();


	}

}
