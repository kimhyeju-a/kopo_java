package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.user.ui.UserUI;
import kr.ac.kopo.account.vo.AccountVO;

public class AccountUI extends AccountBaseUI{
	private int choiceMenu() {
		System.out.println("--------------------------------------------------------");
		System.out.println("\t\t통합계좌관리시스템");
		System.out.println("--------------------------------------------------------");
		System.out.println("\t1. 계좌번호 등록");
		System.out.println("\t2. 계좌번호 수정");
		System.out.println("\t3. 계좌번호 삭제");
		System.out.println("\t4. 계좌번호 조회");
		System.out.println("\t0. 로그아웃");
		System.out.println("--------------------------------------------------------");
		int type = scanInt("\t번호를 입력하세요 : ");
		return type;

	}
	
	public void execute() throws Exception {
		IAccountUI ui = new UserUI();
		ui.execute();
		
		while(true) {
			int type = choiceMenu();
			switch(type) {
			case 1:
				System.out.println("1을선택");
				ui = new AccountAddUI();
				break;
			case 2:
				ui = new AccountModifyUI();
				break;
			case 3:
				ui = new AccountDeleteUI();
				break;
			case 4:
				ui = new AccountSelectUI();
				break;
			case 5:
				ui = new AccountLogoutUI();
				break;
			}
			if(ui != null) {
				ui.execute();
			}
		}
	}
}
