package sist;


// 키보드로 두 수를 입력을 받아서 
// 두 수의 차이를 화면에 출력해 보세요.

public class Ex10 {

	public static void main(String[] args) {

		int su1 = Integer.parseInt(args[0]);
		int su2 = Integer.parseInt(args[1]);
		
		int dist;
		
		if(su1 > su2) {
			dist = su1 - su2;
		}else {
			
			dist = su2- su1;
		}
		
		System.out.println("두 수의 차이는 >>> " + dist + "입니다.");

	}

}
