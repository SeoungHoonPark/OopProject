/**
 * 
 */
package P0102;

import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @author hong
 *
 */
public class Test02 {

	public Test02() {
		Properties prop = new Properties();
		prop.put("name", "ȫ�浿");
		prop.put("age", "24");
		prop.put("tel", "01085770895");
		prop.put("addr", " ����� ���α�");
		
		FileOutputStream fout = null;
		
			try{
					fout = new FileOutputStream("scr/Oop/P0102/Result.txt");
					prop.store(fout, "�ּ����� ����� ������ ����");
			}catch(Exception e){
					
			}
	}

	public static void main(String[] args) {
			new Test02();
	}

}
