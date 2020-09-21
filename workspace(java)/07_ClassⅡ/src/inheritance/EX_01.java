package inheritance;

import java.util.Scanner;

class Employee2{
	String name;
	
	public Employee2() { }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	int getPays() {
		return 0;
	}
}

class Permanent extends Employee2{
	private int pay;
	private int bonus;
	
	public Permanent() { }
	
	public Permanent(String name, int pay,int bonus) { 
		this.name = name;
		this.pay = pay;
		this.bonus = bonus;
	}
	
	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	int getPays() {
		return pay + bonus;
	}
}

class Temporary extends Employee2{
	private int pay;
	private int time;
	
	public Temporary() { }
	
	public Temporary(String name, int pay,int time) { 
		this.name = name;
		this.pay = pay;
		this.time = time;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	int getPays() {
		return pay*time;
	}
}
public class EX_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("고용형태 - 정규직<P>, 임시적<T>를 입력하세요");
		String e = sc.next();
		
		String name;
		int pay,bonus,time;
		
		if(e.equalsIgnoreCase("P")) {
			e = "정규직";
			System.out.println("이름, 기본급, 보너스를 입력하세요.");
			name = sc.next();
			pay = sc.nextInt();
			bonus = sc.nextInt();
			
			Permanent permanent = new Permanent(name, pay,bonus);
			
			System.out.println("============================");
			System.out.println("고용형태 : "+e);
			System.out.println("이름 : " + permanent.getName());
			System.out.printf("급여 : %,d원",permanent.getPay());
			
		}else if(e.equalsIgnoreCase("T")){
			e = "임시직";

			System.out.println("이름, 작업시간, 시간당 급여를 입력하세요.");
			name = sc.next();
			time = sc.nextInt();
			pay = sc.nextInt();
			
			Temporary temporary = new Temporary(name, pay, time);
			
			System.out.println("============================");
			System.out.println("고용형태 : "+e);
			System.out.println("이름 : " + temporary.getName());
			System.out.printf("급여 : %,d원",temporary.getPay());
			
		}else {
			System.out.println("P 와 T 중 하나를 입력해주세요.");
		}
	}

}
