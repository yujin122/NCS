package classes;

class PigSave {	//돼지 저금통

	private int balance; // 돼지 저금통 잔액

	public PigSave() {
	}

	public PigSave(int b) {
		balance = b;
	}

	public void deposit(int money) { // 입금 메서드
		System.out.println("돼지 저금통에 입금을 합니다.");
		balance += money;
		System.out.println("현재 잔액 : " + balance + "원");
	}

	public void withdraw(int money) { // 출금 메서드
		
		if (balance < money) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		
		System.out.println("돼지 저금통에서 출금을 합니다.");
		balance -= money;
		System.out.println("현재 잔액 : " + balance + "원");
	}
}

public class PigSave_Main {

	public static void main(String[] args) {
		
		PigSave pig = new PigSave(0);
		
		pig.deposit(3000);
		pig.deposit(5000);
		pig.withdraw(2000);
		pig.withdraw(10000);
		
		//pig.balance = 10000; // 이렇게 접근할 수 있게 하면 안됌
		
		
	}
}
