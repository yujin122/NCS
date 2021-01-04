package com.test.nonspring03;

public class ServiceImpl {
	
	// 객체
	private DAO dao;
	
	public ServiceImpl() {	}
	
	// 객체의 참조변수를 갖는 생성자
	public ServiceImpl(DAO dao) {
		this.dao = dao;
	}
	
	// 비지니스 로직
	public void biz() {
		dao.add();
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
		
}
