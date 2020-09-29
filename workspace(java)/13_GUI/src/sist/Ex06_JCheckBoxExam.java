package sist;

import javax.swing.*;

public class Ex06_JCheckBoxExam {

	public static void main(String[] args) {

		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("과일 체크박스 예제");
		
		// 1-1. 과일 이미지 아이콘을 만들자.
		ImageIcon apple = new ImageIcon("images/apple.jpg");
		ImageIcon mango = new ImageIcon("images/mango.jpg");
		ImageIcon kiwi = new ImageIcon("images/kiwi.jpg");
		
		// 1-2. 컴포넌트를 만들자
		JCheckBoxMenuItem jcb1 = new JCheckBoxMenuItem("사과", apple);
		JCheckBoxMenuItem jcb2 = new JCheckBoxMenuItem("망고", mango);
		JCheckBoxMenuItem jcb3 = new JCheckBoxMenuItem("키위", kiwi);
		
		// 2. 컴포넌트를 컨테이너에 올리기		
		jp.add(jcb1); jp.add(jcb2); jp.add(jcb3);
		
		// 3. 컨테이너를 프레임에 올리기
		jf.add(jp);
		
		jf.setBounds(100,100,400,600);
		
		// 프레임의 크기를 고정시키는 메서드
		jf.setResizable(false);
		
		// 프레임의 x버튼을 클릭 시 종료시키는 메서드
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jf.setVisible(true);
		
		
		
		
	}

}
