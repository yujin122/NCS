package sist;

// 1 ~ 100까지 홀수의 합과 짝수의 합을 구해보자.
public class Ex27 {

	public static void main(String[] args) {

		int num = 1;	// 반복문에서 초기식
		int odd = 0, even = 0; // 홀수의 합 누적변수, 짝수의 합 누적변수

		while (num <= 100) {
			if (num % 2 == 0) {
				even += num;	// 짝수의 합
			} else {
				odd += num;		// 홀수의 합
			}
			num++;	// 반복문에서 증감식
		} // while 반복문 end

		System.out.println("짝수의 합 >>> " + even);
		System.out.println("홀수의 합 >>> " + odd);
		System.out.println();
		
		// ABCKEFGHIJKLMN...XYZ 문자를 출력해 보자.
		char alpha = 'A'; // 반복문에서 초기식
		
		while(alpha <= 'Z') {
			System.out.print(alpha);
			alpha++;
		}
		System.out.println();
		System.out.println();
		
		// ZYXWV...CBA
		char alpha1='Z';
		
		while(alpha1 >= 'A') {
			System.out.print(alpha1);
			alpha1--;
		}
		
		
	}

}
