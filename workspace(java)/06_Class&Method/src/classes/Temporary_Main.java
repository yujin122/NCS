package classes;

import java.util.Scanner;

class Temporary{
	
	private String name;
	private int time;
	private int pay;
	
	public Temporary(String name, int time, int pay) {
		this.name = name;
		this.time = time;
		this.pay = pay;
	}
	
	void paySum() {
		
		int total = time * pay;
		int amount = (int)(total * 0.03);
		int payable= total - amount;
	
		output(total,amount,payable);
	}
	
	void output(int total,int amount, int payable) {
		System.out.println("===========================");
		System.out.println("이름 : " + name);
		System.out.printf("총급여 : %,d원\n", total);
		System.out.printf("공제액 : %,d원\n",amount);
		System.out.printf("실지급액 : %,d원\n",payable);
	}
	
}

public class Temporary_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름, 작업시간, 시간당 급여를 입력하세요.");
		
		Temporary tem = new Temporary(sc.next(),sc.nextInt(),sc.nextInt());
		
		tem.paySum();
		
		sc.close();
	}

}
