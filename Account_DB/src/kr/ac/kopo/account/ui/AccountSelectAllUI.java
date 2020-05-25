package kr.ac.kopo.account.ui;

import java.util.List;

import kr.ac.kopo.account.user.ui.CheckIdPassException;
import kr.ac.kopo.account.vo.AccountVO;

public class AccountSelectAllUI extends AccountBaseUI{

	@Override
	public void execute() throws Exception {
		List<AccountVO> list = accountService.selectAllBoard();
		int i = 1;
		System.out.println("=================================================================");
		System.out.println("\t\t\t계좌번호 수정");
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
	}

}
