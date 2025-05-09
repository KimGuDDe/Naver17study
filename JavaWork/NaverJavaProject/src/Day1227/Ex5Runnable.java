package Day1227;
/*
 * 자바는 다중상속이 안되므로 부득이하게 이미 다른 클래스를
 * 상속받고 있다면 더이상 Thread를 상속받을 수 없다
 * 이런 경우는 인터페이스를 Runnable 을 구현하므로써 쓰레드를 구현할 수 있다
 */
		
public class Ex5Runnable implements Runnable{
	
	int count;
	String msg;
	
	public Ex5Runnable(String msg,int count)
	{
		this.msg =msg;
		this.count = count;
	}
	public Ex5Runnable() {
		// TODO Auto-generated constructor stub
	}
		
	@Override
	public void run() {
		for(int i=1;i<=count;i++)
		{
			System.out.println(msg+":"+count);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5Runnable ex1 = new Ex5Runnable("1번 쓰레드", 300);
		Ex5Runnable ex2 = new Ex5Runnable("2번 쓰레드", 300);
		Ex5Runnable ex3 = new Ex5Runnable("3번 쓰레드", 300);
		
		Thread th1 = new Thread(ex1);
		Thread th2 = new Thread(ex2);
		Thread th3 = new Thread(ex3);
		
		th1.start();
		th2.start();
		th3.start();
		
		
	}

}
