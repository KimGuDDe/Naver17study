package day1212;

import java.util.Date;
import java.util.Scanner;

public class Ex11Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		/*
		 * 년(year),월(month),일(day)를 입력 후
		 * 해당 날짜에 대한 Date 클래스를 생성 후(myDate)
		 * myDate를 이용해서 년도, 월 , 일, 요일을 구해서 출력하시오
		 * 요일은 요일숫자를 먼저 얻은 후요 요일(weekNum)을 구해서 출력할 것.
		 * 
		 */
		
		Date dt=new Date();
		int curYear=dt.getYear()+1900;
		int curMonth=dt.getMonth()+1;
		int curDate=dt.getDate();
		
		System.out.println("오늘의 년도를 입력");
		curYear=sc.nextInt();
		System.out.println("오늘의 달을 입력");
		curMonth=sc.nextInt();
		System.out.println("오늘의 일자를 입력");
		curDate=sc.nextInt();
		int weekNum = dt.getDay();
		System.out.println(weekNum);
		System.out.println(curDate==6?'토':curDate==5?'금':curDate==4?'목':curDate==3?'수':curDate==2?'화':
			curDate==1?'월':'일');
		
		System.out.println("연도 :"+curYear+"년");
		System.out.println("월 :"+curMonth+"월");
		System.out.println("일 :"+curDate+"일");
		System.out.println("요일 :"+weekNum+"요일");
		
		
	}

}
