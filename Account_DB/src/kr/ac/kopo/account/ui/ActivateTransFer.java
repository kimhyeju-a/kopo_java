package kr.ac.kopo.account.ui;

import kr.ac.kopo.account.vo.AccountVO;

public class ActivateTransFer extends AccountBaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("=================================================================");
		System.out.println("\t\t\t입금/출금/계좌이체");
		System.out.println("\t\t\t계좌이체 업무 페이지 입니다.");
		System.out.println("=================================================================");
		
		String fromAccount = scanStr("\t출금하실 계좌를 입력하세요. \t:");
		while(accountService.checkAccountNo(fromAccount,AccountVO.userNo)) {
			System.out.println("\t계좌번호가 없습니다.");
			fromAccount = scanStr("\t출금하실 계좌를 입력하세요. \t:");
		}
		String toAccount = scanStr("\t계좌이체하실 계좌를 입력하세요. \t:");
		while(accountService.checkAccountNo(toAccount)) {
			System.out.println("\t계좌번호가 없습니다.");
			toAccount = scanStr("\t계좌이체하실 계좌를 입력하세요. \t:");
		}
		int money = scanInt("\t출금하실 금액을 입력하세요 \t:");
		while(money < 0) {
			System.out.println("\t출금할 금액은 0원 초과여야 합니다.");
			money = scanInt("\t출금하실 금액을 입력하세요 \t:");
		}
		if(accountService.activateTransFer(fromAccount,toAccount,money)) {
			System.out.println("\t계좌번호 [ "+fromAccount+"]에서 ["+money+"]원이 출금되었습니다.");
			System.out.println("\t계좌번호 [ "+toAccount+"]에서 ["+money+"]원이 출금되었습니다.");
		}else {
			System.out.println("\t예기치 않은 문제로 인해 입금이 완료되지 않았습니다.");
		}
	}

}
