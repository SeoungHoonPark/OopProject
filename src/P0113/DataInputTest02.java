package P0113;
/*
 * 	�տ��� ������ ģ��.doc ������ ������ �о ����� ����.
 */
import	java.io.*;
public class DataInputTest02 {
	public DataInputTest02() {
		//	Data ������� ó���� ������ �ݵ�� Data �������
		//	��ó���� �ؾ� �� �� �ִ�.
		FileInputStream		fin = null;
		DataInputStream		din = null;
		try {
			fin = new FileInputStream("D:\\ģ��.doc");
			din = new DataInputStream(fin);
			//	�����Ҷ� �̸�, ����, ����, ����, ����, ���� ������
			//	���������Ƿ� �������� �� ������� �޾ƾ� �Ѵ�.
			String	irum = din.readUTF();
			int		nai = din.readInt();
			float	sinjang = din.readFloat();
			boolean	sung = din.readBoolean();
			String	jun = din.readUTF();
			String	addr = din.readUTF();
			
			System.out.println("�̸� " + irum);
			System.out.println("���� " + nai);
			System.out.println("���� " + sinjang);
			System.out.println("���� " + sung);
			System.out.println("��ȭ��ȣ " + jun);
			System.out.println("�����ּ� " + addr);
					
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				din.close();
				fin.close();
			}
			catch(Exception e) {}
		}
	}
	public static void main(String[] args) {
		new DataInputTest02();
	}
}




