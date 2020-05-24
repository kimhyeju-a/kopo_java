package kr.ac.kopo.account.user.ui;

import kr.ac.kopo.account.ui.IAccountUI;

//메인 실행 후, 처음으로 보여지는 화면을 담당
/*
	Main -> UserUI -> 회원 가입 -> UserUI로 돌아가서 로그인
				   -> 로그인 	-> 성공시 AccountUI
				   			-> 실패시 UserUI
 */

public class UserUI extends BaseUI {
	private int choiceMenu() {
		System.out.println("--------------------------------------------------------");
		System.out.println("\t\t통합계좌 관리시스템");
		System.out.println("\t\t이용을 위해서는 로그인이 필요합니다.");
		System.out.println("--------------------------------------------------------");
		System.out.println("\t1. 회원가입");
		System.out.println("\t2. 로그인");
		System.out.println("--------------------------------------------------------");
		int type = scanInt("\t번호를 입력하세요 : ");
		return type;

	}

	@Override
	public void execute() throws Exception {

		int type = choiceMenu();
		IUserUI ui = null;

		switch (type) {
		case 1:
			ui = new SignUpUI();
			break;
		case 2:
			ui = new LoginUI();
			break;
		case 0:
			ui = new ExitUI();
			break;
		}

		if (ui != null) {
			ui.execute();
		}
	}

}
