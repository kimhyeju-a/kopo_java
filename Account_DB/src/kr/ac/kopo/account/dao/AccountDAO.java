package kr.ac.kopo.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.account.ui.CheckAccountException;
import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class AccountDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	public AccountDAO() {}

	/**
	 * 계좌가 있는지 없는지 확인
	 * @param accountNo
	 * @return 있으면 false, 없으면 true 리턴
	 */
	public boolean checkAccountNo(String accountNo) {
		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("select account_no ");
			sql.append("  from t_account ");
			sql.append(" where account_no = ? ");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setString(1, accountNo);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return false;
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return false;
	}

	/**
	 * 계좌생성 기능
	 * @param newAccount
	 */
	public void insertBoard(AccountVO newAccount) {
		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("insert into t_account(user_no, name, account_no, bank_no, balance, alias) ");
			sql.append(" values(?, ?, ?, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sql.toString());
			int userNo = newAccount.getUserNo();
			String name = newAccount.getName();
			String accountNo = newAccount.getAccountNo();
			int bank_no = newAccount.getBankNo();
			int balance = newAccount.getBalance();
			String alias = newAccount.getAlias();

			pstmt.setInt(1, userNo);
			pstmt.setString(2, name);
			pstmt.setString(3, accountNo);
			pstmt.setInt(4, bank_no);
			pstmt.setInt(5, balance);
			pstmt.setString(6, alias);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

	/**
	 * User 테이블에서 유저의 이름 가져오는 기능
	 * 
	 * @param userNo
	 * @return
	 */
	public String getName(int userNo) {
		String name = null;
		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("select name ");
			sql.append("  from t_user ");
			sql.append(" where user_no = ? ");
			pstmt = conn.prepareStatement(sql.toString());

			pstmt.setInt(1, userNo);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				name = rs.getString("name");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return name;
	}
	/**
	 * 전체 계좌 조회
	 * @return 전체 계좌 리스트를 리턴
	 */
	public List<AccountVO> selectAllAccount() {
		List<AccountVO> list = new ArrayList<>();
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select bank_name , account_no, alias, balance ");
			sql.append("  from t_account a, t_bank b ");
			sql.append(" where a.bank_no = b.bank_no ");
			sql.append("   and user_no = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, AccountVO.userNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				String bankName = rs.getString("bank_name");
				String accountNo = rs.getString("account_no");
				String alias = rs.getString("alias");
				int balance = rs.getInt("balance");
				AccountVO account = new AccountVO(bankName, accountNo, balance, alias);

				list.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return list;
	}
	/**
	 * 은행별 계좌 조회
	 * @param findBankNo 
	 * @return
	 */
	public List<AccountVO> accountSelectBank(int findBankNo) {
		List<AccountVO> list = new ArrayList<>();
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select bank_name , account_no, alias, balance ");
			sql.append("  from t_account a, t_bank b ");
			sql.append(" where a.bank_no = ? ");
			sql.append("   and a.bank_no = b.bank_no ");
			sql.append("   and user_no = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, findBankNo);
			pstmt.setInt(2, AccountVO.userNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				String bankName = rs.getString("bank_name");
				String accountNo = rs.getString("account_no");
				String alias = rs.getString("alias");
				int balance = rs.getInt("balance");
				AccountVO account = new AccountVO(bankName, accountNo, balance, alias);

				list.add(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return list;
	}
	
	/**
	 * 계좌번호로 검색
	 */
	public AccountVO accountSelectNoUI(String findAccountNo) {
		AccountVO account = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select bank_name , account_no, alias, balance ");
			sql.append("  from t_account a, t_bank b ");
			sql.append(" where a.bank_no = b.bank_no ");
			sql.append("   and a.account_no = ? ");
			sql.append("   and a.user_no = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, findAccountNo);
			pstmt.setInt(2, AccountVO.userNo);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				String bankName = rs.getString("bank_name");
				String accountNo = rs.getString("account_no");
				String alias = rs.getString("alias");
				int balance = rs.getInt("balance");
				account = new AccountVO(bankName, accountNo, balance, alias);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return account;
	}
	/**
	 * 별칭을 바꾸는 기능
	 * @param modifyAccount
	 * @param modifyAlias
	 * @return 정상수행시 true, 실패시 false
	 */
	public boolean modifyAlias(String modifyAccount, String modifyAlias) {
		boolean bool = false;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update t_account ");
			sql.append("   set alias = ? ");
			sql.append(" where account_no = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, modifyAlias);
			pstmt.setString(2, modifyAccount);

			pstmt.executeUpdate();
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return bool;
	}

	/**
	 * 자기 보유 계좌를 지움
	 * @param deleteAccount
	 * @return
	 */
	public boolean deleteAccount(String deleteAccount) {
		boolean bool = false;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete  ");
			sql.append("  from t_account ");
			sql.append(" where account_no = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, deleteAccount);

			pstmt.executeUpdate();
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return bool;
	}
	/**
	 * 입금 서비스를 제공함
	 * @param account 	입금할 계좌
	 * @param money		입금할 금액
	 * @return	boolean
	 */
	public boolean activateDeposit(String account, int money) {
		boolean bool = false;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update t_account ");
			sql.append("   set balance = banlance + ? ");
			sql.append(" where account_no = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, money);
			pstmt.setString(2, account);

			pstmt.executeUpdate();
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return bool;
	}
	/**
	 * 출금 서비스
	 */
	public boolean activateWithDraw(String account, int money) {
		boolean bool = false;
		try {
			AccountVO vo = accountSelectNoUI(account);
			int balance = vo.getBalance();
			if(balance - money < 0 ) {
				throw new CheckAccountException("[잔액 : "+ balance +", 출금액 : "+ money +" ] 잔액이 부족합니다.");
			}
			conn = new ConnectionFactory().getConnection();
			
			StringBuilder sql = new StringBuilder();
			sql.append("update t_account ");
			sql.append("   set balance = balance - ? ");
			sql.append(" where account_no = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, money);
			pstmt.setString(2, account);

			pstmt.executeUpdate();
			bool = true;	
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return bool;
	}

	/**
	 * 계좌이체 서비스
	 */
	public boolean activateTransFer(String fromAccount, String toAccount, int money) {
		boolean bool = false;
		if(activateWithDraw(fromAccount,money)) {
			if(activateDeposit(toAccount,money)) {
				System.out.println("\t계좌이체 정상 처리");
				bool = true;
			}else {
				bool = false;
			}
		}
		return bool;
	}

}
