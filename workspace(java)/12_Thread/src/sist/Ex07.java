package sist;

/*
 * Thread 제어 명령어
 * - sleep(), join(), interrupt(), stop()
 */

/*
 * Thread 클래스의 sleep() 메서드
 * - 현재 실행중인 스레드를 잠시 정지시키는 메서드
 * 	  형식) Thread.sleep(밀리세컨드);	// 1/1000초
 * - 예외 처리를 해 주어야 함.
 */

class ThreadB extends Thread {
	
	public ThreadB() {	}
	
	public ThreadB(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		
		for(int i = 1; i<=5; i++) {
			System.out.println(this.getName() + "_" + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class Ex07 {

	public static void main(String[] args) {
		ThreadB t1 = new ThreadB("스레드1");
		ThreadB t2 = new ThreadB("스레드2");
		ThreadB t3 = new ThreadB("스레드3");
		ThreadB t4 = new ThreadB("스레드4");
		ThreadB t5 = new ThreadB("스레드5");
		
		t1.start();	t2.start();
		t3.start();	t4.start();	t5.start();
	}

}
