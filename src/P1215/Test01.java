package P1215;

/**
 *
 */
public class Test01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Sam011 s = new Sam011();
		// �� Ŭ������ ������ ������Ʈ ��� Ŭ������ ������ �ִ�
		// ��� �Լ��� ����� �� �ִ�.
	}
}

//class Sam011{
//	
//	if(Object instanceof Object){
//		System.out.println("Object �Ҽ��̴�.");
//	}else{
//		System.out.println("Object  �ƴϴ�");
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