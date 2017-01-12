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
 *	ģ���� ����ó�� �����ϴ� ���α׷��� ����� ����.
 */
public class Test06 {
	MyJFrame f = new MyJFrame();
	JTextField nameF, telF, addF, mailF, comF;
	JButton addB, delB, modifyB, exitB;
	JTable t;
	DefaultTableModel m;
	
	public Test06() {
		JLabel nameL = new JLabel("�̸�");
		JLabel telL = new JLabel("��ȭ��ȣ");
		JLabel addL = new JLabel("�ּ�");
		JLabel mailL = new JLabel("�̸����ּ�");
		JLabel comL = new JLabel("ȸ���");
		
		nameF = new JTextField(10);
		telF = new JTextField(10);
		addF = new JTextField(10);
		mailF = new JTextField(10);
		comF = new JTextField(10);
		
		addB = new JButton("�߰��ϱ�");
		delB = new JButton("�����ϱ�");
		modifyB = new JButton("�����ϱ�");
		exitB = new JButton("�����ϱ�");
		// ���̺� ����
		String[] title = {"�̸�","��ȭ��ȣ","�ּ�","�̸���","ȸ���"};
		// �������� ���ڴ� ���� ���̰� ������ ����� �Ѵ�.		
		m = new DefaultTableModel(title,0);
		t = new JTable(m);
		t.addMouseListener(new TableEvent());
		
		addB.addActionListener(new ButtonEvent());
		delB.addActionListener(new ButtonEvent());
		modifyB.addActionListener(new ButtonEvent());
		exitB.addActionListener(new ButtonEvent());
		
		// ���� 4���� �ϳ��� ����
		JPanel p1 = new JPanel();
		p1.add(addB);
		p1.add(delB);
		p1.add(modifyB);
		p1.add(exitB);
		
		// ���� 5���� �ϳ��� ����
		JPanel p2 = new JPanel(new GridLayout(5,1));
		p2.add(nameL);
		p2.add(telL);
		p2.add(addL);
		p2.add(mailL);
		p2.add(comL);
		
		// �Է»��� 5���� �ϳ��� ����
		JPanel p3 = new JPanel(new GridLayout(5,1));
		p3.add(nameF);
		p3.add(telF);
		p3.add(addF);
		p3.add(mailF);
		p3.add(comF);
		
		// ����� �Է»��ڸ� �ϳ��� ����
		JPanel p4 = new JPanel (new BorderLayout());
		p4.add("West", p2);
		p4.add("East", p3);
		
		//����� �Է»��ڸ� �������� ��ġ����.
		JPanel p5 = new JPanel(new BorderLayout());
		//ImageIcon img =  new ImageIcon("src/P0112/img.jpg");
		//JLabel l = new JLabel(img);
		//l.setSize(30, 30);
		p5.add("North",p4);
		//p5.add("Center",l);
		// ���̺� ��ũ�ѹٸ� ������
		JScrollPane sp = new JScrollPane(t);
		
		f.add("West", p5);
		f.add("South", p1);
		f.add("Center", sp);
		
		f.setSize(700,500);
		f.setVisible(true);
		
	}
	// �߰� ����� ����� �Լ�
	void addProc(){
		// �߰� 
		// �Է»��ڿ� �Է��� ������ �˾Ƴ���.
		String name 	= nameF.getText();
		String tel		= telF.getText();
		String addr 	= addF.getText();
		String mail 	= mailF.getText();
		String com 	= comF.getText();		
		// 	�� ������ ���̺� �߰��Ѵ�.
		
		String[] item = {name, tel, addr, mail, com};
		m.addRow(item);
		// 	�Է»����� ������ �����Ѵ�.
		
		nameF.setText("");
		telF.setText("");
		addF.setText("");
		mailF.setText("");
		comF.setText("");
		
	}
	//������ ������ �Լ�
	void modifyProc(){
		//����
		// �ؽ�Ʈ �ʵ��� ������ �ٽ� �˾Ƴ���.(������ ���뵵 �˾Ƴ���)
		// ���̺� ���õ� ���� �ٽ� �˾Ƴ���(�� ���� �����ؾ� �ϹǷ�)
		String name 	= nameF.getText();
		String tel		= telF.getText();
		String addr 	= addF.getText();
		String mail 	= mailF.getText();
		String com 	= comF.getText();		
		int row = t.getSelectedRow();
		if(row == -1){
			return;
			// �����Ѵ�.
		}
		
		t.setValueAt(name, row, 0);
		t.setValueAt(tel, row, 1);
		t.setValueAt(addr, row, 2);
		t.setValueAt(mail, row, 3);
		t.setValueAt(com, row, 4);		
		
	}
	// ������ ������ �Լ�
	void delProc(){
		// ����
		// �������� �����... ������ �� �Է»����� ���뵵 �����ش�.
		int kind = JOptionPane.showConfirmDialog(f, "�����ϰڽ��ϱ�", "����", JOptionPane.YES_NO_OPTION);
		
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
			// �̺�Ʈ�� �߻��� ���߸� ��������.
			JButton t = (JButton) e.getSource();
			
			if(t == addB){
				//�߰� ����� ����� �Լ��� ���� ���� ó������
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
	
	//  ���̺� ���� �����ϴ� ���� �̺�Ʈ�� �߻��ؼ� 
	// ������ ���� ������ �Է»��ڿ� �ְ� �ʹ�.
	// ���̺��� �̺�Ʈ�� ����.
	//=> ��� ������ �� ����� �� �ִ� �̺�Ʈ�� ���콺 �̺�Ʈ�� ó���ؾ� �Ѵ�.
	
	class TableEvent extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			// ����
			// ������ ���� �˾Ƴ���.
			int row = t.getSelectedRow();
			if(row == -1){
				//������ �߸��� ���̹Ƿ�
				//�۾��� �����Ѵ�.
				return;
			}
			// �� �ٿ� �ִ� ������ �׸��� �˾Ƴ���.
			String name = (String) t.getValueAt(row, 0);
			String tel = (String) t.getValueAt(row, 1);
			String addr = (String) t.getValueAt(row, 2);
			String mail= (String) t.getValueAt(row, 3);
			String com = (String) t.getValueAt(row, 4);
			
			// �˾Ƴ� ������ �ʵ忡 ����Ѵ�.
			nameF.setText(name);
			telF.setText(tel);
			addF.setText(addr);
			mailF.setText(mail);
			comF.setText(com);
			
		}
	}
}
