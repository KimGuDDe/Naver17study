package day1213;

import java.util.Scanner;

public class Ex10GuguDan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);


//		int num;
//		for(int i=1;i<=1;i++)
//		{
//			num=i;
//			System.out.print(num+"단");
//		}
//		System.out.println();
//		System.out.println("=".repeat(30));
//		
//		for(int i=1;i<=1;i++)
//		{
//			for(int j=1;j<=9;++j)
//				
//				System.out.println(num+"X"+j+"="+(num*j));
//		}
		
		for(int dan=2;dan<=9;dan++)
			System.out.print("["+dan+"단]\t");
		System.out.println();
		System.out.println("=".repeat(65));
		
		for(int i=1;i<=9;i++)
		{
			for(int dan=2;dan<=9;dan++)
			{
				System.out.print(dan+"X"+i+"="+dan*i+"\t");
			}
			System.out.println();
		}
		
		
		
		
	}

}
