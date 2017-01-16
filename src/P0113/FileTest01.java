package P0113;
/*	1.
 * 	D:\\ 폴더하나를 강제로 만들자
 * 	2.	
 * 	D:\\ 계층된 폴더를 강제로 만들자
 * 	3.
 * 	만들어진 파일중 하나를 삭제하자.(폴더 삭제도 가능, 파일 삭제도 가능)
 */
import	java.io.*;
public class FileTest01 {

	public FileTest01() {
		//	만들고 싶은 폴더(없어도 상관없으니) 파일로 만들자.
		//	1.
//		File	file = new File("D:\\연습");
//		file.mkdir();
		
		//	2.
//		File	file = new File("D:\\테스트\\진짜\\태연");
//		file.mkdirs();
		
		//	3.
		//	삭제할 파일을 File로 만든다.(존재해야 지울수 있다)
		File	file = new File("D:\\연습");
		file.delete();
		
		//	4.	특정 파일의 이름을 다른 이름으로 변경하자.
		//		1)	현재 파일과 바꿀이름의 파일을 둘다 File로 만든다.
		File	oldF = new File("d:\\sam.txt");
		File	newF = new File("d:\\sample.txt");
		//		2)	바꾸면 된다.(renameTo)
		oldF.renameTo(newF);
	}

	public static void main(String[] args) {
		new FileTest01();
	}
}
