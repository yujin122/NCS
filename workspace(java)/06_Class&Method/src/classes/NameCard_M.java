package classes;

import java.util.Scanner;

class NameCard {
	private String name;
	private String phone;
	private String addr;
	private String position;
	
	public NameCard(String name, String phone, String addr, String position) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.position = position;
	}
	
	public void output() {
		System.out.println("============================");
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
		System.out.println("주소 : " + addr);
		System.out.println("직급 : " + position);
	}
}

public class NameCard_M {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름, 전화번호, 주소, 직급을 입력하세요.");
		NameCard nc = new NameCard(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine());
		
		nc.output();
		
		sc.close();

	}

}
