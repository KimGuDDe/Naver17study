package day1217;

import java.util.Scanner;

public class Ex12ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String []member= {"장원영","안유진","김신","강호동","김태희","고민시","배두나"};
		String searchName;
		boolean find;
		int count;
		
		/*
		 * 검색할 성씨는? 이
		 * 이지혜
		 * 총 1명 검색
		 * 
		 * 검색할 성씨는? 강
		 * 강호동
		 * 강리나
		 * 총 2명 검색
		 * 
		 * 검색할 성씨는? 홍
		 * "홍"씨 성을 가진 사람은 없습니다
		 * =>대소문자 상관없이 Exit 입력 시 종료
		 * 
		 */
		
		while(true)
		{
			count=0;
			System.out.println("검색할 성씨는?(종료 시 : Exit)");
			searchName=sc.nextLine();	
			
			if(searchName.equalsIgnoreCase("exit"))
			{
				System.out.println("프로그램 종료");
				break;
			}
			
			for(int i=0; i<member.length;i++)
			{
				if(member[i].startsWith(searchName))
				{
					count ++;
					System.out.println(i+":"+member[i]);
				}
				
			}
			
			if(count==0)
				System.out.println("\""+searchName+"\"씨성을 가진 사람은 없습니다");
			else
				System.out.println("총"+count+"명 검색");
		}
		
		
	}

}
