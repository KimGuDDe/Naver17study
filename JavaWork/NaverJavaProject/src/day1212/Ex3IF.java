package day1212;

import java.util.Scanner;

public class Ex3IF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		/*
		 * 상품(sang)과 수량(su),단가(dan)을 입력받은후
		 * 총금액(total)을 출력하시오.
		 * 단, 수량이 5개 이상이면 총금액의 10프로를 할인된 금액으로
		 * 같이 출력해주세요
		 * 
		 * Ex>
		 * 상품명 : 바나나킥
		 * 수량 : 5개
		 * 단가 : 1000원
		 * 총금액 : 5000원
		 * 10% DC된 금액 4500원입니다 -> 5개 이상인 경우에만 출력되는 문장
		 */
		
		String sang;
		int su, dan, total, dctotal;
		
		System.out.println("상품명을 입력해주세요");
		sang=sc.nextLine();
		System.out.println("수량을 입력해주세요");
		su=sc.nextInt();
		System.out.println("단가를 입력해주세요");
		dan=sc.nextInt();
		
		total=su*dan;
		
			
		System.out.println("상품명 :"+ sang );
		System.out.println("수량 :"+ su );
		System.out.println("단가 :"+ dan );
		System.out.printf("가격 :"+"%d원\n",total);
		
		if(su>=5)
		{
			dctotal =(int)(total * 0.9);
			System.out.println("10프로 DC된 금액은"+dctotal+"원입니다");
		}
		
	}

}