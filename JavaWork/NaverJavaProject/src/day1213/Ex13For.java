package day1213;

import java.util.Scanner;

public class Ex13For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제 2
		 * 
		 * 5명의 나이를 입력 후
		 * 40세 이상과 48세 미만이 각각 몇명인지 출력하고
		 * 평균 나이도 같이 출력하시오
		 * (for 문 사용)
		 * 
		 * 
		 */
		
		Scanner sc=new Scanner(System.in);
		int count1=0, count2=0, sum=0, age;
		double avg;
		
		for(int i=1;i<=5;i++)
		{
			System.out.println("나이 입력");
			age=sc.nextInt();
			//0~100세 벗어나는 경우는 제외
			//ㄴcontinue를 사용한다
			if(age<0 || age>=100)
			{
				System.out.println("다시 입력하세요");
				i--;
				continue;
			}
		
			sum+=age;
			if(age>=48)
				count1++;
			else
				count2++;
		}
		avg=(double)sum/5;
		
		System.out.println("40세 이상 인원 수 :"+ count1);
		System.out.println("40세 미만 인원 수 :"+ count2);
		System.out.println("평균 나이 :"+ avg);
		
		
		
		
	}

}
