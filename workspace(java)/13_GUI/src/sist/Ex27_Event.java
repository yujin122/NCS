package sist;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

// 프레임의 특정 위치에 마우스 버튼을 클릭하면
// 마우스 포인터(해당 위치)로 글자를 옮겨보도록 하자.

public class Ex27_Event{

	public static void main(String[] args) {

		JFrame jf = new JFrame("이벤트 예제 -2");
		
		JPanel jp = new JPanel();
		
		// 1. 컴포넌트를 만들어 보자
		JLabel label = new JLabel("JAVA");
		label.setFont(new Font("굴림체",Font.BOLD,30));
		// 2. 컴포넌트를 컨테이너에 올려야 한다.
		jp.add(label);
		
		// 3. 컨테이너를 프레임에 올려야 한다.
		jf.add(jp);
		
		jf.setBounds(200, 200, 1000, 1000);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		
		jp.addMouseListener(new MouseListener() {
			
			@Override	// 눌러진 마우스 버튼이 떼어질 때  
			public void mouseReleased(MouseEvent e) {	}	
			
			@Override	// 마우스 버튼이 눌러질 때
			public void mousePressed(MouseEvent e) {	
				
				int x = e.getX();	// 마우스 클릭 시 X 좌표 값
				int y = e.getY();	// 마우스 클릭 시 Y 좌표 값
				
				label.setLocation(x, y);	// 라벨 컴포넌트 위치를 xy로 이동
			}
			
			@Override	// 컴포넌트 위에 올라온 마우스가 컴포넌트를 떠날 때
			public void mouseExited(MouseEvent e) {	}
			
			@Override	// 컴포넌트 위에 마우스가 올라왔을 떄
			public void mouseEntered(MouseEvent e) {	}
			
			@Override	// 마우스 버튼이 클릭될 떄
			public void mouseClicked(MouseEvent e) {	}
		});
	}

}
