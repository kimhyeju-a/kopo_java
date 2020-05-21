package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
/*
 	Statement [conn.createStatement]
 		implements(상속 용어 알기!!!!!!!)
 	PreparedStatement
 		ㄴ 문자열 필요할거니까 알아서 셋팅해줘~~~!! --> ok!
 */
public class InsertMain03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null; //인터페이스... 공부하기

		try {
			//1단계 : 
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2단계 : JDBC Driver를 이용한 DB접속, Connection 객체 얻기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			
			System.out.print("등록할 아이디를 입력하세요 : ");
			String id = sc.nextLine();
			System.out.print("등록할 이름를 입력하세요 : ");
			String name = sc.nextLine();
			
			//3단계 : sql 작성 (PreparedStatement) - 변수들어갈 곳에 ? 로 표시를한다.
			String sql = "insert into t_test(id,name) ";
				   sql+= " values(?,?)";
			
			pstmt = conn.prepareStatement(sql);
			//?에 변수삽입은 객체를 만든 후에 함		sql은 배열이 아니기 때문에 1부터 시작한다. 주의!
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			
			//4단계 : sql 실행
			int cnt = pstmt.executeUpdate();
			System.out.println("총 " +cnt + "개 행 삽입");
				   
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
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
