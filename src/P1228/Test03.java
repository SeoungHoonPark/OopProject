
package P1228;

import java.util.ArrayList;

public class Test03 {

	public Test03() {
			ArrayList list = new ArrayList();
			list.add("홍길동");
			list.add(24);
			list.add("박아지");
			list.add("홍길동");	// 같은 데이터가 들어가도 상관없고
			list.add(3.14f);
			
			int size = list.size();
			
			System.out.println("개수 = " + size);
			// 물론 컬렉션의 특징은 여러형태의 데이터를 동시에 보관 할 수 있다는 것이다.
			// 하지만 실무에서는 이렇게 하는 경우는 거의 없고
			// 배열과 동일하게 될 수 있으면 한가지 종류만 입력해 놓는것이 원칙이다.
			
			for(int i = 0; i < size; i++){
				Object o = list.get(i);
				// 어떤 형태인지 모르므로 Object로 꺼내야 한다.
				if ( o instanceof String){
					String temp = (String) o;
					System.out.println(temp);
				}else if (o instanceof Integer){
					int temp = (int) o;
					System.out.println(temp);
				}else if (o instanceof Integer){
					float temp = (float) o;
					System.out.println(temp);
				}
			}
			// 위와 같이 형변환 시점에서 질문하여 변환해야 하기 때문에 불편하다.
			
			
			
			
	}

	public static void main(String[] args) {

	}
}
