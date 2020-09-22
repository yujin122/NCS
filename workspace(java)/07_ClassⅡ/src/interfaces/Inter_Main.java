package interfaces;

/*
 * API(Application Programming Interface)
 * - 자바 시스템을 제어하기 위해서 자바에서 제공하는 명령어들을 말함
 * - JDK를 설치하면 자바 시스템을 제어하기 위한 API들을 제공해 주고 있음
 * - 자바 개발자들은 자바에서 제공한 API를 이용해서 자바 어플리케이션을 만들게 됨
 * - API 문서들을 모아둔 곳 : http://docs.oracle.com/javase
 */

/*
 * 인터페이스(interface)?
 * 1. 완벽한 추상화를 제공한다
 * 	  => - 일종의 추상클래스. 추상클래스보다 추상화 정도가 더 높다.
 * 		 - 실제 구현된 것이 전혀 없는 기본 설계도(알맹이 없는 껍데기)
 * 		 - 추상메서드와 상수만을 멤버로 갖는다.
 * 		 - 인스턴스를 생성할 수 없고, 클래스 작성에 도움을 줄 목적으로 사용됨
 * 		 - 미리 정해진 규칙에 맞게 구현하도록 표준을 제시하는데 사용 ==> 명세서
 * 2. 클래스와 클래스 사이의 중계적 역할을 하는 서비스를 제공함
 * 	  => 객체와 객체 중간에 놓이는 통신 채널
 * 3. 모든 메서드가 추상화(추상메서드)이다.
 * 4. 프로젝트 진행 시 표준규약에 따른다.
 * 	  => 추상클래스보다 더 많이 사용됨
 * 5. 인터페이스는 상수와 추상메서드로만 구성됨
 * 6. 모든 변수는 상수가 된다.
 * 	    예) public static final 로 인식
 * 7. 모든 메서드는 추상 메서드가 된다.
 * 	    예) public abstract 로 인식
 * 8. 인터페이스는 객체 생성이 불가능
 * 9. 자식클래스로 상속을 하여 자식클래스로 객체 생성
 * 	  => 인터페이스의 추상메서드는 반드시 재정의(강제성이 부여됨)
 * 10. 인터페이스는 다중 상속을 제공함
 * 11. class -> interface 키워드 사용
 * 	   extends -> implements 키워드 사용
 */

interface Inter{
	int num = 100;
	
	void display1();
	void display2();
}

class Sub implements Inter{

	@Override
	public void display1() {
		System.out.println("인터페이스 display1() 메서드 재정의");
	}

	@Override
	public void display2() {
		System.out.println("인터페이스 display2() 메서드 재정의");
	}
	
}
public class Inter_Main {

	public static void main(String[] args) {
		// 인터페이스는 객쳋 생성 불가
		// Inter inter = new Inter();
		
		Sub sub = new Sub();
		
		// 상수값은 변경이 안됨
		// static final로 인식
		//sub.num = 10;
		sub.display1();
		sub.display2();

	}

}
