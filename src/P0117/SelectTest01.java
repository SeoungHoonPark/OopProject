package P0117;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *	select * from emp 질의 명령을 실행한 후 필요한 데이터를 출력해 보자
 */
public class SelectTest01 {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	public SelectTest01() {
		try{
			// 1. 드라이버 로딩을 해야 한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 오라클을 로딩했다.
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 2. 필요한 오라클에 접속을 한다.
			con = DriverManager.getConnection(url,"scott","tiger");
			// 1번 매개 변수 오라클의 url
			// 	오라클은 서버 데이터베이스이므로 다른 컴퓨터에 있을 수 있다.
			// 2번과 3번에는 계정이름과 비번
			// --------------------------------------------------------------------
			// jdbc와 실제 데이터베이스 사이의 명령을 전달자를 만들자
			
			stmt = con.createStatement();
			
			// 질의 명령 만들어서 실행해라
			String sql = "select * from emp";
			rs = stmt.executeQuery(sql);
			
			// ★ select 질의 명령의 결과는 반드시 한줄 내린 후 사용해야 한다. 
			// why? 시작위치는 bof이기 때문이다.
//			rs.next();
//			String name = rs.getString(1);
//			System.out.println(name);
			
			while(rs.next()){
				// 다음줄이 존재하면 반복하세요..
				//	이름, 직책, 급여만 출력하고싶다.
				
				String name = rs.getString(2);
				String job = rs.getString("job");
				float sal = rs.getFloat("sal");
				
				System.out.println("이름 : " + name + "||  직책 : " + job + "||  급여 : " + sal);
			}
			
			// 문제점
			// 한번 꺼낸 데이터를 다시 꺼내고 싶다.
//			rs.beforeFirst(); 	// 안되는 이유
			// 일반적인 인라인테이블은 전반향 테이블이라고해서 레코드 포인터가 아래로만 이동 가능한 테이블이 된다.
			// 위 아래의 이동이 불가능한 인라인테이블이 된다.
			
			
			
			 
				
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				rs.close();
				stmt.close();
				con.close();
			}catch(Exception e){
				
			}
		}
	}

	public static void main(String[] args) {
		new SelectTest01();
	}

}
