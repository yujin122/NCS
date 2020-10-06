package sist;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex31_Event {

	public static void main(String[] args) {

		JFrame jf = new JFrame("간단한 계산기 예제");

		JPanel jp1 = new JPanel();
		JPanel jp3 = new JPanel();

		JLabel jl1 = new JLabel("수 1 : ");
		JTextField num1 = new JTextField(5);

		JLabel jl2 = new JLabel("수 2 : ");
		JTextField num2 = new JTextField(5);

		JLabel jl3 = new JLabel("연산자 : ");

		JTextField oper = new JTextField(1);

		ButtonGroup bg = new ButtonGroup();
		
		jp1.add(jl1);
		jp1.add(num1);
		jp1.add(jl2);
		jp1.add(num2);
		jp1.add(jl3);
		jp1.add(oper);

		JTextArea jta = new JTextArea(8, 30);
		JScrollPane jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);

		JButton bt1 = new JButton("계  산");
		JButton bt2 = new JButton("종  료");
		JButton bt3 = new JButton("취  소");

		jp3.add(bt1);
		jp3.add(bt2);
		jp3.add(bt3);

		jf.setLayout(new BorderLayout());
		jf.add(jp1, BorderLayout.NORTH);
		jf.add(jsp, BorderLayout.CENTER);
		jf.add(jp3, BorderLayout.SOUTH);

		jf.setBounds(200, 200, 500, 300);

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int n1 = Integer.parseInt(num1.getText());
				int n2 = Integer.parseInt(num2.getText());

				String op = oper.getText();
				
				String result="";
				
				switch (op) {
				case "+":
					result = "결과 : " + n1 + "+" + n2 + " = " + (n1 + n2);
					break;
				case "-":
					result = "결과 : " + n1 + "-" + n2 + "=" + (n1 - n2);
					break;
				case "*":
					result = "결과 : " + n1 + "*" + n2 + "=" + (n1 * n2);
					break;
				case "/":
					result = "결과 : " + n1 + "/" + n2 + "=" + (n1 / n2);
					break;
				}
				
				jta.setText(result + "\n");
				num1.setText(""); num2.setText(""); oper.setText("");
				
				num1.requestFocus();
			}
		});
		
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		bt3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				num1.setText(""); num2.setText(""); oper.setText("");
				jta.setText("");
				num1.requestFocus();
			}
		});
	}

}
