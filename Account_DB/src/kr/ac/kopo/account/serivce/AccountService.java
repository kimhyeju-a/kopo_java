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
	public List<AccountVO> accountSelectBank(int findBankNo) {
		List<AccountVO> list = accountDAO.accountSelectBank(findBankNo);
		return list;
	}

	public AccountVO accountSelectNoUI(String findAccountNo){
		AccountVO list = accountDAO.accountSelectNoUI(findAccountNo);
		return list;
	}
	public boolean modifyAlias(String modifyAccount, String modifyAlias) {
		boolean bool = accountDAO.modifyAlias(modifyAccount, modifyAlias);
		return bool;
	}

	public boolean deleteAccount(String deleteAccount) {
		boolean bool = accountDAO.deleteAccount(deleteAccount);
		return bool;
	}

	public boolean activateDeposit(String account, int money) {
		boolean bool = accountDAO.activateDeposit(account,money);
		return bool;
	}

	public boolean activateWithDraw(String account, int money) {
		boolean bool = accountDAO.activateWithDraw(account, money);
		return false;
	}

	public boolean activateTransFer(String fromAccount, String toAccount, int money) {
		boolean bool = accountDAO.activateTransFer(fromAccount, toAccount, money);
		return false;
	}


}
