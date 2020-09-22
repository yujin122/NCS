package abstracts;

abstract class Animal1{
	
	abstract void sound();
}

class Dog extends Animal1{
	
	@Override
	void sound() {
		System.out.println("멍멍멍");
	}
}

class Cat extends Animal1{
	@Override
	void sound() {
		System.out.println("야옹");
	}
}

class Duck extends Animal1{
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
