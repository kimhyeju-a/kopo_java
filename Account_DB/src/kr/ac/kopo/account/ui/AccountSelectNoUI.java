package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.user.ui.CheckIdPassException;
import kr.ac.kopo.account.vo.AccountVO;

public class AccountSelectNoUI extends AccountBaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("=================================================================");
		System.out.println("\t\t\t계좌번호로 계좌 정보 검색");
		System.out.println("=================================================================");
		System.out.println("");
		String findAccountNo = scanStr("\t검색하실 계좌번호를 입력하세요 :");
		AccountVO account = accountService.accountSelectNoUI(findAccountNo);
		
		if(account == null) {
			throw new CheckIdPassException("\t일치하는 계좌번호가 없습니다.",2);
		}else {
			System.out.println("\t\t계좌번호\t: " + account.getAccountNo());
			System.out.println("\t\t은  행 명\t: " + account.getBankNo());
			System.out.println("\t\t별      명\t: " + account.getAlias());
			System.out.println("\t\t잔      액\t: " + account.getBalance());
			Thread.sleep(1000);
		}

	}

}
