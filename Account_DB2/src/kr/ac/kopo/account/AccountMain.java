package kr.ac.kopo.account;

import kr.ac.kopo.account.ui.AccountUI;

public class AccountMain {

	public static void main(String[] args) {
		
		AccountUI ui = new AccountUI();
		try {
			ui.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
