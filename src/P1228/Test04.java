/**
 * 
 */
package P1228;

import java.util.LinkedList;

/**
 *
 */
public class Test04 {

	public Test04() {
		LinkedList list = new LinkedList();
		list.add("�¿�");
		list.add("����");
		list.add("ȿ��");
		list.add("����ī");
		list.add("����");
		list.add("����");
		list.add("���");
		list.add("����");
		
		int size = list.size();
		
		for(int i = 0; i < size; i++){
			String sosi = (String) list.get(i);
			System.out.println(sosi);
		}		
	}

	public static void main(String[] args) {
		new Test04();
	}

}
