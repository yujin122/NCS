package sist;

import java.awt.Color;

import javax.swing.*;

public class Ex04_JButton {

	public static void main(String[] args) {
		
		// 1. 프레임 만들기!
		JFrame jf = new JFrame("JButton 예제");
		
		// 2. 컨테이너 만들기!
		JPanel jp = new JPanel();
		
		// 배경색 지정!
		jp.setBackground(Color.YELLOW);
		
		// 이미지 아이콘 컴포넌트를 만들어 보자
		ImageIcon cheey = new ImageIcon("images/cherry.jpg");
		
		// 3. 컴포넌트 만들기!
		JButton jb1 = new JButton("버튼1");
		JButton jb2 = new JButton("버튼2");
		JButton jb3 = new JButton("버튼3");
		JButton jb4 = new JButton(cheey);

		jp.add(jb1);
		jp.add(jb2);
		jp.add(jb3);
		jp.add(jb4);
		
		// 버튼을 비활성화 시키는 방법
		jb3.setEnabled(false);
		//jb3.setVisible(false);
		
		// 프레임에 컨테이너 올리기!
		jf.add(jp);
		
		jf.setBounds(100, 100, 300, 300);
		jf.setVisible(true);
		
		
		
	}

}
