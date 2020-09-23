package polymorphism;

import java.util.Scanner;

interface OverWatch{
	void name();
	void leftClick();
	void rightClick();
	void shiftButton();
	void eButton();
	void qButton();
}

class Mei implements OverWatch{

	@Override
	public void name() {
		System.out.println("이름 : 메이");
	}

	@Override
	public void leftClick() {
		System.out.println("왼쪽 버튼 : 냉각총");
	}

	@Override
	public void rightClick() {
		System.out.println("오른쪽 버튼 : 고드름");
	}

	@Override
	public void shiftButton() {
		System.out.println("Shift 버튼 : 급속 빙결");
	}

	@Override
	public void eButton() {
		System.out.println("e 버튼 : 빙벽");
	}

	@Override
	public void qButton() {
		System.out.println("q 버튼 : 눈보라");
	}
	
}

class Gengi implements OverWatch{
	
	@Override
	public void name() {
		System.out.println("이름 : 겐지");
	}

	@Override
	public void leftClick() {
		System.out.println("왼쪽 버튼 : 표창던지기");
	}

	@Override
	public void rightClick() {
		System.out.println("오른쪽 버튼 : 표창 3개 던지기");
	}

	@Override
	public void shiftButton() {
		System.out.println("Shift 버튼 : 돌진");
	}

	@Override
	public void eButton() {
		System.out.println("e 버튼 : 칼로 막기");
	}

	@Override
	public void qButton() {
		System.out.println("q 버튼 : 칼로 썰기");
	}
	
}

class Mccree implements OverWatch{
	
	@Override
	public void name() {
		System.out.println("이름 : 맥크리");
	}

	@Override
	public void leftClick() {
		System.out.println("왼쪽 버튼 : 피스키퍼");
	}

	@Override
	public void rightClick() {
		System.out.println("오른쪽 버튼 : 모든 총알 발사");
	}

	@Override
	public void shiftButton() {
		System.out.println("Shift 버튼 : 구르기");
	}

	@Override
	public void eButton() {
		System.out.println("e 버튼 : 섬광탄");
	}

	@Override
	public void qButton() {
		System.out.println("q 버튼 : 황야의 무법자");
	}
	
}
public class Game_Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		OverWatch watch = null;
		
		System.out.println("플레이할 캐릭터 선택(1. 메이 / 2. 겐지 / 3. 메크리)");
		
		int bunho = sc.nextInt();
		
		if(bunho == 1) {
			watch = new Mei();	// 다형성
		}else if(bunho == 2) {
			watch = new Gengi();
		}else if(bunho == 3) {
			watch = new Mccree();
		}else {
			System.out.println("잘못입력하셨습니다.");
		}
		
		watch.name();
		watch.leftClick();
		watch.rightClick();
		watch.shiftButton();
		watch.eButton();
		watch.qButton();
	}

}
