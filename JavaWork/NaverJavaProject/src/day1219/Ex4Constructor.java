package day1219;

class Orange
{
	private String name;
	private String color;
	private int age;
	//생성자
	Orange()
	{
//		this.name="장원영";
//		this.color="노랑";
//		this.age=21;
		
		//생성자에서 다른 생성자 호출 시 this() 사용
		this("장원영","노랑");//인자가 맞는 생성자 호출
				
	}
	
	Orange(String name,String color)
	{
		this.name=name;
		this.color=color;
		this.age=30;
	}
		
	public void writeMember()
	{
		System.out.println("name="+name+", color="+color+", age="+age);
	}
	
	public void writeMember(int n)
	{
		if(n==1)
		{
			System.out.println("이름  : "+name);
			System.out.println("좋아하는 색상  : "+ color);
			System.out.println("나이  : "+age);
			System.out.println("*".repeat(20));
		}else if(n==2)
		{
			System.out.println(name+" 님은 "+color+" 색상을 좋아합니다");
			System.out.println("*".repeat(20));
		}else 
		{
			System.out.println("1 or 2만 가능합니다");
		}
	}
}

public class Ex4Constructor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orange a1 = new Orange();
		a1.writeMember();
		
		Orange a2=new Orange("고민시","파랑");
		//a2.writeMember();
		a2.writeMember();
		a2.writeMember(1);
		a2.writeMember(2);
		a2.writeMember(3);
	}

}
