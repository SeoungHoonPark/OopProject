package P1219;

/**
 * 문제 5개의 클래스를 하나의 배열로 관리하세요.
 */
public class Test06 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Object[] o = new Object[5];
			
			o[0] = new Son061();
			o[1] = new Son062();
			o[2] = new Son063();
			o[3] = new Son064();
			o[4] = new Son065();
			
			//오브젝트는 모든 클래스의 최상위 클래스이므로
			//오브젝트 배열을 이용해서 ...
			// 결론 
			//	각각의 다른 클래스를 같은 배열로 관리하려면
			// 배열 변수를 상위 클래스로 형 변환한다.
	}
}

class Son061{
	
}
class Son062{
	
}
class Son063{
	
}
class Son064{
	
}
class Son065{
	
}


