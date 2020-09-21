package inheritance;

/*
 * 1. super() 키워드
 * 	  - 자식클래스에서 부모클래스의 생성자를 호출하는 명령어
 * 		형식) super(인자);	// 인자는 생략도 가능
 * 2. this() 키워드
 * 	  - 현재 클래스에서 다른 생성자를 호출하는 명령어 
 * 		형식) this(인자);
 * 		주의) 생성자 첫 문장에 와야 한다
 */
class Point {
	int x;
	int y;
	
	public Point() { }
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Point3D extends Point{
	
	int z;
	
	public Point3D() { super(); }
	
	public Point3D(int x, int y) {
		super(x,y);
	}
	
	void prn() {
		System.out.println("X 좌표 >>> "+ x);
		System.out.println("Y 좌표 >>> "+ y);
		System.out.println("Z 좌표 >>> "+ z);
	}
	
	public Point3D(int x, int y, int z) {
		/*this.x = x;
		this.y = y;*/
		this(x,y);
		this.z = z;
	}
}
public class Point_Main {

	public static void main(String[] args) {
		
		Point3D point3d = new Point3D();

	}

}
