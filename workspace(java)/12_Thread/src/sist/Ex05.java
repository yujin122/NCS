package sist;

/*
 * [문제] 숫자(1~100)를 생성하는 스레드 클래스와 
 * 		  영문자(A~Z)를 생성하는 스레드 클래스를 각각
 * 		  정의하고, 스레드가 수행되도록 해 보세요.
 * 		  조건1) 숫자 생성 클래스 : NumberThread
 * 				=> Thread 라는 클래스를 상속하여 생성
 * 		  조건2) 영문자 생성 클래스 : AlphaThread
 * 				=> Runnable 인터페이스를 구현하여 생성
 */

class NumberThread extends Thread{
	
	@Override
	public void run() {
		for(int i =1;i<=100;i++) {
			System.out.println(i);
		}
	}
}

class AlphaThread implements Runnable{
	
	@Override
	public void run() {
	
		for(char i = 'A'; i <='Z' ; i++) {
			System.out.println(i);
		}
	}
}

public class Ex05 {

	public static void main(String[] args) {
		
		NumberThread nt = new NumberThread();
		
		AlphaThread at = new AlphaThread();
		Thread t = new Thread(at);
		
		nt.start(); t.start();
		
	}

}
