package sist;

import javax.swing.JOptionPane;

/*
 * 키보드로 입력받은 정수값이 5로 나누어 떨어지면 
 * "이 값은 5로 나누어집니다." 라고 출력해보세요
 */
public class Ex04 {

	public static void main(String[] args) {

		System.out.println("프로그램 시작");

		int su = Integer.parseInt(JOptionPane.showInputDialog("정수를 입력하세요"));

		if (su % 5 == 0) {
			System.out.println("입력받은 " + su + "는 5로 나누어집니다.");
		}

		System.out.println("프로그램 종료");
	}

}
