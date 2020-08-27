package sist;

/*
 * [문제1] for문을 이용하여 1 ~ 100까지의 홀수의 합과 짝수의 합을 구하시오.
 */

public class Ex33 {

	public static void main(String[] args) {

		int odd = 0, even = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				even += i;
			} else {
				odd += i;
			}
		}
		
		System.out.println("홀수의 합 >>> " + odd);
		System.out.println("짝수의 합 >>> " + even);
	}

}
