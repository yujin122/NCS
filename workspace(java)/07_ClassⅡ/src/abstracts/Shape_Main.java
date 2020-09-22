package abstracts;

abstract class Shape1{
	abstract void draw();
}

class Line extends Shape1{
	@Override
	void draw() {
		System.out.println("선을 그리다.");
	}
}

class Rect extends Shape1{
	@Override
	void draw() {
		System.out.println("사각형을 그리다.");
	}
}

class Circle extends Shape1{
	@Override
	void draw() {
		System.out.println("원을 그리다");
		
	}
}

public class Shape_Main {

	public static void main(String[] args) {
		Line line = new Line();
		Circle circle = new Circle();
		Rect rect = new Rect();
		
		line.draw(); circle.draw(); rect.draw();
	}

}
