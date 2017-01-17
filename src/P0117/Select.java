/**
 * 
 */
package P0117;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import GUI.MyJFrame;
import SQL.MyJDBC;
import oracle.security.o3logon.O3LoginClientHelper;

/**
 *	select ���Ǹ� ����� �� �ִ� ���α׷��� ������
 */
public class Select {
	JTextArea area;
	JLabel label;
	JTable	table;
	DefaultTableModel model;
	JButton execB, exitB;
	JPanel sp;
	
	MyJDBC db = null;
	
	public Select() {
		MyJFrame f = new MyJFrame();
		f.setLayout(new GridLayout(2,1));
		
		area = new JTextArea();
		Font font = new Font("�޸տ�ü", Font.PLAIN, 20);
		area.setFont(font);
		label = new JLabel();
		// ���̺��� �����ϸ� ����� �����Ƿ� ������ �ʴ´�.
		// �ٸ� ���Ǹ� ������ ���� ���̺��� ���� ����� �����̴�.
		
		sp = new JPanel(new BorderLayout());
		sp.add(new JScrollPane());
		execB = new JButton("����");
		exitB = new JButton("����");
		execB.addActionListener(new ButtonEvent());
		exitB.addActionListener(new ButtonEvent());
		
		JPanel p1 = new JPanel (new BorderLayout());
		p1.add("Center", area);
		p1.add("South", label);
		
		JPanel p2 = new JPanel ();
		p2.add(execB);
		p2.add(exitB);
		
		JPanel p3 = new JPanel(new BorderLayout());
		p3.add("Center", sp);
		p3.add("South", p2);
		
		f.add(p1);
		f.add(p3);
		
		f.setSize(500,500);
		f.setVisible(true);
				
	}

	public static void main(String[] args) {
		new Select();
	}
	
	void execProc(){
		//����
		// ���� ��� �˾Ƴ���
		String sql = area.getText();
		while(sql.endsWith(";")){
			sql = sql.substring(0,sql.length() -1);
		}
		Statement stmt = null;
		ResultSet rs = null;
		try{
			// �����Ѵ�.
			db = new MyJDBC(); 
			stmt = db.getSTMT();
			rs = stmt.executeQuery(sql);
			// ���� ��� ������ �˾Ƴ���
			ResultSetMetaData meta = rs.getMetaData();
			
			int col = meta.getColumnCount();
			String[] title = new String[col];
			for(int i = 0; i < col; i++){
				title[i] = meta.getColumnName(i+1);
				// �ڹٴ� �ε����� 0���� ���������� �����ͺ��̽��� 1���� �����Ѵ�.
			}
			// �� ������ �̿��ؼ� ���̺� �����
			model = new DefaultTableModel(title, 0);
			table = new JTable(model);
			
			// ���̺� �����͸� �������.
			// ����� ���پ� ������ ȭ���� ���̺� �������.
			while(rs.next()){
				Object[] temp = new Object[col];
				
				for(int i = 0; i < col; i++){
					temp[i] = rs.getObject(i + 1);
				}
				// �� ������ ���̺� �ִ´�
				model.addRow(temp);
			}
				// ���θ��� ���̺��� sp�� ����
				sp.removeAll();	// �Ʒ� �򸮴� ����� �����.(�ڿ� ������ ���Ͽ�..)
				JScrollPane temp = new JScrollPane(table);
				sp.add(temp);
				// �߰��� �߰��� ������ ȭ�鿡 �ﰢ �ݿ����� �ʴ´�.
				// ������ �߰��� ������ �ﰢ������ ȭ�鿡 �ݿ���Ű�� ����� �ٷ� validate��� ����̴�.
				sp.validate();
				label.setText("������ �Ϸ�Ǿ����ϴ�.");
		}catch(Exception e){
			label.setText(e.toString());
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(stmt);
			db.close(db.con);
		}
		
		
		
	}
	class ButtonEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton t = (JButton)e.getSource();
			if(t == execB){
				execProc();
			}else{
				System.exit(0);
			}
		}
	}
	

}
