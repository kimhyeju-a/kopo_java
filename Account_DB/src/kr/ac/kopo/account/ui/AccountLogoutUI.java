package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.user.ui.UserUI;

public class AccountLogoutUI extends AccountBaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("=================================================================");
		System.out.println("\t\t\t로그아웃");
		System.out.println("=================================================================");
		
		new UserUI().execute();
	}

}
