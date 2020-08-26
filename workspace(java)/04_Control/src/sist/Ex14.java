package sist;

import javax.swing.JOptionPane;

/*
 * 학생 성적 처리
 * 이름, 국어, 영어, 수학, 자바 점수를
 * 키보드로 입력받아서 총점, 평균, 학점까지 출력해보자.
 */
public class Ex14 {

	public static void main(String[] args) {

		// 1. 키보드로 이름과 점수 입력받기.
		String name = JOptionPane.showInputDialog("이름을 입력하세요.");

		int kor = Integer.parseInt(JOptionPane.showInputDialog("국어 점수을 입력하세요."));
		int eng = Integer.parseInt(JOptionPane.showInputDialog("영어 점수을 입력하세요."));
		int mat = Integer.parseInt(JOptionPane.showInputDialog("수학 점수을 입력하세요."));
		int java = Integer.parseInt(JOptionPane.showInputDialog("자바 점수을 입력하세요."));

		// 2. 총점을 구하자
		int total = kor + eng + mat + java;

		// 3. 평균을 구하자.
		float avg = total / 4.0f;

		// 4. 학점을 구하자.
		String grade; // 학점변수

		if (avg >= 90) {
			grade = "A학점";
		} else if (avg >= 80) {
			grade = "B학점";
		} else if (avg >= 70) {
			grade = "C학점";
		} else if (avg >= 60) {
			grade = "D학점";
		} else {
			grade = "F학점";
		} 

		// 5. 성적을 화면에 출력.
		System.out.println("이     름 : " + name);
		System.out.println("국어점수 : " + kor + "점");
		System.out.println("영어점수 : " + eng + "점");
		System.out.println("수학점수: " + mat + "점");
		System.out.println("자바점수 : " + java + "점");
		System.out.println("총     점 : " + total + "점");
		System.out.printf("평     균 : %.2f점\n", avg);
		System.out.println("학     점 : " + grade);

	}

}
