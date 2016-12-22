package P1212;

/**
 */
public class Test06 {
	static int calcSum (int ... num){
		int sum = 0;
		for(int temp : num){
			sum = sum + temp;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int total = calcSum(5,5);
		
		System.out.println(total);
	}
}
