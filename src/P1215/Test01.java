package P1215;

/**
 *
 */
public class Test01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Sam011 s = new Sam011();
		// 이 클래스는 저절로 오브젝트 라는 클래스가 가지고 있는
		// 모든 함수를 사용할 수 있다.
	}
}

//class Sam011{
//	
//	if(Object instanceof Object){
//		System.out.println("Object 소속이다.");
//	}else{
//		System.out.println("Object  아니다");
//	}
//}
// Grand is a Grand
// Grand is a Object
class Grand2{
}

// Father is a Father
// Father is a Grand
// Father is a Mother
// Father is a Object
class Father2 extends Grand2{
}

// Mom is a mother
class Mother2{
}

//class Son2{
//}