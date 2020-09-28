package generic;


class Box{
	
	private Object obj;

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}

public class Ex03 {

	public static void main(String[] args) {
		
		Box box = new Box();
		box.setObj("제네릭");			// String
		
		// 형변환 반드시 필요
		// 형변환이 자주 일어나게 되면 프로그램 성능이 저하
		String str = (String)box.getObj();
		
		System.out.println("str : " + str);
		
		
		
	}

}
