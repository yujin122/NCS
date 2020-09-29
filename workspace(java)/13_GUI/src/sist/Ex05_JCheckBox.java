package sist;

import javax.swing.*;


public class Ex05_JCheckBox {

	public static void main(String[] args) {

		JFrame jf = new JFrame("JCheckBox 예제");
		JPanel jp = new JPanel();
		
		JCheckBox jcb1 = new JCheckBox("게임");
		JCheckBox jcb2 = new JCheckBox("독서");
		JCheckBox jcb3 = new JCheckBox("영화감상", true);
		JCheckBox jcb4 = new JCheckBox("운등");
		JCheckBox jcb5 = new JCheckBox("잠자기");
				
		jp.add(jcb1); jp.add(jcb2); 
		jp.add(jcb3); jp.add(jcb4); 
		jp.add(jcb5);
		
		jf.add(jp);
		
		jf.setBounds(100,00,300,300);
		jf.setVisible(true);
		
	}

}
