package P0113;
/*
 * 	앞에서 저장한 친구.doc 파일의 내용을 읽어서 출력해 보자.
 */
import	java.io.*;
public class DataInputTest02 {
	public DataInputTest02() {
		//	Data 방식으로 처리된 내용은 반드시 Data 방식으로
		//	역처리를 해야 알 수 있다.
		FileInputStream		fin = null;
		DataInputStream		din = null;
		try {
			fin = new FileInputStream("D:\\친구.doc");
			din = new DataInputStream(fin);
			//	저장할때 이름, 나이, 신장, 성별, 전번, 메일 순서로
			//	저장했으므로 받을때도 이 순서대로 받아야 한다.
			String	irum = din.readUTF();
			int		nai = din.readInt();
			float	sinjang = din.readFloat();
			boolean	sung = din.readBoolean();
			String	jun = din.readUTF();
			String	addr = din.readUTF();
			
			System.out.println("이름 " + irum);
			System.out.println("나이 " + nai);
			System.out.println("신장 " + sinjang);
			System.out.println("성별 " + sung);
			System.out.println("전화번호 " + jun);
			System.out.println("메일주소 " + addr);
					
			
			
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




