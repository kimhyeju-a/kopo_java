package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//DriverManager 클래스에서 connection 객체를 얻어오고 connection객체에서 statement/preparedStatement 를 얻어올 수있다.
public class InsertMain01 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			//1단계 : JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1단계 드라이버 로딩 ... ");
			
			//2단계 : JDBC Driver를 이용한 DB접속, Connection 객체 얻기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("2단계 conn : " + conn);
			
			//3단계 : SQL문 실행 (Statement)
			stmt =conn.createStatement();
			//Update, Insert, Delete => execute(sql); 
			//Select 는 executeQuery 
			String sql = "insert into t_test(id,name) values('hong','홍길동')";
			
			//4단계 : SQL문 실행 및 결과 도출
			//int 형 총 몇개의 행을 변경했는지
			int cnt = stmt.executeUpdate(sql);
			System.out.println("총" + cnt + "개 행 삽입...");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			//5단계 : 자원반납 
			if(stmt != null) {
				try {
				stmt.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
