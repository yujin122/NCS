package sist;

import javax.swing.*;

public class Ex12_JTable {

	public static void main(String[] args) {

		JFrame jf = new JFrame("JTable");

		// JTable은 컨테이너에 컴포넌트를 올리지 않고 바로 프레임에 올림
		String[] header = {"학생이름", "국어점수", "영어점수", "수학점수", "자바점수"};
		
		String[][] contents = {{"홍길동", "94", "96", "100", "90"},
								{"이순신", "87", "89", "98", "90"},
								{"유관순", "99", "97", "84", "90"},
								{"김연아", "76", "78", "80", "90"},
								{"강감찬", "87", "88", "78", "90"},
								{"세종대왕", "90", "89", "89", "90"},
								{"백종원", "91", "90", "98", "90"},
								{"유재석", "85", "91", "73", "90"},
								{"강호동", "76", "79", "95", "90"},
								{"김유신", "68", "91", "62", "90"}};
		
		JTable jt = new JTable(contents, header);
		
		// 스크롤 기능 추가
		JScrollPane jsp = new JScrollPane(
				jt, 	// 스크롤바가 보여질 컴포넌트
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,	// 수직 스크롤 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER		// 수평 스크롤
				);
		
		
		jf.add(jsp);
		jf.setResizable(false);
		jf.setBounds(100, 100, 300, 200);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
