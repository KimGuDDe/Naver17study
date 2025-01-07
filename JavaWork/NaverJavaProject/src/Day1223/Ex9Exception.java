package Day1223;

import java.util.Date;
import java.util.Scanner;

public class Ex9Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int birthYear,age;

		try {				
			System.out.println("태어난 년도는?");
			birthYear = Integer.parseInt((sc.nextLine()));

			Date date = null;
			age = 2024 - birthYear;

			System.out.println("내 나이는 " + age + "세입니다");
		}catch(NumberFormatException|NullPointerException e)
		//둘 중 하나의 이셉션 발생 시 catch 로 이동
		{
			System.out.println("예외 발생 :" + e.getMessage());
		}
		System.out.println("정상 종료");
	}

}
