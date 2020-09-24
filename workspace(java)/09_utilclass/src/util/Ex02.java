package util;

/*
 *  2. Math 클래스 - java.lang 패키지에 있는 클래스
 *  	- 수학과 관련된 메서드를 제공해 주는 클래스
 */
public class Ex02 {

	public static void main(String[] args) {
		
		// 1. max() : 최대값을 구하는 메서드. - 두 수를 비교
		//	  min() : 최소값을 구하는 메서드. - 두 수를 비교
		int num1 = 57, num2 = 41;
		System.out.println("최대값 >>> " + Math.max(num1, num2));
		System.out.println("최소값 >>> " + Math.min(num1, num2));
		System.out.println();
		
		// 2. round() : 반올림이 적용되는 메서드
		System.out.println(123.5124);
		System.out.println(Math.round(123.5124));
		System.out.println();
		
		// 3. abs() : 절대값을 구하는 메서드
		System.out.println("abs >>> " + Math.abs(-54.2));
		System.out.println();
		
		// 4. ceil() : 무조건 올림을 해주는 메서드
		System.out.println("ceil >>> " + Math.ceil(57.365));
		System.out.println();
		
		
	}

}
