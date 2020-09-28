package generic;

/*
 * 제네릭(generic)?
 * - 포괄적, 총괄적인
 * - 특정한 클래스에 원하는 객체 타입을 지정하여 지정된
 * 	  객체만 저장하게 되는 하는 자바 문법
 * 	  다양한 타입의 객체들을 다루는 메서드나 다음에 학습할
 * 	  컬렉션에서 컴파일 할 때 타입을 확인해 주는 기능.
 * 	 => 즉, 다루어질 객체의 타입을 미리 명시함으로써
 * 		번거로운 형변환을 줄여 준다는 장점이 있음.
 * - jdk 1.5 에서부터 추가된 기능.
 * - 클래스 내부에서 사용할 데이터를 외부에서 지정하는 방법
 * - 데이터의 명확성과 안정성을 보장해 줌
 * 	 => 다른 데이터 타입의 데이터가 들어올 경우 컴파일 시점에서
 * 		error 발생
 */

class Generic<T>{
	T[] str;
	T var;
	
	void setArr(T[] str) {
		this.str = str;
	}
	
	void setVar(T var) {
		this.var = var;
	}
	
	void prn() {
		for(T k : str) {
			System.out.println("str 배열 요소 : " + k);
		}
		System.out.println("var " + var);
	}
}

public class Ex02 {

	public static void main(String[] args) {
		
		// String 타입의 클래스 작성
		Generic<String> st = new Generic<String>();
		
		String[] str = {"홍길동", "이순신", "유관순"};
		String var = "김연아";
		
		st.setArr(str);
		st.setVar(var);
		st.prn();
		System.out.println();
		
		// Integer 타입의 클래스 작성
		Generic<Integer> it = new Generic<Integer>();
		
		Integer[] iarr = {100, 200, 300};
		Integer ivar = 500;
		
		it.setArr(iarr);
		it.setVar(ivar);
		it.prn();
		
		
		
		
		
		
		
		
		
		
	}

}