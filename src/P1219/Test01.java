/**
 * 
 */
package P1219;

/**
 *	 	�����ϰ� ���ڸ� �߻��Ͽ�
 * 	�� ���ڰ� ¦���̸� �ﰢ���� ó���ϰ�
 * 	�� ���ڰ� Ȧ���̸� �簢���� ó���϶�.
 */
public class Test01 {
	public static void main(String[] args) {
		
		int num = (int)(Math.random() * 101);
		
		Father01 f = null;
		
		if(num % 2 == 0){
			f = new SamGak01();
		}else{
			f = new SaGak01();
		}
		
		if(num % 2 == 0){
			f.display();
		}else{
			f.display();
		}
	}
}

// ���õ� Ŭ������ ��ǥ�ϴ� ���� Ŭ������ ����� ����� ����ߴ�.
// 
class Father01 {
	void display(){
		System.out.println("���� �ƹ����̴�.");
	}
}

// �� Ŭ������ �ﰢ���� ó���ϱ� ���� Ŭ�����̴�
class SamGak01 extends Father01{
	void display(){
		System.out.println("���� �ﰢ���̴�");
	}
}
// �� Ŭ������ �簢���� ó���ϱ� ���� Ŭ�����̴�.
class SaGak01 extends Father01{
	void display(){
		System.out.println("���� �簢���̴�");
	}
}
