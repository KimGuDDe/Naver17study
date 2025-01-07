package Day1220;

import java.util.Scanner;

/*
 *  command 라는 인터페이스에 process() 추상메소드를 추가
 *  인터페이스 command 를 구현하는 List(출력), Insert(추가), Delete(삭제)
 *  , Update(수정) 클래스를 구현하시오
 *  
 *  메인에서 while 문을 통해 다음과 같이 메뉴가 나오면
 *  1.추가
 *  2.출력
 *  3.삭제
 *  4.수정
 *  5.종료
 *  
 *  1번을 누르면 데이터가 추가되었습니다
 *  2번을 누르면 데이터가 출력합니다
 *  3번을 누르면 데이터가 삭제되었습니다
 *  4번을 누르면 데이터가 수정되었습니다
 *  5번을 누르면 프로그램을 종료합니다 -> 실제로 종료
 *  
 *  호출하는 메소드는
 *  public static void dbProcess(command comm)
 *  {
 *  	comm.process(); //이 부분이 다형성 처리가 되도록
 * 	}
 */
interface Command
{
	int process = 0;
	
	public void process();

}

class List implements Command
{	
	@Override
	public void process()
	{
		System.out.println("데이터를 출력합니다");
	}
}

class Insert implements Command
{	
	@Override
	public void process()
	{
		System.out.println("데이터를 추가합니다");
	}
}

class Delete implements Command
{	
	@Override
	public void process()
	{
		System.out.println("데이터를 삭제합니다");
	}
}

class Update implements Command
{
	@Override
	public void process() {
	System.out.println("데이터를 수정합니다");
		
	}
}

public class Ex11InterfaceExam {
	public static void dpProcess(Command comm) 
	{
		comm.process();//다형성처리
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Command comm = null;
		
		while(true)
		{
			System.out.println("1. 추가 2. 출력 3. 삭제 4. 수정 5. 종료");
			int num = sc.nextInt();
			if(num == 1)
				comm = new Insert();
			else if(num == 2)
				comm = new List();
			else if(num == 3)
				comm = new Delete();
			else if(num == 4)
				comm = new Update();
			else {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			
			dpProcess(comm);
		}
	}

}
