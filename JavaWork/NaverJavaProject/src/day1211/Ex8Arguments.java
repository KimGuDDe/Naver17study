package day1211;

public class Ex8Arguments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Arguments는 외부에서 한 번 실행해야 가져올 수 있다.
		System.out.println("외부에서 값 읽어오기");
		String name=args[0];
		System.out.println("이름 :"+name);
		String city=args[1];
		System.out.println("도시 :"+city);
		int birthYear=Integer.parseInt(args[2]);
		//String 형태의 년도를 정수타입으로 변환
		int age=2024-birthYear;
		System.out.println("태어난 년도 :"+ birthYear+"나이 :" +age);
		int kor=Integer.parseInt(args[3]);
		int eng=Integer.parseInt(args[4]);
		System.out.println("국어점수 :" + kor + "점");
		System.out.println("영어점수 :" + eng + "점");
		int total=kor+eng;
		double average=(double)total/2.0;
		//int+double=double, int+int=int -> 위 예시처럼 숫자가 있으면 소숫점을 붙이던가
		//없다면 (double) 붙여서 int를 double 효과를 내던가
		System.out.println("총점 :"+ total + "점");
		System.out.println("평균점수 :" + average + "점");
		
		
		
				
	}

}
