package sist;

import java.awt.BorderLayout;

import javax.swing.*;

public class Exam02 {

	public static void main(String[] args) {
		
		JFrame jf = new JFrame("성적처리");
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		
		JLabel jl1 = new JLabel("이름 : ");
		JTextField name = new JTextField(10);
		
		jp4.add(jl1); jp4.add(name);
		
		JLabel jl2 = new JLabel("국어 : ");
		JTextField kor = new JTextField(5);
		
		JLabel jl3 = new JLabel("영어 : ");
		JTextField eng = new JTextField(5);
		
		JLabel jl4 = new JLabel("수학 : ");
		JTextField mat = new JTextField(5);
		
		jp1.add(jl2); jp1.add(kor);
		jp1.add(jl3); jp1.add(eng);
		jp1.add(jl4); jp1.add(mat);
		
		jp2.setLayout(new BorderLayout());
		jp2.add(jp4,BorderLayout.NORTH);
		jp2.add(jp1,BorderLayout.SOUTH);
		
		
		JTextArea jta = new JTextArea(8, 30);
		
		JScrollPane jsp = new JScrollPane(jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton jb1 = new JButton("계산");
		JButton jb2 = new JButton("종료");
		JButton jb3 = new JButton("취소");
		
		jp3.add(jb1); jp3.add(jb2); jp3.add(jb3);
		
		jf.setLayout(new BorderLayout());
		jf.add(jp2, BorderLayout.NORTH);
		jf.add(jsp, BorderLayout.CENTER);
		jf.add(jp3, BorderLayout.SOUTH);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(200, 200, 400, 300);
		jf.setVisible(true);
	}

}
