package Day1218;

import java.util.Scanner;

public class Ex5Bingo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3행 3열의 2차원 배열을 생성 후 1~3 사이의 난수가 발생하여
		// 가로,세로, 각 대각선을 비교하여 같은 값이 나오면 빙고 : 2개 이런 식으로 출력
		//없을 경우 "꽝!!" 출력
		//
		//엔터를 누를 때마다 다시 난수 발생
		//q나 Q를 누르면 프로그램 종료

		Scanner sc=new Scanner(System.in);
		int [][]puzzle=new int[3][3];
		int bingo;

		while(true)
		{
			//2차원 배열에 1~3 사이의 난수 발생
			for(int i=0;i<puzzle.length;i++)
			{
				for(int j=0;j<puzzle[i].length;j++)
				{
					puzzle[i][j]= (int)(Math.random()*3)+1;
				}
			}

			//출력
			for(int i=0;i<puzzle.length;i++)
			{
				for(int j=0;j<puzzle[i].length;j++)
				{
					System.out.printf("%3d",puzzle[i][j]);
				}
				System.out.println();
			}
			//가로,세로,대각선 비교하여 같은 숫자가 나온 갯수 출력
			
			//없으면 꽝 출력
			bingo=0;


			//빙고수 계산
			for(int i=0;i<puzzle.length;i++)
			{
				//가로방향
				if(puzzle[i][0]==puzzle[i][1] && puzzle[i][1]==puzzle[i][2])
					bingo++;
				//세로방향
				if(puzzle[0][i]==puzzle[1][i] && puzzle[1][i]==puzzle[2][i])
					bingo++;
			}
			//대각선
			if(puzzle[0][0]==puzzle[1][1] && puzzle[1][1]==puzzle[2][2])
				bingo++;		
			if(puzzle[0][2]==puzzle[1][1] && puzzle[1][1]==puzzle[2][0])
				bingo++;		
					
			if(bingo==0)
				System.out.println("\t꽝!!!!");
			else
				System.out.println("\t\t빙고"+bingo+"개");

			//q(대소문자 상관없음) 입력시 종료
			if(sc.nextLine().equalsIgnoreCase("q"))
			{
				System.out.println("프로그램을 종료합니다");
				break;
			}
			System.out.println("-".repeat(20));
		}


	}

}
