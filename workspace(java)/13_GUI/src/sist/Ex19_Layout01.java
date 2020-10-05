package sist;

import java.awt.BorderLayout;

import javax.swing.*;

// 간단한 계산기 화면을 구성해 보자

public class Ex19_Layout01 {

	public static void main(String[] args) {
		
		JFrame jf = new JFrame("간단한 계산기 예제");
		
		JPanel jp1 = new JPanel();
		JPanel jp3 = new JPanel();
		
		JLabel jl1 = new JLabel("수 1 : ");
		JTextField num1 = new JTextField(5);
		
		JLabel jl2 = new JLabel("수 2 : ");
		JTextField num2 = new JTextField(5);
		
		JLabel jl3 = new JLabel("연산자 : ");
		/*JTextField oper = new JTextField(1);*/
		JRadioButton plus = new JRadioButton("+");
		JRadioButton minus = new JRadioButton("-");
		JRadioButton mul = new JRadioButton("*");
		JRadioButton div = new JRadioButton("/");
		JRadioButton mod = new JRadioButton("%");
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(plus);	bg.add(minus);
		bg.add(mul);	bg.add(div);
		bg.add(mod);
		
		jp1.add(jl1);	jp1.add(num1);
		jp1.add(jl2);	jp1.add(num2);
		jp1.add(jl3);	/*jp1.add(oper);*/
		jp1.add(plus);	jp1.add(minus);	
		jp1.add(mul);	jp1.add(div);	
		jp1.add(mod);	
		
		JTextArea jta = new JTextArea(8, 30);
		JScrollPane jsp = new JScrollPane(jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);
		
		
		JButton bt1 = new JButton("계  산");
		JButton bt2 = new JButton("종  료");
		JButton bt3 = new JButton("취  소");
		
		jp3.add(bt1);	jp3.add(bt2);	jp3.add(bt3);
	
	
		jf.setLayout(new BorderLayout());
		jf.add(jp1, BorderLayout.NORTH);
		jf.add(jsp, BorderLayout.CENTER);
		jf.add(jp3, BorderLayout.SOUTH);
		
		jf.setBounds(200, 200, 500, 300);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}
