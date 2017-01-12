package P0112;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import GUI.MyJFrame;

/**
 *	친구의 연락처를 관리하는 프로그램을 만들어 보자.
 */
public class Test06 {
	MyJFrame f = new MyJFrame();
	JTextField nameF, telF, addF, mailF, comF;
	JButton addB, delB, modifyB, exitB;
	JTable t;
	DefaultTableModel m;
	
	public Test06() {
		JLabel nameL = new JLabel("이름");
		JLabel telL = new JLabel("전화번호");
		JLabel addL = new JLabel("주소");
		JLabel mailL = new JLabel("이메일주소");
		JLabel comL = new JLabel("회사명");
		
		nameF = new JTextField(10);
		telF = new JTextField(10);
		addF = new JTextField(10);
		mailF = new JTextField(10);
		comF = new JTextField(10);
		
		addB = new JButton("추가하기");
		delB = new JButton("삭제하기");
		modifyB = new JButton("수정하기");
		exitB = new JButton("종료하기");
		// 테이블 제목
		String[] title = {"이름","전화번호","주소","이메일","회사명"};
		// 시작하자 마자는 제목만 보이고 내용이 없어야 한다.		
		m = new DefaultTableModel(title,0);
		t = new JTable(m);
		t.addMouseListener(new TableEvent());
		
		addB.addActionListener(new ButtonEvent());
		delB.addActionListener(new ButtonEvent());
		modifyB.addActionListener(new ButtonEvent());
		exitB.addActionListener(new ButtonEvent());
		
		// 단추 4개를 하나로 묶자
		JPanel p1 = new JPanel();
		p1.add(addB);
		p1.add(delB);
		p1.add(modifyB);
		p1.add(exitB);
		
		// 제목 5개를 하나로 묶자
		JPanel p2 = new JPanel(new GridLayout(5,1));
		p2.add(nameL);
		p2.add(telL);
		p2.add(addL);
		p2.add(mailL);
		p2.add(comL);
		
		// 입력상자 5개를 하나로 묶자
		JPanel p3 = new JPanel(new GridLayout(5,1));
		p3.add(nameF);
		p3.add(telF);
		p3.add(addF);
		p3.add(mailF);
		p3.add(comF);
		
		// 제목과 입력상자를 하나로 묶자
		JPanel p4 = new JPanel (new BorderLayout());
		p4.add("West", p2);
		p4.add("East", p3);
		
		//제목과 입력상자를 위쪽으로 배치하자.
		JPanel p5 = new JPanel(new BorderLayout());
		//ImageIcon img =  new ImageIcon("src/P0112/img.jpg");
		//JLabel l = new JLabel(img);
		//l.setSize(30, 30);
		p5.add("North",p4);
		//p5.add("Center",l);
		// 테이블에 스크롤바를 입히자
		JScrollPane sp = new JScrollPane(t);
		
		f.add("West", p5);
		f.add("South", p1);
		f.add("Center", sp);
		
		f.setSize(700,500);
		f.setVisible(true);
		
	}
	// 추가 기능을 담당할 함수
	void addProc(){
		// 추가 
		// 입력상자에 입력한 내용을 알아낸다.
		String name 	= nameF.getText();
		String tel		= telF.getText();
		String addr 	= addF.getText();
		String mail 	= mailF.getText();
		String com 	= comF.getText();		
		// 	그 내용을 테이블에 추가한다.
		
		String[] item = {name, tel, addr, mail, com};
		m.addRow(item);
		// 	입력상자의 내용을 삭제한다.
		
		nameF.setText("");
		telF.setText("");
		addF.setText("");
		mailF.setText("");
		comF.setText("");
		
	}
	//수정을 전담할 함수
	void modifyProc(){
		//할일
		// 텍스트 필드의 내용을 다시 알아낸다.(수정할 내용도 알아낸다)
		// 테이블에 선택된 줄을 다시 알아내고(이 줄을 수정해야 하므로)
		String name 	= nameF.getText();
		String tel		= telF.getText();
		String addr 	= addF.getText();
		String mail 	= mailF.getText();
		String com 	= comF.getText();		
		int row = t.getSelectedRow();
		if(row == -1){
			return;
			// 수정한다.
		}
		
		t.setValueAt(name, row, 0);
		t.setValueAt(tel, row, 1);
		t.setValueAt(addr, row, 2);
		t.setValueAt(mail, row, 3);
		t.setValueAt(com, row, 4);		
		
	}
	// 삭제를 점담할 함수
	void delProc(){
		// 할일
		// 삭제할지 물어보고... 삭제한 후 입력상자의 내용도 지워준다.
		int kind = JOptionPane.showConfirmDialog(f, "삭제하겠습니까", "삭제", JOptionPane.YES_NO_OPTION);
		
		if(kind == JOptionPane.YES_OPTION){
			int row = t.getSelectedRow();
			if(row == -1){
				return;
			}
			m.removeRow(row);
			
			nameF.setText("");
			telF.setText("");
			addF.setText("");
			mailF.setText("");
			comF.setText("");
		}
		
	}
	public static void main(String[] args) {
		new Test06();
	}
	
	class ButtonEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// 이벤트가 발생한 단추를 구분하자.
			JButton t = (JButton) e.getSource();
			
			if(t == addB){
				//추가 기능을 담당할 함수를 따로 만들어서 처리하자
				addProc();
			}else if(t == delB){
				delProc();
			}else if(t == modifyB){
				modifyProc();
			}else{
				System.exit(0);
			}
		}
	}
	
	//  테이블에 줄을 선택하는 순간 이벤트를 발생해서 
	// 선택한 줄의 내용을 입력상자에 넣고 싶다.
	// 테이블에는 이벤트가 없다.
	//=> 모든 곳에서 다 사용할 수 있는 이벤트인 마우스 이벤트로 처리해야 한다.
	
	class TableEvent extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			// 할일
			// 선택한 줄을 알아낸다.
			int row = t.getSelectedRow();
			if(row == -1){
				//선택이 잘못된 것이므로
				//작업을 포기한다.
				return;
			}
			// 그 줄에 있는 각각의 항목을 알아내자.
			String name = (String) t.getValueAt(row, 0);
			String tel = (String) t.getValueAt(row, 1);
			String addr = (String) t.getValueAt(row, 2);
			String mail= (String) t.getValueAt(row, 3);
			String com = (String) t.getValueAt(row, 4);
			
			// 알아낸 내용을 필드에 출력한다.
			nameF.setText(name);
			telF.setText(tel);
			addF.setText(addr);
			mailF.setText(mail);
			comF.setText(com);
			
		}
	}
}
