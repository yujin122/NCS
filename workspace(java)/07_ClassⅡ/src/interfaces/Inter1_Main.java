package interfaces;

interface Inter1{
	
	void aa();
	
}

// 인터페이스끼리 상속을 하는 경우에는 extends를 사용
interface Inter2 extends Inter1{
	
	void bb();
	
}

// 자바에서는 일반적으로 단일 상속만 가능
// 하지만 인터페이스는 다중 상속이 가능
interface Inter3 extends Inter2{
	
	void cc();
	
}

class BB implements Inter3{

	@Override
	public void aa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bb() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cc() {
		// TODO Auto-generated method stub
		
	}
	
}
public class Inter1_Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
