package generic;

class StringType {

	String[] str;
	String var;

	void setStr(String[] str) {
		this.str = str;
	}

	void setVar(String var) {
		this.var = var;
	}
	
	void prn() {
		for(String k : str) {
			System.out.println("str 배열 요소 : " + k);
		}
		
		System.out.println("var : " + var);
	}
}

class IntegerType{
	
	Integer[] iarr;
	Integer ivar;
	
	void setArr(Integer[] iarr) {
		this.iarr = iarr;
	}
	
	void setVar(Integer ivar) {
		this.ivar = ivar;
	}
	
	void prn() {
		for(Integer k : iarr) {
			System.out.println("iarr 배열 요소 : " + k);
		}
		
		System.out.println("ivar : " + ivar);
	}
	
}

public class Ex01 {

	public static void main(String[] args) {
		
		// StringType 클래스 객체 생성
		StringType st = new StringType();
		
		String[] str = {"홍길동", "이순신", "유관순"};
		String var = "김연아";
		
		st.setStr(str);
		st.setVar(var);
		st.prn();
		System.out.println();
		
		IntegerType it = new IntegerType();
		
		Integer[] iarr = {100, 200, 300};
		Integer ivar = 500;
		
		it.setArr(iarr);
		it.setVar(ivar);
		it.prn();
		
	}

}
