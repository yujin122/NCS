package sist;

import javax.swing.*;

public class Ex10_JList {

	public static void main(String[] args) {
		
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		
		jf.setTitle("JList 예제");
		
		String[] job = {"회사원", "공무원", "학생", "주부", "무직"};
		
		JList<String> jl = new JList<String>(job);
		
		jp.add(jl);
		
		jf.add(jp);
		jf.setBounds(100, 100, 300, 300);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
