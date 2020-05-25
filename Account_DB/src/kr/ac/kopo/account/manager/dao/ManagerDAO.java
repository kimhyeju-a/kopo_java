package kr.ac.kopo.account.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.ac.kopo.account.user.vo.UserVO;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class ManagerDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	/**
	 * 모든 사용자 출력
	 * @return
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
	public boolean mgrUserDelete(int useNo) {
		boolean bool = false;
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("delete user_no, id, name, age, phone_no, reg_date ");
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

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return list;
	}
	/**
	 * 연관되어 있는 사용자 삭제
	 */
}
