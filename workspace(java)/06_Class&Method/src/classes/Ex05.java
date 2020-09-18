package classes;

import java.util.*;

class Item {
	String name;
	int unitPrice;
	int count;
	
	public Item() { }
	
	public Item(String name, int unitPrice, int count) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.count = count;
	}
	
}

public class Ex05 {
	
	public static final double TAX_RATE=1.1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이템은 몇 개인가요? : ");
		Item[] items = new Item[sc.nextInt()];
		
		for(int i=0;i<items.length;i++){
			System.out.println((i+1)+"번째 제품의 품명, 단가, 수량을 입력해주세요.");
			items[i] = new Item(sc.next(),sc.nextInt(),sc.nextInt());
		}
		System.out.println();

		int total=0;
		
		System.out.println("품명\t단가\t수량\t금액");
		System.out.println("---------------------------------------");
		for(int i=0;i<items.length;i++) {
			System.out.print(items[i].name+"\t"+items[i].unitPrice+"\t"+ items[i].count);
			System.out.printf("\t%,6d원\n",items[i].unitPrice*items[i].count);
			total=items[i].unitPrice*items[i].count;
		}
		int supplyPrice= (int)(total /TAX_RATE);
		int vat = total - supplyPrice;
		
		System.out.println("---------------------------------------");
		System.out.printf("공급가액\t\t\t%,6d원\n",supplyPrice);
		System.out.printf("부가세\t\t\t%,6d원\n",vat);
		System.out.println("---------------------------------------");
		System.out.printf("청구금액\t\t\t%,6d원",supplyPrice+vat);
		
		sc.close();
	}

}
