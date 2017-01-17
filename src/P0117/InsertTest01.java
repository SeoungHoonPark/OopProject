package P0117;
/*
 * 	����
 * 		Test01 ���̺� 5����� �������.
 * 
 * 		INSERT ����� 5�� ������...
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
			//	INSERT ���� ���� ���� Statement�� ������
			//	�׷��� ���ؼ��� ���� ���� ����� �����ؾ� �Ѵ�.
			//	�ֳ��ϸ� ������Ʈ��Ʈ�� ���鶧 �˷�����ϹǷ�....
			String	sql = "INSERT INTO Test01 VALUES(?, ?, ?)";
			//	��ȭ�Ǵ� ������ �κ��� ?�� ��� ����� �ȴ�.
			pstmt = con.prepareStatement(sql);
			
			//	���� ���Ǹ� ��������.
			//	? �κ��� �˷��� �� �����ؾ� �Ѵ�.
			pstmt.setString(1, "ȫ�浿");
			pstmt.setInt(2, 24);
			pstmt.setString(3, "010-1111-2222");
			pstmt.execute();
			
			pstmt.setString(1, "�ڱ浿");
			pstmt.setInt(2, 64);
			pstmt.setString(3, "010-2222-3333");
			pstmt.execute();
			
			pstmt.setString(1, "��浿");
			pstmt.setInt(2, 54);
			pstmt.setString(3, "010-3333-4444");
			pstmt.execute();
			
			pstmt.setString(1, "��浿");
			pstmt.setInt(2, 44);
			pstmt.setString(3, "010-55555-6666");
			pstmt.execute();

			pstmt.setString(1, "�ȱ浿");
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




