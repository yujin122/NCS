package sist;

/*
 * 아래와 같이 출력을 해보자.
 * 
 * 	*****
 * 	*****
 * 	*****
 * 	*****
 * 
 * 	*
 * 	**
 * 	***
 * 	****
 * 	*****
 */
public class Ex37 {

	public static void main(String[] args) {

		for (int i = 1; i <= 4; i++) { // 행
			for (int j = 1; j <= 5; j++) { // 열
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
