/**
 * 
 */
package P1222;

/**
 * @author hong
 *
 */
public class Test08 {
	public Test08() {
		
		Runtime run = Runtime.getRuntime();
		long start = run.freeMemory();
		System.out.println("시작하기 전 메모리 = " + start);
		//String str = "";
		StringBuffer str = new StringBuffer();
		
		for(int i = 0; i < 100; i++){
			//str = str + i
			str.append(i);
		}
		long end = run.freeMemory();
		System.out.println("끝나기 전 메모리 = " + end);
	}

	public static void main(String[] args) {

	}
}
