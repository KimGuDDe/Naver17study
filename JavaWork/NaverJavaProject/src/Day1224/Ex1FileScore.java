package Day1224;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex1FileScore {
	public static void scoreRead()
	{
		FileReader fr = null;
		BufferedReader br = null;
		
		int count = 0, sum = 0;
		double avg;
		
		//생성
		try {
			fr = new FileReader("d:/naver1210/score.txt");
			System.out.println("파일 존재");
			br = new BufferedReader(fr);
			
			while(true)
			{
				//파일에서 한줄씩 읽기
				String s=br.readLine();
				//null 일 경우 갯수에도 포함 안되고 while 문을 빠져나간다
				if(s==null)
					break;
				try
				{
					int score = Integer.parseInt(s);
					
					count++;
					sum+=score;
					System.out.println(count+"=>"+score+"점");
				}catch (NumberFormatException e)
				{
					System.out.println("\t문자가 포함됨");
				}
				
			}
			//평균
			avg = (double)sum/count;
			System.out.println("점수 갯수 : "+count);
			System.out.println("총점 : "+sum);
			System.out.println("평균 : "+avg);
		} catch (FileNotFoundException e) {
			System.out.println("파일 없음"+e.getMessage());
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException|NullPointerException e) {
				System.out.println(e.getMessage());
				// TODO Auto-generated catch block
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		scoreRead();
	}

}
