/**
 * 
 */
package P0102;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 
 */
public class Test05 {

	public Test05() {
		HashSet<String> set = new HashSet<String>();
		
		set.add("�¿�");
		set.add("����");
		set.add("��ȿ");
		set.add("����ī�����");
		set.add("Ƽ�ĴϿ��� ��ħ��");
		set.add("����");
		set.add("�����忡��");
		
		ArrayList<String> list = new ArrayList<String>(set);
		
		Collections.sort(list);
		int size = list.size();
		
		for(int i = 0; i < size; i++){
			String name = list.get(i);
			
			System.out.println(name);
		}
		
	}

	public static void main(String[] args) {
		new Test05();
	}

}
