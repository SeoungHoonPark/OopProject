/**
 * 
 */
package P1227;

import java.text.MessageFormat;

/**
 *	
 */
public class Test07 {
	public Test07() {
		// ���� 
		// "Name : ȫ�浿. tel : 010-1111-2222, age : 24";
		// "Name : �ھ���. tel : 010-1234-5678, age : 34";
		
		MessageFormat f 
		= new MessageFormat("Name : {0}, tel : {1}, age : {2}");
		
		Object[] date = {"ȫ�浿", "010-1111-2222", 24};
		// {0} ... �� �� �����͸� �迭�� �غ��Ѵ�.
		
			String result = f.format(date);
			System.out.println(result);
			
	}

	public static void main(String[] args) {
		new Test07();
	}
}
