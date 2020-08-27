package sist;

/*
 * .2. 반복문
 * 	- 반복해서 실행할 때 사용한다.
 * 	- 반복문의 종료 : while문, do~while문, for문
 * 
 * 	* while 반복문
 * 		- 조건식을 비교하여 참인 경우 계속해서 반복 실행문을 실행하고, 조건식이 거짓인 경우에는 반복문을 빠져 나감.
 * 		- while 반복문은 반복문의 횟수를 알 수 없는 경우에 많이 사용함.
 * 		- 반복문에는 반드시 초기식, 조건식, 증감식이 있어야 함.
 * 		  형식)
 * 				while(조건식){
 * 					반복 실행문;
 * 				}
 * 
 * 	* dp ~ while 반복문
 * 		- 먼저 반복 실행문을 실행하고 조건식을 비교함.
 * 		- 한 번 이상 반복 실행문이 실행되어야 하는 경우에 사용함.
 * 		  형식)
 * 				do{
 * 					반복 실행문;
 * 				}while(조건식);
 */
public class Ex25 {

	public static void main(String[] args) {

		System.out.println("num >>> " + 1);
		System.out.println("num >>> " + 2);
		System.out.println("num >>> " + 3);
		System.out.println("num >>> " + 4);
		System.out.println("num >>> " + 5);
		System.out.println("num >>> " + 6);
		System.out.println("num >>> " + 7);
		System.out.println("num >>> " + 8);
		System.out.println("num >>> " + 9);
		System.out.println("num >>> " + 10);
		System.out.println();

		// while 반복문을 이용하여 1 ~ 10까지 출력해 보자.
		int num = 1; // 반복문에서 초기식

		while (num <= 10) { // 반복문에서 조건식
			System.out.println("num >>> " + num);
			num++; 			// 반복문에서 증감식
		}
		System.out.println();
		
		//do ~ while 반복문을 이용하여 1 ~ 10까지 출력해 보자
		int su = 1;
		
		do {
			System.out.println("su >>> "+su);
			su++;
		}while(su <= 10);
		
	}

}
