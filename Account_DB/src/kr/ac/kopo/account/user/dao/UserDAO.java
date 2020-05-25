package kr.ac.kopo.account.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	 * 새로운 유저를 등록하는 기능
	 */
	public void insertUser(UserVO newUser) {
		try {
			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append("insert into t_user(user_no, id, password, name, age) ");
			sql.append(" values(seq_t_user_no.nextval, ?, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sql.toString());
			String id = newUser.getId();
			String pwd = newUser.getPassword();
			String name = newUser.getName();
			String age = newUser.getAge();
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, age);

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
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select user_no, name ,password");
			sql.append("  from t_user ");
			sql.append(" where id = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("password").equals(password)) {
					int userNo = rs.getInt("user_no");
					String name = rs.getString("name");
					System.out.println("***loginUser***");
//					new AccountUI().execute(userNo);
					
					//교수님. ...................................................
					AccountVO vo = new AccountVO(userNo,name);
					new AccountUI().setList(vo);
				}else {
					throw new CheckIdPassException("비밀번호가 일치하지 않습니다.");
				}
					
			}else {
				throw new CheckIdPassException("일치하는 아이디가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

	
	
}
