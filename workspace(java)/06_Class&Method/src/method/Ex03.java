package method;
 
/*
 * 매개변수가 있는 메서드 정의
 * 형식)
 * 		[접근제한] 반환형 메서드이름(type 변수1, type 변수2, ...) {
 * 			메서드 호출 시 실행문;
 * 		}
 * 
 * - 실인수와 가인수
 * 	* 실인수 : 매개변수에 전달할 실제 값 ==> 메서드를 호출할 때 사용함.
 * 	* 가인수 : 매개변수 ==> 메서드에 정의.
 * 	* 실인수와 가인수는 반드시 type, 순서, 갯수가 일치해야 함(중요함).
 */

public class Ex03 {

	public static void prn() {
		System.out.println("prn() 메서드가 호출되었습니다.");
	}
	
	public static void tot(int su) {		
		System.out.println("x >>> " + su);
		
		
	}
	
	public static void total(int start, int end) {
		int sum = 0;
		
		for(int i = start;i<=end;i++) {
			sum +=i;
		}
		
		System.out.println(start+"~"+end+"까지의 합 : " + sum);
	}
	
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		prn();
		System.out.println();
		tot(150);
		System.out.println();
		total(1,100);
		System.out.println();
		total(1,500);
		System.out.println();
		
		System.out.println("프로그램 종료");
		
	}

}
