package P0124;
/*
 * 	각각의 클라이언트와 통신할 스레드 클래스
 */
import	NETData.*;
import	java.net.*;
import	java.io.*;
import	java.sql.*;
import java.util.Vector;
public class ClientThread03 extends Thread {
	ChatServer03		main;
	//	필수변수(통신변수)
	Socket				socket;	//	앞에서 받아서 사용하고
	ObjectInputStream	oin;	//	Socket이 있으면 만들 수 있고...
	ObjectOutputStream	oout;
	//	선택변수(정보변수)
	//	프로그램을 편하게 처리하게 위해 필요한 정보가 있으면...
	//	얼마든지 만들어서 기억하면 된다.
	String				ip;
	String				name;
	String				id;
	
	public ClientThread03(ChatServer03 m, Socket s) throws Exception {
		main 	= m;
		socket 	= s;
		
		InputStream		in 	= socket.getInputStream();
		OutputStream	out = socket.getOutputStream();
		//	주의	★★★★
		//		Object 는 만드는 순서가 중요하다.
		System.out.println("받고");
		oout 	= new ObjectOutputStream(out);
		System.out.println("준다");
		oin 	= new ObjectInputStream(in);
		
		InetAddress	inet = socket.getInetAddress();
		ip = inet.getHostAddress();
	}
	
	void loginProc(MainData data) {
		//	할일
		//		데이터베이스에서 그 사람의 정보가 있는지 확인하고
		boolean		isSuccess = false;
		try {
			//	이미 스테이트먼트는 만들어져 있으므로,,,,
			//	?에 데이터를 채우고
			main.loginS.setString(1, data.loginD.id);
			main.loginS.setString(2, data.loginD.pw);
			//	질의 명령을 실행해본다.
			main.rs = main.loginS.executeQuery();
			if(main.rs.next() == true) {
				//	그런 회원이 존재한다
				isSuccess = true;
				//	정보를 정보 변수에 기억해 놓자
				id = main.rs.getString("m_ID");
				name = main.rs.getString("m_Name");
			}
			else {
				//	그런 회원이 존재하지 않는다.
				isSuccess = false;
			}
		}
		catch(Exception e) {
			
		}
		finally {
			main.db.close(main.rs);
		}
		//		그 결과를 응답한다.
		//		응답 방법은 클라이언트가 서버에게 데이터를
		//		주는 방식과 동일하다.
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
		//	할일
		//		데이터를 꾸미고
		String	msg = "[" + name + " 님 말씀 ] " + data.chatD.msg;
		//		모든 클라이언트에게 응답한다.
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
		//	할일
		//		클라이언트 준 파일의 내용을 서버의 적당한 위치에
		//		저장한다.
		//		나는	D:\\upload에 저장할 예정이다.
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
	
		//	응답한다.
		MainData	mainD = new MainData();
		mainD.protocol = 2301;
		mainD.isSuccess = isSuccess;
		
		try {
			oout.writeObject(mainD);
		}
		catch(Exception e) {}
	}
	void listProc(MainData data) {
		//	할일
		//		D:\\upload 폴더에 있는 모든 파일의 목록을
		//		클라이언트에게 알려준다.
		File	dir = new File("D:\\upload");
		String[]	list = dir.list();
		//	이것을 Vector로 만들어서 클래스에 넣는다.
		Vector v = new Vector();
		for(int i = 0; i < list.length; i++) {
			v.add(list[i]);
		}

		//	클라이언트에게 응답한다.
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
		//	할일
		//		클라이언트가 요청한 파일을 스트림으로 읽어서
		//		그 내용을 클라이언트에게 응답한다.
		//		(그러면 클라이언트는 받은 내용을 지 컴퓨터에
		//		저장할 것이다.)
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
		//	응답한다.
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
				//	클라이언트가 보내준 데이터 받는다
				//	클래스가 통채로 온다.
				MainData	data = (MainData) oin.readObject();
				if(data == null) {
					break;
				}
				//	작업을 분석한다.
				switch(data.protocol) {
				case	1101:	//	로그인 요청
					loginProc(data);
					break;
				case	1201:	//	채팅 요청
					chatProc(data);
					break;
				case	1301:	//	업로드 요청
					uploadProc(data);
					break;
				case	1302:	//	목록 요청
					listProc(data);
					break;
				case	1303:	//	다운로드 요청
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







