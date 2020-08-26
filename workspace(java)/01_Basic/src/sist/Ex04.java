package sist;

public class Ex04 {

	public static void main(String[] args) {
		
		// 1) 숫자 + 숫자 ==> 숫자(+의 역할은 덧셈의 역할)
		System.out.println(10 + 2);
		
		// 2) 문자 + 숫자 ==> 문자(+의 역할은 연결(결합)의 역할)
		System.out.println("10" + 2);
		
		// 3) 숫자 + 문자 ==> 문자(+의 역할은 연결(결합)의 역할)
		System.out.println(10 + "2");
		
		// 4) 문자 + 문자 ==> 문자(+의 역할은 연결(결합)의 역할)
		System.out.println("10" + "2");
		
		System.out.println("a >>> " + 10 + 2);
		
		System.out.println("a >>> " + (10 + 2));

	}

}
