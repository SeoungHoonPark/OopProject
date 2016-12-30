package P1230;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *		�̸��� ���̸� map���� ������ �� �̰��� ���̼������ �����Ͽ� ����ϼ���. 
 */
public class Test05 {
	public Test05() {
		HashMap map = new HashMap();
		map.put("������", 26);
		map.put("���ϴ�", 28);
		map.put("����ȿ", 22);
		map.put("������", 22);
		map.put("������", 26);
		
		//Ű ���� �����͸� ���ÿ� ����ϱ� ���ؼ� set���� ���� ����ϵ��� �غ��ڴ�.
		
		Set set = map.entrySet();
		ArrayList list = new ArrayList(set);
		Collections.sort(list, new MySort05());
		//����Ʈ�ȿ� �ִ� �����ʹ� Map.Entry�� �ְ� �� �ȿ��� ������ 2���� �����Ƿ�
		// ������ �������� �ؼ� �������� �𸥴�.
		
		Iterator iter = set.iterator();
		
		while(iter.hasNext()){
			Map.Entry temp = (Map.Entry)iter.next();
			String name = (String)	temp.getKey();
			int age = (int)	temp.getValue();
			
			System.out.println(name + " : " + age);
		}
	}

	public static void main(String[] args) {
		new Test05();
	}
}

class MySort05 implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// ���� ������ ���弼��.
		// o1�� 02�� ������ ���ñ�?
		
		Map.Entry temp1 = (Map.Entry)o1;
		Map.Entry temp2 = (Map.Entry)o2;
		
		int age1 = (int)temp1.getValue();
		int age2 = (int)temp2.getValue();
		return age1 - age2;
	}
	
}
