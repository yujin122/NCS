package sist;

public class Ex03 {

	public static void main(String[] args) {
		
		/*
		 * 실수형 : 소숫점이 존재함. ==> float < double (기본형)
		 *  - float : 소수점 이하 7(6)자리까지 표현이 가능함.
		 *  - double : 소수점 이하 15~16 자리까지 표현이 가능함.
		 *  - float 자료형 선언시에는 반드시 실수 값 뒤에 f를 붙여주어야 함.(생략하면 error)
		 *  - f를 안 붙이면 오류가 발생하는 이유 ==> 실수형의 기본 자료형은 double형이기 때문.
		 *  - 실수 자료형에서 명시적 형변환을 진행하면 거의 자료의 손실이 발생하지 않음.
		 */
		float fNum = 12.457f;
		
		System.out.println("fNum >>> "+ fNum);
		
		
	}

}
