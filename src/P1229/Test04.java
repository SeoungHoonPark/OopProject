/**
 * 
 */
package P1229;

import java.util.HashSet;
import java.util.Iterator;

public class Test04 {

	public Test04() {
		HashSet set = new HashSet();
		set.add(new Sagak04(5, 4));
		set.add(new Sagak04(7, 5));
		set.add(new Sagak04(4, 8));
		set.add(new Sagak04(2, 5));
		set.add(new Sagak04(4, 5));
		
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			Sagak04 temp = (Sagak04) iter.next();
			System.out.println(temp);
		}
	}

	public static void main(String[] args) {
		new Test04();
	}
}

class Sagak04 {
	int garo;
	int sero;
	int area;
	public Sagak04(){}
	public Sagak04(int g, int s){
		garo = g;
		sero = s;
		area = garo * sero;	
	}
	
	//�� Ŭ������ ����� �� ������ ����ϱ� ���� �Լ� �������̵��̴�.
	public String toString(){
		return "�̻簢���� ������ " +   area + "�Դϴ�.";
	}
	// �� Ŭ������ set�� ��涧
	// ������ �������� ���� Ŭ���������� �Ǵ��ұ�?
	//	1. equals�� true�� ��ȯ�ϰ� => ���� Ŭ������ �����ϰ�
	//	���� [������ ������ ���� Ŭ������ �����ϰ��� �Ѵ�.]
	// euqals()�� �������̵��ؼ� �ذ��Ѵ�.
	
	public boolean equals(Object obj){
		Sagak04 temp = (Sagak04) obj;
		if(temp.area == this.area){
			return true;			
		}else{
			return false;
		}
	}
	// 2. hashcode���� �����ؾ� �Ѵ�.
	//	hashcode�Լ��� �������̵��ؼ� ���� Ŭ�����̸� ���� hashcode���� ��ȯ�ϵ��� �ؾ��Ѵ�.
	
	public int hashCode(){
		return 1;
		// �� Ŭ������ �ؽ��ڵ尪�� �������ʹ� �׻� 1�� �ȴ�.
	}
}

