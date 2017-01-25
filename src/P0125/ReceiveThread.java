package P0125;

import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * 	이 클래스는 쪽지를 받기 위한 클래스이다.
 * 	tcp에서와 마찬가지고 쪽지는 언제 도착할지 모르는 상태이다.
 * 	그러므로 독립적으로 쪽지를 받기 위한 프로그램을 따로 만들어서 처리해야 한다.
 */
public class ReceiveThread extends Thread {
	JJokJi main;
	public ReceiveThread(JJokJi m) {
		main = m;
	}
	void receiveProc(DatagramPacket pack){
		// 포장을 뜯어서 내용물을 확인하고
		byte[] buff = pack.getData();
		String msg = new String(buff, 0, buff.length);
		InetAddress addr = pack.getAddress();
		String ip = addr.getHostAddress();
		// 그 내용물을 대화상자 출력하고
		String name = (String) main.ipToName.get(ip);
		ReceiveDlg dlg = new ReceiveDlg(main);
		dlg.field.setText(name);
		dlg.area.setText(msg);
		// 대화상자를 보여주다
		dlg.frame.setVisible(true);
	}
	
	@Override
	public void run() {
		try{
			while(true){
				// 할일
				// 쪽지를 받아야 한다.
				// 도착한 쪽지는 패킷으로 도착을 한다.
				
				// ★★★★ 반드시 패킷을 준비해서 받아야 한다.
				
				byte[] buff = new byte[10240];
				DatagramPacket pack = new DatagramPacket(buff, 10240);
				main.rSocket.receive(pack);
				// 이 함수 역시 블러킹 함수로써
				// 패킷이 도착하면 실행되는 함수이다.
				// 도착한 패킷을 대화상자를 이용해서 출력한다.
				receiveProc(pack);
				
			}
		}catch(Exception e){
			
		}finally {
			
		}
	}
}
