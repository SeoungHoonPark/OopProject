/**
 * 
 */
package P1212;

/**
 * @author hong
 *
 */
public class Test04 {
	public static void main(String[] args) {
		Sam041 s= new Sam041();
	}
}

class Sam041{
	Sam041(){
//		int a = 5; 앞쪽에 다른 문장이 나오면 에러가 발생
		this(5);
		System.out.println("디폴트");
	}
	
	Sam041(int a){
		System.out.println("한개");
	}
	
	void abc(){
		//일반 함수에서는 사용 할 수 없다
		// this(5);			에러
	}
}