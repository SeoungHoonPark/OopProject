package P0116;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *		InputStreamReader 역할에 대해서 
 *		파일을 읽어내자
 */
public class BufferedReaderTest02 {

	public BufferedReaderTest02() {
		FileInputStream fin= null;
		BufferedReader br = null;
		
		try{
			fin = new FileInputStream("src/P0116/FileCopyTest01.java");
			//br = new BufferedReader(fin); 에러
			// 크기가 다르면 연결할 수 없다.
			// T관을 하나 준비해서 한쪽을 연결한다.
			
			InputStreamReader temp = new InputStreamReader(fin);
			br  = new BufferedReader(temp);
			
			// 몇번 읽어야 할지 모르므로...
			while(true){
				String line = br.readLine();
				if(line == null){
					break;
				}				
				System.out.println(line);
			}
			
		}catch(Exception e){
			
		}finally{
			try{
				br.close();
				fin.close();
			}catch(Exception e){
				
			}
		}
	}

	public static void main(String[] args) {
		new BufferedReaderTest02();
	}
}
