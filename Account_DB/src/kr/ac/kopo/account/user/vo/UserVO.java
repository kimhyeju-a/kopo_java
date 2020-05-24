package kr.ac.kopo.account.user.vo;

public class UserVO {

	private int 	userNo;				// 사용자 고유 넘버 (해당 넘버로 계좌table과 join)
	private String 	id;					// id
	private String	password;			// password
	private String	name;				// 사용자 이름
	private String 	age;				// 사용자 나이
	private String 	regDate;			// 등록일자
	
	public UserVO() {
		super();
	}
	public UserVO(int userNo ,String name) {
		this.userNo = userNo;
		this.name = name;
	}
	public UserVO(int userNo, String id, String password, String name, String age, String residentNo, String regDate) {
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "UserVO [userNo=" + userNo + ", id=" + id + ", password=" + password + ", name=" + name + ", age=" + age
				+ ", regDate=" + regDate + "]";
	}
	

}
