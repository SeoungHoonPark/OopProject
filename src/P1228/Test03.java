
package P1228;

import java.util.ArrayList;

public class Test03 {

	public Test03() {
			ArrayList list = new ArrayList();
			list.add("ȫ�浿");
			list.add(24);
			list.add("�ھ���");
			list.add("ȫ�浿");	// ���� �����Ͱ� ���� �������
			list.add(3.14f);
			
			int size = list.size();
			
			System.out.println("���� = " + size);
			// ���� �÷����� Ư¡�� ���������� �����͸� ���ÿ� ���� �� �� �ִٴ� ���̴�.
			// ������ �ǹ������� �̷��� �ϴ� ���� ���� ����
			// �迭�� �����ϰ� �� �� ������ �Ѱ��� ������ �Է��� ���°��� ��Ģ�̴�.
			
			for(int i = 0; i < size; i++){
				Object o = list.get(i);
				// � �������� �𸣹Ƿ� Object�� ������ �Ѵ�.
				if ( o instanceof String){
					String temp = (String) o;
					System.out.println(temp);
				}else if (o instanceof Integer){
					int temp = (int) o;
					System.out.println(temp);
				}else if (o instanceof Integer){
					float temp = (float) o;
					System.out.println(temp);
				}
			}
			// ���� ���� ����ȯ �������� �����Ͽ� ��ȯ�ؾ� �ϱ� ������ �����ϴ�.
			
			
			
			
	}

	public static void main(String[] args) {

	}
}
