package P0116;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *		�տ��� ����� �ҽ��� �о �������.
 */
public class BufferedReaderTest01 {
	// ���پ� ���� �����̹Ƿ� BufferedReader�� ����� �����̴�.
	// ������ �ݵ�� Ÿ���� �����ؾ� �ϰ� �ʿ��ϸ� ���͸� �����ϴ� ���̴�.
	FileReader fr = null;
	BufferedReader br = null;
	
	public BufferedReaderTest01() {
		try{
			// ó������ Ÿ�ٿ� ���븦 �ȴ´�.
			fr = new FileReader("scr/p0115/FileCopyTest01.java");
			// �ʿ��ϸ� ������Ʈ���� �����Ѵ�.
			br = new BufferedReader(fr);
			
			// ��� �о�� ���� �𸣹Ƿ�...
			while(true){
				String line = br.readLine();
				if(line == null){
					break;
				}				
				System.out.println(line);
				// println()�� ��� �� ���� �ٲ��ִ� ����̴�.
				// �̹� readLine()���� ������ ���� �� �ٹٲޱ�ȣ�� ���ȱ� ������..
				// �ڵ����� ���� �ٲ��� �ʴ´�.
				// �� ������ �ٲ�� �Ѵ�.
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
