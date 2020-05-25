package kr.ac.kopo.account.ui;

public class AccountActive extends AccountBaseUI {

	private int choiceMenu() {
		System.out.println("=================================================================");
		System.out.println("\t\t\t입금/출금/계좌이체 업무 수행");
		System.out.println("=================================================================");
		System.out.println("\t1. 입금");
		System.out.println("\t2. 출금");
		System.out.println("\t3. 계좌이체");
		System.out.println("\t0. 뒤로가기");
		System.out.println("-----------------------------------------------------------------");
		int type = scanInt("\t번호를 입력하세요 : ");
		return type;
	}
	
	@Override
	public void execute() throws Exception {
		loop : while(true) {
			int type = choiceMenu();
			IAccountUI ui = null;
			switch(type) {
			case 1 :
				ui = new ActivateDeposit();
				break;
			case 2 :
				ui = new ActivateWithDraw();
				break;
			case 3 :
				ui = new ActivateTransFer();
				break;
			case 0 :
				break loop;
			default : 
				System.out.println("1,2,3,0 만 입력해주세요.");
				break;
			}
			if(ui !=null) {
				ui.execute();
			}
		}
	}

}
