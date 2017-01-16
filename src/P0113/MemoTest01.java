package P0113;
/*
 * 	�ҷ������ �����ϱ� ����� ���� ������ �޸����� ������.
 */
import	GUI.*;
import	javax.swing.*;
import	java.awt.*;
import	java.awt.event.*;
import	java.io.*;
public class MemoTest01 {
	JTextArea		area;		//	������ �Է��� ����
	JButton			saveB, loadB;
	MyJFrame		f;
	public MemoTest01() {
		f = new MyJFrame("�޸���");
		area	= new JTextArea();
		JScrollPane	sp = new JScrollPane(area);
		
		saveB = new JButton("�����ϱ�");
		loadB = new JButton("�ҷ�����");
		
		MemoButtonEvent01	evt = new MemoButtonEvent01(this);
		saveB.addActionListener(evt);
		loadB.addActionListener(evt);
		
		JPanel	p = new JPanel();
		p.add(saveB);
		p.add(loadB);
		
		f.add("Center", sp);
		f.add("South", 	p);
		
		f.setSize(500, 500);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		new MemoTest01();
	}
	//	������ ����� �Լ�
	void saveProc() {
		//	����
		//		������ ������ ������ �˾Ƴ���.
		JFileChooser	fc = new JFileChooser();
		int	kind = fc.showSaveDialog(f);
		File	file = null;		//	������ ������ ������ ����� ����
		if(kind == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		}
		else {
			return;
		}
		//		�� ���Ͽ� ������ �����Ѵ�.
		//			1.	��Ʈ���� �����Ѵ�.
		FileOutputStream	fout = null;
		try {
			fout = new FileOutputStream(file);
			//	������ ������ �˾Ƴ���.
			//	������ ������ ���...	�ؽ�Ʈ ����� �Է��� �����̴�.
			String	str = area.getText();
			//			2.	������ ����Ѵ�.
			byte[]	buff = str.getBytes();
			fout.write(buff);
		}
		catch(Exception e) {
			System.out.println("���� = " +  e);
		}
		finally  {
			try {
				fout.close();
			}
			catch(Exception e) {}
		}
		
	}
	//	�ҷ����⸦ ����� �Լ�
	void loadProc() {
		//	����
		//		�ҷ������� ������ ������ �˾Ƴ���.
		JFileChooser	fc = new JFileChooser();
		int	kind = fc.showOpenDialog(f);
		File	file = null;
		if(kind == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
		}
		else {
			return;
		}
		//		�� ���Ͽ��� ������ �о ����� ����Ѵ�.
		FileInputStream		fin = null;
		try {
			//		1.	��Ʈ���� �����ϰ�
			fin = new FileInputStream(file);
			//		2.	������ �д´�.
			//	������ ����ϱ� ���� ���� ������ ����� ��������.
			area.setText("");
			while(true) {
				byte[] buff = new byte[1024];
				int	len = fin.read(buff);
				if(len == -1) {
					break;
				}
				//	�ؽ�Ʈ ����� ����Ѵ�.(�ݺ��Ҷ����� �߰��ؾ� �Ѵ�.)
				String	str = new String(buff, 0, len);
				area.append(str);
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				fin.close();
			}
			catch(Exception e) {}
		}
	}
}
class MemoButtonEvent01 implements ActionListener {
	MemoTest01	main;
	public MemoButtonEvent01() {}
	public MemoButtonEvent01(MemoTest01 m) {
		main = m;
	}
	public void actionPerformed(ActionEvent e) {
		//	����
		//		��� ���߿��� �̺�Ʈ�� �߻��ߴ����� �˾Ƴ���
		JButton	target = (JButton) e.getSource();
		
		//		����, �ҷ����� �۾��� ��������.
		if(target == main.saveB) {
			//	�� Ŭ������ ���� Ŭ������ ������� Ŭ�����̹Ƿ�
			//	���� Ŭ������ ����� ����� �� ����.
			//	�����ϱ� �۾�
			main.saveProc();
		}
		else {
			//	�ҷ����� �۾�
			main.loadProc();
		}
	}
}






