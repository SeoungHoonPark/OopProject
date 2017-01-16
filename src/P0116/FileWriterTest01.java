package P0116;

import java.io.FileWriter;

/**
 * char단위로 파일에 데이터를 저장하는 프로그램을 작성하세요.
 */
public class FileWriterTest01 {
	public FileWriterTest01() {
		FileWriter fw = null;
		char[] buff = null;
		try{
			fw = new FileWriter("d:\\파일테스트.txt", true);
			// 1. 한글자만 저장해보자
//			char  ch = '한';
//			fw.write(ch);
			
			// 2. 여러 글자를 저장해 보자.
//			String str = "하늘을 우러러 한점 부끄럼 없기를";
//			String str2 = "뻥입니다.";
//			
//			char[] buff = str.toCharArray();
//			buff = str2.toCharArray();
//			fw.write(buff);
			// 참고
			// char 단위는 텍스트 데이터만 처리하도록 되어있기 때문에
			// 기본 함수에 + 문자 처리 기능이 추가되었다.
			String str = "하늘을 우러러 한점 부끄럼 없기를";
			fw.write(str);
			
		}catch(Exception e){
			System.out.println(e);
		}finally {
			try{
				fw.close();
			}catch(Exception e){
				
			}
		}
	}

	public static void main(String[] args) {
		new FileWriterTest01();
	}

}
