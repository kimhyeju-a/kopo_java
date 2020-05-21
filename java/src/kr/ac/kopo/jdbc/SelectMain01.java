package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class SelectMain01 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			/*
			 	conn = new ConnectionFactory().getConnection();
				garbege collection 이 수거해갈 수 있다. .getConnection(); 이 되자마자 사라진다. 
				ConnectionFactory안에 멤버변수를 활용하고 싶을 때에는 절대 사용하면 안된다.
					
				garbege collection이 다음 실행문이 선언된 브레이스문이 끝날 때 수거해간다.
				ConnectionFactory안에 멤버변수를 활용하고 싶을 때에는 다음 구문을 사용해야 한다.
				ConnectionFactory fact = new ConnectionFactory();
				conn = fact.getConnection();
				
				
				new InputStreamReader(System.in)의 변수를 알지 못하므로 close를 시킬 수 없다. 프로그램이 종료해야지만 close가 된다.
					서브클래스 (?)에서는 사용하지 않는 것이 좋다.
				BufferedReader br = new BufferedReader(new InputStreamTeader(System.in));
				
			 */
			conn = new ConnectionFactory().getConnection();
			
			String sql = "select * from t_test ";
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery(); // ResultSet형이다.
			
			while(rs.next()) {
				System.out.println("id : " + rs.getString("id") + "\tname : " + rs.getString("name"));
//				System.out.println("id : " + rs.getString(1) + "\tname : " + rs.getString(2));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
}
