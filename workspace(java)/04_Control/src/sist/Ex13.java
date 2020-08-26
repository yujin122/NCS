package sist;

public class Ex13 {

	public static void main(String[] args) {

		// 임의의 점수를 키보드로부터 입력을 받자.
		int jumsu = Integer.parseInt(args[0]);

		if (jumsu >= 90) {
			if (jumsu >= 95) {
				System.out.println("A+학점입니다.");
			} else {
				System.out.println("A학점입니다.");
			}
		} else if (jumsu >= 80) {
			System.out.println("B학점입니다.");
		} else if (jumsu >= 70) {
			System.out.println("C학점입니다.");
		} else if (jumsu >= 60) {
			System.out.println("D학점입니다.");
		} else {
			System.out.println("F학점입니다.");
		}
	} 
}
