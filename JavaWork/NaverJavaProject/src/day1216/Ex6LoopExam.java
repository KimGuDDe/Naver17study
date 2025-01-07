package day1216;

import java.util.Scanner;

public class Ex6LoopExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 문자열 str을 입력 후 엔터를 누르면
		 * 문자열을 분석해서 대문자,소문자,숫자 각각의 갯수를 구해서
		 * 출력하시오
		 * 사용할 문자메소드 : length(),charAt(인덱스)
		 */
		Scanner sc=new Scanner(System.in);
		System.out.println("글자를 입력해주세요");
		String a;
		a=sc.nextLine();
		System.out.println("숫자를 입력해주세요");
		int uppercount = 0, lowercount = 0, numbercount = 0;
		for(int i=0;i<a.length();i++)
		{
			char ch=a.charAt(i);
			if(ch>='A' && ch<='Z')
				uppercount++;
			else if(ch>='a' && ch<='z')
				lowercount++;
			else if(ch>='0' && ch<='9')
				numbercount++;
			
		}
		
		System.out.println("대문자 갯수:"+uppercount);
		System.out.println("소문자 갯수:"+lowercount);
		System.out.println("숫자 갯수:"+numbercount);
		
		
		
		
		
		
	}

}
