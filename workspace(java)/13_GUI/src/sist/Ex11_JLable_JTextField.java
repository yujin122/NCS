package sist;

import javax.swing.*;

public class Ex11_JLable_JTextField {

	public static void main(String[] args) {
		
		JFrame jf = new JFrame("JLable_JTextField");
		JPanel jp = new JPanel();
		
		JLabel jl1 = new JLabel("이 름 : ");
		JTextField name = new JTextField(15);
		
		JLabel jl2 = new JLabel("학 과 : ");
		JTextField major = new JTextField(15);
		
		JLabel jl3 = new JLabel("주 소 : ");
		JTextField addr = new JTextField(15);
		
		jp.add(jl1); jp.add(name);
		jp.add(jl2); jp.add(major);
		jp.add(jl3); jp.add(addr);
		
		jf.add(jp);
		jf.setBounds(100, 100, 250, 130);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
	}

}
