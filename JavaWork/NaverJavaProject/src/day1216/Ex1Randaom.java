package day1216;

import java.util.Random;

public class Ex1Randaom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 난수를 구하는 방법 2가지
		 * 1.Math.randaom()
		 * 2. Random
		 * 
		 */
		System.out.println("Math.random()dms 0.0보다 크거나 같고 1.0보다 작은 난수 발생");
		for(int i=1;i<=5;i++)
		{
			System.out.println(Math.random());
		}
		System.out.println("0~9사이의 난수를 구하는 방법");
		for(int i=1;i<=5;i++)
		{
			int n=(int)(Math.random()*10);
			System.out.println(n);
		}
		
		System.out.println("0~99 사이의 난수를 구해라");
		for(int i=1;i<=6;i++)
		{
			int n=(int)(Math.random()*100);
					System.out.println(n+" ");
		}
		System.out.println("1~10 사이의 난수를 구해라");
		for(int i=1;i<=5;i++)
		{
			int n=(int)(Math.random()*10)+1;
					System.out.print(n+" ");
		}		
		Random r=new Random();
		System.out.println("0~9까지 난수 구하기");
		for(int i=1;i<=5;i++)
		{
			int n=r.nextInt(10)+1;
			System.out.print(n+" ");
		}
		System.out.println();
		
	    
		Random a=new Random();
		System.out.println("A~Z(65~90)까지 난수 구하기");
		for(int i=1;i<=5;i++)
		{
			int n=a.nextInt(26)+97;
			System.out.print((char)n+" ");
		}
		System.out.println();
					
		}
		


}
