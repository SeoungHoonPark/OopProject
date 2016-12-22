/**
 * 
 */
package P1221;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * d드라이브에다가 
 */
public class Test09 {
	public Test09() {
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream("D:\\test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(true){
			byte[] buff = new byte[255];
			int len = 0;
			try {
				len = fin.read(buff);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String str = new String(buff, 0, len);
			System.out.println(str);
		}
	}
	public static void main(String[] args) {
		new Test09();
	}

}
