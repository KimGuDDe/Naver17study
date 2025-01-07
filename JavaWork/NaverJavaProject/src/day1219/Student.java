package day1219;

import java.util.Calendar;

public class Student {
	private String stuName;
	private String stuAddress;
	private String stuBlood;
	private int stuBirthYear;
	private int stuScore;
	
	//source 메뉴에서 getter & setter에서 생성
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	public int getStuBirthYear() {
		return stuBirthYear;
	}
	public void setStuBirthYear(int stuBirthYear) {
		this.stuBirthYear = stuBirthYear;
	}
	
	//stuBlood 에 대한 setter&getter
	public String getStuBlood()
	{
		return stuBlood;
	}
	public void setStuBlood(String stuBlood)
	{
		this.stuBlood = stuBlood;
	}
		
	//stuName 에 대한 setter&getter
	public String getstuName()
	{
		return stuName;
	}
	public void setStuName(String stuName)
	{
		this.stuName=stuName;
	}
	
	//stuScore 에 대한 setter&getter
	public int getStuScore()
	{
		return stuScore;
	}
	public void setStuScore(int stuScore)
	{
		this.stuScore=stuScore;
	}
	
	//한꺼번에 변경할 경우
	public void changeStudent(String stuName,String stuAddress,String sutBlood)
	{
		this.setStuName(stuName);
		this.setStuAddress(stuAddress);
		this.setStuBlood(sutBlood);
	}
	
	//stuScore 에 대한 절대평가(A-F) 반환하는 메서드
	public char getScoreGrade()
	{
		char grade=switch(stuScore/10)
				{
					case 10,9 -> 'A';
					case 8 -> 'B';
					case 7 -> 'C';
					case 6 -> 'D';
					default -> 'F';
					
				};
		return grade;
				
	}
	
	//stuBirthYear 로 나이를 구해서 반환
	public int getAge()
	{
		//현재년도
		//Calender 이용해서 현재 년도를 구해보자(protected)
		Calendar cal=Calendar.getInstance();
		int curYear=cal.get(Calendar.YEAR);
		
		return curYear-stuBirthYear;
	}
}
