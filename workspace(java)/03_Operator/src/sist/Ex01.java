package sist;

/*
 * 연산 : 주어진 식을 계산하여 결과를 얻어내는 과정.
 *  - 피연산자 : 연산자의 작업 대상 (예 20 + 10)
 *  - java에서의 연산자의 종류
 * 	  1. 산술연산자
 * 	  2. 관계연산자(비교연산자)
 * 	  3. 논리연산자
 * 	  4. 단항연산자 / 3항연산자
 * 	  5. 배정연산자 / 단축배정연산자
 * 	  6. 비트연산자
 * 	  7. 쉬프트연산자 
 */

/*
 * 1. 산술연산자
 * 	- 덧셈(+), 뺄셈(-), 곱셈(*), 나눗셈(/), 나머지(%)
 */
public class Ex01 {

	public static void main(String[] args) {
		
		// 같은 자료형의 경우 ,로 구분해서 한 줄로 나열해도 된다.
		int su1 = 10, su2 = 3, result;
		
		// 덧셈연산		
		result = su1 + su2;
		System.out.println("덧셈결과 >>> " + result);
		System.out.println(); //빈 줄 생성
		
		// 뺄셈연산
		result = su1 - su2;
		System.out.println("뺄셈 결과 >>> " + result);
		System.out.println();
		
		// 곱셈연산
		result = su1 * su2;
		System.out.println("곱셈 결과 >>> " + result);
		System.out.println();
		
		// 나눗셈연산
		result = su1 / su2;
		System.out.println("나눗셈 결과(몫) >>> " + result);
		System.out.println();
		
		// 나머지연산
		result = su1 % su2;
		System.out.println("나머지 결과 >>> " + result);
		System.out.println();
		
		
		
			
	}

}
