package sist;

import javax.swing.JOptionPane;

/*
 * [문제1] 키보드로 점수를 입력받아서 입력받은 점수가
 * 		 60점 이상이면 "합격" 이라는 문자열을 
 * 		 화면에 출력하고, 그렇지 않으면 "불합격" 이라는 
 * 		 문자열을 화면에 출력해 보세요.
 * [문제2] 키보드로 입력받은 숫자가 홀수인지 짝수인지 판별해 보세요
 */


public class Ex11 {
	public static void main(String[] args) {

		System.out.println("[문제1]");

		int score = Integer.parseInt(JOptionPane.showInputDialog("점수를 입력해주세요."));

		if (score > 60) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
		System.out.println();

		System.out.println("[문제2]");
		
		int num = Integer.parseInt(JOptionPane.showInputDialog("정수를 입력해주세요."));
		
		if (num % 2 == 0) {
			System.out.println("짝수입니다.");
		} else {
			System.out.println("홀수입니다.");
		}

	}

}
