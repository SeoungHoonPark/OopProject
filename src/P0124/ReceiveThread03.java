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
				//	서버는 클라이언트에게 클래스를 통채로 주기로 했다.
				//	이때 우리는 MainData 클래스만 통신하기로 약속했다.
				//	서버가 준 데이터를 받자
				MainData	data = (MainData)main.oin.readObject();
				if(data == null) {
					break;
				}
				//	데이터가 도착되었으면... 데이터의 의미를
				//	분석해서 원하는 작업을 하도록 한다.
				switch(data.protocol) {
				case 	2101:	//	로그인 응답
					loginProc(data);
					break;
				case	2201:	//	채팅 응답
					chatProc(data);
					break;
				case	2301:	//	업로드 응답
					uploadProc(data);
					break;
				case	2302:	//	목록 응답
					listProc(data);
					break;
				case	2303:	//	다운로드 응답
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
		//	할일
		if(data.isSuccess == true) {
			//		성공하면 화면을 채팅화면으로 바꿔주고
			main.card.show(main.mainP, "CHAT");
		}
		else {
			//		실패하면 실패 대화상자 출력
			JOptionPane.showMessageDialog(main.frame, "로그인에 실패했어도 다시 시도하세요");
		}
	}
	void chatProc(MainData data) {
		//	할일
		//		메시지를 텍스트 에리어에 출력한다.
		main.chatP.area.append(data.chatD.msg + "\r\n");
		main.chatP.sp.getVerticalScrollBar().setValue(main.chatP.sp.getVerticalScrollBar().getMaximum());
	}
	void uploadProc(MainData data) {
		//	할일
		if(data.isSuccess == true) {
		//		성공하면 성공 메시지를 출력하고
			JOptionPane.showMessageDialog(main.frame, "업로드가 성공적으로 되었습니다.");
		}
		else {
		//		실패하면 실패 메시지를 출력한다.
			JOptionPane.showMessageDialog(main.frame, "업로드에 실패했습니다. 다시 시도하세요");
		}
	}
	void listProc(MainData data) {
		//	할일
		//		서버가 알려준 목록을 준비된 콤보상자에 출력한다.
		//	1.	먼저있던 내용 지우고
		main.chatP.listBox.removeAll();
		//	2,	벡터의 내용을 하나씩꺼내서 콤보에 넣는다.
		int	size = data.fileD.list.size();
		for(int i = 0; i < size; i++) {
			main.chatP.listBox.addItem(data.fileD.list.get(i));
		}
	}
	void downloadProc(MainData data) {
		//	할일
		//		서버가 전달해준 파일이름을 이용해서
		//		스트림을 만들고
		//		그 안에 파일의 내용을 저장한다.
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
