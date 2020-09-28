package wrapper;

/*
 * wrapper class
 * - wrap : 감싸다, 포장하다
 * - 기본자료형을 클래스 타입으로 포장해 놓은 클래스
 * - 기본자료형보다 객체로 저장하기 때문에 좀 더 다양한 기능을 제공하기 위해 사용함
 * - 기본 타입의 값울 내부에 두고 포장하기 때문에 포장(wrapper) 객체라고 함
 * - 기본자료형 : byte, short, long, float, double, boolean, char, int
 * - wrapper class : Byte, Short, Long, Float, Double, Boolean, Character, Integer
 * - wrapper class 사용 이유
 * 	 1. 매개변수로 객체가 요구될 때
 * 	 2. 기본형 값이 아닌 객체로 저장해야 될 때
 * 	 3. 객체간 비교가 필요할 때
 * 	 wrapper class 사용하는 더 중요한 이유 : 형변환이 자유롭다는 특징이 있음
 */

public class Ex01 {

	public static void main(String[] args) {
		// 기본자료형은 단순한 연산을 위한 용도로 사용됨
		int su1 = 100, su2 = 46;
		System.out.println("더하기 : " + (su1 + su2));

		// 박싱(boxing) : 기본자료형 -> 클래스형
		// 언박싱(unboxing) : 클래스형 -> 기본자료형
		Integer in = new Integer(su1);	// 박싱
		
		System.out.println(in + 35);
		
		Integer in1 = new Integer(100);
		System.out.println("in.equals(in1) : " + in.equals(in1));
		
		System.out.println("int형 : " + in1.intValue());	// 언박싱
		System.out.println("float형 : " + in1.floatValue());
		
		// 숫자 -> 문자열 : toString()
		// 숫자 -> 문자열 : String.valueOf(숫자)
		System.out.println("숫자 - > 문자열  : " + (in1.toString()+38));
		System.out.println("숫자 - > 문자열  : " + (String.valueOf(in1) + 38));
		
		// 문자열 -> 숫자 : parseInt()
		System.out.println("문자열 -> 숫자 : " + Integer.parseInt(in1.toString()+47));
		
		
		
		
		
	}

}
