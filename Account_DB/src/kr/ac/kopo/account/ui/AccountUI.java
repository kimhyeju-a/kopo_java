package kr.ac.kopo.account.ui;

public class AccountUI extends AccountBaseUI{
	private int choiceMenu() {
		System.out.println("=================================================================");
		System.out.println("\t\t\t통합계좌관리 시스템");
		System.out.println("=================================================================");
		System.out.println("\t1. 계좌정보 등록");
		System.out.println("\t2. 계좌정보 수정");
		System.out.println("\t3. 계좌정보 삭제");
		System.out.println("\t4. 계좌정보 조회");
		System.out.println("\t5. 입출금    수행 ");
		System.out.println("\t0. 로그아웃");
		System.out.println("-----------------------------------------------------------------");
		int type = scanInt("\t번호를 입력하세요 : ");
		return type;

	}
	
	public void execute() throws Exception {
		while(true) {
			IAccountUI ui = null;
			int type = choiceMenu();
			switch(type) {
			case 1:
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
				ui = new AccountActive();
				break;
			case 0:
				ui = new AccountLogoutUI();
				break;
			}
			if(ui != null) {
				ui.execute();
			}
		}
	}
}
