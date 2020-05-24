package kr.ac.kopo.account.ui;

import java.util.List;

import kr.ac.kopo.account.serivce.AccountSetUserInfo;
import kr.ac.kopo.account.vo.AccountVO;

public class AccountModifyUI extends AccountBaseUI{
//	private AccountSetUserInfo setInfo= null;
	
	@Override
	public void execute() throws Exception {
		List<AccountVO> list = accountService.selectAllBoard();
		int i = 1;
		System.out.println("--------------------------------------------------------");
		System.out.println("번호\t계좌번호\t별명");
		System.out.println("--------------------------------------------------------");
		if(list.isEmpty()) {
			System.out.println("\t등록된 게시물이 없습니다.");
		} else {
			for(AccountVO account : list) {
				System.out.println((i++)+"\t"+account.getAccountNo() +"\t" + account.getBankName() + "\t" + account.getAlias());
			}
		}
	}

}
