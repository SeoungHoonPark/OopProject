/**
 * 
 */
package P1221;

/**
 * @author hong
 *
 */
public class Test06 {
	void abc(){
		int a = 5;
		int b = 25;
		int c = 0;
		try{
			c= b / a;
		}catch(Exception e ){
			System.out.println("�����߻� ");
			return;
			
		}finally {
			System.out.println("���̳���");
		}
		System.out.println("���� �Ϲ� �ҽ�");
	}
	public Test06() {
		abc();
	}
	public static void main(String[] args) {
		new Test06();
	}
}
