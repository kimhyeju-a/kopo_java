package kr.ac.kopo.account.user.ui;

import kr.ac.kopo.account.ui.AccountUI;

public class CheckIdPassException extends Exception {

	public CheckIdPassException() {
	}

	public CheckIdPassException(String message) {
		System.out.println(message);
		System.out.println("\t확인 후 다시 시도 해주세요.");

		UserUI ui = new UserUI();
		try {
			Thread.sleep(1000);
			ui.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CheckIdPassException(String message, int ver) {
		if (ver == 2) {
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
}
