package sist;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// Exam02 소스 복사 후 이벤트 처리

public class Ex32_Event {

	public static void main(String[] args) {
		JFrame jf = new JFrame("성적처리");

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();

		JLabel jl1 = new JLabel("이름 : ");
		JTextField name = new JTextField(10);

		jp4.add(jl1);
		jp4.add(name);

		JLabel jl2 = new JLabel("국어 : ");
		JTextField kor = new JTextField(5);

		JLabel jl3 = new JLabel("영어 : ");
		JTextField eng = new JTextField(5);

		JLabel jl4 = new JLabel("수학 : ");
		JTextField mat = new JTextField(5);

		jp1.add(jl2);
		jp1.add(kor);
		jp1.add(jl3);
		jp1.add(eng);
		jp1.add(jl4);
		jp1.add(mat);

		jp2.setLayout(new BorderLayout());
		jp2.add(jp4, BorderLayout.NORTH);
		jp2.add(jp1, BorderLayout.SOUTH);

		// JTextArea 컴포넌트에 값이 변경되지 않도록 하는 메서드
		// setFocusable()
		JTextArea jta = new JTextArea(8, 30);

		JScrollPane jsp = new JScrollPane(jta, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		JButton jb1 = new JButton("계산");
		JButton jb2 = new JButton("종료");
		JButton jb3 = new JButton("취소");

		jta.setFocusable(false);
		
		jp3.add(jb1);
		jp3.add(jb2);
		jp3.add(jb3);

		jf.setLayout(new BorderLayout());
		jf.add(jp2, BorderLayout.NORTH);
		jf.add(jsp, BorderLayout.CENTER);
		jf.add(jp3, BorderLayout.SOUTH);

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(200, 200, 400, 300);
		jf.setVisible(true);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int k = Integer.parseInt(kor.getText());
				int en = Integer.parseInt(eng.getText());
				int m = Integer.parseInt(mat.getText());
				
				int total = k+en+m;
				float avg = total/3.0f;
				
				String grad = "";
				
				if(avg >=90) {
					grad = "A";
				}else if(avg >=80) {
					grad = "B";
				}else if(avg >=70) {
					grad = "C";
				}else if(avg >=60) {
					grad = "D";
				}else{
					grad = "F";
				}
				
				jta.setText("*** " + name.getText() + "님의 성적결과 ***\n" +
						"이름 : " + name.getText() + "\n" +
						"국어점수 : " + k + "점\n" + 
						"영어점수 : " + en + "점\n" +
						"수학점수 : " + m + "점\n" +
						"총       점 : " + total + "점\n" +
						"평       균 : " + String.format("%.2f", avg) + "점\n" +
						"학       점 : " + grad + "학점\n");
				
				name.setText(""); kor.setText(""); eng.setText(""); mat.setText("");
				name.requestFocus();
			}
			
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				name.setText(""); kor.setText(""); eng.setText(""); mat.setText("");
				jta.setText("");
				name.requestFocus();
			}
		});
	}

}
