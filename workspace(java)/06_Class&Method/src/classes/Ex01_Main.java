package classes;

public class Ex01_Main {

	public static void main(String[] args) {
		
		System.out.println(Ex01.num);
		System.out.println("adder() 메서드 호출 결과 >>> "+ Ex01.adder(150, 36));
		
		// error => 인스턴스 변수이기 때문에 error 발생
		// 인스턴스 변수는 반드시 객체 생성(new) 후 사용이 가능함
		// System.out.println(Ex01.su1); => error
		
		Ex01 ex01 = new Ex01();
		System.out.println(ex01.su1);
		System.out.println(ex01.su2);
		ex01.sum();

	}

}
