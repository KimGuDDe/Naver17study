package Day1218;

class Apple
{
	//접근지정자 생략 시 default가 되는데 같은 패키지에서는
	//private를 제외하고 모두 직접 접근이 가능하다
	static String message="hello";//클래스 멤버변수
	static final String EMP = "비트캠프";//상수
	String name="캔디"; //인스턴스 멤버 변수
	
	
	
}
////////////////////////////////
public class Ex7Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//다른 클래스의 static 변수는 클래스면.변수명 이렇게 접근한다
		System.out.println("메세지 : "+Apple.message);
		System.out.println("EMP : "+Apple.EMP);
		
		Apple.message="Happy Day";
		System.out.println(Apple.message);
		
		//Apple.EMP="사만전자";//final 상수는 값이 변경 안된다(오류가 뜸)
		
		//다른 클래스의 인스턴스 멤버변수를 접근하려면 new 로 생성된 인스턴스 변수가 있어야 한다
		Apple a=new Apple();
		System.out.println("이름 = "+a.name);
		//System.out.println("이름 = "+Apple.name);//오류발생
		a.name="미라";
		System.out.println("a의 이름 = "+a.name);
		
		Apple b=new Apple();
		b.name="원영";
		System.out.println("b의 이름 : "+b.name);
		
		
		
		
		
	}

}
