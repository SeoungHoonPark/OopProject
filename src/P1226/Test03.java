/**
 * 
 */
package P1226;

import java.io.File;
import java.util.Scanner;

/**
 * ��ĳ�ʸ� �̿��ؼ� ���Ͽ� ����� ������ �о �������
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
		
		System.out.println("����� ���� �ȿ��� " + str);
		
	}
	public static void main(String[] args) {
		new Test03();
	}

}
