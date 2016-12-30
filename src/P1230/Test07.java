/**
 * 
 */
package P1230;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author hong
 *
 */
public class Test07 {
	public Test07() {
		
		TreeMap  map = new TreeMap();
//		map.put(new Sagak07(4,5), "홍길동");
//		map.put(new Sagak07(7,6), "박아지");
		// 에러
		
		map.put("홍길동", new Sagak07(7,6));
		map.put("박아지", new Sagak07(7,8));
		// 하지만 데이터에는 정렬기준이 없는 클래스도 사용할 수 있다.
		// 결론
		// 		TreeMap은 키값을 이용해서 정렬해서 처리하는 컬렉션이다.
		
		Set set = map.entrySet();
		Iterator iter = set.iterator();
		
		while(iter.hasNext()){
			Map.Entry temp = (Map.Entry) iter.next();
			Sagak07 name = (Sagak07) temp.getKey();
			int age = (int) temp.getValue();
			System.out.println(name + "  :  " + age);
		}
	}

	public static void main(String[] args) {
		new Test07();
	}
}

class Sagak07{
	int width;
	int heigth;
	int area;
	
	public Sagak07(){}
	public Sagak07(int w, int h){
		width = w;
		heigth = h;
		area = width * heigth;
	}
}