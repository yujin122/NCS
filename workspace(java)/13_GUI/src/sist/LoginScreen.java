package sist;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginScreen extends JFrame{

	public LoginScreen() {	
		
		super("제품관리 시스템");
		
		JPanel title = new JPanel();
		
		JLabel login = new JLabel("로그인 화면");
		
		/*Color color = new Color(5, 0, 153);
		login.setForeground(color);*/			// 글자 색상
		
		login.setForeground(new Color(5, 0, 153));
		
		/*Font font = new Font("휴먼편지체", Font.BOLD, 25);
		login.setFont(font);*/
		
		login.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		login.setHorizontalAlignment(0);
		
		title.add(login);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(3,2));
		
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jl2 = new JLabel("아이디 : ", JLabel.CENTER);
		idPanel.add(jl2);
		
		JPanel idPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField id = new JTextField(10);
		idPanel2.add(id);
		
		jp1.add(idPanel);	jp1.add(idPanel2);
		
		JPanel pwdPanel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jl3 = new JLabel("비밀번호 : ", JLabel.CENTER);
		pwdPanel1.add(jl3);
		
		JPanel pwdPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField pwd = new JPasswordField(10);
		pwdPanel2.add(pwd);
		
		jp1.add(pwdPanel1);	jp1.add(pwdPanel2);
		
		
		JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton jb1 = new JButton("로그인");
		
		JPanel joinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton jb2 = new JButton("회원가입");
		
		loginPanel.add(jb1);
		joinPanel.add(jb2);
		
		jp1.add(loginPanel);
		jp1.add(joinPanel);
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(jp1);
		
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		
		pack();
		setResizable(false);		// 화면 크기 고정

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String result = "아이디" + id.getText() + ", 비번 : " + pwd.getText();
				
				JOptionPane.showMessageDialog(jb1, result);
				
			}
		});
		
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new JoinScreen();
				dispose();
				
			}
		});
	}
}
