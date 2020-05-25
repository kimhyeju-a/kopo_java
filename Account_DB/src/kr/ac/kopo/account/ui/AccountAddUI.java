package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.vo.AccountVO;

public class AccountAddUI extends AccountBaseUI{

	@Override
	public void execute() throws Exception {
		System.out.println("=================================================================");
		System.out.println("\t\t\t계좌번호 등록");
		System.out.println("=================================================================");
		
		int bankNo = scanInt("\t1.하나은행,2.국민은행,3.우리은행,4.농협\n\t등록할 은행명을 입력하세요 \t: ");

		//계좌등록은 통합계좌관리시스템에서 제공하는 은행에 한해서만 가능하다.
		while(bankNo < 1 || bankNo > 4) {
			System.out.println("\t계좌등록은 통합계좌관리시스템에서 제공하는 은행만 가능합니다. \n\t다시 입력해주세요.");
			bankNo = scanInt("\t1.하나은행,2.국민은행,3.우리은행,4.농협\n\t등록할 은행명을 입력하세요 \t: ");			
		}
		
		String accountNo = scanStr("\t원하는 계좌번호를 입력하세요 \t: ");
		while(!(accountService.checkAccountNo(accountNo))) {
			System.out.println("\t이미 존재하는 계좌번호 입니다.");
			System.out.println("\t다른 계좌번호를 입력해주세요.");
			accountNo = scanStr("\t원하는 계좌번호를 입력하세요 \t: ");
		}
		String alias = scanStr("\t계좌의 별칭을 입력해주세요 \t: ");
		
		int balance = scanInt("\t입금액을 입력하세요 \t\t:");
		while(balance < 1000) {
			System.out.println("\t첫 계좌 생성시 입금액은 1000원 이상이어야 합니다.");
			balance = scanInt("\t입금액을 입력하세요 \t\t:");
		}
		
		//계좌 등록
		AccountVO newAccount = new AccountVO();
		int userNo = newAccount.getUserNo();
		newAccount.setUserNo(userNo);						//사용자 개인코드
		newAccount.setName(accountService.getName(userNo));	//사용자 이름
		newAccount.setAccountNo(accountNo);					//계좌번호
		newAccount.setBankNo(bankNo);						//은행코드
		newAccount.setBalance(balance);						//잔액
		newAccount.setAlias(alias);							//계좌별칭
		
		
		accountService.insertAccount(newAccount);
	}

}
