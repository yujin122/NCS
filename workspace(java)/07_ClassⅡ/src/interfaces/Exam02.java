package interfaces;

import java.util.Scanner;

interface Shape{
	double findArea();
}

class Circle implements Shape{
	int rad;
	
	public Circle() {	}
	
	public Circle(int rad) {
		this.rad = rad;
	}

	@Override
	public double findArea() {
		return (3.14*rad*rad);
	}
}

class Rectangle implements Shape{
	int width;
	int height;
	
	public Rectangle() {	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double findArea() {
		return (width*height);
	}
}
public class Exam02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("도형을 선택하세요.(1. 원형, 2. 사각형)");
		System.out.print("도형 선택 => ");
		int num = sc.nextInt();
		
		if(num == 1) {
			System.out.print("반지름 입력 => ");
			
			Circle circle = new Circle(sc.nextInt());
			
			System.out.println("==================================");
			System.out.printf("원의 면적 : %.1f", circle.findArea() );
		}else if(num == 2) {
			System.out.print("가로 => ");
			int wid = sc.nextInt();
			System.out.print("세로 => ");
			int heig = sc.nextInt();
			
			Rectangle rec = new Rectangle(wid,heig);
			
			System.out.println("==================================");
			System.out.printf("사각형의 면적 : %.1f", rec.findArea() );
		}else {
			System.out.println("1과 2 둘 중에 하나를 선택하세요.");
		}
		
		sc.close();

	}

}
