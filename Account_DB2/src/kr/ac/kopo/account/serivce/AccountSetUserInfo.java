package kr.ac.kopo.account.serivce;

import kr.ac.kopo.account.vo.AccountVO;

public class AccountSetUserInfo {
	private AccountService accountService;
	
	public AccountVO setUserInfo(int userNo) {
		String name = accountService.getName(userNo);
		AccountVO aVo = new AccountVO(userNo,name);
		return aVo;
	}
}
