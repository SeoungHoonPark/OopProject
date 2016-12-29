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
 *		사각형 클래스를 만들고
 *		정렬 방식을 가로크기 순서대로 정렬해서 출력하도록 하자.
 *		가로 크기가 같으면 세로 크기 순서대로 정렬해서 출력하도록 하자
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
		
		return "이 클래스는 가로 " + garo + "이면 세로는"  + sero ;
	}
	
	// 이 클래스가 TreeSet에 기억되기 위해서는
	//	정렬 기준을반드시 알려주어야 하며, 러기 위해서는 compareTo()를 오버라이드하여 알려주어야 한다
	
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