package day1212;

import java.util.Date;
import java.util.Scanner;

public class Ex11ExamAnswer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		Date today = new Date();
		
		int year,month,day,weekNum;
		String week;
		Date myDate;
		System.out.println("년도 입력");
		year=sc.nextInt();
		System.out.println("월 입력");
		month=sc.nextInt();
		System.out.println("일 입력");
		day=sc.nextInt();
		
		myDate=new Date(year-1900,month-1, day);
		
		weekNum=myDate.getDay();
		
		System.out.println("년도 :"+(myDate.getYear()+1900));
		System.out.println("월 :"+(myDate.getMonth()+1));
		System.out.println("일 : "+myDate.getDate());
		System.out.println(weekNum==6?'토':weekNum==5?'금':weekNum==4?'목':weekNum==3?'수':weekNum==2?'화':
			weekNum==1?'월':'일');
		
		
	}

}