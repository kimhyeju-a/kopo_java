package kr.ac.kopo.account.manager.ui;

public class MgrAccountDelete extends ManagerBaseUI {

	@Override
	public void execute() throws Exception {
		// 전체 사용자 출력
		new MgrAccountAll().execute();

		System.out.println("=================================================================");
		System.out.println("\t\t\t관리자 계정입니다.");
		System.out.println("\t\t\t사용자 계좌 삭제 페이지 입니다.");
		System.out.println("=================================================================");

		String deleteAccount= scanStr("\t 삭제하실 사용자의 계좌번호를 입력하세요 : ");
		if (managerService.mgrAccountDelete(deleteAccount)) {
			System.out.println("\t[" + deleteAccount + "] 정상 삭제 되었습니다.");
		} else {
			System.out.println("\t[" + deleteAccount + "] 삭제 실패하였습니다.");
		}
	}

}
