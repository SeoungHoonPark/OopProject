/**
 * 
 */
package P1229;

import java.util.HashSet;
import java.util.Random;

/**
 *
 */
public class Test02 {

	
	public Test02() {
		HashSet	set = new HashSet();
		Random rnd = new Random();
		while (true){
			int num = rnd.nextInt((45-1+1) + 1);
			
			set.add(num);
			
			if(set.size() == 6){
				break;
			}
		}
		System.out.println(set);
	}

	public static void main(String[] args) {
		new Test02();
	}
}
