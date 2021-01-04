package com.test.nonspring03;

public class MySqlDao implements DAO {
	
	public MySqlDao() {
		System.out.println("MySqlDao 생성자입니다.");
	}
	
	@Override
	public void add() {
		System.out.println("MySqlDao 입니다.");
	}

}
