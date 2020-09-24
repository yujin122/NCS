package exam;

// 객체 간 협업(유기적 관계)
// 객체를 이루는 것은 데이터와 기능

// 과일장수
// 1. 과일을 판매한다. - 행동(메서드)
// 2. 과일장수는 사과 20개, 오렌지 10개를 보유하고 있다. - 상태
// 3. 과일장수의 판매 수익은 50,000원이다. - 상태

class FruitSeller{
	
	final int APPLE_PRICE=1000;	// 사과 가격 - 변하지 않는 가격
	int numOfApple;	// 사과의 갯수
	int myMoney;	// 판매 수익
	
	public FruitSeller() {	}
	
	public FruitSeller(int numOfApple, int myMoney) {
		this.numOfApple= numOfApple;
		this.myMoney = myMoney;
	}
	
	// 사과 판매 메서드
	int saleApple(int money) {	// money : 사과 구매액
		
		int count = money / APPLE_PRICE;
		numOfApple -= count;
		myMoney += money;
		
		return count;
	}
	
	void showSaleResult() {
		System.out.println("남은 사과 : " + numOfApple);
		System.out.println("판매 수익 : " + myMoney);
	}
}

class FruitBuyer{
	
	int myMoney;
	int numOfApple;
	
	public FruitBuyer() {	}
	
	public FruitBuyer(int myMoney, int numOfApple) {
		this.myMoney = myMoney;
		this.numOfApple= numOfApple;
	}

	void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}

	void showBuyResult() {
		System.out.println("현재 잔액 : " + myMoney);
		System.out.println("사과 갯수 : " + numOfApple);
	}
}

public class Ex_01 {

	public static void main(String[] args) {
		
		FruitSeller seller = new FruitSeller(20,0);
		FruitBuyer buyer1 = new FruitBuyer(5000,0);
		FruitBuyer buyer2 = new FruitBuyer(10000,0);
		
		buyer1.buyApple(seller, 3000);
		buyer2.buyApple(seller, 2000);
		
		System.out.println("*** 과일 판매자 현재 상황 ***");
		seller.showSaleResult();
		System.out.println();
		
		System.out.println("*** 과일 구매자1 현재 상황 ***");
		buyer1.showBuyResult();
		System.out.println();
		
		System.out.println("*** 과일 구매자2 현재 상황 ***");
		buyer2.showBuyResult();
	}

}
