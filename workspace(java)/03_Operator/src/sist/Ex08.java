package sist;

/*
 * 7. 쉬프트 연산자
 * 	 - 비트를 대상으로 왼쪽/오른쪽으로 비트를 밀어서 연산을 수행하는 연산자.
 * 	 - 왼쪽 쉬프트(<<) : 왼쪽으로 비트 수만큼 이동하라는 의미.
 * 					  오른쪽에 비어 있는 빈 칸은 0으로 채워준다.
 * 	 - 오른쪽 쉬프트(>>) : 오른쪽으로 비트 수만큼 이동하라는 의미.
 * 					   앞에 비어 있는 빈칸은 부호비트로 채워준다.
 * 	 - 오른쪽 쉬프트(>>>) : 오른쪽으로 비트 수만큼 이동하라는 의미.
 * 						앞에 비어 있는 빈칸은 0으로 채워준다.
 */

public class Ex08 {

	public static void main(String[] args) {
		
		int num1 = 10, num2 = 5;
		// 십진수를 이진수로 변환
		// num1 = 1010, num2 = 0101
		System.out.println(num2 << 3);
		System.out.println(num2 >> 1);
		
		

	}

}
