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
	HashMap groupMap = new HashMap();	// 전체 그룹을 관리하는 맵
	
	//새로운 그룹을 만드는 함수
	public void makeGroup(String name){
		//그룹의 이름을 알려주면 그 그룹을 만들어주는 함수.
		
		if (!groupMap.containsKey(name)){	// 지금 만들고자 하는 그룹이 존재하지 않나? 그러면 새롭게 만들어 주어야 한다.
			groupMap.put(name, new HashMap());
		}
	}
	
	
	//한사람만 꺼내는 함수를 만들어 보자
	public void getOnePerson(String group, String name){
		// 어떤 그룹에 누구를 꺼내달라고 하면...
		
		// 할 일
		// 		1. 꺼내야 하는 그룹맵을 알아내야 한다.
		HashMap tempMap = (HashMap) groupMap.get(group);
		// 		2. 그 맵에서 원하는 친구의 정보를 꺼낸다.
		String tel = (String) tempMap.get(name);
		
		System.out.println(name + " :: " + tel);
	}
	
	// 친구를 등록하느 함수
	public void setFriend(String group, String name, String tel){
		// 등록할 친구가 등록될 그룹과 친구이름, 전화번호를 알려주면 등록을 해 줄 함수.
		// 만약 등록할 그룹에 대한 맵이 없다면? 등록이 되지 않을 것이다. 그럼 만들고 시작해야 겠다.
		makeGroup(group);
		
		// 할 일
		//		1.		이 친구를 등록할 그룹의 해당하는 맵을 알아낸다.
		HashMap tempMap = (HashMap) groupMap.get(group);
		//		2. 	이 맵에 친구를 등록하면 된다.
		tempMap.put(name, tel);		
	}
	
	// 특정 그룹의 전체를 알아내는 함수
	
	public void getGroup(String group){
		// 할 일
		// 1. 	꺼낼 그룹의 맵을 알아낸다.
		HashMap tempMap = (HashMap) groupMap.get(group);
		
		Set set = tempMap.entrySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			Map.Entry temp = (Map.Entry)iter.next();
			System.out.println(temp.toString());
			String name = (String) temp.getKey();
			String tel = (String) temp.getValue();
//			System.out.println("이름 : " + name + " 전화번호 : " + tel);
		}
	}
	
	//숙제
	// 		모든 정보를 꺼낼 수 있는 함수를 제작하고 테스트 하세요.
	//		힌트 
	// 			할 일 	1. groupMap에 있는 모든 그룹맵을 알아낸다.
	//					2. 이것을 반복하면서 다시 해당 그룹맵의 내용을 알아낸다.
	public void getAll(){
		
	}
	public Test08() {
		// 이제 등록하는 함수는 만들어 졌으므로 친구들을 등록해보자.
		
		setFriend("친구", "하지원", "010-1111-1111");
		setFriend("친구", "하늘이", "010-8541-1111");
		setFriend("친구", "하송이", "010-1235-1111");
		setFriend("원수", "최순실", "010-2222-3333");
		setFriend("가족", "김기춘", "010-4444-4444");
		//나중에 좀더 배우면 데이터베이스에서 자료를 가지고 와서 입력할 수 있고
		//윈폼을 배우면 사용자가 입력한 데이터를 입력할 수도 있다.
		
//		getOnePerson("친구", "하지원");
//		getOnePerson("가족", "김기춘");
		
		getGroup("친구");
		
	}
	
	public static void main(String[] args) {
		new Test08();
	}
}
