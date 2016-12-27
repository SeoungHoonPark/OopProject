package P1227;

import java.text.MessageFormat;

/**
 *
 */
public class Test08 {
	public Test08() {
		String sql = "insert into emp values(1234, '�ھ���', '������', 2000)";
		/*
		 *  ����
		 *  	���� ���߿��� ������ �κи� ���� ������ �ʹٸ�?
		 */
		MessageFormat f = new MessageFormat("insert into emp values({0},{1},{2},{3})");
		
		Object[] result = null;
		
		try{
			result = f.parse(sql);
			for(int i = 0; i < result.length; i++){
				System.out.println(result[i]);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		new Test08();
	}
}
