package method;

/*
 * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
 * 메서드 호출 방식 - 2가지
 * 
 * 1. call by value
 * 		- 값을 전달하여 호출하는 방식.
 * 		- 매개변수가 기본자료형(int, float, ...) 사용.
 * 
 * 2. call by reference 
 * 		- 주소값을 전달하여 호출하는 방식.
 * 		- 매개변수가 참조자료형(배열명, 클래스명) 사용.
 * ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
 */ 

public class Ex05 {

	public static void call(int x) {
		System.out.println("call() 메서드 호출...");
		x = 100; 
	}
	
	public static void main(String[] args) {
		
		// call by value
		int num = 200;
		System.out.println("메서드 호출 전...");	
		System.out.println("num >>> " + num);	//	num >>> 200
		
		call(num);
		System.out.println("메서드 호출 후...");
		System.out.println("num >>> " + num);	//	num >>> 100(X)

	}

}
