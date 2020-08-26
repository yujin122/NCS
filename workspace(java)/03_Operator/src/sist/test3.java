package sist;

public class test3 {

	public static void main(String[] args) {
	
		int price = Integer.parseInt(args[0]); //금액
		int cost = Integer.parseInt(args[1]); //단가
		int num = Integer.parseInt(args[2]); //수량
		
		double tax = (cost * num) * 0.1; //부가세
		//int tax = (int)((cost * num) * 0.1)
		double total = (cost * num) + tax; //상품총액
		double money = price - total; //거스름돈
		
		System.out.println("지불한 금액 : " + price + "원");
		System.out.println("제품단가 : " + cost + "원");
		System.out.println("수량 : " + num);
		System.out.println("부가세 : " + (int)tax + "원");
		System.out.println("상품총액 : " + (int)total + "원");
		System.out.println("거스름 돈 : " + (int)money + "원");
		
	}

}
