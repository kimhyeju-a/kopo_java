package kr.ac.kopo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.util.JDBCClose;

/*
	t_test에서 오름차순 기준 (id) 첫번째 사용자 조회
 */
public class SelectMain02 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = new ConnectionFactory().getConnection();
			/*
			// 이런식으로 코드를 작성하게 되면 불필요한 공간들이 많이 생겨나게 된다. 따라서 StringBuffer,StringBulider 클래스를 이용해 작성을 하는것이 좋다.
			String sql = "select * ";
				   sql+= "	from ( ";
				   sql+= "		   select * ";
				   sql+= "			 from t_test ";
				   sql+= "		 order by id ";
				   sql+= "					) ";
				   sql+= " where rownum = 1 ";
			*/
			//pstmt = conn.prepareStatement(sql);
			
			
			StringBuffer sb = new StringBuffer();
			sb.append("select * ");
			sb.append("	from ( ");
			sb.append("		   select * ");
			sb.append("			 from t_test ");
			sb.append("		 order by id ");
			sb.append("					) ");
			sb.append(" where rownum = 1 ");
			//prepareStatement 는 뒤에 String 형식밖에 오지 못한다. 따라서 toString으로 변환을 해준다.
			pstmt = conn.prepareStatement(sb.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
//				System.out.println("id : " + rs.getString("id") + "\tname : " + rs.getString("name"));
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println("id : " + id + "\tname : " + name);
				
				
			
			}else {
				System.out.println("등록된 id가 없습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
}
