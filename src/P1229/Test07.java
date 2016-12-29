/**
 * 
 */
package P1229;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *		�̹����� ����ڰ� ���� Ŭ������ TreeSet�� 
 */
public class Test07 {

	public Test07() {
		TreeSet set = new TreeSet();
		set.add(new Sagak04(5,4));
		set.add(new Sagak04(7,8));
		set.add(new Sagak04(3,5));
		set.add(new Sagak04(6,6));
		set.add(new Sagak04(5,2));
		// TreeSet�� �����Ͱ� ���� ���������� Ư�� ��Ģ�� ������ ������ �Ѵ�.
		// ������ ����ڰ� ���� Ŭ������ ������ �������� �ؼ� �������� jvm���忡�� �𸥴�.
		// �׷��Ƿ� �������� ���ϱ� ������ ������ �߻��Ѵ�.
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			SamGak07 temp = (SamGak07)iter.next();
			System.out.println(temp);
		}
	}

	public static void main(String[] args) {
		new Test07();
	}
}

/*
 * 	���� �������� ���� Ŭ������ TreeSet�� ����Ǿ�� �� ��쿡�� �� Ŭ������ � ���ؿ� ���ؼ� ���ĵǾ�� �ϴ�����
 *  	�ݵ�� �˷��־�� �ϳ���.
 *  
 *  	Ư�� Ŭ������ ���� ����� �˷��ִ� ���
 *  	1. Comparable �������̽��� ��� �޾Ƽ� �����Ѵ�.
 *  	2. �� Ŭ���� �ȿ� compareTo()�� �������̵� �Ѵ�.
 *  		�� �Լ� �ȿ��� ���� ������ �����ָ� �ȴ�.
 */

class SamGak07 implements Comparable {
	int width;
	int heigh;
	float area;
	
	public SamGak07() {}
	public SamGak07(int w, int h){
		this.width = w;
		this.heigh = h;
		
		this.area = (width * heigh) / 2.0f;
	}
	
	public String toString() {		
		return super.toString();
	}
	
	public int compareTo(Object o) {
		// �׸��� �� �Լ� �ȿ��� ���� ��Ģ�� �����Ѵ�.
		// ���� ������ �����ϱ⸦ ���Ҷ�
		// ���� ����� ���ϴ� ��Ģ�� �ռ� ��� ��Ģ�� �����ϴ�.
		SamGak07 temp = (SamGak07) o;
		
		int imsi = (int)(this.area - temp.area);
		
		return imsi;
	}
	
	
}
