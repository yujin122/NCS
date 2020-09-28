package collection;

/*
 * 자바 빈(Java Bean)?
 * - DB에 접근하여 특정 컬럼(속성)에 값을 저장하거나 저장된
 * 	  값을 가져오는 자바 클래스
 * - Java Bean == DTO(Data Transfer Object)  == VO(Value Object)
 * - 구성요소
 * 	 1. 멤버변수 - DB 컬럼명 : 접근지정자(private)
 * 	 2. setter() : 지정자 메서드
 * 	 3. getter() : 획득자 메서드
 */

public class MemberDTO {
	
	// 만약 DB 상에 테이블 이름이 member(회원 테이블)라고 가정했을 때
	// member 테이블의 구성(컬럼)이 id, pwd, name, age, address
	// 로 구성이 되어 있다고 가정하자.
	
	// 멤버변수
	private String id;		// 회원 아이디
	private String pwd;		// 회원 비밀번호
	private String name;	// 회원 이름
	private String age;		// 회원 나이
	private String address;	// 회원 주소 

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
