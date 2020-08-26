package sist;

/*
 * if~else - 조건문
 * 	- 조건식이 true이면 조건식이 참인 경우 실행문을 실행하고 if~else문을 빠져나옴.
 * 	- 조건식이 false이면 조건식이 거짓인 경우 실행문을 실행하고 if~else문을 빠져나옴.
 * 	  형식)
 * 			if(조건식){
 * 				조건식이 참인 경우 실행문;
 * 			}else{
 * 				조건식이 거짓인 경우 실행문;
 * 			}
 */

public class Ex06 {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		int su = 47;
		
		if(su >= 50) {
			// 조건식이 참인 경우 실행문
			System.out.println("입력받은 수는 50 이상의 숫자 입니다.");
		}else {
			// 조건식이 거짓인 경우 실행문
			System.out.println("입력받은 수는 50 이하의 숫자 입니다.");
		}
		
		System.out.println("프로그램 종료");

	}

}
