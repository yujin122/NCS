package abstracts;

abstract class SmartPhone{
	
	String call = "전화";
	String sns = "SNS";
	String search = "인터넷 검색";
	String game = "게임";
	
	String company, name, color, size, weight, price;
	
	// 각각의 기계들의 속성
	void purpose() {
		System.out.println("사용목적 : "+call+" / "+ sns +" / "+search+" / "+game);
	}
	
	// 각각의 기계들의 spec
	abstract void spec();
}

class Galaxy extends SmartPhone{
	@Override
	void spec() {
		company = "삼성";
		name = "Galaxy Note 20";
		color = "화이트";
		size = "20cm";
		weight = "350g";
		price = "150만원";

		System.out.println(company + " / " + name + " / " + color + " / " + size + " / " + weight + " / " + price);
	}
}

class IPhone extends SmartPhone{
	@Override
	void spec() {
		company = "애플";
		name = "IPhone 11";
		color = "화이트";
		size = "15cm";
		weight = "200g";
		price = "150만원";

		System.out.println(company + " / " + name + " / " + color + " / " + size + " / " + weight + " / " + price);
		
	}
}
public class Phone_Main {

	public static void main(String[] args) {
		Galaxy galaxy = new Galaxy();
		galaxy.purpose();
		galaxy.spec();
		System.out.println();
		
		IPhone iPhone = new IPhone();
		iPhone.purpose();
		iPhone.spec();
	}


}
