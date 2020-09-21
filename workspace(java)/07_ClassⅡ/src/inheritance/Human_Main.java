package inheritance;

class Human{
	String name;
	int age;
	String job;
}

class Student extends Human{
	String major;
	
	void StudentgetInfo(){
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("직업 : " + job);
		System.out.println("학과 : " + major);
	}
}

class Employee extends Human{
	int salary;
	
	void EmplyeegetInfo(){
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("직업 : " + job);
		System.out.println("급여 : " + salary);
	}
}

public class Human_Main {

	public static void main(String[] args) {
		Student student = new Student();
		
		student.name = "홍길동";
		student.age = 23;
		student.job = "대학생";
		student.major = "경제학과";
		
		student.StudentgetInfo();
		
		Employee employee = new Employee();
		
		employee.name = "임정훈";
		employee.age = 37;
		employee.job = "학원강사";
		employee.salary = 5000;
		
		employee.EmplyeegetInfo();
	}

}
