package sist;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex30_Event {

	public static void main(String[] args) {

		JFrame jf = new JFrame("텍스트 영역 이벤트");

		JPanel jp = new JPanel();
		
		JLabel label = new JLabel("입력후 <Enter> 키를 입력하세요.");
		
		JTextField text = new JTextField(25);
		
		JTextArea jta = new JTextArea(5, 30);
		
		JScrollPane jsp = new JScrollPane(jta,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		jta.setLineWrap(false);
		
		jp.add(label);
		jp.add(text);
		jp.add(jsp);
		
		jf.add(jp);
		
		jf.setBounds(200, 200, 300, 300);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		text.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				jta.append(text.getText());
				text.setText("");
			}
		});
	}
	

}
