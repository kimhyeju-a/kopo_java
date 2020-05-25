package kr.ac.kopo.account.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.account.manager.ui.ManagerUI;
import kr.ac.kopo.account.ui.AccountUI;
import kr.ac.kopo.account.user.ui.CheckIdPassException;
import kr.ac.kopo.account.user.vo.UserVO;
import kr.ac.kopo.account.vo.AccountVO;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class UserDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	
	/**
	 * id중복 체크하는 기능 
	 */
	public boolean idCheck(String id) {
		boolean idCheckBool = true;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id");
			sql.append("  from t_user ");
			sql.append(" where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				idCheckBool = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return idCheckBool;
	}
	
	/**
	 * 새로운 유저를 등록하는 기능
	 */
	public void insertUser(UserVO newUser) {
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into t_user(user_no, id, password, name, age, phone_no) ");
			sql.append(" values(seq_t_user_no.nextval, ?, ?, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sql.toString());
			String id = newUser.getId();
			String pwd = newUser.getPassword();
			String name = newUser.getName();
			String age = newUser.getAge();
			String phoneNumber = newUser.getPhoneNumber();
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, age);
			pstmt.setString(5, phoneNumber);

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}

	}

	/**
	 * 로그인 기능
	 */
	public void loginUser(String id, String password) {
		if(id.equals("manager")) {
			if(password.equals("manager")) {
				System.out.println("\t관리자 계정으로 로그인 되었습니다");
				ManagerUI mgr = new ManagerUI();
				try {
					mgr.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		try {
			
			
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select user_no ,password");
			sql.append("  from t_user ");
			sql.append(" where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("password").equals(password)) {
					int userNo = rs.getInt("user_no");
					
					AccountVO vo = new AccountVO(userNo);
					new AccountUI().execute();
				}else {
					throw new CheckIdPassException("\t비밀번호가 일치하지 않습니다.");
				}
					
			}else {
				throw new CheckIdPassException("\t일치하는 아이디가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		JDBCClose.close(conn, pstmt);
	}

	/**
	 * 아이디 찾는 서비스 (비밀번호 찾기 할때 아이디를 얻어오는 역할 포함)
	 * @return id
	 */
	public String findId(String phoneNumber) {
		String findId = null;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select id");
			sql.append("  from t_user ");
			sql.append(" where phone_no = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, phoneNumber);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				findId = rs.getString("id");
			}else {
				throw new CheckIdPassException("\t해당 폰 번호와 일치하는 아이디가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return findId;
	}

	/**
	 * 비밀번호 찾기를 이용하여, 비밀번호 변경
	 * @param findId			변경을 진행할 아이디
	 * @param changePassword	바꿀 password
	 * @return 성공-true, 실패-false
	 */
	public boolean changePassword(String findId, String changePassword) {
		boolean changePwd = false;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update t_user ");
			sql.append("   set password = ? ");
			sql.append(" where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, changePassword);
			pstmt.setString(2, findId);
			
			pstmt.executeUpdate();
			changePwd = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return changePwd;
	}

}
