package sist;

import java.util.Scanner;

// [문제] 키보드로 입력 받은 수까지의 홀수의 합과
//		짝수의 합을 구하여 화면에 출력해 보세요.
public class Ex28 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int init = 1;
		int odd = 0, even = 0;

		System.out.print("숫자를 입력하세요. : ");
		int num = sc.nextInt();

		while (init <= num) {
			if (init % 2 == 0) {
				even += init;
			} else {
				odd += init;
			}
			init++;
		}

		System.out.println("홀수의 합 >>> " + odd);
		System.out.println("짝수의 합 >> " + even);
		
		sc.close();
	}

}
