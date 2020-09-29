package sist;

import javax.swing.*;

public class Ex08_JToggleButton {

	public static void main(String[] args) {

		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("JToggleButton 예제");
		
		JToggleButton jtb1 = new JToggleButton("토글버튼1");
		JToggleButton jtb2 = new JToggleButton("토글버튼2");
		JToggleButton jtb3 = new JToggleButton("토글버튼3");
		
		jp.add(jtb1);
		jp.add(jtb2);
		jp.add(jtb3);
		
		jf.add(jp);
		
		jf.setBounds(100,100,300,300);
		jf.setVisible(true);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
