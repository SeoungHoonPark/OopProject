/**
 * 
 */
package P0102;

import java.util.ArrayList;

/**
 *		ArrayList�� String �����͸� �Է��ϵ��� ���ʸ��� ó���Ͽ� ����غ���
 */
public class Test04 {

	public Test04() {
		ArrayList<String> list = new ArrayList<String>();
		// ���� �� list�� String�� �ƴ� �ٸ� ������ �����Ͱ� �ԷµǸ� ������ �߻��Ѵ�.
		list.add("ȫ�浿");
		list.add("�̱浿");
		list.add("�ڱ浿");
//		list.add(35);
		
		for(int i = 0; i < list.size(); i++){
			String name = list.get(i);
		}
		System.out.println(list.toString());
		
	}

	public static void main(String[] args) {
		new Test04();
	}
}
