package sist;

import java.awt.FlowLayout;

import javax.swing.*;

/*
 * 배치관리자(Layout)?
 * - 화면에 컴포넌트들을 배치하는 방법을 알려 주는 관리자
 * - 대표적인 배치관리자의 종류 
 * 	 1) FlowLayout
 * 	 2) BorderLayout
 * 	 3) GridLayout
 * 	 4) CardLayout
 */

/*
 * 1. FlowLayout 배치관리자
 * 	  - 배치 : 좌 -> 우
 * 	  - 상단 중앙에 컴포넌트를 배치 한다.
 * 	  - 화면이 넘칠 경우 바로 아래 중앙에 배치된다.
 * 	  - 배치관리자를 지정하지 않을 경우 default로 
 * 		FlowLayout 배치관리자로 배치를 한다.
 */

public class Ex16_FlowLayout {

	public static void main(String[] args) {
		
		JFrame jf = new JFrame("FlowLayout 배치관리자");
		
		JPanel jp = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자
		JButton jb1 = new JButton("버튼 1");
		JButton jb2 = new JButton("버튼 2");
		JButton jb3 = new JButton("버튼 3");
		JButton jb4 = new JButton("버튼 4");

		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		// 형식) new FlowLayout(컴퓨넌트 정렬방법(왼쪽, 오른쪽, 중앙), 수평간격, 수직간격)
		//		수평간격 : 좌우 컴포넌트 사이의 간격. 픽셀단위, 기본값 5
		//		수직간격 : 상하 컴포넌트 사이의 간격. 픽셀단위, 기본값 5
		jp.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		jp.add(jb1);	jp.add(jb2);
		jp.add(jb3);	jp.add(jb4);
		
		// 3. 컨테이너를 프레임에 올려야 한다.
		jf.add(jp);
		jf.setBounds(200, 200, 300, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		
		
		
	}

}
