package P1227;

import java.util.Date;

/**
 * 	���� ��ǻ���� ��¥�� �ð��� ����غ���.
 */
public class Test01 {

	public Test01() {
		
		Date d = new Date();
		
		// �⵵. ��. ��. ����. �ð�. ��. �ʸ� �������.
		int year = d.getYear() + 1900; // �⵵�� ����� + 1900�� �ؾ� ��Ȯ�� �⵵�� ���´�.
		
		int month = 	d.getMonth()+ 1;
		// 0�� 1���� �ǹ��ϹǷ� ����� 1�� ���ؾ� ��Ȯ�� ���� ���´�.
		int day = d.getDate();
		int week = d.getDay();
		String w = "";
		switch(week){
		case 0:
			w = "��";
			break;
		case 1:
			w = "��";
			break;
		case 2:
			w = "ȭ";
			break;
		case 3:
			w = "��";
			break;
		case 4:
			w = "��";
			break;
		case 5:
			w = "��";
			break;
		case 6:
			w = "��";
			break;
		}
		int hour = d.getHours();
		int min = d.getMinutes();
		int sec = d.getSeconds();
		
		System.out.println(year + " �� " + month + " �� " + day + " �� " + w + "���� " + hour + "��" + min + "��"+ sec + "��");
	}
	
	public static void main(String[] args) {
		new Test01();
	}

}
