package sist;


// 키보드로 입력 받은 정수 값이 음수이면 음수라고 화면에 출력해보자
public class Ex03 {

	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		// 1.키보드로 정수를 입력을 받자
		int num = Integer.parseInt(args[0]);
				
		if(num < 0) { // 음수 값인가 물어봄
			System.out.println("입력받은 수는 음수입니다.");
		}
		
		System.out.println("프로그램 종료");
	
	}

}
