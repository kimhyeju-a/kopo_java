package kr.ac.kopo.account.ui;

import java.util.List;

import kr.ac.kopo.account.user.ui.CheckIdPassException;
import kr.ac.kopo.account.vo.AccountVO;

public class AccountDeleteUI extends AccountBaseUI {

	@Override
	public void execute() throws Exception {
		List<AccountVO> list = accountService.selectAllBoard();
		int i = 1;
		System.out.println("=================================================================");
		System.out.println("\t\t\t계좌번호 삭제");
		System.out.println("\t\t\t보유하고 있는 계좌 정보");
		System.out.println("=================================================================");
		System.out.println("번호\t계좌번호\t\t은행명\t별명\t잔액");
		System.out.println("-----------------------------------------------------------------");
		
		if(list.isEmpty()) {
			throw new CheckAccountException("\t보유하고 있는 계좌번호가 없습니다.");
		} else {
			for(AccountVO account : list) {
				System.out.println((i++)+"\t"+account.getAccountNo() +"\t" + account.getBankName() + "\t" + account.getAlias() +"\t"+account.getBalance());
			}
		}
		
		
		System.out.println();
		String deleteAccount = scanStr("\t삭제할 계좌번호를 입력하세요.\t:");
		
		if(accountService.checkAccountNo(deleteAccount)) {
			throw new CheckAccountException("\t일치하는 계좌번호가 없습니다.");
		}
		
		if(accountService.deleteAccount(deleteAccount)) {
			System.out.println("\t\t[ "+ deleteAccount + " ] 가 삭제 완료되었습니다.");
			Thread.sleep(1000);
		}else {
			System.out.println("변경 실패하였습니다.");
		}		
	}
}
