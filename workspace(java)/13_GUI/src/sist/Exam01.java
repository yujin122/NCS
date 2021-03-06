package sist;

import java.awt.BorderLayout;

import javax.swing.*;

public class Exam01 {

	public static void main(String[] args) {
		
		JFrame jf = new JFrame("계산기 예제-2");
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		
		JLabel jl1 = new JLabel("수 1 : ");
		JTextField num1 = new JTextField(5);
		
		JLabel jl2 = new JLabel("수 2 : ");
		JTextField num2 = new JTextField(5);
		
		jp1.add(jl1); jp1.add(num1); jp1.add(jl2); jp1.add(num2);
		
		JLabel jl3 = new JLabel("연산자 : ");
		JRadioButton jrb1 = new JRadioButton("+");
		JRadioButton jrb2 = new JRadioButton("-");
		JRadioButton jrb3 = new JRadioButton("*");
		JRadioButton jrb4 = new JRadioButton("/");
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(jrb1); bg.add(jrb2); bg.add(jrb3); bg.add(jrb4);
		
		
		jp2.add(jl3); jp2.add(jrb1); jp2.add(jrb2); jp2.add(jrb3); jp2.add(jrb4);
		
		jp4.setLayout(new BorderLayout());
		jp4.add(jp1, BorderLayout.NORTH); jp4.add(jp2,BorderLayout.SOUTH);
		
		JTextArea jta = new JTextArea(8, 30);
		
		JScrollPane jsp = new JScrollPane(jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		JButton jb1 = new JButton("계산");
		JButton jb2 = new JButton("종료");
		JButton jb3 = new JButton("취소");
		
		jp3.add(jb1); jp3.add(jb2); jp3.add(jb3);
		
		jf.setLayout(new BorderLayout());
		jf.add(jp4, BorderLayout.NORTH);
		jf.add(jsp, BorderLayout.CENTER);
		jf.add(jp3, BorderLayout.SOUTH);
		
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(200,200,400,300);
		jf.pack();
		jf.setVisible(true);
		
		
	}

}
