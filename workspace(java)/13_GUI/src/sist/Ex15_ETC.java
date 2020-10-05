package sist;

import javax.swing.*;

public class Ex15_ETC {

	public static void main(String[] args) {

		JFrame jf = new JFrame("종합 예제");
		
		JPanel jp = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자
		JLabel jl1 = new JLabel("아이디 : ");
		JTextField id = new JTextField(10);
		
		JLabel jl2 = new JLabel("비밀번호 : ");
		JPasswordField pwd = new JPasswordField(10);
		
		JLabel jl3 = new JLabel("하고 싶은 말: ");
		JTextArea jta = new JTextArea(5, 30);
		
		JScrollPane jsp = new JScrollPane(jta, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		// TextArea 컴포넌트에서 자동 줄바꿈 기능
		jta.setLineWrap(true);
		
		// 2. 컴포넌트들을 컨테이너에 올려주어야 한다.
		jp.add(jl1);	jp.add(id);
		jp.add(jl2);	jp.add(pwd);
		jp.add(jl3);	jp.add(jsp);
		
		// 3. 컨테이너를 프레임에 올려주어야 한다.
		jf.add(jp);
		jf.setBounds(100, 100, 250, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);		
	}

}
