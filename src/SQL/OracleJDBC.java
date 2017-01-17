package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *		이 클래스는 앞으로 jdbc작업을 할 때 필요한 나만의 부품을 만들 예정이다.
 *
 *		즉, jdbc작업은 반복적인 작업이 많이 포함되어 있다.
 *		 이 작업을 좀더 편하게 하기위해서 나만의 부품을 만들어서 사용할 예정이다.
 */
public class OracleJDBC {
	// 누군가가 이 부품이 필요해서 new를 시키면 생성자 함수가 실행될 것이고
	// 나는 그 순간에 드라이버 로딩을 자동으로 해주고 싶다.
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public OracleJDBC() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 오라클을 로딩했다.
		}catch(Exception e){
			System.out.println("로딩 에러 + " + e);
			e.printStackTrace();
		}
	}
	
	// 누군가가 접속을 요구하면 대신 접속해주는 기능을 제공해 주고 싶다.
	public Connection getCon(){
		try{
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(url,"scott","tiger");
		}catch(Exception e){
			System.out.println("접속 에러 + " + e);
			e.printStackTrace();			
		}
		return con;
	}
	
	// 누군가가 Statement를 만들어 달라고 하면 자동으로 만들어주는 함수
	public Statement getSTMT(){
		try{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);	
		}catch(Exception e){
			System.out.println("stmt 생성 에러 + " + e);
			e.printStackTrace();
		}
		return stmt;
	}
	
	// 닫아주는 함수를 만들고 싶다.
	public void close(Object obj){
		try{
			if(obj instanceof Connection){
				Connection temp  = (Connection) obj;
				temp.close();
			}else if(obj instanceof Statement){
				Statement temp = (Statement) obj;
				temp.close();
			}else if(obj instanceof Statement){
				ResultSet temp = (ResultSet) obj;
				temp.close();
			}
		}catch(Exception e){
			
		}
	}

}
