package P0104;

/*
 * 	 문제
 * 		ArrayList를 하나 준비해서
 * 		이곳에 데이터를 넣고 빼고를 할 예정이다.
 * 		즉,		1번 스레드는 이곳에 데이터를 입력할 예정이고
 * 				2번 스레드는 이곳에 데이러를 가지고 갈 예정이다.
 * 
 * 		규칙	5개의 데이터가 입력되면 더이상 입력하면 안된다.
 */
import		java.util.*;
public class Test09 {
	ArrayList	list = new ArrayList();
	
	//	이 함수가 아까 비유한 창고에 물건을 쌓는 함수이다.
	synchronized void makeData(int num) {
		if(list.size() == 5) {
			//	이제는 절대로 일을 해서는 안된다.
			try {
				System.out.println("채우는 사람이 쉬러 갑니다.");
				wait();
				//	이순간에 이 함수를 사용하는 스레드는
				//	스스로가 Block상태로 전위된다.
			}
			catch(Exception e) {}
		}
		//	창고에 물건 하나를 넣었다.
		list.add(num);
		System.out.println(num + "을 채웠습니다.");
		System.out.println("채운 후 현재 창고는 " + list.size() + " 가 있습니다.");
		//	그러면 이제 물건을 가지고 가는 사람은 일을해도 되는 시점이
		//	되었다.
		notify();
		//	이렇게 하면 어떤 현상이 벌어지는가?
		//	가장 먼저 Block 상태로 들어간 스레드가 일어나서 
		//	일을 하게 된다.
		
	}
	//	이 함수는 아까 비유한 창고의 물건을 가지고 가는 함수이다.
	synchronized void	useData() {
		if(list.size() == 0) {
			//	이 스레드는 물건을 가지고 갈 수 없으므로
			//	스스로가 Block 상태로 전위되어야 한다.
			try {
				System.out.println("가지고 가는 사람이 쉬러 갑니다.");
				wait();
			}
			catch(Exception e) {}
		}
		int	num = (int) list.get(0);
		//	사용이 된 데이터를 List에서 제거한다.
		list.remove(0);
		System.out.println(num + "을 가지고 갔습니다.");
		System.out.println("가지고 간 후 현재 창고는 " + list.size() + " 가 있습니다.");
		//	그러면 list에는 최소한 공간 하나가 생긴다.
		//	이제 물건을 채워도 되므로 물건을 채우는 사람을 깨운다.
		notify();
	}
	
	public Test09() {
		Thread091	t1 = new Thread091(this);
		Thread092	t2 = new Thread092(this);
		
		t1.start();
		t2.start();
	}

	public static void main(String[] args) {
		new Test09();
	}

}

class Thread091 extends Thread {
	Test09	main;
	public Thread091(Test09 m) {
		main = m;
	}
	public void run() {
		for(int i = 0; i < 50; i++) {
			int	num = (int) (Math.random() * 101);
			main.makeData(num);
			int	sleep = (int)(Math.random() * (2000 - 500) + 500);
			try {
				Thread.sleep(sleep);
			}
			catch(Exception e) {}
		}
	}
}

class Thread092 extends Thread {
	Test09	main;
	public Thread092(Test09 m) {
		main = m;
	}

	public void run() {
		for(int i = 0; i < 50; i++) {
			main.useData();
			int	sleep = (int)(Math.random() * (2000 - 500) + 500);
			try {
				Thread.sleep(sleep);
			}
			catch(Exception e) {}
		}
	}
}