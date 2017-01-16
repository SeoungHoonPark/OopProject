package P0113;
/*
 * 	문제
 * 		파일에
 * 		친구의 정보를 저장하자
 * 		정보		이름		String
 * 					나이		int
 * 					신장		float
 * 					성별		boolean
 * 					전화번호	String
 * 					메일주소	String
 */
import	java.io.*;
public class DataInputTest01 {
	public DataInputTest01() {
		FileOutputStream	fout = null;
		DataOutputStream	dout = null;
		try {
			fout = new FileOutputStream("D:\\친구.doc");
			dout = new DataOutputStream(fout);
			String	name = "홍길동";
			int		age = 24;
			float	height = 175.45F;
			boolean	gender = true;
			String	tel = "010-5656-3636";
			String	mail = "hong@daum.net";
			//	DataInput/Output의 특징은 자바의 데이터를
			//	변환없이 사용할 수 있다.
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
