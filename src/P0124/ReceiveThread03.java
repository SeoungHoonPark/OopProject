package P0124;

import 	javax.swing.*;
import	java.io.*;
import 	NETData.*;

public class ReceiveThread03 extends Thread {
	ChatClient03	main;
	public ReceiveThread03(ChatClient03 m) {
		main = m;
	}
	
	public void run() {
		try {
			while(true) {
				//	������ Ŭ���̾�Ʈ���� Ŭ������ ��ä�� �ֱ�� �ߴ�.
				//	�̶� �츮�� MainData Ŭ������ ����ϱ�� ����ߴ�.
				//	������ �� �����͸� ����
				MainData	data = (MainData)main.oin.readObject();
				if(data == null) {
					break;
				}
				//	�����Ͱ� �����Ǿ�����... �������� �ǹ̸�
				//	�м��ؼ� ���ϴ� �۾��� �ϵ��� �Ѵ�.
				switch(data.protocol) {
				case 	2101:	//	�α��� ����
					loginProc(data);
					break;
				case	2201:	//	ä�� ����
					chatProc(data);
					break;
				case	2301:	//	���ε� ����
					uploadProc(data);
					break;
				case	2302:	//	��� ����
					listProc(data);
					break;
				case	2303:	//	�ٿ�ε� ����
					downloadProc(data);
					break;
				}
			}
		}
		catch(Exception e) {
		}
		finally {
			main.close();
		}
	}
	void loginProc(MainData data) {
		//	����
		if(data.isSuccess == true) {
			//		�����ϸ� ȭ���� ä��ȭ������ �ٲ��ְ�
			main.card.show(main.mainP, "CHAT");
		}
		else {
			//		�����ϸ� ���� ��ȭ���� ���
			JOptionPane.showMessageDialog(main.frame, "�α��ο� �����߾ �ٽ� �õ��ϼ���");
		}
	}
	void chatProc(MainData data) {
		//	����
		//		�޽����� �ؽ�Ʈ ����� ����Ѵ�.
		main.chatP.area.append(data.chatD.msg + "\r\n");
		main.chatP.sp.getVerticalScrollBar().setValue(main.chatP.sp.getVerticalScrollBar().getMaximum());
	}
	void uploadProc(MainData data) {
		//	����
		if(data.isSuccess == true) {
		//		�����ϸ� ���� �޽����� ����ϰ�
			JOptionPane.showMessageDialog(main.frame, "���ε尡 ���������� �Ǿ����ϴ�.");
		}
		else {
		//		�����ϸ� ���� �޽����� ����Ѵ�.
			JOptionPane.showMessageDialog(main.frame, "���ε忡 �����߽��ϴ�. �ٽ� �õ��ϼ���");
		}
	}
	void listProc(MainData data) {
		//	����
		//		������ �˷��� ����� �غ�� �޺����ڿ� ����Ѵ�.
		//	1.	�����ִ� ���� �����
		main.chatP.listBox.removeAll();
		//	2,	������ ������ �ϳ��������� �޺��� �ִ´�.
		int	size = data.fileD.list.size();
		for(int i = 0; i < size; i++) {
			main.chatP.listBox.addItem(data.fileD.list.get(i));
		}
	}
	void downloadProc(MainData data) {
		//	����
		//		������ �������� �����̸��� �̿��ؼ�
		//		��Ʈ���� �����
		//		�� �ȿ� ������ ������ �����Ѵ�.
		FileOutputStream	fout = null;
		try {
			fout = new FileOutputStream("D:\\download\\" + 
								data.fileD.fileName);
			fout.write(data.fileD.buff);
		}
		catch(Exception e) {
		}
		finally {
			try {
				fout.close();
			}
			catch(Exception e) {}
		}
	}
}
