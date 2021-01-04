package com.test.nonspring03;

public class OracleDao implements DAO {
	
	public OracleDao() {
		System.out.println("OracleDao 생성자입니다.");
	}
	
	@Override
	public void add() {
		System.out.println("OracleDao입니다.");
	}
}
