/**
 * 
 */
package P1226;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��ȭ��ȣ�� �Է��� �� �װ��� ��ȭ��ȣ ������ �´��� �˻��϶�
 * 
 */
public class Test01 {
	
	public Test01() {
		String tel = "010-8755-0895";
		// �ڡڡڡڡڡڡ�
		// Pattern Ŭ�󽺸� �̿��ؼ� �˻��ϰ� ���� ���Խ� ������ �����.
		// ���� �� Ŭ������ ������ �Լ��� �����Ƿ� ����� new ���Ѽ� ����� �� ����.
		
		Pattern ptn = Pattern.compile("0[0-9]{2}-[0-9]{3,4}-[0-9]{4}");
		// ��� compile�Լ��� �̿��ؼ�
		//	���Խ��� ����ϸ鼭 ��� ����� �޶�� �ؾ��Ѵ�.
		
		// �� Ŭ�������� ���Խ� ������ �˻��� �޶�� �䱸�Ѵ�.
		//	���� �˻� �Լ��� matcher()
		//	�� �Լ��� �˻� ����� Matcher��� Ŭ������ ����� ���� ��� ������ ��� �˷��ֵ��� �Ǿ��ִ�.
		
		Matcher m = ptn.matcher(tel);
		// ���� Matcher Ŭ���� �ȿ� �˻��� ������ ���Ǿ� �ִ�.
		// �˻� ��� �߿��� �´��� Ʋ������ �˷��ִ� �Լ��� Matcher()�Լ���
		if(m.matches()){
			System.out.println("�ùٸ� ��ȭ��ȣ�Դϴ�.");
		}else{
			System.out.println("�߸��� ��ȭ��ȣ�Դϴ�.");
		}
		
		
	}
		
	public static void main(String[] args) {
		
		new Test01();
		
	}
}
