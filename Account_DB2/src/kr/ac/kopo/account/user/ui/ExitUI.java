package kr.ac.kopo.account.user.ui;

public class ExitUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		System.out.println("======================================");
		System.out.println("\n\t 통합계좌관리시스템을 종료합니다.");
		System.out.println("======================================");
		System.exit(0);
	}

}
