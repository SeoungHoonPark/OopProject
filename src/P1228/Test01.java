package P1228;

import java.util.Vector;

/**
 * @author hong
 *
 */
public class Test01 {

	public Test01() {
		Vector v = new Vector(10,5);
		int len = v.capacity();
		System.out.println("ó�� ����= " + len);
		
		for(int i = 0; i < 11; i++){
			// �����͸� 11�� �Է��Ѵ�.
			v.add(i);
		}
		
		len = v.capacity();
		System.out.println("���� ����= " + len);
	}
	public static void main(String[] args) {
		new Test01();
	}
}
