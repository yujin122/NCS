package string;

public class Ex02 {

	public static void main(String[] args) {

		String str = "java";
		String str1 = " program";

		System.out.println("str 주소 : " + System.identityHashCode(str));
		System.out.println("str1 주소 : " + System.identityHashCode(str1));

		str = str + str1;
		System.out.println(str);
		
		System.out.println("str 주소 : " + System.identityHashCode(str));
	}

}
