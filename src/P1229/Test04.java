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
	
	//이 클래스를 출력할 때 정보를 출력하기 위한 함수 오버라이딩이다.
	public String toString(){
		return "이사각형의 면적은 " +   area + "입니다.";
	}
	// 이 클래스가 set에 담길때
	// 무엇을 기준으로 같이 클래스인지를 판단할까?
	//	1. equals가 true를 반환하고 => 같은 클래스로 판정하고
	//	문자 [면적이 같으면 같은 클래스로 판정하고자 한다.]
	// euqals()를 오버라이드해서 해결한다.
	
	public boolean equals(Object obj){
		Sagak04 temp = (Sagak04) obj;
		if(temp.area == this.area){
			return true;			
		}else{
			return false;
		}
	}
	// 2. hashcode값이 동일해야 한다.
	//	hashcode함수를 오버라이드해서 같은 클래스이면 같은 hashcode값을 반환하도록 해야한다.
	
	public int hashCode(){
		return 1;
		// 잌 클래스의 해쉬코드값은 이제부터는 항상 1이 된다.
	}
}

