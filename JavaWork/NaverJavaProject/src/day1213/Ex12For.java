package day1213;

import java.util.Scanner;

public class Ex12For {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문제1
		 * 숫자 n을 입력하면 1부터 n까지의 합계를 구하시오.
		 * (for문 사용할 것)
		 * 
		 */
		
		Scanner sc=new Scanner(System.in);
		 System.out.println("합계를 구하시오");
		 int n;
		 n=sc.nextInt();
		 		 
		 int sum = 0;
		 int i;
		 for(i=1; i<=n; i++)
		 {
			sum += i;
		 }
			 System.out.println("1~"+(i-1)+"까지의 합은"+sum+"입니다.");
		 
		
	}

}
