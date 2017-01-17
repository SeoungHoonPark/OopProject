package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *	jdbc를 처리할때 필요한 공통적인 기능을 제공하기 위한 부품 클래스를 만들어보자
 */
public class MyJDBC {
	public Connection con = null;
	public Statement stmt = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	
	/*
	 * 나는 누군가가 이 클래스를 new시키는 순간
	 *  가장 필요한 드라이버 로딩과 커넥션을 동시에 실행하겠다.
	 */	
	public MyJDBC() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*
	 * 누군가가 statment 가 필요하면 
	 */
	public Statement getSTMT(){
		Statement stmt= null;
		try{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		}catch(Exception e){
			e.printStackTrace();
		}
		return stmt;
	}

	/*
	 * 누군가가 PreparedStatement 가 필요하면 
	 */
	public PreparedStatement getPSTMT(String sql){
		PreparedStatement pstmt= null;
		try{
			pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		}catch(Exception e){
			e.printStackTrace();
		}
		return pstmt;
	}
	
	/*
	 *  자원을 닫고 싶은면
	 */
	public void close(Object obj) {
		try{
			if(obj instanceof Connection){
				Connection temp  = (Connection) obj;
				temp.close();
			}else if(obj instanceof Statement){
				Statement temp = (Statement) obj;
				temp.close();
			}else if(obj instanceof PreparedStatement){
				PreparedStatement temp = (PreparedStatement) obj;
				temp.close();
			}else if( obj instanceof ResultSet){
				((ResultSet) obj).close();
			}
		}catch(Exception e){
			
		}
	}
}
