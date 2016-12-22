/**
 * 
 */
package P1212;

/**
 * @author hong
 *
 */
public class Test02 {
	public static void main(String[] args) {
		Sam021 s = new Sam021(5.2f);
	}
}

class Sam021{
	Sam021(){
		System.out.println("¾ø´Â°Å");
	}
	Sam021(int a){
		System.out.println("1");		
	}
	Sam021(int a, int b){
		System.out.println("1, 2");
	}
	Sam021(float a){
		System.out.println("1.0f");
	}
}