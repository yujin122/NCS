package sist;

// 다중 for문을 이용하여 구구단을 화면에 출력해 보자.

public class Ex36 {

	public static void main(String[] args) {

		for (int i = 2; i <= 9; i++) { // 고정 ==> 구구단에서의 단
			System.out.println("*** " + i + "단 ***");

			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d X %d = %2d\n", i, j, i * j);
			}

			System.out.println();
		}
		System.out.println();

		for (int i = 2; i <= 9; i++) {
			System.out.print("*** " + i + "단 ***\t");
		}

		System.out.println();
		for (int i = 1; i <= 9; i++) { // 고정 ==> 구구단에서의 단
			// System.out.println("*** " + i + "단 ***");

			for (int j = 2; j <= 9; j++) {
				System.out.printf("%d X %d = %2d\t", j, i, i * j);
			}

			System.out.println();
		}

	}

}
