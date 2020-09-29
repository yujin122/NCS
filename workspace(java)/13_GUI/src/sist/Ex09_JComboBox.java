package sist;

import javax.swing.*;

public class Ex09_JComboBox {

	public static void main(String[] args) {

		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("JComboBox 예제");
		
		String[] job = {"회사원", "공무원", "학생", "주부", "무직"};
		
		JComboBox<String> jcb = new JComboBox<String>(job);

		//jcb.setSelectedIndex(2);
		jcb.setSelectedItem("공무원");
		
		jp.add(jcb);
		
		jf.add(jp);
		jf.setBounds(100, 100, 300, 300);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}

}
