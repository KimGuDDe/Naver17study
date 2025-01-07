package day1217;

public class Ex9ArrayAge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []datas= {12,34,56,23,44,57,24,51,37,20,29};
		System.out.println("인원 수:"+ datas.length);
		/*
		 * 위의 데이터를 분석하여 10대 ~ 50대까지의 각각의 인원 수 구하기
		 * 배열변수 []age를 이용하여
		 * 0번지는 10대 인원 수
		 * 
		 * 출력양식
		 * 
		 * 10대 : 1명
		 * 20대 : 2명

		 *
		 */
		
		int []age=new int[5];
		
		for(int i=0;i<datas.length;i++)
		{
			//연령별 인원 수 구하기
			//10대 일 경우 0번지 증가
			age[datas[i]/10-1]++;
						
		}
		
		for(int i=0;i<age.length;i++)
		{
			System.out.println((i+1)*10+"대:"+age[i]+"명");
		}
		
	}

}
