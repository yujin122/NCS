package sist;

/*
 *  2. 배열의 초기값을 이용하여 배열 생성.
 */
public class Ex04 {

	public static void main(String[] args) {
		
		// 배열을 생성함과 동시에 초기값을 설정
		int[] arr = {10, 20, 30, 40, 50};
		
		int[] num;	// 배열선언

		num = new int[5];	// 배열 메모리 생성

		// 배열 초기화
		num[0] = 10;
		num[1] = 20;
		num[2] = 30;
		num[3] = 40;
		num[4] = 50;
		
		for(int i : num){
			System.out.println("배열 num의 원소 : " + i);
		}
		
		System.out.println("num 배열의 크기 : " + num.length);

		
	}

}
