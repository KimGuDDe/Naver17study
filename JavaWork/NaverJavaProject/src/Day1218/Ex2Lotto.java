package Day1218;

import java.util.Random;
import java.util.Scanner;

public class Ex2Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int money;
		int [] lotto= new int[6];
		Random r=new Random();
		
		//금액 입력
		System.out.println("금액을 입력해주세요");
		money=sc.nextInt();
		
		//1000원 미만이면 종료
		if(money<1000)
		{
			System.out.println("** 금액이 부족합니다 **");
			return;
			
		}
		
		//금액만큼 로또 숫자 발생 후 출력(오름차순)
		for(int n=1;n<money/1000;n++)
		{
			System.out.printf("%3d회 :",n);
			
			//lotto 배열에1~45 사이의 난수발생(중복체크)
			for(int i=0;i<lotto.length;i++)
			{
				lotto[i]=r.nextInt(45)+i;
				
				for(int j=0;j<i;j++)
				{
					if(lotto[i]==lotto[j])
					{
						i--;
						break;
					}
				}
			}
			
			//오름차순 정렬
			for(int m=0;m<lotto.length-1;m++)
			{
				for(int j=m+1;j<lotto.length;j++)
				{
					if(lotto[m]>lotto[j])
					{
						int temp=lotto[m];
						lotto[j]=lotto[m];
						lotto[j]=temp;
					}
				}
			}
			
			
			//출력
			for(int i=0;i<lotto.length;i++)
			{
				System.out.printf("%4d",lotto[i]);
			}
			System.out.println();
			
		}
		
		
	}	

}
