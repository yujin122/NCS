package sist;

public class Ex05 {

	public static void main(String[] args) {
		
		// 키보드로 두 개의 숫자를 입력을 받아보자.
		// 문자열을 숫자로 형변환하는 방법
		int su1 = Integer.parseInt(args[0]);
		int su2 = Integer.parseInt(args[1]);
		
		// 산술연산을 진행해 보자.
		System.out.println(su1 + "+" + su2 + "=" + (su1+su2));
		System.out.println(su1 + "-" + su2 + "=" + (su1-su2));
		System.out.println(su1 + "*" + su2 + "=" + (su1*su2));
		System.out.println(su1 + "/" + su2 + "=" + (su1/su2));
		System.out.println(su1 + "%" + su2 + "=" + (su1%su2));
		
	}

}
