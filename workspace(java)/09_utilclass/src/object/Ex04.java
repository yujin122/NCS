package object;

public class Ex04 {

	public static void main(String[] args) {
		
		// String 배열 객체 생성
		String[] str = new String[4];
		str[0] = "홍길동";
		str[1] = "서울시 마포구";
		str[2] = "hong";
		str[3] = "1234";
		
		for(String k: str) {
			System.out.println("str 배열 요소 : " + k);
		}
		System.out.println();
		
		// Object 배열 객체 생성
		Object[] obj = new Object[4];
		obj[0] = "이순신";
		obj[1] = 130;
		obj[2] = true;
		obj[3] = 3.14;
		
		for(Object o : obj) {
			System.out.println("obj 배열 요소 : " + o);
		}
	}

}
