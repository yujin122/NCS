package sist;

public class Ex04 {

	public static void main(String[] args) {
		
		// 단일 문자형 : char형(0~65536) ==> 2byte
		// 자바에서는 유니코드 체계로 단일문자가 처리가 된다.
		// ==> C언어에서는 ASCII 코드 체계로 처리가 된다.
		
		char ch1 = '강';
		System.out.println("ch1 >>> " + ch1);
		
		char ch2 = 'A';
		System.out.println("ch2 >> " + ch2);
		
		System.out.println(ch2 + 1); //66 값이 나타남.
		System.out.println((char)(ch2 + 1));
		
		
		
	}

}
