package sist;

import javax.swing.*;

public class Ex07_JRadioButton {

	public static void main(String[] args) {
		
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("JRadioButton 예제");
		
		JRadioButton jrb1 = new JRadioButton("게임");
		JRadioButton jrb2 = new JRadioButton("영화감상");
		JRadioButton jrb3 = new JRadioButton("운동");
		JRadioButton jrb4 = new JRadioButton("잠자기");
		
		// 라디오버튼은 반드시 ButtonGroup에 올려져야 한다.
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1); bg.add(jrb2);
		bg.add(jrb3); bg.add(jrb4); 
		
		jp.add(jrb1); jp.add(jrb2);
		jp.add(jrb3); jp.add(jrb4);
		
		jf.add(jp);
		
		jf.setBounds(100, 100, 300, 300);
		jf.setVisible(true);
			
	}

}
