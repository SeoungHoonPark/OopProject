/**
 * 
 */
package P1229;

import java.util.TreeSet;

/**
 *
 */
public class Test09 {

	public Test09() {
		TreeSet set = new TreeSet();
		
		set.add("abc");
		set.add("alien");
		set.add("bat");
		set.add("car");
		set.add("Car");
		set.add("disc");
		set.add("dance");
		set.add("dZZZZ");
		set.add("dzzzzz");
		set.add("elephant");
		set.add("elevator");
		set.add("fan");
		set.add("flower");
		// �� �߿��� b�� �����ϴ� �����ͺ��� d�� �����ϴ� ������ ������ ������
		// ���ο� set�� ������� �Ѵٸ�
		
		TreeSet tempSet = (TreeSet) set.subSet("b","dzzz");
		//�̷��� �ϸ� �����Ϳ� b. d�� comparerTo�Ͽ� �� ����� ���� �̾Ƴ���.
		
		System.out.println(tempSet);
		
		
		
		
	}

	public static void main(String[] args) {
		new Test09();
	}
}
