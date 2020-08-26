package sist;

/*
 * 4. 이항연산자 /단항연산자 / 3항연산자
 * 	- 이항연산자 : 2개의 항을 대상으로 연산을 수행하는 것이다.
 * 	- 단항연산자 : 1개의 항을 대상으로 연산을 수행하는 것이다.
 * 	- 3항연산자 : 3개의 항을 대상으로 연산을 수행하는 것이다.
 */

public class Ex04 {

	public static void main(String[] args) {
		
		// 단항연산자 (++, --)
		int su1 = 10, su2 = 10;
		
		System.out.println("su1 >>> " + su1++);
		System.out.println("su2 >>> " + ++su2);
		System.out.println();
		
		/*
		 * 단항연산자(++, --)
		 * 	- 전위연산자 : 연산자가 변수명 앞에 온다.(++su2)
		 * 				변수의 값을 하나 증가 또는 감소 시킨 후 출력한다.
		 * 	- 후위연산자 : 연산자가 변수명 뒤에 온다.(su1++)
		 * 				변수의 값을 출력 후 값을 하나 증가 또는 감소시킨다.
		 */
		
		int su3 = 10, su4 = 20;
		
		System.out.println(++su3 + su4++); // 31
		System.out.println((++su3 % 3) + (su3 * ++su4)); // 12%3 0  12 * 22 264
		System.out.println();
		
		/*
		 * 3항연산자
		 * 	형식)
		 * 		(조건) ? 수식1 :수식2;
		 * 			  ==> 수식1 : 해당 조건이 참인 경우 실행문장.
		 * 			  ==> 수식2 : 해당 조건이 거짓인 경우 실행 문장.
		 * 	- 간단한 조건문 대신에 사용할 수 있는 연산자.
		 */
		
		int num1 = 45, num2 = 23;
		
		String result = (num1 > num2) ? "num1 값이 크다" : "num2 값이 크다";
		System.out.println(result);
		System.out.println();
		
		// 데이터베이스와 연결
		//키보드로 데이터를 입력 받자.
		
		String id = args[0];
		String pwd = args[1];
		
		String login = (id.equals("hong")) && (pwd.equals("1234")) ? "로그인 성공" : "로그인 실패";
		
		System.out.println("로그인 결과 : " + login);

	}

}
