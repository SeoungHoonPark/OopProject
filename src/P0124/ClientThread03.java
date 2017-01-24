package P0124;
/*
 * 	������ Ŭ���̾�Ʈ�� ����� ������ Ŭ����
 */
import	NETData.*;
import	java.net.*;
import	java.io.*;
import	java.sql.*;
import java.util.Vector;
public class ClientThread03 extends Thread {
	ChatServer03		main;
	//	�ʼ�����(��ź���)
	Socket				socket;	//	�տ��� �޾Ƽ� ����ϰ�
	ObjectInputStream	oin;	//	Socket�� ������ ���� �� �ְ�...
	ObjectOutputStream	oout;
	//	���ú���(��������)
	//	���α׷��� ���ϰ� ó���ϰ� ���� �ʿ��� ������ ������...
	//	�󸶵��� ���� ����ϸ� �ȴ�.
	String				ip;
	String				name;
	String				id;
	
	public ClientThread03(ChatServer03 m, Socket s) throws Exception {
		main 	= m;
		socket 	= s;
		
		InputStream		in 	= socket.getInputStream();
		OutputStream	out = socket.getOutputStream();
		//	����	�ڡڡڡ�
		//		Object �� ����� ������ �߿��ϴ�.
		System.out.println("�ް�");
		oout 	= new ObjectOutputStream(out);
		System.out.println("�ش�");
		oin 	= new ObjectInputStream(in);
		
		InetAddress	inet = socket.getInetAddress();
		ip = inet.getHostAddress();
	}
	
	void loginProc(MainData data) {
		//	����
		//		�����ͺ��̽����� �� ����� ������ �ִ��� Ȯ���ϰ�
		boolean		isSuccess = false;
		try {
			//	�̹� ������Ʈ��Ʈ�� ������� �����Ƿ�,,,,
			//	?�� �����͸� ä���
			main.loginS.setString(1, data.loginD.id);
			main.loginS.setString(2, data.loginD.pw);
			//	���� ����� �����غ���.
			main.rs = main.loginS.executeQuery();
			if(main.rs.next() == true) {
				//	�׷� ȸ���� �����Ѵ�
				isSuccess = true;
				//	������ ���� ������ ����� ����
				id = main.rs.getString("m_ID");
				name = main.rs.getString("m_Name");
			}
			else {
				//	�׷� ȸ���� �������� �ʴ´�.
				isSuccess = false;
			}
		}
		catch(Exception e) {
			
		}
		finally {
			main.db.close(main.rs);
		}
		//		�� ����� �����Ѵ�.
		//		���� ����� Ŭ���̾�Ʈ�� �������� �����͸�
		//		�ִ� ��İ� �����ϴ�.
		MainData	mainD = new MainData();
		mainD.protocol = 2101;
		mainD.isSuccess = isSuccess;

		try {
			oout.writeObject(mainD);
		}
		catch(Exception e) {	
		}
	}
	void chatProc(MainData data) {
		//	����
		//		�����͸� �ٹ̰�
		String	msg = "[" + name + " �� ���� ] " + data.chatD.msg;
		//		��� Ŭ���̾�Ʈ���� �����Ѵ�.
		MainData	mainD = new MainData();
		ChatData	chatD = new ChatData();
		mainD.protocol = 2201;
		chatD.msg = msg;
		mainD.chatD = chatD;
	
		int	size = main.clientList.size();
		synchronized(main.clientList) {
			for(int i = 0; i < size; i++) {
				ClientThread03	temp =
						(ClientThread03) main.clientList.get(i);
				try {
					temp.oout.writeObject(mainD);
				}
				catch(Exception e) {}
			}
		}
	}
	void uploadProc(MainData data) {
		//	����
		//		Ŭ���̾�Ʈ �� ������ ������ ������ ������ ��ġ��
		//		�����Ѵ�.
		//		����	D:\\upload�� ������ �����̴�.
		FileOutputStream	fout = null;
		boolean		isSuccess = true;
		try {
			fout = new FileOutputStream("D:\\upload\\" + 
						data.fileD.fileName);
			fout.write(data.fileD.buff);
		}
		catch(Exception e) {
			isSuccess = false;
		}
		finally {
			try {
				fout.close();
			}
			catch(Exception e) {}
		}
	
		//	�����Ѵ�.
		MainData	mainD = new MainData();
		mainD.protocol = 2301;
		mainD.isSuccess = isSuccess;
		
		try {
			oout.writeObject(mainD);
		}
		catch(Exception e) {}
	}
	void listProc(MainData data) {
		//	����
		//		D:\\upload ������ �ִ� ��� ������ �����
		//		Ŭ���̾�Ʈ���� �˷��ش�.
		File	dir = new File("D:\\upload");
		String[]	list = dir.list();
		//	�̰��� Vector�� ���� Ŭ������ �ִ´�.
		Vector v = new Vector();
		for(int i = 0; i < list.length; i++) {
			v.add(list[i]);
		}

		//	Ŭ���̾�Ʈ���� �����Ѵ�.
		MainData	mainD = new MainData();
		FileData	fileD = new FileData();
		mainD.protocol = 2302;
		fileD.list = v;
		mainD.fileD = fileD;
		
		try {
			oout.writeObject(mainD);
		}
		catch(Exception e) {}
	}
	void downloadProc(MainData data) {
		//	����
		//		Ŭ���̾�Ʈ�� ��û�� ������ ��Ʈ������ �о
		//		�� ������ Ŭ���̾�Ʈ���� �����Ѵ�.
		//		(�׷��� Ŭ���̾�Ʈ�� ���� ������ �� ��ǻ�Ϳ�
		//		������ ���̴�.)
		FileInputStream		fin = null;
		byte[]	buff = null;
		boolean	isSuccess = true;
		try {
			File	file = new File("D:\\upload\\" + 
										data.fileD.fileName);
			fin = new FileInputStream(file);
			buff = new byte[(int)file.length()];
			fin.read(buff);
		}
		catch(Exception e) {
			isSuccess = false;
		}
		finally {
			try {
				fin.close();
			}
			catch(Exception e) {}
		}
		//	�����Ѵ�.
		MainData	mainD = new MainData();
		FileData	fileD = new FileData();
		mainD.protocol = 2303;
		mainD.isSuccess = isSuccess;
		fileD.fileName = data.fileD.fileName;
		fileD.buff = buff;
		mainD.fileD = fileD;
		try {
			oout.writeObject(mainD);
		}
		catch(Exception e) {}
	}

	public void run() {
		try {
			while(true) {
				//	Ŭ���̾�Ʈ�� ������ ������ �޴´�
				//	Ŭ������ ��ä�� �´�.
				MainData	data = (MainData) oin.readObject();
				if(data == null) {
					break;
				}
				//	�۾��� �м��Ѵ�.
				switch(data.protocol) {
				case	1101:	//	�α��� ��û
					loginProc(data);
					break;
				case	1201:	//	ä�� ��û
					chatProc(data);
					break;
				case	1301:	//	���ε� ��û
					uploadProc(data);
					break;
				case	1302:	//	��� ��û
					listProc(data);
					break;
				case	1303:	//	�ٿ�ε� ��û
					downloadProc(data);
					break;
				}
			}
		}
		catch(Exception e) {
		}
		finally {
			try {
				oin.close();
				oout.close();
				socket.close();
			}
			catch(Exception e) {}
			main.clientList.remove(this);
		}
	}
}







