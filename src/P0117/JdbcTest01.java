package P0117;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC ����� ���� Ŭ������ �غ��� ��Ű��
 */
public class JdbcTest01 {
	public JdbcTest01() {
		// 1. JDBC�� �ܺ� �����ͺ��̽��� ������ ����̹��� ���α׷����� ������ �;� �Ѵ�.
		// �ܺ� Ŭ������ �ε��ϴ� �Լ�
		// Class.forName() �Լ��̴�.
		// ����̹����� �ܺ�Ŭ������ �̸��� ���ݾ� �ٸ���.
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("�ε� ����");
			
			// 2. ����Ŭ�� ������ �õ�����.
			// ������ �����ͺ��̽� ���� �����ϴ� ����� �ణ�� �ٸ���. (ã�Ƽ� �ð� ����)
			
			//  �����ϴ� ��ɾ�� jdbc���� ����ϸ� �ȴ�.
			// DriverManager.getConnection();
			
			String url1 =  "jdbc:oracle:thin:@localhost:1521:orcl";
			//String url2 =  "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			// �� url�� �����ͺ��̽����� ���ݾ� �ٸ���
			String user = "scott";
			String password = "tiger";
			
			Connection con = DriverManager.getConnection(url1, user, password);
			System.out.println("���� ����");
			
			// ��ó�� ������ �ϸ� �����ڸ� �����ϴ� ������ �����ϰ� �ȴ�. 
			// �� ������ �����ϴ� �������̽��� �ٷ� Connection�̴�.
			
			// 3 Statement �� �����Ѵ�.
			Statement stmt = (Statement) con.createStatement();
			
			// 4 ���� ����� ����� �����ش�.
			// test01�� �����Ǿ��ٸ� ���̺� ���ο� ������ �Է��Ѵ�.
			
			String sql1 = "insert into test01 values('ȫ', 25, sysdate)";
			String sql2 = "insert into test01 values('��', 35, sysdate)";
			String sql3 = "insert into test01 values('��', 45, sysdate)";
			
			//		�� ����
			// 		jdbc�� ���� ����� ;���� �������� �ʴ´�.
			//		;�� ����ϸ� �����̴�.
			
			// �ؽÿ� �Ǿ �����ͺ��̽��� ���� ����� �Ǿ����.
			stmt.executeQuery(sql1);
			stmt.executeQuery(sql2);
			stmt.executeQuery(sql3);
			
			stmt.close();
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		// �׷��� jdbc�� �ش� ����̹��� �̿��ؼ� ������ �õ��Ѵ�.
		
	}

	public static void main(String[] args) {
		new JdbcTest01();
	}
}
