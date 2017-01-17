/**
 * 
 */
package P0117;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import SQL.OracleJDBC;

/**
 *	 ��������� �̵��ϸ鼭 ó������.
 *  con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
 */
public class SelectTest02 {
		OracleJDBC db = new OracleJDBC();
		Connection con = db.getCon();
		Statement stmt = db.getSTMT();
		ResultSet rs = null;
	public SelectTest02() {
		try{
			String sql = "select * from emp";
			rs = stmt.executeQuery(sql);
			
			System.out.println("ù��° ������");
			
			while (rs.next()){
				String name  = rs.getString("ename");
				String job = rs.getString("job");
				//...
				System.out.println("�̸� : " + name + " || ��å : " + job);
				
			}
			rs.beforeFirst();
			while (rs.next()){
				String name  = rs.getString("ename");
				String job = rs.getString("job");
				//...
				System.out.println("�̸� : " + name + " || ��å : " + job);
				
			}
		} catch(Exception e){	
		} finally {
			try{
//				rs.close();
//				stmt.close();
//				con.close();
				db.close(rs);
				db.close(stmt);
				db.close(con);
			}catch(Exception e){}
		}
	}


	public static void main(String[] args) {
		new SelectTest02();
	}
}
