package Day1223;

import java.awt.desktop.SystemSleepEvent;
import java.util.Date;
import java.util.Scanner;

public class Ex8Exception {

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
		}catch(NumberFormatException e){
			System.out.println("숫자로만 입력해주십시오" + e.getMessage());
		}catch(NullPointerException e) {
			System.out.println("Date 변수가 null입니다"+e.getMessage());

		}
		System.out.println("정상 종료");
	}

}
