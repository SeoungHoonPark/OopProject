/**
 * 
 */
package P0105;

import GUI.MyJFrame;

/**
 *	Frame �ϳ��� ���� ȭ�鿡 ����� ����.
 */
public class Swing01 {

	public Swing01() {
		/* ��ü���⿡�� Ŭ������ ����ϴ� ���
		 1. new ���Ѽ� ����ϴ� ���
			has a
			���� 	������ ����� �� �ְ� �ٸ� Ŭ������ ���� ����� �� �ִ�.
			*/
		MyJFrame frame = new MyJFrame("���� ���� ù��° ���α׷�");
		//�ʿ��� ����� �̿��ؼ� ó���ϸ� �ȴ�.
		// ���� ��ȭ������ ũ�⸦ ���ϰ� �ʹ�.
		frame.setSize(400,400);
		// �ʿ��� �������� ȭ�鿡 ��Ÿ���� �ϰ� �ʹ�.
		frame.setVisible(true);
		/*
			2. ��� �޾Ƽ� ����ϴ� ���
			is a
			���� 	�̹� new�� �� �����̹Ƿ� �״�� ����ϸ� �ȴ�.
		*/
	}
	
	public static void main(String[] args) {
		new Swing01();
		}
}
