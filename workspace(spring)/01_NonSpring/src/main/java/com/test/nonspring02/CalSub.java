package com.test.nonspring02;

public class CalSub implements Calculator{
	
	@Override
	public int sum(int fNum, int sNum) {
		
		return fNum - sNum;
	}
}
