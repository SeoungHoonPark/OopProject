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
			System.out.println("에러발생 ");
			return;
			
		}finally {
			System.out.println("파이날맅");
		}
		System.out.println("나는 일반 소스");
	}
	public Test06() {
		abc();
	}
	public static void main(String[] args) {
		new Test06();
	}
}
