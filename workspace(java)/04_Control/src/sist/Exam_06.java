package sist;

import java.util.*;

/*
 * [문제6] coffee 메뉴 처리. 
 */
public class Exam_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*** coffee 메뉴 ***");
		System.out.println("1. 아메리카노 - 3,000원");
		System.out.println("2. 카페라떼 - 4,000원");
		System.out.println("3. 마키아또 - 4,500원");
		System.out.println("4. 바닐라라떼 - 4,500원");
		
		System.out.print("위 메뉴 중 하나를 선택하세요. : ");
		int menu = sc.nextInt();
		System.out.print("주문수량 >> ");
		int amount = sc.nextInt();
		System.out.print("입금액 >> ");
		int cash = sc.nextInt();
		
		
		boolean tf = false;
		float tax, total,coin;
		int price = 0;
		String menuName="";
		
		switch(menu) {
			case 1:
				menuName = "아메리카노";
				price = 3000;
				tf =true;
				break;
			case 2:
				menuName = "카페라떼";
				price = 4000;
				tf =true;
				break;
			case 3:
				menuName = "마키아또";
				price = 4500;
				tf =true;
				break;
			case 4:
				menuName = "바닐라라떼";
				price = 4500;
				tf =true;
				break;
			default:
				tf =false;
				System.out.println("메뉴에 없습니다.");
		}
		
		if(tf == true) {
			tax = (price*amount)*0.1f;
			total = (price * amount)+tax;
			coin = cash - total;
		
			
			System.out.println("\n주문한 메뉴 : " + menuName );
			System.out.println("커피단가 : " + price + "원");
			System.out.println("주문수량 : " + amount);
			System.out.println("입금액 : " + cash + "원");
			System.out.println("총금액 : " + (int)total + "원");
			System.out.println("거스름 돈 : " + (int)coin + "원");
		}
		
		sc.close();
	}

}
