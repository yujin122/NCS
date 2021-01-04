package com.test.nonspring03;

public class Factory {

	public static void main(String[] args) {
		
		MySqlDao mySqlDao = new MySqlDao();
		mySqlDao.add();
		
		OracleDao oracleDao = new OracleDao();
		oracleDao.add();
		
		System.out.println("=======================");
		
		// 1. 생성자를 이용하여 주입하는 방법
		ServiceImpl impl = new ServiceImpl(oracleDao);
		impl.biz();
		
		// 2. setter() 메서드를 이용하여 주입하는 방법
		ServiceImpl impl2 = new ServiceImpl();
		impl2.setDao(mySqlDao);
		impl2.biz();
	}

}
