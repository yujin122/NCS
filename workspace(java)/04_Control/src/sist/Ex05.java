package sist;

import javax.swing.JOptionPane;

/*
 * [문제] 키보드로 점수를 입력받아서 입력받은 점수가 60점 이상이면 "합격" 이라는 문자열을 화면에 출력해 보세요/
 */

public class Ex05 {

	public static void main(String[] args) {
			
		int score = Integer.parseInt(JOptionPane.showInputDialog("점수를 입력해주세요."));
		
		if(score >= 60) {
			System.out.println("합격");
		}
	}

}
