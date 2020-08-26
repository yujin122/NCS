package sist;

public class Ex15 {

	public static void main(String[] args) {
		
		// 컴퓨터로부터 임의의 숫자를 입력을 받는다.
		// 형식) Math.random() * 마지막 값 + 시작 값
		int su = (int) (Math.random() * 6) + 1;

		if (su == 1) {
			System.out.println("1번이 나왔습니다.");
		} else if (su == 2) {
			System.out.println("2번이 나왔습니다.");
		} else if (su == 3) {
			System.out.println("3번이 나왔습니다.");
		} else if (su == 4) {
			System.out.println("4번이 나왔습니다.");
		} else if (su == 5) {
			System.out.println("5번이 나왔습니다.");
		} else {
			System.out.println("6번이 나왔습니다.");
		} 

	}

}
