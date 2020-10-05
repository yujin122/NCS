package sist;

import java.awt.*;
import javax.swing.*;

public class JoinScreen {

	public static void main(String[] args) {
		
		JFrame jf = new JFrame("제품관리 시스템");
		
		JPanel title = new JPanel();
		
		JLabel login = new JLabel("회원가입");
		
		login.setForeground(new Color(5, 0, 153));
		login.setFont(new Font("휴먼편지체", Font.BOLD, 25));
		
		title.add(login);
		
		JPanel grad = new JPanel();
		
		JRadioButton jrb1 = new JRadioButton("고객");
		JRadioButton jrb2 = new JRadioButton("관리자");
		JRadioButton jrb3 = new JRadioButton("기타");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1); bg.add(jrb2); bg.add(jrb3);
		
		grad.add(jrb1); grad.add(jrb2); grad.add(jrb3);
		
		JPanel join = new JPanel(new GridLayout(5, 2));
		
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel idLabel = new JLabel("아이디 : ", JLabel.CENTER);
		idPanel.add(idLabel);
		
		JPanel idPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField id = new JTextField(10);
		idPanel2.add(id);
		
		join.add(idPanel); join.add(idPanel2);
		
		JPanel pwdPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel pwdLabel = new JLabel("비밀번호 : ", JLabel.CENTER);
		pwdPanel.add(pwdLabel);
		
		JPanel pwdPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField pwd = new JTextField(10);
		pwdPanel2.add(pwd);
		
		join.add(pwdPanel); join.add(pwdPanel2);
		
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel nameLabel = new JLabel("이름 : ", JLabel.CENTER);
		namePanel.add(nameLabel);
		
		JPanel namePanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField name = new JTextField(10);
		namePanel2.add(name);
		
		join.add(namePanel); join.add(namePanel2);
		
		JPanel phonePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel phoneLabel = new JLabel("전화번호 : ", JLabel.CENTER);
		phonePanel.add(phoneLabel);
		
		JPanel phonePanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField phone = new JTextField(10);
		phonePanel2.add(phone);
		
		join.add(phonePanel); join.add(phonePanel2);
		
		
		JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton jb1 = new JButton("회원가입");
		loginPanel.add(jb1);
		
		JPanel canclePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton jb2 = new JButton("취소");
		canclePanel.add(jb2);
		
		join.add(loginPanel); join.add(canclePanel);
		
		JPanel jp2 = new JPanel(new BorderLayout());
		
		jp2.add(grad, BorderLayout.NORTH);
		jp2.add(join, BorderLayout.CENTER);
		
		jf.setLayout(new BorderLayout());
		
		jf.add(title, BorderLayout.NORTH);
		jf.add(jp2, BorderLayout.CENTER);
		
		jf.setBounds(200, 200, 300, 350);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
