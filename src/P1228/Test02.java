package P1228;

import java.util.Calendar;
import java.util.Vector;

/**
 *	����
 *		�پ��� ������ �����͸� ���Ϳ� �Է��� �� ��������
 */
public class Test02 {
	public Test02() {
		Vector v = new Vector();
		
		v.add("ȫ�浿");
		v.add(10);
		v.add(Calendar.getInstance());
		v.add(3.14f);
		v.add(false);
		// �÷��� �ȿ��� ��� �����͸� ���ÿ� ���� �� �� �ִ�.
		
		String name = (String)v.get(0);
		
		for(int i = 0; i < v.size(); i++){
			System.out.println(v.get(i));
		}
		
	}

	public static void main(String[] args) {
		new Test02();
	}
}
