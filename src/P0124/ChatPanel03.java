package P0124;
import	NETData.*;
import	javax.swing.*;
import	java.awt.*;
import	java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
public class ChatPanel03 extends JPanel {
	ChatClient03	main;
	JButton		uploadB, listB, downloadB;
	JComboBox	listBox;
	JTextArea	area;
	JScrollPane	sp;
	JTextField	field;
	public ChatPanel03(ChatClient03 m) {
		main = m;
		this.setLayout(new BorderLayout());
		uploadB = new JButton("���ε�");
		listB = new JButton("��Ͽ�û");
		downloadB = new JButton("�ٿ�ε�");
		listBox = new JComboBox();
		//	�� �ȿ��� ���߿��� �������Լ� ����� �޾Ƽ� �׸���
		//	���� �����̹Ƿ�...
		area = new JTextArea();
		sp = new JScrollPane(area);
		field = new JTextField();
		
		ChatEvent	evt = new ChatEvent();
		uploadB.addActionListener(evt);
		downloadB.addActionListener(evt);
		listB.addActionListener(evt);
		field.addActionListener(evt);
		
		JPanel	p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(uploadB);
		JPanel	p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(listB);
		JPanel	p3 = new JPanel(new GridLayout(1, 2));
		p3.add(p1);
		p3.add(p2);
		
		JPanel	p4 = new JPanel(new BorderLayout());
		p4.add("Center", listBox);
		p4.add("East", downloadB);
		
		JPanel	p5 = new JPanel(new GridLayout(2, 1));
		p5.add(p3);
		p5.add(p4);
		
		this.add("North", p5);
		this.add("Center", sp);
		this.add("South", field);
	}
	//	ä�� ���� �Լ�
	void sendProc() {
		//	����
		//		���� ������ �˾Ƴ���
		String	msg = field.getText();
		if(msg == null || msg.length() == 0) {
			return;
		}
		//		������ ������.
		//		1.	MainData�� ����(�ʼ�)
		MainData	mainD = new MainData();
		//		2.	�۾� Data�� ����(����)
		ChatData	chatD = new ChatData();
		//		3.	�ʿ��� �����͸� ä���.
		mainD.protocol = 1201;
		chatD.msg = msg;
		//		4.	�۾� �����͸� ���� �����Ϳ� ��ģ��.
		mainD.chatD = chatD;
		//		5.	������.
		try {
			main.oout.writeObject(mainD);
		}
		catch(Exception e) {
		}
	}
	//	���ε� ���� �Լ�
	void uploadProc() {
		//	����
		//		���ε��� ������ �����ϵ��� �Ѵ�.
		JFileChooser	fc = new JFileChooser();
		int	kind = fc.showOpenDialog(main.frame);
		String	fileName = null;	//	�����̸��� ����� ����
		byte[]	buff = null;		//	���� ������ ����� ����
		File	file = null;		//	������ ������ ����� ����
		if(kind == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			fileName = file.getName(); 
		}
		//		������ ������ ��Ʈ������ �д´�.
		FileInputStream	fin = null;
		try {
			//	������ ����
			fin = new FileInputStream(file);
			//	���� ����� ����� byte[]�� ������ ũ�⸸ŭ �غ��ϰ�
			buff = new byte[(int)file.length()];
			//	�� ���α׷��� ������
			//		���� ���ε�� �ѹ��� �о �������� �������.
			//		�ʹ� �뷮�� ū ������ �ȵȴ�.
			//	�ѹ��� �д´�.
			fin.read(buff);
		}
		catch(Exception e) {
		}
		finally {
			try {
				fin.close();
			}
			catch(Exception e) {}
		}
		//		������ ������.
		//		MainData ����
		MainData	mainD = new MainData();
		//		�۾� ������ ����
		FileData	fileD = new FileData();
		//		������ ä���
		mainD.protocol = 1301;
		fileD.fileName = fileName;
		fileD.buff = buff;
		//		�۾� �����͸� MainData�� �ֱ�
		mainD.fileD = fileD;
		//		������
		try {
			main.oout.writeObject(mainD);
		}
		catch(Exception e) {}
	}
	//	���� ��� ��û
	void listProc() {
		//	����
		//		�׳� ���ϸ�� �����޶�� ��û�� �ϸ� �ȴ�.
		MainData	mainD = new MainData();
		mainD.protocol = 1302;
		try {
			main.oout.writeObject(mainD);
		}
		catch(Exception e) {
		}
	}
	//	�ٿ�ε� ��û ���� �Լ�
	void downloadProc() {
		//	����
		//		�޺����ڿ��� ������ ������ �˾Ƴ���
		String	fileName = (String)listBox.getSelectedItem();
		//		������ ������.
		MainData	mainD = new MainData();
		FileData	fileD = new FileData();
		mainD.protocol = 1303;
		fileD.fileName = fileName;
		mainD.fileD = fileD;
		try {
			main.oout.writeObject(mainD);
		}
		catch(Exception e) {
		}
	}
	class ChatEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	�� �Լ��� �ؽ�Ʈ �ʵ�� ���߿��� ��� �߻��Ѵ�.
			Object	target = e.getSource();
			if(target instanceof JTextField) {
				sendProc();
			}
			else {
				//	���߿��� �̺�Ʈ�� �߻��� ��
				JButton	temp = (JButton) target;
				if(temp == uploadB) {
					uploadProc();
				}
				else if(temp == listB){
					listProc();
				}
				else {
					//	�ٿ�ε� ����
					downloadProc();
				}
			}
		}
	}
}





