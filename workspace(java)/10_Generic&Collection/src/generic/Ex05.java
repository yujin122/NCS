package generic;

class Powder{
	
	@Override
	public String toString() {
		return "재료는 Powder 입니다.";
	}
}

class Plastic{
	
	@Override
	public String toString() {
		return "재료는 Plastic 입니다.";
	}
}

class GenericPrinter<T>{
	
	private T material;

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return material.toString();
	}
}

public class Ex05 {

	public static void main(String[] args) {
		
		GenericPrinter<Powder> printer1 = new GenericPrinter<Powder>();

		Powder powder = new Powder();
		printer1.setMaterial(powder);

		System.out.println(printer1.toString());
		System.out.println();

		GenericPrinter<Plastic> printer2 = new GenericPrinter<Plastic>();

		Plastic plastic = new Plastic();
		printer2.setMaterial(plastic);

		System.out.println(printer2.toString());
		
	}

}
