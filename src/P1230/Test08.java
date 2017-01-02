/**
 * 
 */
package P1230;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 */
public class Test08 {
	HashMap groupMap = new HashMap();	// ��ü �׷��� �����ϴ� ��
	
	//���ο� �׷��� ����� �Լ�
	public void makeGroup(String name){
		//�׷��� �̸��� �˷��ָ� �� �׷��� ������ִ� �Լ�.
		
		if (!groupMap.containsKey(name)){	// ���� ������� �ϴ� �׷��� �������� �ʳ�? �׷��� ���Ӱ� ����� �־�� �Ѵ�.
			groupMap.put(name, new HashMap());
		}
	}
	
	
	//�ѻ���� ������ �Լ��� ����� ����
	public void getOnePerson(String group, String name){
		// � �׷쿡 ������ �����޶�� �ϸ�...
		
		// �� ��
		// 		1. ������ �ϴ� �׷���� �˾Ƴ��� �Ѵ�.
		HashMap tempMap = (HashMap) groupMap.get(group);
		// 		2. �� �ʿ��� ���ϴ� ģ���� ������ ������.
		String tel = (String) tempMap.get(name);
		
		System.out.println(name + " :: " + tel);
	}
	
	// ģ���� ����ϴ� �Լ�
	public void setFriend(String group, String name, String tel){
		// ����� ģ���� ��ϵ� �׷�� ģ���̸�, ��ȭ��ȣ�� �˷��ָ� ����� �� �� �Լ�.
		// ���� ����� �׷쿡 ���� ���� ���ٸ�? ����� ���� ���� ���̴�. �׷� ����� �����ؾ� �ڴ�.
		makeGroup(group);
		
		// �� ��
		//		1.		�� ģ���� ����� �׷��� �ش��ϴ� ���� �˾Ƴ���.
		HashMap tempMap = (HashMap) groupMap.get(group);
		//		2. 	�� �ʿ� ģ���� ����ϸ� �ȴ�.
		tempMap.put(name, tel);		
	}
	
	// Ư�� �׷��� ��ü�� �˾Ƴ��� �Լ�
	
	public void getGroup(String group){
		// �� ��
		// 1. 	���� �׷��� ���� �˾Ƴ���.
		HashMap tempMap = (HashMap) groupMap.get(group);
		
		Set set = tempMap.entrySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			Map.Entry temp = (Map.Entry)iter.next();
			System.out.println(temp.toString());
			String name = (String) temp.getKey();
			String tel = (String) temp.getValue();
//			System.out.println("�̸� : " + name + " ��ȭ��ȣ : " + tel);
		}
	}
	
	//����
	// 		��� ������ ���� �� �ִ� �Լ��� �����ϰ� �׽�Ʈ �ϼ���.
	//		��Ʈ 
	// 			�� �� 	1. groupMap�� �ִ� ��� �׷���� �˾Ƴ���.
	//					2. �̰��� �ݺ��ϸ鼭 �ٽ� �ش� �׷���� ������ �˾Ƴ���.
	public void getAll(){
		
	}
	public Test08() {
		// ���� ����ϴ� �Լ��� ����� �����Ƿ� ģ������ ����غ���.
		
		setFriend("ģ��", "������", "010-1111-1111");
		setFriend("ģ��", "�ϴ���", "010-8541-1111");
		setFriend("ģ��", "�ϼ���", "010-1235-1111");
		setFriend("����", "�ּ���", "010-2222-3333");
		setFriend("����", "�����", "010-4444-4444");
		//���߿� ���� ���� �����ͺ��̽����� �ڷḦ ������ �ͼ� �Է��� �� �ְ�
		//������ ���� ����ڰ� �Է��� �����͸� �Է��� ���� �ִ�.
		
//		getOnePerson("ģ��", "������");
//		getOnePerson("����", "�����");
		
		getGroup("ģ��");
		
	}
	
	public static void main(String[] args) {
		new Test08();
	}
}
