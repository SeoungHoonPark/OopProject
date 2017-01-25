package P0125;

import java.net.DatagramPacket;
import java.net.InetAddress;

/**
 * 	�� Ŭ������ ������ �ޱ� ���� Ŭ�����̴�.
 * 	tcp������ ���������� ������ ���� �������� �𸣴� �����̴�.
 * 	�׷��Ƿ� ���������� ������ �ޱ� ���� ���α׷��� ���� ���� ó���ؾ� �Ѵ�.
 */
public class ReceiveThread extends Thread {
	JJokJi main;
	public ReceiveThread(JJokJi m) {
		main = m;
	}
	void receiveProc(DatagramPacket pack){
		// ������ �� ���빰�� Ȯ���ϰ�
		byte[] buff = pack.getData();
		String msg = new String(buff, 0, buff.length);
		InetAddress addr = pack.getAddress();
		String ip = addr.getHostAddress();
		// �� ���빰�� ��ȭ���� ����ϰ�
		String name = (String) main.ipToName.get(ip);
		ReceiveDlg dlg = new ReceiveDlg(main);
		dlg.field.setText(name);
		dlg.area.setText(msg);
		// ��ȭ���ڸ� �����ִ�
		dlg.frame.setVisible(true);
	}
	
	@Override
	public void run() {
		try{
			while(true){
				// ����
				// ������ �޾ƾ� �Ѵ�.
				// ������ ������ ��Ŷ���� ������ �Ѵ�.
				
				// �ڡڡڡ� �ݵ�� ��Ŷ�� �غ��ؼ� �޾ƾ� �Ѵ�.
				
				byte[] buff = new byte[10240];
				DatagramPacket pack = new DatagramPacket(buff, 10240);
				main.rSocket.receive(pack);
				// �� �Լ� ���� ��ŷ �Լ��ν�
				// ��Ŷ�� �����ϸ� ����Ǵ� �Լ��̴�.
				// ������ ��Ŷ�� ��ȭ���ڸ� �̿��ؼ� ����Ѵ�.
				receiveProc(pack);
				
			}
		}catch(Exception e){
			
		}finally {
			
		}
	}
}
