package P1227;

import java.util.Date;

/**
 * 	현재 컴퓨터의 날짜와 시간을 출력해보자.
 */
public class Test01 {

	public Test01() {
		
		Date d = new Date();
		
		// 년도. 월. 일. 요일. 시간. 분. 초를 출력하자.
		int year = d.getYear() + 1900; // 년도는 결과에 + 1900을 해야 정확한 년도가 나온다.
		
		int month = 	d.getMonth()+ 1;
		// 0이 1월을 의미하므로 결과에 1을 더해야 정확한 달이 나온다.
		int day = d.getDate();
		int week = d.getDay();
		String w = "";
		switch(week){
		case 0:
			w = "일";
			break;
		case 1:
			w = "월";
			break;
		case 2:
			w = "화";
			break;
		case 3:
			w = "수";
			break;
		case 4:
			w = "목";
			break;
		case 5:
			w = "금";
			break;
		case 6:
			w = "토";
			break;
		}
		int hour = d.getHours();
		int min = d.getMinutes();
		int sec = d.getSeconds();
		
		System.out.println(year + " 년 " + month + " 월 " + day + " 일 " + w + "요일 " + hour + "시" + min + "분"+ sec + "초");
	}
	
	public static void main(String[] args) {
		new Test01();
	}

}
