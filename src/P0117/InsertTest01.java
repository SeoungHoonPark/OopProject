package P0117;
/*
 * 	문제
 * 		Test01 테이블에 5사람을 등록하자.
 * 
 * 		INSERT 명령을 5번 내려라...
 */
import		SQL.*;
import		java.sql.*;
public class InsertTest01 {
	public InsertTest01() {
		OracleJDBC			db = null;
		Connection			con = null;
		PreparedStatement	pstmt = null;
		try {
			db = new OracleJDBC();
			con = db.getCon();
			//	INSERT 만을 위한 전용 Statement를 만들자
			//	그러기 위해서는 먼저 질의 명령이 존재해야 한다.
			//	왜냐하면 스테이트먼트를 만들때 알려줘야하므로....
			String	sql = "INSERT INTO Test01 VALUES(?, ?, ?)";
			//	변화되는 데이터 부분은 ?로 대신 만들면 된다.
			pstmt = con.prepareStatement(sql);
			
			//	이제 질의를 실행하자.
			//	? 부분을 알려준 후 실행해야 한다.
			pstmt.setString(1, "홍길동");
			pstmt.setInt(2, 24);
			pstmt.setString(3, "010-1111-2222");
			pstmt.execute();
			
			pstmt.setString(1, "박길동");
			pstmt.setInt(2, 64);
			pstmt.setString(3, "010-2222-3333");
			pstmt.execute();
			
			pstmt.setString(1, "장길동");
			pstmt.setInt(2, 54);
			pstmt.setString(3, "010-3333-4444");
			pstmt.execute();
			
			pstmt.setString(1, "노길동");
			pstmt.setInt(2, 44);
			pstmt.setString(3, "010-55555-6666");
			pstmt.execute();

			pstmt.setString(1, "안길동");
			pstmt.setInt(2, 34);
			pstmt.setString(3, "010-7777-8888");
			pstmt.execute();
		}
		catch(Exception e) {
			
		}
		finally {
			
		}
	}
	public static void main(String[] args) {
		new InsertTest01();
	}
}




