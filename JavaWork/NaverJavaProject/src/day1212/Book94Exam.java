package day1212;

public class Book94Exam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int charcode = 'A';
		
		if((65<=charcode) & (charcode<=90))
		{
			System.out.println("대문자입니다");
		}
		
		if((97<=charcode) & (charcode<=122))
		{
			System.out.println("소문자입니다");
		}
		
		if((48<=charcode) & (charcode<=57))
		{
			System.out.println("0~9 사이 값입니다");
		}
		
		int value = 6;
		
		if((value%2==0) | (value%3==0))
		{
			System.out.println("2또는 3의 배수입니다");
		}
		
		boolean result = (value%2==0) | (value%3==0);
		if(!(result))
		{
			System.out.println("2또는 3의 배수가 아닙니다");
		}
		
	}

}
