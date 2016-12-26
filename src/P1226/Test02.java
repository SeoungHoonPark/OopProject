/**
 * 
 */
package P1226;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Ư�� ���ڿ��� �Է��� �� �� ���ڿ� �߿��� ���ϴ� ��Ģ�� �´� �κи� ��� ����϶�.
 * 
 */
public class Test02 {

	public Test02() {
		String tel = "[HP] : 010-8755-0895";
		// �� �߿��� ��ȭ��ȣ �κи� ������ �ʹ�.
		/* ���
		 * 	���Խ� �˻縦 �����Ѵ�. 
		*/
		Pattern p = Pattern.compile("0[0-9]{2}-[0-9]{3,4}-[0-9]{4}");
		Matcher m = p.matcher(tel);
		if(m.find()){
			//find �Լ��� �̿��ؼ� ��Ģ�� �´� �κ��� �ִ��� Ȯ���ϰ�
			String group = m.group(); // �����ϸ� �´� �κи� ������ �ȴ�.
			System.out.println("����� ��ȭ��ȣ�� " + group);
		}
	}
	public static void main(String[] args) {
		new Test02();
	}

}
