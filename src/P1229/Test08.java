package P1229;

import java.util.Iterator;
import java.util.TreeSet;

public class Test08 {
	public Test08() {
		TreeSet set = new TreeSet();
		set.add(new Sagak08(5,4));
		set.add(new Sagak08(5,8));
		set.add(new Sagak08(7,5));
		set.add(new Sagak08(5,6));
		set.add(new Sagak08(3,8));
		set.add(new Sagak08(8,7));
		set.add(new Sagak08(9,3));
		set.add(new Sagak08(1,2));
		set.add(new Sagak08(2,4));
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			Sagak08 temp = (Sagak08) iter.next();
		}
	}

	public static void main(String[] args) {
		new Test08();
	}
}

/**
 *		�簢�� Ŭ������ �����
 *		���� ����� ����ũ�� ������� �����ؼ� ����ϵ��� ����.
 *		���� ũ�Ⱑ ������ ���� ũ�� ������� �����ؼ� ����ϵ��� ����
 */
class Sagak08 implements Comparable{
	int garo;
	int sero;
	int area;
	
	public Sagak08() {
	}
	public Sagak08(int g, int s) {
	}
	
	public String toString() {
		
		return "�� Ŭ������ ���� " + garo + "�̸� ���δ�"  + sero ;
	}
	
	// �� Ŭ������ TreeSet�� ���Ǳ� ���ؼ���
	//	���� �������ݵ�� �˷��־�� �ϸ�, ���� ���ؼ��� compareTo()�� �������̵��Ͽ� �˷��־�� �Ѵ�
	
	@Override
	public int compareTo(Object o) {
		Sagak08 temp = (Sagak08) o;
		
		int imsi1 = this.garo - temp.garo;
		if(imsi1 == 0){
			int imsi2 = this.sero - temp.sero;
			return imsi2;
		}else{
			return imsi1;
		}
	}
	
}