/**
 * 
 */
package P0102;

import java.util.Enumeration;
import java.util.Properties;

/**
 *	프로그램에 관련된 정보를 자동으로 뽑아서 구경하자.
 */
public class Test03 {
	public Test03() {
		Properties proc = System.getProperties();
		// getProperties()가 프로그램에 관련된 정보를 map으로 만등러주는 함수이다.
		
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
