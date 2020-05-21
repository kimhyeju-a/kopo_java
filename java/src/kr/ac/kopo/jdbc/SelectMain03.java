package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

public class SelectMain03 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			
			while(true) {

				System.out.print("급여를 입력하시오 : ");
//				String sal = sc.nextLine();
				int sal = sc.nextInt();
				sc.nextLine();
				StringBuilder sql = new StringBuilder();
				sql.append("select job_title, avg(salary) ");
				sql.append("  from( ");
				sql.append("        select job_title, salary ");
				sql.append("          from employees e, jobs j ");
				sql.append("         where e.job_id = j.job_id ");
//				sql.append("           and salary >= " + sal + " ) ");
				sql.append("           and salary >= ? ) ");
				sql.append("group by job_title ");
				sql.append("order by 2 desc ");

				// prepareStatement 는 뒤에 String 형식밖에 오지 못한다. 따라서 toString으로 변환을 해준다.
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setInt(1, sal);
				
				ResultSet rs = pstmt.executeQuery();
				int cnt = 0;
				while (rs.next()) {
					String jobTitle = rs.getString("job_title");
					sal = rs.getInt("avg(salary)");
					System.out.println(" [ " + jobTitle + " ] " + sal);
					cnt++;
				} 
				System.out.println(" 총 [ "+ cnt + " ] 명이 검색되었습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
}
