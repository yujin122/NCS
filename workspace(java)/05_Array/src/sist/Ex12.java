package sist;

/*
 * 다차원배열의 가변배열
 * -java의 다차원 배열은 행마다 서로 다른 열을 가질 수 있다.
 * 	행의 크기를 먼저 정해 놓고, 열의 크기는 가변적으로 할당하는 배열
 * - 가변 배열 : 행마다 열의 크기를 다르게 설정하는 배열.
 * - 가변 배열 사용하는 이유 : 메모리 손실을 최소화시켜 주기 위함.
 */
public class Ex12 {

	public static void main(String[] args) {
		
		// 1. 다차원 배열의 가변배열 선언 및 메모리 생성.
		int[][] arr = new int[4][];
		
		// 2. 가변 배열의 열 메모리 생성
		arr[0] = new int[3];	// 1행 3열
		arr[1] = new int[2];	// 2행 2열
		arr[2] = new int[1];	// 3행 1열
		arr[3] = new int[4];	// 4행 3열
		
		// 3. 가변 배열에 초기값 할당
		int count = 10;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = count;
				count = count+10;
			}
		}
		
		// 4. 가변 배열에 저장된 데이터를 출력해 보자.
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}
