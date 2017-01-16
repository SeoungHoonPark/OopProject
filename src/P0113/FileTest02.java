package P0113;
/*
 * 	문제
 * 		수업설명의 자바 폴더 안에있는 파일의 목록을 알아내자
 */
import	java.io.*;
public class FileTest02 {
	public FileTest02() {
		//	목록을 알아내고 싶은 폴더를 파일로 만든다.
		File	dir = new File("D:\\수업설명\\Java");
		
//		String[]	list = dir.list();
//		for(int i = 0; i < list.length; i++) {
//			String	fileName = list[i];
//			System.out.println(fileName);
//		}
		
//		File[]	list = dir.listFiles();
//		for(int i = 0; i < list.length; i++) {
//			File	fileInfo = list[i];
//			String	fileName = fileInfo.getName();
//			long	len = fileInfo.length();
//			System.out.println(fileName + " : " + len);
//		}
	
		//	확장자가 xlsx인것만 골라서 출력하고싶다.
		String[]	list = dir.list(new MyFillter());
		for(int i = 0; i < list.length; i++) {
			String	fileName = list[i];
			System.out.println(fileName);
		}
	}
	public static void main(String[] args) {
		new FileTest02();
	}
}
//	문제
//		특정 폴더에 있는 파일 중에서 이름이 A로 시작하고 
//		확장자가 ???인 파일만 골라서 출력해보시요. 

class MyFillter implements FilenameFilter {
	public boolean accept(File dir, String name)  {
		//	매개변수의 역활
		//		File dir		현재 파일의 정보를 알려주고
		//		String name		현재 파일의 이름만 알려준다.
		
		//	이 함수는 역시 자동 호출함수이다.
		//	목록을 구하는 파일을 하나씩 발견할때마다 이 함수가 호출된다.
		//	이 함수에서 true를 반환하면 목록에 포함하고
		//	이 함수에서 false를 반환하면 목록에서 제외한다.
		
		if(name.endsWith("xlsx")) {
			return true;			
		}
		else {
			return false;
		}
	}
}







