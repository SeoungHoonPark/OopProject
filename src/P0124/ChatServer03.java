package P0124;

import	java.net.*;
import	java.util.*;

import	SQL.*;
import	java.sql.*;
public class ChatServer03 {
	ServerSocket	server;		//	�ʼ�

	ArrayList		clientList;	//	������ Ŭ���̾�Ʈ�� ����� ����
	//	1:�� ��ſ����� �ʿ��� ����
	
	//	�����ͺ��̽� ����� ���� ����
	PreparedStatement	loginS;
	MyJDBC				db;
	ResultSet			rs;
	public ChatServer03() {
		//	��ǥ��ȭ�غ�
		try {
			server = new ServerSocket(9988);
			clientList = new ArrayList();
		}
		catch(Exception e) {
			System.exit(0);
		}
		//	������ Ŭ���̾�Ʈ�� ��û�� ���� �����ͺ��̽���
		//	����� �ʿ䰡 �ִ�.
		//	���� Ŭ���̾�Ʈ�� �����ͺ��̽� ����û�� ���� �𸣹Ƿ�....
		//	�̸� �����ͺ��̽��� ������ ���� �غ� ����.
		db = new MyJDBC();
		String	login = "SELECT * FROM Member WHERE m_id=? AND m_pw=?";
		loginS = db.getPSTMT(login);
		//	���Ŀ� �Ǵٸ� ���� ����� �ʿ��ϸ�....
		//	����ؼ� ����� ������ �ȴ�.
		System.out.println(" ���� ��� ");
		while(true) {
			try {
				Socket	socket = server.accept();
				//	�� Ŭ���̾�Ʈ�� ���������� ����� ���α׷���
				//	���� ������ �ش�.
				
				ClientThread03	t = new ClientThread03(this, socket);
				clientList.add(t);
				t.start();
			}
			catch(Exception e) {
				System.out.println("���� ���� = " + e);
			}
		}
	}
	public static void main(String[] args) {
		new ChatServer03();
	}
}



