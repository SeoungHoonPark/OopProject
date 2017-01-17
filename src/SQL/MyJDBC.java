package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *	jdbc�� ó���Ҷ� �ʿ��� �������� ����� �����ϱ� ���� ��ǰ Ŭ������ ������
 */
public class MyJDBC {
	public Connection con = null;
	public Statement stmt = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	
	/*
	 * ���� �������� �� Ŭ������ new��Ű�� ����
	 *  ���� �ʿ��� ����̹� �ε��� Ŀ�ؼ��� ���ÿ� �����ϰڴ�.
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
	 * �������� statment �� �ʿ��ϸ� 
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
	 * �������� PreparedStatement �� �ʿ��ϸ� 
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
	 *  �ڿ��� �ݰ� ������
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
