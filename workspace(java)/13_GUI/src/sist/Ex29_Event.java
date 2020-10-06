package sist;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex29_Event {

	public static void main(String[] args) {

		JFrame jf = new JFrame("버튼 이벤트");
		
		JPanel jp = new JPanel();
		
		JButton btn1 = new JButton("입력");
		JButton btn2 = new JButton("종료");
		
		jp.add(btn1);
		jp.add(btn2);
		
		jf.add(jp, BorderLayout.SOUTH);
		
		jf.setBounds(200, 200, 300, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		// 입력(btn1) 클릭했을 때 이벤트 처리
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("입력 버튼을 클릭하셨네요!");
				JOptionPane.showMessageDialog(jf, "입력 버튼을 클릭하셨네요!");
			}
		});
		
		// 종료(btn2) 클릭했을 때 이벤트 처리
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
	
	}

}
