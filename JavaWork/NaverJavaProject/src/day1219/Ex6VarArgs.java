package day1219;

public class Ex6VarArgs {

	public static void writeColor(String color1)
	{
		System.out.println("color = " + color1);
	}
	
	public static void writeColor(String color1,String color2)
	{
		System.out.println("color1 = " + color1+ ", color2 = " + color2);
	}
	
	public static void writeColor(String color1,String color2,String color3)
	{
		System.out.println("color1 = " + color1+ ", color2 = " + color2 + ", color3 = " + color3);
	}
	
	public static void writeName(String ... name)//...은 배열타입으로 전달받는다
	{
		System.out.println("name의 length : "+ name.length);
		if(name.length==0)
			System.out.println("멤버가 없습니다");
		else
		{
			System.out.println("**멤버 목록**");
			for(String n:name)
				System.out.println("\t"+n);
			System.out.println("=".repeat(40));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeColor("red");
		writeColor("green","yellow");
		writeColor("pink","purple","white");
		//writeColor("pink","purple","white","red"); -> 해당 오버로딩 메서드가 없기에 오류 발생
		
		System.out.println("variable Arguments 기능을 이용해서 인자로 여러 문자열을 만들어보자");
		writeName("장원영");
		writeName("장원영","안유진");
		writeName("장원영","안유진","고민시","김유연");
		writeName();
		
	}

}
