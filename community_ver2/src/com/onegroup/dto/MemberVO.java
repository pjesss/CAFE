package com.onegroup.dto;

public class MemberVO {
	private String name;
	private String userid;
	private String pw;
	private int age;
	private String email;
	private String phone;
	private String address;
	private int usermoney;
	private int userlevel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUsermoney() {
		return usermoney;
	}
	public void setUsermoney(int usermoney) {
		this.usermoney = usermoney;
	}
	public int getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVO(String name, String userid, String pw, int age, String email, String phone, String address,
			int usermoney, int userlevel) {
		super();
		this.name = name;
		this.userid = userid;
		this.pw = pw;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.usermoney = usermoney;
		this.userlevel = userlevel;
	}

	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", userid=" + userid + ", pw=" + pw + ", age=" + age + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", usermoney=" + usermoney + ", userlevel=" + userlevel
				+ "]";
	}
	
	
}
