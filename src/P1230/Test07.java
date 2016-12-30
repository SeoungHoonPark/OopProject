/**
 * 
 */
package P1230;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author hong
 *
 */
public class Test07 {
	public Test07() {
		
		TreeMap  map = new TreeMap();
//		map.put(new Sagak07(4,5), "ȫ�浿");
//		map.put(new Sagak07(7,6), "�ھ���");
		// ����
		
		map.put("ȫ�浿", new Sagak07(7,6));
		map.put("�ھ���", new Sagak07(7,8));
		// ������ �����Ϳ��� ���ı����� ���� Ŭ������ ����� �� �ִ�.
		// ���
		// 		TreeMap�� Ű���� �̿��ؼ� �����ؼ� ó���ϴ� �÷����̴�.
		
		Set set = map.entrySet();
		Iterator iter = set.iterator();
		
		while(iter.hasNext()){
			Map.Entry temp = (Map.Entry) iter.next();
			Sagak07 name = (Sagak07) temp.getKey();
			int age = (int) temp.getValue();
			System.out.println(name + "  :  " + age);
		}
	}

	public static void main(String[] args) {
		new Test07();
	}
}

class Sagak07{
	int width;
	int heigth;
	int area;
	
	public Sagak07(){}
	public Sagak07(int w, int h){
		width = w;
		heigth = h;
		area = width * heigth;
	}
}