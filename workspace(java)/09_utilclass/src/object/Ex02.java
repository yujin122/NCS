package object;

class Value{
	int value;
	
	public Value() {	}
	
	public Value(int value) {	
		this.value = value;
	}
}

public class Ex02 {

	public static void main(String[] args) {
		
		Value value1 = new Value(100);
		Value value2 = new Value(100);
		
		if(value1 == value2) {
			System.out.println("맞다");
		}else {
			System.out.println("다르다");
		}
		System.out.println();
		
		value2 = value1;
		
		if(value1.equals(value2)) {
			System.out.println("맞다");
		}else {
			System.out.println("다르다");
		}
	}

}
