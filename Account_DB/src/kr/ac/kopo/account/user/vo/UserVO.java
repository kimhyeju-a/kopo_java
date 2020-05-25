package kr.ac.kopo.account.user.vo;

import java.util.Date;

public class UserVO {

	private int 	userNo;				// 사용자 고유 넘버 (해당 넘버로 계좌table과 join)
	private String 	id;					// id
	private String	password;			// password
	private String	name;				// 사용자 이름
	private int 	age;				// 사용자 나이
	private String	phoneNumber;		// 핸드폰번호 -- 아이디/비밀번호 찾기에 쓰임
	private Date 	regDate;			// 등록일자
	
	public UserVO() {
		super();
	}
	public UserVO(int userNo ,String name) {
		this.userNo = userNo;
		this.name = name;
	}
	
	public UserVO(int userNo, String id, String name, int age, String phoneNumber, Date regDate) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.regDate = regDate;
	}
	
	public UserVO(int userNo, String id, String password, String name, int age, String residentNo, Date regDate) {
		super();
		this.userNo = userNo;
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.regDate = regDate;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "UserVO [userNo=" + userNo + ", id=" + id + ", password=" + password + ", name=" + name + ", age=" + age
				+ ", regDate=" + regDate + "]";
	}
	

}
