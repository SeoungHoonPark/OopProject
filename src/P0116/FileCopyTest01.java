/**
 * 
 */
package P0116;

import java.io.FileReader;
import java.io.FileWriter;

/**
 *	기계어 처리는 반드시 BYTE단위를 사용해야 한다.
 *	여기서는 CHAR단위를 사용함으로 안되는 것.
 */
public class FileCopyTest01 {
	public FileCopyTest01() {
		FileReader fr = null;
		FileWriter fw = null;
		
		try{
			fr = new FileReader("d:\\tae.jpg");
			fw = new FileWriter("d:\\yun.jpg");
			while(true){
				char[] buff = new char[1024];
				int len = fr.read(buff);
				if(len == -1){
					break;
				}
				fw.write(buff, 0, len);
			}
			System.out.println("복사끝");		
		}catch(Exception e){
			
		}finally {
			try{
				fw.close();
				fr.close();
			}catch(Exception e){
				
			}
		}
	}

	public static void main(String[] args) {
		new FileCopyTest01();
	}
}
