package kr.ac.kopo.account.ui;

public class ActivateDeposit extends AccountBaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("=================================================================");
		System.out.println("\t\t\t입금/출금/계좌이체");
		System.out.println("\t\t\t입금 업무 페이지 입니다.");
		System.out.println("=================================================================");
		
		String account = scanStr("\t입금하실 계좌를 입력하세요. \t:");
		int money = scanInt("\t입금하실 금액을 입력하세요 \t:");
		while(money < 0) {
			System.out.println("\t입금할 금액은 0원 초과여야 합니다.");
			money = scanInt("\t입금하실 금액을 입력하세요 \t:");
		}
		
		if(accountService.activateDeposit(account,money)) {
			System.out.println("\t계좌번호 [ "+account+"]에 ["+money+"]원이 정상 입금되었습니다.");
		}else {
			System.out.println("\t예기치 않은 문제로 인해 입금이 완료되지 않았습니다.");
		}
	}
}
