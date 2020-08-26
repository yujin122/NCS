package sist;

/*
 * 5. 배정연산자 / 단축배정연산자
 * 	- 배정연산자
 * 	  형식) 변수 = 변수 or 값 or 수식;
 * 	 - 좌변에는 항상 변수명이 온다.
 * 	 - 우변에는 숫자(리터럴), 변수명, 수식이 온다.
 * 	- 단축배정연산자
 * 	 - 배정연산자를 간편하게 사용하는 연산자.
 */
public class Ex06 {

	public static void main(String[] args) {
		
		// 배정연산자
		// 변수 = 숫자(리터럴)
		int su1 = 10, su2 = 27, result=0;
		
		// 변수 = 변수
		su1 = su2;
		
		// 변수 = 수식
		su1 = su2 + 27;
		
		System.out.println("su1 >>> " + su1);
		System.out.println();
		
		//result = result + su2; // result : 누적변수
		result += su2; // 단축배정연산자
		
		int su = 15;
		
		//su = su + 5
		System.out.println("su >>> " + (su += 5));
		//su = su - 5
		System.out.println("su >>> " + (su -= 5));
		//su = su * 5
		System.out.println("su >>> " + (su *= 5));
		//su = su / 5
		System.out.println("su >>> " + (su /= 5));
		//su = su % 5
		System.out.println("su >>> " + (su %= 5));
	}

}
