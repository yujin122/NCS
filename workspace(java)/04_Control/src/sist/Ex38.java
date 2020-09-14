package sist;

/*
 * 3. 기타(보조 제어문)
 * - break 명령어
 * - 현재의 제어문을 빠져 나가는 명령어.
 * - 보통 switch~case문과 반복문에서 사용됨.
 * - if문을 제외한 첫번째 블럭에서 빠져나오는 명령어.
 */

public class Ex38 {

	public static void main(String[] args) {
		// 반복문에서 break 예제
		for (int i = 1; i <=100; i++) {
			if (i > 20) {
				break;
			}
			System.out.println("i >>> " + i);
		}
		System.out.println();
		
		// 1~100까지의 합을 구하는데 합이 100이 되는 순간
		// 그 순간의 합과 숫자를 화면에 출력해 보자.
				
		int sum=0, i;
		for(i = 1;i<=100;i++) {
			sum+=i;
			if(sum>= 100) {
				break;
			}
		}
		System.out.println("sum >>>  " + sum);
		System.out.println("i >>> " + i);
	

	}

}
