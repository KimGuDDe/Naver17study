package Day1218;

class Orange
{
    public static final String MESSAGE="Happy";
	
	private String name; //String 초기값 : null , int 초기값 : 0
	private int age;
	
	
	public void showData()
	{
		//일반 멤버 메서드는 this 라는 인스턴스 변수를 가지고 있다
		//static 멤버 메서드에는 this가 없음
		//그래서 this.name 이런 식으로 접근가능(this 는 경우에 따라 생략 가능)
		System.out.println("이름 : "+this.name+",나이 : "+this.age);// 여기서 this 는 생략가능
		
		
	}
	//값을 변경하기 위한 setter method 를 만들어보자
	public void setName(String name)
	{
		//같은 구역에 멤버와 같은 이름의 변수가 있을 경우
		//멤버변수 앞에 반드시 this 가 붙여야 한다
		this.name=name;
	}
	
	public void setAge(int age)
	{
		//같은 구역에 멤버와 같은 이름의 변수가 있을 경우
		//멤버변수 앞에 반드시 this 가 붙여야 한다
		this.age=age;
	}
}

public class Ex8Object {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Orange.MESSAGE);
		
		Orange orange=new Orange();
		//System.out.println(orange.name);// private 변수는 직접 접근 불가(오류나는 이유)
		orange.showData();
		System.out.println("값 변경");
		orange.setName("장원영");
		orange.setAge(23);
		
		orange.showData();
		
		
		
		
	}

}
