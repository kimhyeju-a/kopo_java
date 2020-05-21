package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class UpdateMain02 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			ConnectionFactory factory = new ConnectionFactory();
			conn = factory.getConnection();
			// 3

			Scanner sc = new Scanner(System.in);

			System.out.print("id를 입력하세요 : ");
			String id = sc.nextLine();

			System.out.print("변경할 이름을 입력하세요:");
			String name = sc.nextLine();

			String sql = "update t_test ";
			sql += "	 set name = ? ";
			sql += " where id = ? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			
			
			//4단계
			int cnt = pstmt.executeUpdate();
			System.out.println("총 " + cnt + "개 행이 수정되었습니다.");
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			//5단계
			JDBCClose.close(conn, pstmt);
		}
	}
}
