/**
 * 
 */
package P1226;

import java.io.File;
import java.util.Scanner;

/**
 * 스캐너를 이용해서 파일에 저장된 내용을 읽어서 출력하자
 */
public class Test03 {
	
	public Test03() {
		File f = new File("D:\\test2.txt");		
		Scanner s = null;
		
		try{
			s = new Scanner(f);
		}catch(Exception e){
			e.printStackTrace();;			
		}
		String str = s.nextLine();
		
		System.out.println("당신의 파일 안에는 " + str);
		
	}
	public static void main(String[] args) {
		new Test03();
	}

}
