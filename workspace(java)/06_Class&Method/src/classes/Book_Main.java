package classes;

import java.util.Scanner;

class Book {
	String title;
	String author;
	String price;
	
	public Book() {  }
	
	public Book(String title,String author, String price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
}

public class Book_Main {

	public static void main(String[] args) {
		// 객체 배열 생성
		Book[] books = new Book[3];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<books.length;i++) {
			System.out.println((i+1)+"번째 책 제목, 책 저자, 가격을 입력하세요...");
			books[i] = new Book(sc.nextLine(),sc.nextLine(),sc.nextLine());
		}
		
		for(int i = 0;i<books.length;i++) {
			System.out.println("*****"+(i+1)+"번째 책 정보*****");
			System.out.println("책 제목 : " +books[i].title);
			System.out.println("책 저자 : " +books[i].author);
			System.out.println("책 가격 : " +books[i].price +"원");
			System.out.println();
		}
		
		sc.close();
	}

}
