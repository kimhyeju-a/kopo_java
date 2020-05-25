package kr.ac.kopo.account.manager.ui;

public class MgrUserDelete extends ManagerBaseUI {

	@Override
	public void execute() throws Exception {
		// 전체 사용자 출력
		new MgrAccountAll().execute();

		System.out.println("=================================================================");
		System.out.println("\t\t\t관리자 계정입니다.");
		System.out.println("\t\t\t사용자 삭제 페이지 입니다.");
		System.out.println("=================================================================");

		int deleteUser = scanInt("\t 삭제하실 사용자의 고유 번호를 입력하세요 : ");
		if (managerService.mgrUserDelete(deleteUser)) {
			System.out.println("\t[" + deleteUser + "] 정상 삭제 되었습니다.");
		} else {
			System.out.println("\t[" + deleteUser + "] 삭제 실패하였습니다.");
		}
	}

}
