package overriding;

class Animal{
	
	void sound() {
		System.out.println("소리를 냅니다.");
	}
}

class Dog extends Animal{
	
	@Override
	void sound() {
		System.out.println("멍멍멍");
	}
}

class Cat extends Animal{
	@Override
	void sound() {
		System.out.println("야옹");
	}
}

class Duck extends Animal{
	@Override
	void sound() {
		System.out.println("꽥꽥");
	}
}

public class Animal_Main {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		Duck duck = new Duck();
		
		dog.sound(); cat.sound(); duck.sound();
	}

}
