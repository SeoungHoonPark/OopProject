package P0124;

import	java.net.*;
import	java.util.*;

import	SQL.*;
import	java.sql.*;
public class ChatServer03 {
	ServerSocket	server;		//	필수

	ArrayList		clientList;	//	접속한 클라이언트를 기억할 변수
	//	1:다 통신에서만 필요한 변수
	
	//	데이터베이스 사용을 위한 변수
	PreparedStatement	loginS;
	MyJDBC				db;
	ResultSet			rs;
	public ChatServer03() {
		//	대표전화준비
		try {
			server = new ServerSocket(9988);
			clientList = new ArrayList();
		}
		catch(Exception e) {
			System.exit(0);
		}
		//	서버는 클라이언트의 요청에 따라서 데이터베이스를
		//	사용할 필요가 있다.
		//	언제 클라이언트가 데이터베이스 사용요청을 할지 모르므로....
		//	미리 데이터베이스와 연결해 놓고 준비를 하자.
		db = new MyJDBC();
		String	login = "SELECT * FROM Member WHERE m_id=? AND m_pw=?";
		loginS = db.getPSTMT(login);
		//	이후에 또다른 질의 명령이 필요하면....
		//	계속해서 만들어 놓으면 된다.
		System.out.println(" 접속 대기 ");
		while(true) {
			try {
				Socket	socket = server.accept();
				//	이 클라이언트와 독립적으로 통신할 프로그램을
				//	만들어서 배정해 준다.
				
				ClientThread03	t = new ClientThread03(this, socket);
				clientList.add(t);
				t.start();
			}
			catch(Exception e) {
				System.out.println("접속 에러 = " + e);
			}
		}
	}
	public static void main(String[] args) {
		new ChatServer03();
	}
}



