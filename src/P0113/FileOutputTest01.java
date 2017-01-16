package P0113;/*
 * 	문제
 * 		적당한 파일에 내용을 저장하는 프로그램을 만들어보자.
 */

import		java.io.*;
public class FileOutputTest01 {

	public FileOutputTest01() {
		//	파일에 저장하기 위해서는 파일로 연결된 스트림이 필요하다.
		FileOutputStream	fout = null;
		try {
			fout = new FileOutputStream("d:\\FileText.txt");
			//	파일이 존재하지 않아도 자동으로 만들어준다....
			//	1.	한글자만 입력하자.
//			fout.write('A');
			//	2.	여러 글자를 내보내보자.
//			String	str = "죽는날까지 하늘을 우러러 한점 부끄럼 없기를";
//			byte[]	buff = str.getBytes();
//			fout.write(buff);
			
			String	str = "I Am A Boy, My Name is Hong Gil Dong";
			byte[]	buff = str.getBytes();
			fout.write(buff, 12, buff.length - 12);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			//	외부장치와 연결된 경우는 해당 외부장치의 사용이 
			//	끝나면 닫아주는 것이 원칙이다.
			try {
				fout.close();
			}
			catch(Exception e) {}
		}
	}

	public static void main(String[] args) {
		new FileOutputTest01();
	}
}
