package kr.ac.kopo.account.serivce;

import java.util.List;

import kr.ac.kopo.account.dao.AccountDAO;
import kr.ac.kopo.account.vo.AccountVO;

public class AccountService {

	private AccountDAO accountDAO;
	
	public AccountService() {
		accountDAO = new AccountDAO();
	}
	
	public void insertAccount(AccountVO newAccount) {
		accountDAO.insertBoard(newAccount);
	}
	
	public boolean checkAccountNo(String accountNo) {
		boolean bool = accountDAO.checkAccountNo(accountNo);	
		return bool;
	}

	public String getName(int userNo) {
		String name = accountDAO.getName(userNo);
		return name;
	}

	public List<AccountVO> selectAllBoard() {
		List<AccountVO> list = accountDAO.selectAllAccount();
		return list;
	}

}
