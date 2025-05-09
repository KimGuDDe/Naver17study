package day1212;

import java.util.Date;

public class Ex6Date {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//현재 날짜와 시간을 알아보자
		//Date 클래스는 jdk1.1 이후에 deprecate됨. Canlendar를 권장
		
		Date today = new Date();
		
		int curYear=today.getYear()+1900;//그어진 명령어 deprecated 되었음을 의미
		int curMonth=today.getMonth()+1;//0-11을 반환하므로 +1 필수
		int curDate=today.getDate();
		
		System.out.println("현재년도:"+curYear);
		System.out.println("현재월:"+curMonth);
		System.out.println("현재일:"+curDate);
		
		System.out.println(today.getHours()+"시"+today.getMinutes()+"분");
		
		//요일 숫자 구하기(0~6 : 일 ~ 토)

		int weekday=today.getDay();
		System.out.println(weekday);
		
		//오늘은 목요일입니다
		System.out.println("오늘은"+(weekday==6?"토":weekday==5?"금":weekday==4?"목":weekday==3?"수"
				:weekday==2?"화":weekday==1?"월":"일")+"요일입니다!");
		
		
		
	}

}
