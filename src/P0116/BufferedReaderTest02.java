package P0116;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *		InputStreamReader ���ҿ� ���ؼ� 
 *		������ �о��
 */
public class BufferedReaderTest02 {

	public BufferedReaderTest02() {
		FileInputStream fin= null;
		BufferedReader br = null;
		
		try{
			fin = new FileInputStream("src/P0116/FileCopyTest01.java");
			//br = new BufferedReader(fin); ����
			// ũ�Ⱑ �ٸ��� ������ �� ����.
			// T���� �ϳ� �غ��ؼ� ������ �����Ѵ�.
			
			InputStreamReader temp = new InputStreamReader(fin);
			br  = new BufferedReader(temp);
			
			// ��� �о�� ���� �𸣹Ƿ�...
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
