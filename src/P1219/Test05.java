/**
 * 
 */
package P1219;

/**
 *
 */
public class Test05 {
	public static void main(String[] args) {
		Father05 f = new Son05();
		
		System.out.println(f.a); // 100
		// �� ��쿡�� ���۷����� ������ �̿��ϰ� �ȴ�.
		// �׷��Ƿ� ���۷����� ������ �������� ������ ������ �߻��Ѵ�.
		
		Son05  s = new Son05();
		System.out.println(s.a); // 200
		
		Father05 f2 = new Son05();
		f2.abc();
	}
}

class Father05{
	int a = 100;
	void abc(){
		System.out.println("A = " + a);
	}
}
class Son05 extends Father05{
	int a = 200;
	void abc(){
		System.out.println("A = " + a);
	}	
}