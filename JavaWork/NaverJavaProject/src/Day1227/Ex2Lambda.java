package Day1227;
/*
 *  자바에서의 함수형 프로그램 람다(Lambda) 표현식은 인터페이스를
 *  사용하는 익명 내부 클래스의 또다른 표현식
 *  단, 인터페잇는 단 하나의 추상 메서드만 가지고 있어야 한다
 *  
 *  람다는 ^ 그리스어 알파벳의 11번째 글자이다
 */

@FunctionalInterface //메소드가 하나인지 아닌지 검증 역할, 두개면 오류
interface Orange
{
	public void write(); //추상 메소드
}

@FunctionalInterface
interface DataAdd
{
	public void add(int x, int y);
}

public class Ex2Lambda {
	//우리가 알고있는 익명 내부 클래스 형태로 orange 를 구현
	Orange or = new Orange() {
		
		@Override
		public void write() {
			// TODO Auto-generated method stub
			System.out.println("오렌지 익명 내부 클래스 형태");
			
		}
	};
	
	public void lambdaMethod()
	{
		Orange orange1 = () -> System.out.println("람다식 오렌지 메소드 호출");
		orange1.write();
		
		Orange orange2 = () -> System.out.println("ㄱㄱ");
		orange2.write();
		
		DataAdd add1=(int x,int y)->System.out.println(x+"+"+y+"="+(x+y));
		add1.add(10, 10);
		add1.add(3, 67);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2Lambda ex2 = new Ex2Lambda();
		ex2.or.write();
		ex2.lambdaMethod();
	}

}
