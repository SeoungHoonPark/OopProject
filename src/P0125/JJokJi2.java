package P0125;

import		javax.swing.*;
import		java.awt.*;
import		java.awt.event.*;
import java.io.FileInputStream;
import		java.util.*;

import		java.net.*;
public class JJokJi2 {
	//	�̸��� �˸� �ּҸ� ã�Ƴ��� ���� Map
	//	�ּҸ� �˸� �̸��� ã�Ƴ��� ���� Map
	Properties		nameToIp, ipToName;	
	JList	list;
	JButton	sendB;
	JFrame	frame;
	
	DatagramSocket		sSocket, rSocket;
	//	sSocket�� ������ ������ ���� ����
	//	rSocket�� ������ �ޱ� ���� ����
	
	//	�����
	//		�ݵ�� 2���� ������ �ϴ� ���� �ƴϴ�.
	//		���� �ϳ��� ������ ������� �ޱ⸦ �� �� �ִ�.
	//		�ٸ�....
	//			�� ��쿡�� ������ ���߿��� ������ ���� �� �ִ�.
	//		�׷��� ������ ����� ���ؼ�
	//		������ ���ϰ� �޴� ������ ������ ó���ϴ� ���� ����.
	public JJokJi2() {
		setMap();
		frame = new JFrame("���� ���α׷�");
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				close();
			}
		});
		
		//	��ϻ��ھȿ� ģ�� �̸��� ����ϱ�� �����Ƿ�
		//	Map���� ģ���̸��� ã�Ƽ� �־����.
		Set			temp = nameToIp.keySet();
		Vector		v = new Vector(temp);
		list = new JList(v);
		JScrollPane sp = new JScrollPane(list);
		sendB = new JButton("��������");
		sendB.addActionListener(new ButtonEvent());
		frame.add("Center", sp);
		frame.add("South", sendB);
		
		frame.setSize(200, 200);
		frame.setVisible(true);
		
		//	���� ���α׷��� ���۵Ǿ����Ƿ�.... ��Ʈ��ũ ������
		//	�� �����̴�.
		//	������ UDP ����̹Ƿ� DatagramSocket�� �̿��ؼ�
		//	��Ʈ��ũ ������ �� �����̴�.
		try {
			sSocket = new DatagramSocket();
			rSocket = new DatagramSocket(9999);
			//	�̷��� �ϸ� �������� ������ �ϴ� ���� �ƴϰ�
			//	�ٸ� ��Ʈ��ũ ȸ������ ������ �� ���°� �ȴ�.
			//	��, ��Ʈ��ũ�� �����ϵ��ϸ� ���ִ� ���̴�.
			
			//	���� ��Ʈ��ũ ������ �Ϸ�Ǿ����Ƿ�
			//	������ ������ ���� �� �ִ�.
			//	�޴� ���α׷��� ��������.
			ReceiveThread	t = new ReceiveThread(this);
			t.start();
		}
		catch(Exception e) {
			close();
		}
	}
	
	void close() {
		try {
			sSocket.close();
			rSocket.close();
		}
		catch(Exception e) {}
		System.exit(0);
	}
	
	void setMap() {
		nameToIp = new Properties();
		ipToName = new Properties();
		FileInputStream	fin1 = null;
		FileInputStream	fin2 = null;
		try {
			fin1 = new FileInputStream("src/M01/P0125/ip_ko.txt");
			fin2 = new FileInputStream("src/M01/P0125/name_ko.txt");
			nameToIp.load(fin1);
			ipToName.load(fin2);
		}
		catch(Exception e) {}
	}
	public static void main(String[] args) {
		new JJokJi();
	}
	
	class ButtonEvent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//	����
			//		��ϻ��ڿ��� ������ �̸��� �˾Ƴ���.
			String	name = (String)list.getSelectedValue();
			if(name == null || name.length() == 0) {
				return;
			}
			//		������ ���� ��ȭ���ڸ� new ��Ų��.
			SendDlg	dlg = new SendDlg(JJokJi2.this);
			//		�ؽ�Ʈ �ʵ忡 �޴»�� �̸� ���ְ�
			dlg.field.setText(name);
			//		ȭ�鿡 ����Ѵ�.
			dlg.frame.setVisible(true);
		}
	}
}
