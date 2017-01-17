package P0117;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC 사용을 위한 클래스를 준비한 패키지
 */
public class JdbcTest01 {
	public JdbcTest01() {
		// 1. JDBC와 외부 데이터베이스를 연결할 드라이버를 프로그램에서 가지고 와야 한다.
		// 외부 클래스를 로딩하는 함수
		// Class.forName() 함수이다.
		// 드라이버마다 외부클래스의 이름이 조금씩 다르다.
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("로딩 성공");
			
			// 2. 오라클에 접속을 시도하자.
			// 각각의 데이터베이스 마다 접속하는 방법이 약간씩 다르다. (찾아서 맡게 설정)
			
			//  접속하는 명령어는 jdbc에게 명령하면 된다.
			// DriverManager.getConnection();
			
			String url1 =  "jdbc:oracle:thin:@localhost:1521:orcl";
			//String url2 =  "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			// 이 url은 데이터베이스마다 조금씩 다르다
			String user = "scott";
			String password = "tiger";
			
			Connection con = DriverManager.getConnection(url1, user, password);
			System.out.println("접속 성공");
			
			// 이처럼 접속을 하면 접속자를 관리하는 세션을 제공하게 된다. 
			// 이 세션을 관리하는 인터페이스가 바로 Connection이다.
			
			// 3 Statement 를 생성한다.
			Statement stmt = (Statement) con.createStatement();
			
			// 4 질의 명령을 만들어 날려준다.
			// test01이 생성되었다면 테이블에 새로운 정보를 입력한다.
			
			String sql1 = "insert into test01 values('홍', 25, sysdate)";
			String sql2 = "insert into test01 values('박', 35, sysdate)";
			String sql3 = "insert into test01 values('장', 45, sysdate)";
			
			//		★ 참고
			// 		jdbc는 질의 명령을 ;으로 종료하지 않는다.
			//		;을 사용하면 에러이다.
			
			// 텍시에 실어서 데이터베이스에 질의 명령을 실어보낸다.
			stmt.executeQuery(sql1);
			stmt.executeQuery(sql2);
			stmt.executeQuery(sql3);
			
			stmt.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		// 그래야 jdbc가 해당 드라이버를 이용해서 연결을 시도한다.
		
	}

	public static void main(String[] args) {
		new JdbcTest01();
	}
}
