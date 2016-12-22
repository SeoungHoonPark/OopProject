package P1222;

/**
 *
 */
public class Test05 {
	
	public void setAge(int a ) throws AgeException {
		// 나이가 음수로 입력되면 더이상 진행할 필요가 없다고 가정한다
		System.out.println("함수시작");
		if(a < 0){
			throw new AgeException();
		}
		System.out.println();
	}
	public Test05() {
		try {
		setAge(-100);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Test05();
	}
}
