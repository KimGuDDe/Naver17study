package day1219;

import java.util.StringTokenizer;

public class Ex9StringToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = "red|green|yellow|white|black";
//		// | 로 분리해서 출력
//		String []arr=msg.split("|");
//		for(String a:arr)
//		{
//			System.out.print(a);
//		}
		
		StringTokenizer st = new StringTokenizer(msg,"|");
		System.out.println("분리할 총 토큰 수"+st.countTokens());

		//countTokens 는 토큰을 읽을 때마다 갯수가 줄어든다
		//이런 식으로 반복문을 돌리면 3번만 반복
		
//		for(int i=0;i<st.countTokens();i++) // 이렇게 짜면 안됨
//		{
//			System.out.println(st.countTokens());
//		}
//		
		//방법 1
		int count=st.countTokens();
		for(int i = 0; i <count; i++)
		{
			System.out.println(st.nextToken());
		}
		System.out.println();
		
		StringTokenizer st2 = new StringTokenizer(msg,"|");
		//방법 2
		while(st2.hasMoreTokens())
		{
			System.out.println(st2.nextToken());
		}
		System.out.println();
		
		String []arr3=msg.split("\\|");// '\\' 이거는 정규 표현식이다
		System.out.println("총"+arr3.length+"개");
		for(String a:arr3)
		{
			System.out.println(a);
		}
		
		//아래 데이터를 .으로 분리하여 출력하시오.(split)
		String msg2 = "장원영.안유진.김미미.이영지.지민정";
		
		String []arr4 = msg2.split("\\.");
		System.out.println("총"+arr4.length+"개");
		for(String a:arr4)
		{
			System.out.println(a);
		}
	}

}
