package kr.ac.kopo.account.manager.ui;

import java.util.List;

import kr.ac.kopo.account.ui.CheckAccountException;
import kr.ac.kopo.account.user.vo.UserVO;
import kr.ac.kopo.account.vo.AccountVO;

public class MgrAccountAll extends ManagerBaseUI {

	@Override
	public void execute() throws Exception {
		List<AccountVO> list = managerService.mgrAccountAll();
		System.out.println("=================================================================");
		System.out.println("\t\t\t관리자 계정입니다.");
		System.out.println("\t\t\t계좌번호 전체 조회");
		System.out.println("=================================================================");
		System.out.println("번호\t소유주\t계좌번호\t\t은행코드\t별명\t잔액");
		System.out.println("-----------------------------------------------------------------");
		int i = 1;
		if(list.isEmpty()) {
			throw new CheckAccountException("\t보유하고 있는 계좌번호가 없습니다.");
		} else {
			for(AccountVO account : list) {
				System.out.println((i++)+"\t"+account.getName() + "\t" +account.getAccountNo() +"\t" + account.getBankNo() + "\t" + account.getAlias() +"\t"+account.getBalance());
			}
		}
	}

}
