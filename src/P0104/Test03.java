/**
 * 
 */
package P0104;

/**
 *
 */
public class Test03 {
	Test031 downT;
	
	public Test03() {
		downT = new Test031(this);
	}

	public static void main(String[] args) {
		new Test03();
	}
}

class Test031{
	Test03 upT;
	public Test031(Test03 temp) {
		upT = temp;
	}
	public void Test031(){
	}
}