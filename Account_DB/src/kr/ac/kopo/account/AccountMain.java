package kr.ac.kopo.account;

import kr.ac.kopo.account.user.ui.UserUI;

public class AccountMain {

	public static void main(String[] args) {
		
		UserUI ui = new UserUI();
		try {
			ui.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
