package P0116;

/*
 * 	����
 * 		�ø� �Ѽ� ���Ͽ� �����غ���.
 */
import		java.io.*;
public class PrintStreamTest01 {
	public PrintStreamTest01() {
		PrintStream		ps = null;
		try {
			ps = new PrintStream("D:\\��.txt");
			//	���� ���Ͽ� ����� ��Ʈ���� ����� ������Ʈ���̴�.
			ps.println("���޷���");
			ps.println("��ҿ�");
			ps.println();
			ps.println("�����Ⱑ ���ܿ� ���Ƕ�����");
			ps.println("������ ���� �����帮�츮��");
			ps.println();
			ps.println("������ ��� ���޷���");
			ps.println("���Ǳ濡 �Ƹ����� �Ѹ��츮��.");
			ps.println();
			ps.println("���ô� �������� ���� �ײ���");
			ps.println("����� ������ ���ÿɼҼ�");
			ps.println();
			ps.println("������ ���ܿ� ���Ƕ�����");
			ps.println("�׾ �ƴϴ��� �긮�츮��.");
			
			ps.flush();
			//	����������  Buffer�� ����� ������ �����Ƿ�
			//	�ݵ�� �����Ⱑ �������� ���۸� ����� �Ѵ�.
		}
		catch(Exception e) {
			System.out.println("���� = " +  e);
		}
		finally {
			try {
				ps.close();
				//	close() ��� �ȿ��� ����������  flush 
				//	����� �����ϰ� �ִ�.
				//	close() �� ������ �ڵ� flush()�� �ȴ�.
			}
			catch(Exception e) {}
		}
	}
	public static void main(String[] args) {
		new PrintStreamTest01();
	}
}
