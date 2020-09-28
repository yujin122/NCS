package generic;

class Student{
	
	String name;
	
	public Student() {	}
	
	public Student(String name) {	
		this.name = name;
	}
}

// 제네릭이 2개인 경우에는 기재하는 자료형은
// 참조자료형만 올 수 있음
class Person<T, E>{
	
	T data;
	E id;
	
	public Person() {	}
	
	public Person(T data, E id) {
		this.data = data;
		this.id = id;
	}
}

public class Ex04 {

	public static void main(String[] args) {

		// Student student = new Student("홍길동");
		// Integer id = new Integer(20092801);

		Person<Student, Integer> person = 
				new Person<Student, Integer>(new Student("홍길동"), new Integer(20092801));

		System.out.println(person.data.name + " : " + person.id);
	}

}
