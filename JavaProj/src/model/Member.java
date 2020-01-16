package model;


public class Member {
	private String id;
	private String pw;
	private String name;
	private String socialNumber;
	private String address;
	private String phone;

	public Member(String id, String name, String socialNumber, String address, String phone, String pw) {
		super();
		this.id = id;
		this.name = name;		
		this.socialNumber = socialNumber;
		this.address = address;
		this.phone = phone;
		this.pw = pw;
	}

	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}	
	
	public Member(String id, String name, String pw, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
	}		

	public Member(String name,String pw, String address, String phone) {
		super();
		this.name = name;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
	}
	
	public Member(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public String getSocialNumber() {
		return socialNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

}
