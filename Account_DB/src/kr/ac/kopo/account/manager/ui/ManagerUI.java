package kr.ac.kopo.account.manager.ui;


public class ManagerUI extends ManagerBaseUI{

	private int choiceMenu() {
		System.out.println("=================================================================");
		System.out.println("\t\t\t관리자 계정입니다.");
		System.out.println("=================================================================");
		System.out.println("\t1. 사용자 전체 조회"); 
		System.out.println("\t2. 사용자 삭제");
		System.out.println("\t3. 계좌번호 전체 조회");
		System.out.println("\t4. 계좌번호 삭제");
		System.out.println("\t0. 로그아웃");
		System.out.println("-----------------------------------------------------------------");
		int type = scanInt("\t번호를 입력하세요 : ");
		return type;
	}

	@Override
	public void execute() throws Exception {
		loop : while(true) {
			int type = choiceMenu();
			IManagerUI ui = null;
			switch(type) {
			case 1 :
				ui = new MgrUserAllSelect();
				break;
			case 2 :
				ui = new MgrUserDelete();
				break;
			case 3 :
				ui = new MgrAccountAll();
				break;
			case 4 :
				ui = new MgrAccountDelete();
				break;
			case 0 :
				break loop;
			default : 
				System.out.println("1,2,3,4,0 만 입력해주세요.");
				break;
			}
			if(ui != null) {
				ui.execute();
			}
		}
	}
	
}
