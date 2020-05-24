package kr.ac.kopo.account.vo;

import kr.ac.kopo.account.user.vo.UserVO;

public class AccountVO extends UserVO{

	private int		userNo;			//사용자 개인 코드
	private String 	name;			//계좌주명
	private String	accountNo;		//계좌번호
	private int		bankNo;			//은행코드
	private int		balance;		//잔액
	private String	alias;			//별칭
	private String	bankName;		//은행명
	public AccountVO() {
		super();
	}
	public AccountVO(int userNo, String name) {
		super();
		this.userNo = userNo;
		this.name = name;
	}
	public AccountVO(int userNo, String name, String accountNo, int bankNo, int balance, String alias) {
		super();
		this.userNo = userNo;
		this.name = name;
		this.accountNo = accountNo;
		this.bankNo = bankNo;
		this.balance = balance;
		this.alias = alias;
	}
	
	
	public AccountVO(String bankName, String accountNo, String alias) {
		this.bankName = bankName;
		this.accountNo = accountNo;
		this.alias = alias;
	}
	public AccountVO(int userNo) {
		this.userNo = userNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBankNo() {
		return bankNo;
	}
	public void setBankNo(int bankNo) {
		this.bankNo = bankNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	@Override
	public String toString() {
		return "AccountVO [userNo=" + userNo + ", name=" + name + ", accountNo=" + accountNo + ", bankNo=" + bankNo
				+ ", balance=" + balance + ", alias=" + alias + "]";
	}
	
	
}
