package day1216;

import java.util.Scanner;

public class Ex3Random {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 임의의 난수를 구한 후 숫자를 알아맞추기
		 * 맞췄을 경우
		 * 계속하시겠습니까? y 입력 시
		 * -> 새로운 난수 발생, 카운트 변수 0으로 초기화
		 * y가 아닐 경우 프로그램 종료
		 */
		Scanner sc= new Scanner(System.in);
		int su,rnd,count;
		
		Exit: //레이블은 대소문자 상관없이 임의로 지정하면 됨
			while(true)
			{
				rnd=(int)(Math.random()*100)+1;
				count=0;
				
				while(true)
				{
					System.out.println("숫자를 입력하세요");
					//su=sc.nextInt();
					su=Integer.parseInt(sc.nextLine());
					if(su<rnd)
						System.out.println(su+"보다 큽니다");
					else if(su>rnd)
						System.out.println(su+"보다 작습니다");
					else
					{			
						System.out.println("정답입니다");
						System.out.println("숫자맞추기 게임을 계속하시려면 y,그만하려면 n을 누르세요");
						char ch=sc.nextLine().charAt(0);
						if(ch=='y' || ch=='Y') {
							System.out.println("새로운 난수를 발생합니다");
							//break; -> 현재 속한 while 문만 빠져나감
							continue Exit;//바깥쪽 반복문의 조건식으로 이동
							}else {
								break Exit; //바깥쪽 while 문을 빠져나간다
							}
					}	
				
				}
			}
		
		System.out.println("프로그램을 종료합니다");
		
	}
	
	
	}
