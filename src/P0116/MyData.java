package P0116;

import java.io.Serializable;

/**
 * �� ����ȭ�� �Ǳ� ���ؼ��� �ش� Ŭ������ �ݵ�� ����ȭ ���� Ŭ������ �Ǿ�� �ϰ� �� �����
 *   implements Serializable �� ���ָ� �ȴ�.
 *	����ȭ �� ���� ������ Ŭ���� 
 */
public class MyData implements Serializable {
	String name;
	int age;
	float height;
	boolean gender;
	String tel;
	String addr;
	// ���Ŀ� ���� �Լ��� ��¥�� ��µ��� ���ϹǷ� �����Ѵ�
}
