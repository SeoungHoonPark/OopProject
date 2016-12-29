/**
 * 
 */
package P1229;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *		이번에는 사용자가 만든 클래스를 TreeSet에 
 */
public class Test07 {

	public Test07() {
		TreeSet set = new TreeSet();
		set.add(new Sagak04(5,4));
		set.add(new Sagak04(7,8));
		set.add(new Sagak04(3,5));
		set.add(new Sagak04(6,6));
		set.add(new Sagak04(5,2));
		// TreeSet에 데이터가 담기면 내부적으로 특정 규칙을 가지고 정렬을 한다.
		// 문제는 사용자가 만든 클래스는 무엇을 기준으로 해서 정렬할지 jvm입장에선 모른다.
		// 그러므로 정렬하지 못하기 때문에 에러가 발생한다.
		
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
 * 	만약 여러분이 만든 클래스가 TreeSet에 저장되어야 할 경우에는 이 클래스가 어떤 기준에 의해서 정렬되어야 하는지를
 *  	반드시 알려주어야 하나다.
 *  
 *  	특정 클래스에 정렬 방식을 알려주는 방법
 *  	1. Comparable 인터페이스를 방속 받아서 제작한다.
 *  	2. 이 클래스 안에 compareTo()를 오버라이드 한다.
 *  		이 함수 안에서 정렬 기준을 정해주면 된다.
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
		// 그리고 이 함수 안에서 정렬 규칙을 지정한다.
		// 면적 순서로 정렬하기를 원할때
		// 정렬 방식을 정하는 규칙은 앞서 배운 규칙과 동일하다.
		SamGak07 temp = (SamGak07) o;
		
		int imsi = (int)(this.area - temp.area);
		
		return imsi;
	}
	
	
}
