package day1219;

public class Ex7VarArgs {

	public static int calNum(int...n)
	{
		int sum=0;
		System.out.println("총 : "+ n.length + "개의 점수");
		for(int score:n)
		{
			System.out.println(score+" ");
			sum+=score;
		}
		System.out.println();
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s1=calNum(90,80);
		System.out.println("합계 : "+s1);
		
		int s2=calNum(90,80,54,76,23);
		System.out.println("합계 : "+s2);
		
		int s3=calNum(90,80,23,125,234,54,23);
		System.out.println("합계 : "+s3);
	}

}
