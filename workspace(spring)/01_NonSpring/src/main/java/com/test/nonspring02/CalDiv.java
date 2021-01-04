package com.test.nonspring02;

public class CalDiv implements Calculator {

	@Override
	public int sum(int fNum, int sNum) {
		
		return sNum != 0 ? (fNum / sNum) : 0;
	}

}
