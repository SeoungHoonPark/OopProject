/**
 * 
 */
package P0102;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author hong
 *
 */
public class Test06 {

	public Test06() {
		HashSet<String> set = new HashSet<String>();
		
		set.add("�¿�");
		set.add("����");
		set.add("��ȿ");
		set.add("����ī�����");
		set.add("Ƽ�ĴϿ��� ��ħ��");
		set.add("����");
		set.add("�����忡��");
		
		Iterator<String> iter = set.iterator();
		
		while(iter.hasNext()){
			String name = iter.next();
			System.out.println(name);
		}
	}

	public static void main(String[] args) {

	}
}
