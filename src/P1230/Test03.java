package P1230;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *		�л��� �̸��� �̿��ؼ� ������ �����ϴ� map�� ������		
 */
public class Test03 {

	public Test03() {
		HashMap map = new HashMap();
		map.put("ȫ�浿", new Student03("ȫ�浿", 65, 77, 45));
		map.put("��׷�", new Student03("��׷�", 65, 77, 45));
		map.put("�ȱ׷�", new Student03("�ȱ׷�", 65, 77, 45));
		map.put("�ֱ׷�", new Student03("�ֱ׷�", 65, 77, 45));
		map.put("��׷�", new Student03("��׷�", 65, 77, 45));
		
		Set set = map.keySet();
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			String name = (String) iter.next();
			//Ű���� �˸� �����͵� �� �� �� �ִ�.
			Student03 temp = (Student03) map.get(name);
			System.out.println(name +	" : " + temp.tot);
		}
	}

	public static void main(String[] args) {
		new Test03();
	}
}


 class Student03 {
	 String name;
	 int kor;
	 int eng;
	 int mat;
	 int tot;
	 
	public Student03() {
	}
	
	public Student03(String n, int k, int e, int m) {
		name = n;
		kor = k;
		eng = e;
		mat = m;
		tot = kor + eng + mat;
	}
	
 }
 