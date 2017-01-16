package P0116;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *		앞에서 만드는 소스를 읽어서 출력하자.
 */
public class BufferedReaderTest01 {
	// 한줄씩 읽을 예정이므로 BufferedReader를 사용할 예정이다.
	// 하지만 반드시 타겟을 존재해야 하고 필요하면 필터를 연결하는 것이다.
	FileReader fr = null;
	BufferedReader br = null;
	
	public BufferedReaderTest01() {
		try{
			// 처음에는 타겟에 빨대를 꽂는다.
			fr = new FileReader("scr/p0115/FileCopyTest01.java");
			// 필요하면 보조스트림을 연결한다.
			br = new BufferedReader(fr);
			
			// 몇번 읽어야 할지 모르므로...
			while(true){
				String line = br.readLine();
				if(line == null){
					break;
				}				
				System.out.println(line);
				// println()은 출력 후 줄을 바꿔주는 명령이다.
				// 이미 readLine()에서 한줄을 읽은 후 줄바꿈기호를 버렸기 때문에..
				// 자동으로 줄이 바뀌지 않는다.
				// ※ 강제로 바꿔야 한다.
			}
					
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try{
				br.close();
				fr.close();
			}catch(Exception e){
				
			}
		}
	}

	public static void main(String[] args) {
		new BufferedReaderTest01();
	}

}
