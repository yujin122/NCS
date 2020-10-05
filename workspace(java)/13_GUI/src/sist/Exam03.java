package sist;

import java.awt.BorderLayout;

import javax.swing.*;

public class Exam03 {

	public static void main(String[] args) {

		JFrame jf = new JFrame("커피 자판기");
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		
		JLabel jl1 = new JLabel("원하는 커피 선택");
		jl1.setHorizontalAlignment(0);
		
		JRadioButton jrb1 = new JRadioButton("아메리카노(2500)");
		JRadioButton jrb2 = new JRadioButton("카페모카(3500)");
		JRadioButton jrb3 = new JRadioButton("에스프레소(2500)");
		JRadioButton jrb4 = new JRadioButton("카페라떼(4000)");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1); bg.add(jrb2); bg.add(jrb3); bg.add(jrb4);
		
		jp1.add(jrb1); jp1.add(jrb2); jp1.add(jrb3); jp1.add(jrb4);
		
		JLabel jl2 = new JLabel("수량 : ");
		JTextField count = new JTextField(8);
	
		JLabel jl3 = new JLabel("입금액 : ");
		JTextField money = new JTextField(8);
	
		jp2.add(jl2); jp2.add(count);
		jp2.add(jl3); jp2.add(money);
	
		jp4.setLayout(new BorderLayout());
		jp4.add(jl1, BorderLayout.NORTH);
		jp4.add(jp1, BorderLayout.CENTER);
		jp4.add(jp2, BorderLayout.SOUTH);
		
		
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
		
		jf.setBounds(200, 200, 500, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);	
		
	}

}
