package kr.ac.kopo.account.user.ui;

public class CheckIdPassException extends Exception {
	
	public CheckIdPassException() {
	}

	public CheckIdPassException(String message) {
		System.out.println(message);
		System.out.println("확인 후 다시 로그인 해주세요.");
		UserUI ui = new UserUI();
		try {
			ui.execute();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
