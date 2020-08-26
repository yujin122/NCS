package sist;

/*
 * 2. 관계연산자(비교연산자)
 * 	- >=(크거나 같다), >(크다), <=(작거나 같다), <(작다), ==(같다), !=(같지 않다)
 * 	- 결과는 boolean형으로 반환된다. ==> true/false로 반환 
 * 	- 관계연산자는 제어문(조건문)에서 많이 사용되는 연산자.
 */
public class EX02 {

	public static void main(String[] args) {
		
		int su1 = 10, su2 =5;
		//boolean test = false;
		
		//test = (su1 >= su2); // true
		System.out.println("su1 >= su2 결과 >>> "+ (su1 >= su2));
		System.out.println();
		
		System.out.println("su1 > su2 결과 >>> "+ (su1 > su2));
		System.out.println();
		
		System.out.println("su1 <= su2 결과 >>> "+ (su1 <= su2));
		System.out.println();
		
		System.out.println("su1 < su2 결과 >>> "+ (su1 < su2));
		System.out.println();
		
		System.out.println("su1 == su2 결과 >>> "+ (su1 == su2));
		System.out.println();
		
		System.out.println("su1 != su2 결과 >>> "+ (su1 != su2));
		System.out.println();

	}

}
