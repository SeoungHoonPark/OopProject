/**
 * 
 */
package P1228;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author hong
 *
 */
public class Test05 {
	public Test05() {
		// ���⼭ �÷����� ����ϴٰ�, �����͸� ���� ������ �Ǹ�
		// �ؿ� �ִ� �Լ����� �ڽ��� �÷����� Iterator�� ��ȯ�����ָ� ���� �� �ֵ��� �Ѵ�.
		
		ArrayList al = new ArrayList();
		
//		al.add("�¿�");
//		al.add("�¿�");
//		al.add("�¿�");
//		al.add("�¿�");
//		al.add("�¿�");
//		al.add("�¿�");
//		al.add("�¿�");
//		al.add("�¿�");
//		al.add("�¿�");
		
//		getData(al.iterator());
		
		HashSet list = new HashSet();
		al.add("�¿�1");
		al.add("�¿�2");
		al.add("�¿�3");
		al.add("�¿�4");
		al.add("�¿�5");
		al.add("�¿�6");
		al.add("�¿�7");
		al.add("�¿�8");
		al.add("�¿�9");
		
		getData(list.iterator());
			
	}
	
	// �����͸� ������ ���� ���� �Լ�
	void getData(Iterator iter){
		while(iter.hasNext()){
			String temp = (String) iter.next();
			// ����ó�� ������θ� ���� �� �ִ�.
			// List�� ������ �����ϰ� Set�� �������� ���ϹǷ� �ΰ��� ����� ȥ���ϱ� ���ؼ��� ������ ���ظ� ���� �Ѵ�.
			System.out.println(temp);
		}
		System.out.println("�ٽò�����.");
		// ������ �����͸� ������ ���Ѵ�. �ѹ� ���� �����ʹ� �������� ���Ѵ�.+666666666666666666```````````
		
		while(iter.hasNext()){
			String temp = (String) iter.next();
			// ����ó�� ������θ� ���� �� �ִ�.
			// List�� ������ �����ϰ� Set�� �������� ���ϹǷ� �ΰ��� ����� ȥ���ϱ� ���ؼ��� ������ ���ظ� ���� �Ѵ�.
			System.out.println(temp);
		}
	}

	public static void main(String[] args) {
		new Test05();
	}

}
