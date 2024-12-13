package day1212;

import java.util.Scanner;

public class Ex2If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int score;
		String grade;
		
		System.out.println("점수를 입력해주세요");
		score=sc.nextInt();
		
		//if(!(score>=0 && score<=100))//방법 1
		if(score<0 || score>100)
		
		{
			System.out.println("값의 범위를 벗어남");
			return;//현재 메서드를 종료
		}
		
		if(score>=90)
			grade="A";
		else if(score>=80)
			grade="B";
		else if(score>=70)
			grade="C";
		else if(score>=60)
			grade="D";
		else
			grade="F";
		
		System.out.printf("%d 점의 학점은 %s학점입니다\n",score,grade);
		
		//점수가 0-100의 값을 벗어나면 메서드 종료
		
		
	}

}
