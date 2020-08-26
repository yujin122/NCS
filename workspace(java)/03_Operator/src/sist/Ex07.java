package sist;

/*
 * 6. 비트연산자
 * 	  - 비트(0,1)를 이용하여 연산하는 연산자.
 * 	  - &(and) : 두 비트의 조건이 참(1)인 경우 1을 반환, 그 외에는 0을 반환한다.
 * 	  - |(or) : 두 비트 중 하나만 조건이 참인 경우 1을 반환하고, 그 외에는 0을 반환한다.
 * 	  - ^(xor) : 두 비트 중 서로 다른경우에만 1을 반환하고, 그 외에는 0을 반환한다.
 */
public class Ex07 {

	public static void main(String[] args) {
		
		// 십진수
		int num1 = 10, num2 = 5;
		// 십진수를 이진수로 변환
		// num1 = 1010, num2 = 0101

		// and 연산
		int result = num1 & num2; // 1010 & 0101 ==> 0000
		System.out.println("and result >>> " + result);

		// or 연산
		result = num1 | num2; // 1010 & 0101 ==> 1111
		System.out.println("or result >>> " + result);

		// xor 연산
		num2 = 8;
		result = num1 ^ num2; // 1010 & 1000 ==>
		System.out.println("xor result >>> " + result);

	}

}
