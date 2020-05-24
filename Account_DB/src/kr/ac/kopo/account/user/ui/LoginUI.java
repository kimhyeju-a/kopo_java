package kr.ac.kopo.account.user.ui;


public class LoginUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		String name = scanStr("ID		: ");
		String password = scanStr("password	: ");
		
		////////////////////////////////////////////////////
		// 로그인을 하는 서비스
		userService.loginUser(name, password);
		
	}

}
