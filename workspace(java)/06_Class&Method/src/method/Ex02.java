package method;

public class Ex02 {
 
	public static void add() {
		int sum=0;
		
		for(int i=1;i<=500;i++) {
			sum+=i;
		}
		
		System.out.println("1 ~ 500 까지의 합 : " + sum);
	}
	
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		//[문제] 1 ~ 500까지의 합을 구하는 메서드를 호출
		add();
		
		System.out.println("프로그램 종료");

	}

}
