package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ex1OracleConnect {
	
	static final String Oracle_Driver="oracle.jdbc.OracleDriver";
	// db 에 접근하려면 url 과 id,password 가 필요하다
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String username = "angel";
	String password = "pw1234";
	
	public ex1OracleConnect()
	{
		try {
			Class.forName(Oracle_Driver);
			System.out.println("오라클 드라이버 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//db 연결성공 후 Connection 을 반환하는 메서드
	public Connection getconnection()
	{
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("접속했습니다!");
		} catch (SQLException e) {
			System.out.println("접속 실패했습니다"+e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public void shopWriteData()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from shop";
		conn = this.getconnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);//select sql문은 ResultSet이 반환되는 executeQuery만 가능
			//여러 개인 경우 while문으로 rs.next() 가 true인 동안만 반복
			System.out.println("상품코드\t상품명\t상품단가");
			System.out.println("=".repeat(30));
			while(rs.next())
			{
//				String code = rs.getString("sangcode");
//				String sname = rs.getString("sangname");
//				int sprice = rs.getInt("sangprice");
				
				String code = rs.getString("sangcode");
				String sname = rs.getString("sangname");
				int sprice = rs.getInt("sangprice");
				
				System.out.println(code+"\t"+sname+"\t"+sprice);
			}
		} catch (SQLException e) {
			System.out.println("sql문 오류"+e.getMessage());
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException|NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ex1OracleConnect ex1 = new ex1OracleConnect(); //생성자 호출
		ex1.shopWriteData();
	}

}
