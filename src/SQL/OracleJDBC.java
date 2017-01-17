package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *		�� Ŭ������ ������ jdbc�۾��� �� �� �ʿ��� ������ ��ǰ�� ���� �����̴�.
 *
 *		��, jdbc�۾��� �ݺ����� �۾��� ���� ���ԵǾ� �ִ�.
 *		 �� �۾��� ���� ���ϰ� �ϱ����ؼ� ������ ��ǰ�� ���� ����� �����̴�.
 */
public class OracleJDBC {
	// �������� �� ��ǰ�� �ʿ��ؼ� new�� ��Ű�� ������ �Լ��� ����� ���̰�
	// ���� �� ������ ����̹� �ε��� �ڵ����� ���ְ� �ʹ�.
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public OracleJDBC() {
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");	// ����Ŭ�� �ε��ߴ�.
		}catch(Exception e){
			System.out.println("�ε� ���� + " + e);
			e.printStackTrace();
		}
	}
	
	// �������� ������ �䱸�ϸ� ��� �������ִ� ����� ������ �ְ� �ʹ�.
	public Connection getCon(){
		try{
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(url,"scott","tiger");
		}catch(Exception e){
			System.out.println("���� ���� + " + e);
			e.printStackTrace();			
		}
		return con;
	}
	
	// �������� Statement�� ����� �޶�� �ϸ� �ڵ����� ������ִ� �Լ�
	public Statement getSTMT(){
		try{
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);	
		}catch(Exception e){
			System.out.println("stmt ���� ���� + " + e);
			e.printStackTrace();
		}
		return stmt;
	}
	
	// �ݾ��ִ� �Լ��� ����� �ʹ�.
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
