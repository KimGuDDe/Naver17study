package Day1220;

class Parent1
{
	public void process()
	{
		System.out.println("기본 작업을 한다");
	}
}
////////////////////////////////////////////
class My1 extends Parent1
{
	@Override
	public void process()
	{
		super.process();
		System.out.println("벽지작업을 한다");
	}
}
/////////////////////////////////////////////////
class My2 extends Parent1
{
	@Override
	public void process()
	{
		super.process();
		System.out.println("바닥 작업을 한다");
	}
}
public class Ex5Inherit {

	public static void homeProcess(My1 my)
	{
		my.process();
	}
	
	public static void homeProcess(My2 my)
	{
		my.process();
	}
	public static void homeProcessAll(Parent1 p)
	{
		p.process();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		My1 my1=new My1();
		//my1.process();
		
		My2 my2=new My2();
		//my2. process();
		
		homeProcess(my1);
		homeProcess(my2);
		
		//다형성 처리
		Parent1 p1=null;
		p1 = new My1();
		p1.process(); //my1 이 가진 process 메서드가 호출
		
		p1 = new My2();
		p1.process();
		System.out.println("=".repeat(20));
		
		homeProcessAll(new My1());
		homeProcessAll(new My2());
		homeProcessAll(new Parent1());
		
	}

}
