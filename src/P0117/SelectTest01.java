package P0117;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *	select * from emp ���� ����� ������ �� �ʿ��� �����͸� ����� ����
 */
public class SelectTest01 {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	public SelectTest01() {
		try{
			// 1. ����̹� �ε��� �ؾ� �Ѵ�.
			Class.forName("oracle.jdbc.driver.OracleDriver");	// ����Ŭ�� �ε��ߴ�.
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 2. �ʿ��� ����Ŭ�� ������ �Ѵ�.
			con = DriverManager.getConnection(url,"scott","tiger");
			// 1�� �Ű� ���� ����Ŭ�� url
			// 	����Ŭ�� ���� �����ͺ��̽��̹Ƿ� �ٸ� ��ǻ�Ϳ� ���� �� �ִ�.
			// 2���� 3������ �����̸��� ���
			// --------------------------------------------------------------------
			// jdbc�� ���� �����ͺ��̽� ������ ����� �����ڸ� ������
			
			stmt = con.createStatement();
			
			// ���� ��� ���� �����ض�
			String sql = "select * from emp";
			rs = stmt.executeQuery(sql);
			
			// �� select ���� ����� ����� �ݵ�� ���� ���� �� ����ؾ� �Ѵ�. 
			// why? ������ġ�� bof�̱� �����̴�.
//			rs.next();
//			String name = rs.getString(1);
//			System.out.println(name);
			
			while(rs.next()){
				// �������� �����ϸ� �ݺ��ϼ���..
				//	�̸�, ��å, �޿��� ����ϰ�ʹ�.
				
				String name = rs.getString(2);
				String job = rs.getString("job");
				float sal = rs.getFloat("sal");
				
				System.out.println("�̸� : " + name + "||  ��å : " + job + "||  �޿� : " + sal);
			}
			
			// ������
			// �ѹ� ���� �����͸� �ٽ� ������ �ʹ�.
//			rs.beforeFirst(); 	// �ȵǴ� ����
			// �Ϲ����� �ζ������̺��� ������ ���̺��̶���ؼ� ���ڵ� �����Ͱ� �Ʒ��θ� �̵� ������ ���̺��� �ȴ�.
			// �� �Ʒ��� �̵��� �Ұ����� �ζ������̺��� �ȴ�.
			
			
			
			 
				
			
			
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
