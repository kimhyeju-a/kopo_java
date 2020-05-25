package kr.ac.kopo.account.user.ui;


public class LoginUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("=================================================================");
		System.out.println("\t\t\t로그인");
		System.out.println("=================================================================");
		
		String id = scanStr("\tID\t: ");
		String password = scanStr("\tpassword: ");
		
		////////////////////////////////////////////////////
		// 로그인을 하는 서비스
		userService.loginUser(id, password);
		
	}

}
