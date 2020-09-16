package method;

public class Ex08 {
	
	// 반환되는 값이 리터럴 상수가 반환되는 경우
	public static int method1() {
		return 100;
	}
	
	// 반환되는 값이 변수가 반환이 되는 경우
	public static int method2(int x,int y) {
		int sum =(x*2)+(y*2);
		return sum;
	}
	
	//반환되는 값이 수식이 반환되는 경우
	public static int method3(int a,int b) {
		return a + b;
	}
	
	// 반환되는 값이 문자열이 반환되는 경우
	public static String method4() {
		return "홍길동";
	}
	
	// 반환되는 값이 문자열 변수가 반환되는 경우
	public static String method5(String str1, String str2) {
		String result = str1+str2;
		return result;
	}
	 
	// 반환되는 값이 문자열 결합이 반환되는 경우
	public static String method6(String s1, String s2) {
		return s1+s2;
	}
	
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		//int su = method1();
		System.out.println("method1() 호출 후 반환된 값 >>> "+ method1());
		System.out.println("method2() 호출 후 반환된 값 >>> " + method2(135,200));
		System.out.println("method3() 호출 후 반환된 값 >>> " + method3(132,55));
		System.out.println("method4() 호출 후 반환된 값 >>> " + method4());
		System.out.println("method5() 호출 후 반환된 값 >>> " + method5("대한","민국"));
		System.out.println("method6() 호출 후 반환된 값 >>> " + method6("유","관순"));

		System.out.println("프로그램 종료");
		
	}
}
