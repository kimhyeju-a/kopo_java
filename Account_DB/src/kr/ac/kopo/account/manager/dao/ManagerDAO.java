package kr.ac.kopo.account.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.ac.kopo.account.user.vo.UserVO;
import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class ManagerDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	/**
	 * 모든 사용자 출력
	 */
	public List<UserVO> mgrUserAll() {
		List<UserVO> list = new ArrayList<>();
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select user_no, id, name, age, phone_no, reg_date ");
			sql.append("  from t_user ");

			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int userNo = rs.getInt("user_no");
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String phoneNo = rs.getString("phone_no");
				Date date = rs.getDate("reg_date");
				UserVO user = new UserVO(userNo, id, name, age, phoneNo, date);
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return list;
	}

	/**
	 * 사용자 삭제
	 */
	public boolean mgrUserDelete(int userNo) {
		boolean bool = false;
		// 사용자가 가지고 있는 계좌가 정상적으로 삭제되었을 때에만 사용자 삭제를 수행할 수 있다.
		if(mgrUserAccountDelete(userNo)) {			
			conn = new ConnectionFactory().getConnection();
			try {
				conn.setAutoCommit(false);
				StringBuilder sql = new StringBuilder();
				sql.append("delete ");
				sql.append("  from t_user ");
				sql.append(" where user_no = ? ");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, userNo);
				pstmt.executeUpdate();
				conn.commit();
				bool = true;
			} catch (Exception e) {
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException sqlE) {
					// TODO: handle exception
				}
			} finally {
				JDBCClose.close(conn, pstmt);
			}
		}
		return bool;
	}

	/**
	 * 연관되어 있는 사용자 계좌 삭제
	 */
	public boolean mgrUserAccountDelete(int userNo) {
		boolean bool = false;
		try {
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			sql.append("delete ");
			sql.append("  from t_account ");
			sql.append(" where user_no = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, userNo);
			pstmt.executeUpdate();
			conn.commit();
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException sqlE) {
				// TODO: handle exception
			}
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return bool;
	}

	/**
	 * 전체 사용자의 계좌 츨력 
	 */
	public List<AccountVO> mgrAccountAll() {
		List<AccountVO> list = new ArrayList<>();
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select user_no, name, account_no, bank_no, balance, alias ");
			sql.append("  from t_account ");
			sql.append(" order by user_no ");

			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int userNo = rs.getInt("user_no");
				String name = rs.getString("name");
				String accountNo = rs.getString("account_no");
				int bankNo = rs.getInt("bank_no");
				int balance = rs.getInt("balance");
				String alias = rs.getString("alias");
				AccountVO user = new AccountVO(userNo, name, accountNo, bankNo, balance, alias);

				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return list;
	}

	/**
	 * 사용자 계좌 삭제
	 */
	public boolean mgrAccountDelete(String deleteAccount) {
		boolean bool = false;
		try {
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			sql.append("delete ");
			sql.append("  from t_account ");
			sql.append(" where account_no = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, deleteAccount);
			pstmt.executeUpdate();
			conn.commit();
			bool = true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException sqlE) {
				// TODO: handle exception
			}
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return bool;
	}
}
