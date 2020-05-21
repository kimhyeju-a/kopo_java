package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBTestMain {

	public static void main(String[] args) {
		
		//1단계 : jdbc 드라이버 로딩 - 어떤 클래스를 내가 동적으로 읽게하겠다 (jvm이 읽게하겠다.) - checked Exception 이기 때문에 try catch로 묶어준다.
		try {
			//ojdbc6에 맞춰서 나온 것
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공 ...");
			
			//2단계 Connection 객체 생성
			Connection conn = DriverManager.getConnection(
							  "jdbc:oracle:thin:@`:1521:xe","hr", "hr");
			
			System.out.println("db 접속 성공 " + conn);
		} catch (Exception e) {
			e.printStackTrace();
			//이런것은 예외처리 크으으게 잡는다
		}
	}
}
