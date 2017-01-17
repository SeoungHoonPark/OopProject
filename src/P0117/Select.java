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
 *	select 질의만 사용할 수 있는 프로그램을 만들어보자
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
		Font font = new Font("휴먼옛체", Font.PLAIN, 20);
		area.setFont(font);
		label = new JLabel();
		// 테이블은 시작하면 결과가 없으므로 만들지 않는다.
		// 다만 질의를 실행한 순간 테이블을 만들어서 사용할 예정이다.
		
		sp = new JPanel(new BorderLayout());
		sp.add(new JScrollPane());
		execB = new JButton("실행");
		exitB = new JButton("종료");
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
		//할일
		// 질의 명령 알아내고
		String sql = area.getText();
		while(sql.endsWith(";")){
			sql = sql.substring(0,sql.length() -1);
		}
		Statement stmt = null;
		ResultSet rs = null;
		try{
			// 실행한다.
			db = new MyJDBC(); 
			stmt = db.getSTMT();
			rs = stmt.executeQuery(sql);
			// 실행 결과 정보를 알아내고
			ResultSetMetaData meta = rs.getMetaData();
			
			int col = meta.getColumnCount();
			String[] title = new String[col];
			for(int i = 0; i < col; i++){
				title[i] = meta.getColumnName(i+1);
				// 자바는 인덱스가 0부터 시작하지만 데이터베이스는 1부터 시작한다.
			}
			// 그 정보를 이용해서 테이블 만들고
			model = new DefaultTableModel(title, 0);
			table = new JTable(model);
			
			// 테이블에 데이터를 출력하자.
			// 결과를 한줄씩 꺼내서 화면의 테이블에 출력하자.
			while(rs.next()){
				Object[] temp = new Object[col];
				
				for(int i = 0; i < col; i++){
					temp[i] = rs.getObject(i + 1);
				}
				// 이 한줄을 테이블에 넣는다
				model.addRow(temp);
			}
				// 새로만든 테이블을 sp에 넣자
				sp.removeAll();	// 아래 깔리는 페널을 지운다.(자원 관리를 위하여..)
				JScrollPane temp = new JScrollPane(table);
				sp.add(temp);
				// 중간에 추가한 도구는 화면에 즉각 반영되지 않는다.
				// 강제로 추가한 도구를 즉각적으로 화면에 반영시키는 명령이 바로 validate라는 명령이다.
				sp.validate();
				label.setText("실행이 완료되었습니다.");
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
