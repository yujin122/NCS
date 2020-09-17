package classes;

class Person{
	// 멤버변수
	String name;
	int age;
	boolean marrige;
	int numberOfChild;
}

public class Person_Main {

	public static void main(String[] args) {

		Person person = new Person();
		
		person.name = "홍길동";
		person.age = 27;
		
		String mar = "";
		
		if(person.marrige) {
			mar = "기혼";
		}else {
			mar = "미혼";
		}
		
		System.out.println("이      름 >>> " + person.name);
		System.out.println("나      이 >>> " + person.age);
		System.out.println("결혼여부 >>> " + mar);
		System.out.println("자녀   수 >>> " + person.numberOfChild);
	}

}
