package kr.ac.kopo.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class AccountDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private AccountVO aVo;
	
	public AccountDAO() {
		
	}

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
			
			if(rs.next()) {
				return false;
			}
			return true;
			
		}catch (Exception e) {
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
			System.out.println("테스트");
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}		
	}

	/**
	 * User 테이블에서 유저의 이름 가져오는 기능 
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
			
			if(rs.next()) {
				name = rs.getString("name");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return name;
	}

	public List<AccountVO> selectAllAccount() {
		List<AccountVO> list = new ArrayList<>();
		try {
			conn = new ConnectionFactory().getConnection();
			System.out.println(aVo.getUserNo());
			StringBuilder sql = new StringBuilder();
			sql.append("select bank_name , account_no, alias ");
			sql.append("  from t_account a, t_bank b ");
			sql.append(" where a.bank_no = b.bank_no ");
			sql.append("   and user_no = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1,aVo.getUserNo());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				String bankName = rs.getString("bank_name");
				String accountNo = rs.getString("account_no");
				String alias = rs.getString("alias");
				
				AccountVO account = new AccountVO(bankName,accountNo,alias);
				
				list.add(account);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return list;
	}

}
