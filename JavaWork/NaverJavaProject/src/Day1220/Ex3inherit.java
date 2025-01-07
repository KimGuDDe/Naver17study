package Day1220;

import Day1220_2.DbServerSystem;

class DataProcess extends DbServerSystem
{
	private String sql;
	
	public DataProcess()
	{
		sql = "select";
		this.dbServerName = "Mysql"; //protected 인 경우 직접 접근가능(상속관계인 경우에만)
		//this.serverPort = 9000; //오류 : default 멤버 변수는 상속 관계라 하더라도 접근 불가
	}
	
	public DataProcess(String dbServerName,int severPort,String sql)
	{
		super(dbServerName,severPort);
		this.sql=sql;
	}
	
	public void process()
	{
		//this.serverStart();//서브 클래스에 오버라이드 메서드가 없는 경우 this 로 호출해도
		//상속받은  메서드가 호출된다.
		//이런 경우 this 로 호출해도 되고 super 로 호출해도 된다
		//하지만 오버라이드 메서드가 있는 경우 부모메서드 호출 시 반드시 super 로 호출
		super.serverStart();
		System.out.println("SQL문"+sql+"처리함");
		this.serverClose();
		System.out.println();
	}
}
public class Ex3inherit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataProcess data1 = new DataProcess();
		data1.process();
		
		DataProcess data2 = new DataProcess("MariaDB", 3000, "insert");
		data2.process();
	}

}
