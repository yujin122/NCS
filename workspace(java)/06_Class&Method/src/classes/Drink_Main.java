package classes;

import java.util.Scanner;

/*
 * 객체 배열
 * 
 * 음료 자판기 
 * 
 * 음료 종류 - 6개
 * 
 * 음료를 저장할 배열을 만들자. - 객체배열
 */

class Drink{
	
	String name;
	int price;
	
	public Drink() { }
	
	public Drink(String name, int price) {
		this.name = name;
		this.price = price;
	}
}

public class Drink_Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("음료 갯수를 입력하세요 : ");
		
		Drink[] drinks = new Drink[sc.nextInt()];
		
		for(int i=0;i<drinks.length;i++) {
			System.out.println((i+1)+"번째 음료의 이름과 가격을 입력하세요...");
			drinks[i]=new Drink(sc.next(),sc.nextInt());
		}
		
		System.out.print("돈을 입력해 주세요 : ");
		int coin = sc.nextInt();
		
		for(int i=0;i<drinks.length;i++) {
			if(coin>=drinks[i].price) {
				System.out.print(drinks[i].name+"\t");
			}
		}
		
		sc.close();
	}

}
