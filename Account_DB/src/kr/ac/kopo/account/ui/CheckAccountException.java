package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.ui.AccountUI;

public class CheckAccountException extends Exception {

	public CheckAccountException() {
	}

	public CheckAccountException(String message) {
		System.out.println(message);
		System.out.println("\t확인 후 다시 시도 해주세요.");

		AccountUI ui = new AccountUI();
		try {
			Thread.sleep(1000);
			ui.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
