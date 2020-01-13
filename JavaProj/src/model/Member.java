package model;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String socialNumber;
	private String address;
	private String phone;

	public Member(String id, String pw, String name, String socialNumber, String address, String phone) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.socialNumber = socialNumber;
		this.address = address;
		this.phone = phone;
	}

	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
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
