package P1220;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 
 */
public class Test02 {
	public static void main(String[] args) {
		
		File file = new File("D:\\");
		String [] list = file.list(new MyFilter());
		for(String temp :list){
			System.out.println("���� ��� = " + temp);
		}
	}
}

class MyFilter implements FilenameFilter {
	public boolean accept(File dir, String name) {
		//System.out.println("�� ����ȿ�");
		// �����̸��� j�� �����ϴ� �͸� ����ϰ� �ʹ�.
		if(name.startsWith("J")){
			return true;
		}else{
			return false;
		}
	}
}
