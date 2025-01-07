package day1217;

import java.util.Scanner;

public class Ex11ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String []member= {"장원영","안유진","김신","강호동","김태희","고민시","배두나"};
		String searchName;
		boolean find;

		/*
		 * 이름을 입력하면 몇번째 있는지 출력
		 * 없을 경우 "해당이름은 없습니다"
		 * 반복적으로 검색하다가 종료하고 싶으면 "종료"
		 */

		while(true)
		{
			find=false;
			System.out.print("검색할 이름은?(종료 희망 시 : 종료)");
			searchName=sc.nextLine();
			if(searchName.equals("종료"))
			{
				System.out.println("프로그램 종료");
				break;
			}

			for(int i=0;i<member.length;i++)
			{
				if(searchName.equals(member[i]))
				{
					find=true;
					System.out.println((i+1)+"번째에 있습니다");
					break;
				}
			}
		}
	}

}
