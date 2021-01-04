package com.test.nonspring02;

public class MainClass {

	public static void main(String[] args) {
		MyCalculator calculator;
		
		calculator = new MyCalculator(10, 5, new CalSum());
		calculator.result();
		
		calculator = new MyCalculator(10, 5, new CalSub());
		calculator.result();
		
		calculator = new MyCalculator(10, 5, new CalMul());
		calculator.result();
		
		calculator = new MyCalculator(10, 5, new CalDiv());
		calculator.result();
	}

}
