package polymorphism;

/*
 * instanceof 연산자
 * - 참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보는 연산자
 * - 연산 결과로 boolean 값(true/false)를 리턴함
 * 	  예) 참조변수 instanceof 클래스(타입)
 * 		 if(a instanceof Car) : 참조변수 a의 타입이 Car 타입인지를 체크함
 * 		 => 값이 false이면 Car 인스턴스가 아니고, true이면 Car 인스턴스임
 * - 만일 Car 클래스의 조상이 Vehicle이면
 * 	 if(a instanceof Vehicle)이면 true 값을 반환함
 */
public class Game2_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gengi gengi = new Gengi();
		
		if(gengi instanceof Gengi) {
			System.out.println("Gengi 클래스 타입입니다.");
		}
		
		if(gengi instanceof OverWatch) {
			System.out.println("조상클래스 타입입니다.");
		}
	}

}
