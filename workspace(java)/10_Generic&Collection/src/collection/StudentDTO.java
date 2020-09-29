package collection;

public class StudentDTO {
	
	private int id;
	private String name;
	private String major;
	private String phone;
	private String addr;
	 
	public String getPhone() {
		return phone;
	} 
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
