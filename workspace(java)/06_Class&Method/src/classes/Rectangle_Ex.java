package classes;

import java.util.Scanner;

class Rectangle{
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void area() {
		System.out.println("사격형의 넓이 : " + (width * height));
	}
	
	public void cum() {
		System.out.println("사각형의 둘레 : " + ((width + height)*2));
	}
}

public class Rectangle_Ex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사각형의 가로,세로를 입력하세요.");
		
		Rectangle rct = new Rectangle(sc.nextInt(),sc.nextInt());
		
		System.out.println("==============================");
		rct.area();
		rct.cum();
		
		sc.close();
	}
}