package sist;

import java.awt.Frame;

/*
 * Frame을 만드는 방법 - 2가지
 * 2. Frame 이라는 클래스의 객체를 생성해서 사용
 */

public class Ex02_Frame {

	public static void main(String[] args) {
		
		Frame frame=new Frame("두번째 예제");
		//frame.setTitle("두번째 예제");
		
		/*// 프레임의 위치
		frame.setLocation(100,100);
		
		// 프레임의 크기
		frame.setSize(300, 300);
		*/
		
		// 프레임의 위치 + 크기
		frame.setBounds(100, 100, 300, 300);
		
		frame.setVisible(true);
	}

}
