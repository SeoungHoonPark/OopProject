package P1220;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 
 */
public class Test02 {
	public static void main(String[] args) {
		
		File file = new File("D:\\");
		String [] list = file.list(new MyFilter());
		for(String temp :list){
			System.out.println("파일 목록 = " + temp);
		}
	}
}

class MyFilter implements FilenameFilter {
	public boolean accept(File dir, String name) {
		//System.out.println("나 실행된요");
		// 파일이름이 j로 시작하는 것만 출력하고 싶다.
		if(name.startsWith("J")){
			return true;
		}else{
			return false;
		}
	}
}
