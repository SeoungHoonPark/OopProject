package P0113;
/*
 * 	����
 * 		���Ͽ�
 * 		ģ���� ������ ��������
 * 		����		�̸�		String
 * 					����		int
 * 					����		float
 * 					����		boolean
 * 					��ȭ��ȣ	String
 * 					�����ּ�	String
 */
import	java.io.*;
public class DataInputTest01 {
	public DataInputTest01() {
		FileOutputStream	fout = null;
		DataOutputStream	dout = null;
		try {
			fout = new FileOutputStream("D:\\ģ��.doc");
			dout = new DataOutputStream(fout);
			String	name = "ȫ�浿";
			int		age = 24;
			float	height = 175.45F;
			boolean	gender = true;
			String	tel = "010-5656-3636";
			String	mail = "hong@daum.net";
			//	DataInput/Output�� Ư¡�� �ڹ��� �����͸�
			//	��ȯ���� ����� �� �ִ�.
			dout.writeUTF(name);
			dout.writeInt(age);
			dout.writeFloat(height);
			dout.writeBoolean(gender);
			dout.writeUTF(tel);
			dout.writeUTF(mail);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		new DataInputTest01();
	}
}
