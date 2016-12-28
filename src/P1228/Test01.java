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
		System.out.println("처음 공간= " + len);
		
		for(int i = 0; i < 11; i++){
			// 데이터를 11개 입력한다.
			v.add(i);
		}
		
		len = v.capacity();
		System.out.println("나중 공간= " + len);
	}
	public static void main(String[] args) {
		new Test01();
	}
}
