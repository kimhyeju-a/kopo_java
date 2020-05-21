package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InsertMain02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		Statement stmt = null;

		try {
			//1단계
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2단계 : JDBC Driver를 이용한 DB접속, Connection 객체 얻기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);

			stmt = conn.createStatement();

			System.out.print("등록할 아이디를 입력하세요 : ");
			String id = sc.nextLine();
			System.out.print("등록할 이름를 입력하세요 : ");
			String name = sc.nextLine();

			//statement 의 문제점 : 하나의 변수를 아용해서 작은 따옴표 붙이는 것이 복잡해지기 시작함 ==> 전처리를 먼저 하고, 변수를 이용해 처리 하는 preparedStatement
			String sql = "insert into t_test(id, name) ";
				   sql+= "values( \'" + id + "\', \'" + name +"\') ";
				   
			int cnt = stmt.executeUpdate(sql);
			System.out.println("총 " + cnt + "개 행이 삽입...");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
