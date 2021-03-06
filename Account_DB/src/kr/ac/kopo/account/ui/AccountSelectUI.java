package kr.ac.kopo.account.ui;

public class AccountSelectUI extends AccountBaseUI {

	private int choiceMenu() {
		System.out.println("=================================================================");
		System.out.println("\t\t\t계좌 정보 조회");
		System.out.println("=================================================================");
		System.out.println("\t1. 계좌번호로 계좌 정보 조회");
		System.out.println("\t2. 전체 계좌 리스트 조회");
		System.out.println("\t3. 은행별 계좌정보 리스트 조회");
		System.out.println("\t0. 뒤로가기");
		System.out.println("-----------------------------------------------------------------");
		int type = scanInt("\t번호를 입력하세요 : ");
		return type;
	}

	@Override
	public void execute() throws Exception {
		loop : while(true) {
			IAccountUI ui = null;
			int type = choiceMenu();
			
			switch (type){
			case 1 :
				ui =  new AccountSelectNoUI();
				break;
			case 2 :
				ui = new AccountSelectAllUI();
				break;
			case 3 :
				ui = new AccountSelectBankUI();
				break;
			case 0 :
				break loop;
			}
			if(ui != null) {
				ui.execute();
			}
		}

	}

}
