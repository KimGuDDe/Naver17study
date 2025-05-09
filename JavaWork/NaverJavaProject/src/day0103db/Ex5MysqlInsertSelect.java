package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex5MysqlInsertSelect {

	static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
	String username = "root";
	String password = "1234";

	public Ex5MysqlInsertSelect()
	{
		try {
			Class.forName(MYSQL_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("오류"+e.getMessage());
		}
	}

	public Connection getConnection()
	{
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("오류"+e.getMessage());
		}		
		return conn;
	}

	public void insertSelect(String name,String blood,int age,String hp)
	{
		Connection conn = null;
		Statement stmt = null;
		String sql = "insert into person (name,blood,age,hp,today) values ("
				+"'"+name+"','"+blood.toUpperCase()+"',"+age+",'"+hp+"',now())";
		System.out.println(sql);

		conn = this.getConnection();
		try {
			stmt = conn.createStatement();
			//insert 문 실행
			stmt.execute(sql);

			System.out.println("db에 데이터를 추가했습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void writePerson()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from person order by num";

		conn = this.getConnection();

		try {
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);

			System.out.println("\t\t** Person Table **");
			System.out.println();
			System.out.println("이름\t나이\t혈액형\t핸드폰\t날짜");
			System.out.println("=".repeat(60));

			while(rs.next())
			{
				String today = rs.getString("today").substring(0,10);

				System.out.println(rs.getString("name")+"\t"+
						rs.getInt("age")+"\t"+
						rs.getString("blood")+"\t"+
						rs.getString("hp")+"\t"+today);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void searchName(String name)
	{
		int count = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from person where name Like'%"+ name +"%'";

		conn = this.getConnection();

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("\t\t** Search Results **");
			System.out.println();

			while (rs.next())
			{
				String today = rs.getString("today").substring(0, 10);
				count++;
				System.out.println(count + "번째");
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("혈액형: " + rs.getString("blood"));
				System.out.println("나이: " + rs.getInt("age") + "세");
				System.out.println("핸드폰: " + rs.getString("hp"));
				System.out.println("-".repeat(60));
			}

			if (count == 0) 
			{
				System.out.println("이름에 \"" + name + "\"를 포함한 회원은 없습니다.");

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("오류"+e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
	/*
	 *  문제 : name 이 '영자'인 경우 영자를 포함하는 모든 데이터 출력
	 *  
	 *  예:
	 *  1번째
	 *  이름: 김영자
	 *  혈액형 : B형
	 *  나이 : 23세
	 *  핸드폰 : 010-2222-3333
	 *  --------------------------
	 *  2번쨰
	 *  이름 : 영자순
	 *  ``````
	 *  
	 *  
	 *  만약 없을 경우
	 *  "영자"를 포함한 회원은 없습니다.
	 */
	public void deletePerson(String name)
	{
		int count = 0;
		Connection conn = null;
		Statement stmt = null;
		String sql = "Delete from person where name = '" + name +"'";
		System.out.println(sql);
		conn = this.getConnection();

		try {
			stmt = conn.createStatement();
			count = stmt.executeUpdate(sql);
			
			if (count == 0)
			{
				System.out.println("이름이" + name + " 님은 존재하지 않습니다.");
								
			} else
			{
				System.out.println(count + "명이 삭제되었습니다.");
			}
		} catch (SQLException e)
		{
			System.out.println("오류발생" + e.getMessage());
			e.printStackTrace();
		} finally 
		{
			try 
			{				 
				 stmt.close();
				 conn.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}	

		/*
		 * 이영자일 있을 경우
		 * 	 있을 경우 1명의 데이터가 삭제되었습니다
		 * 
		 * 이영자가 2명일 경우
		 * 	있을 경우 2명의 데이터가 삭제되었습니다
		 * 
		 * 없을 경우
		 * "이영자" 님은 존재하지 않습니다
		 * 
		 * 
		 * int executeUpdate(String sql)
		 * : 실행한 sql문의 갯수를 반환
		 * 예를 들어 2명이 삭제된 경우 2반환
		 * 1명이 삭제되며 1 반환
		 * 해당이름이 없어서 삭제를 못했다면 0 반환
		 * 
		 * 
		 */
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5MysqlInsertSelect ex5 = new Ex5MysqlInsertSelect();
		Scanner sc = new Scanner(System.in);

		while(true)
		{
			System.out.println("1. 데이터 추가 2. 전체 출력 3. 이름 검색 4. 이름 삭제 5.종료");
			System.out.println("select menu?");
			int menu = Integer.parseInt(sc.nextLine());

			switch(menu)
			{
			case 1:
			{
				System.out.println("데이터를 추가합니다");
				System.out.println("이름을 입력하세요");
				String name = sc.nextLine();
				System.out.println("혈액형을 입력하세요");
				String blood = sc.nextLine();
				System.out.println("나이를 입력하세요");
				int age = Integer.parseInt(sc.nextLine());
				System.out.println("핸드폰을 입력하세요");
				String hp = sc.nextLine();

				ex5.insertSelect(name, blood, age, hp);
				break;
			}
			case 2:
				ex5.writePerson();
				break;
			case 3:{
				System.out.println("검색할 이름을 입력하세요");
				String name = sc.nextLine();

				ex5.searchName(name);
				break;
			}
			case 4 :
			{
				System.out.println("삭제할 이름을 입력하세요");
				String name = sc.nextLine();

				ex5.deletePerson(name);
				break;			

			}
			default:
				System.out.println("** 프로그램을 종료합니다 **");
				System.exit(0);

			}
			System.out.println("-".repeat(60));
		}
	}

}
