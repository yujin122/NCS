package sist;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Ex25_Event extends JFrame{

	JLabel result;

	
	public Ex25_Event() {
		
		super("이벤트 테스트");
		
		// 1. 컴포넌트 만들기
		JPanel panel = new JPanel();
		
		JButton male = new JButton("남자");
		JButton female = new JButton("여자");
		
		JLabel label = new JLabel("당신의 성별은? ");
		result = new JLabel();
		result.setForeground(new Color(219,68,85));
		// 2. 컴포넌틀르 컨테이너에 올리기
		panel.add(male); panel.add(female); panel.add(label); panel.add(result);
		
		// 3. 컨테이너를 프레임에 올리기
		add(panel);
		
		setBounds(200, 100, 300, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		// 4. 이벤트 처리 - 무명클래스로 이벤트 처리
		// male 버튼을 클릭했을 때 이벤트 처리
		male.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText(e.getActionCommand());
			}
		});
		
		// female 버튼을 클릭했을 때 이벤트 처리
		female.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText(e.getActionCommand());
			}
		});
		
		
	}
	
	public static void main(String[] args) {

		new Ex25_Event();
		
	}

}
