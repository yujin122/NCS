package method;

import java.util.*;

/*
 * 메서드(method)?
 * 1. C언어에서의 함수(function)과 같음.
 * 2. 기능을 정의하는 단위(예: 덧셈기능 등등)
 * 3. 하나의 기능만을 정의하는 것이 좋음.
 * 4. 자주 반복되는 내용을 정의해 놓고, 필요 시 호출하여 사용함.
 * 	   형식)
 * 			[접근제한] 변환명 메서드이름(매개변수 혹은 인자){
 * 				메서드 호출 시 실행될 문장;
 * 			}
 * 
 * 	   - 접근제한 : public > protected > default >private
 * 				 (클래스, 메스드, 변수 앞에 사용됨)
 * 				 - public : 누구나 다, 아무나 접근 가능.
 * 				 - protected : 같은 패키지 접근 가능. 다른 패키지는 상속 관계는 접근 가능
 * 				 - default : 같은 패키지에서만 접근 가능. 상속관계라도 접근 안 됨.
 * 				 - private : 외부에서 접근 불가.
 * 	   - 반환형 : - 메서드를 실행하고 특정 타입의 결과를 반환해 주겠다고 선언하는 것을 반환형(리턴타입)이라고 함.
 * 				- 메서드에서 실행된 결과값을 돌려주는 자료형으로 생략이 불가능함.
 * 				- 해당 메서드가 어떤 동작이나 기능을 실행한 후 결과를 알려주는 자료형
 * 				- 메서드를 호출한 곳으로 결과를 되돌려 줄 때 사용하는 자료형.
 * 				- 만약 결과를 되돌려 줄 필요가 없는 경우에는 void 라는 키워드를 작성함.
 * 				- 반환형이 void인 경우를 제외하고 결과를 되돌려주어야 할 때는 메서드 명령문 맨 마지막에 return
 *				    이라는 키워드를 사용 후, 앞에서 선언한 반환형과 같은 자료형으로 결과를 되롤려준다.
 *		- 메서드이름 : - 식별자, 소문자로 시작, 두 개의 단어가 결합된 경우에는 두번째 
 *					  글자의 첫 글자를 대문자로 작성하는 것이 관례임.
 * 		- 매개변수 : - 외부에서 값을 넘겨 받는 변수. 생략 가능.
 * 				   - 메서드 호출 시 전달되는 값의 저장을 위한 용도로 사용 됨.
 * 				   - 메스드 호출 시 전달되는 값의 자료형과 매개변수의 자료형은 반드시 일치해야 함.
 * 		- 메서드 실행문 : 해당 메서드가 호출된 경우에만 실행이 됨.
 */	

 
public class Ex01 {

	public static void add() {
		System.out.println("add() 메서드 호출 ~~~ ");
		System.out.println("10 + 20 >>> " + (10+20));
	}
	
	// 키보드로 정수 3개를 배열에 저장 후 출력하는 메서드 
	public static void input() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		System.out.println("정수 3개를 입력하세요.");
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr["+i+"] >>> " + arr[i]);
		}
		
		sc.close();
	}
	
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		// 메서드 호출
		add();
		input();
		
		System.out.println("프로그램 종료");
	}
	
	

}
