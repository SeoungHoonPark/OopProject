/**
 * 
 */
package P0102;

import java.util.Enumeration;
import java.util.Properties;

/**
 *	���α׷��� ���õ� ������ �ڵ����� �̾Ƽ� ��������.
 */
public class Test03 {
	public Test03() {
		Properties proc = System.getProperties();
		// getProperties()�� ���α׷��� ���õ� ������ map���� ����ִ� �Լ��̴�.
		
		Enumeration	enu = proc.keys();
		
		while(enu.hasMoreElements()){
			String key = (String) enu.nextElement();
			String value = (String) proc.getProperty(key);
			
			System.out.println("key : " + key + "                values : " + value);			
		}		
	}

	public static void main(String[] args) {
		new Test03();
	}
}
