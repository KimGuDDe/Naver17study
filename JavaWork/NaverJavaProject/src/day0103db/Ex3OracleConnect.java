package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3OracleConnect {

	static final String Oracle_Driver = "oracle.jdbc.OracleDriver";

	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String username = "angel";
	String password = "pw1234";

	public Ex3OracleConnect()
	{
		try {
			Class.forName(Oracle_Driver);
			System.out.println("성공");
		} catch (ClassNotFoundException e) {
			System.out.println("실패"+ e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getconnection()
	{
		Connection conn= null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("접속 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("접속 실패"+e.getMessage());
			e.printStackTrace();
		}
		return conn;
	}

	public void shopWirteData() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = """
				SELECT
				s.sangcode,sangname,sangprice,cntnum,to_char(cartday,'yyyy-mm-dd') cartday
				from shop s,cart c
				where s.sangcode=c.sangcode
				""";
		conn = this.getconnection();

		try {
			stmt = conn.createStatement();
			rs=stmt.executeQuery(sql);
			System.out.println("상품코드\t상품명\t상품가격\t상품갯수\t입고날짜");
			System.out.println("=".repeat(60));

			while(rs.next())
			{
				String code = rs.getString("sangcode");
				String sname = rs.getString("sangname");
				int scount = rs.getInt("cntnum");
				String sdate = rs.getString("cartday");
				int sprice = rs.getInt("sangprice");

				System.out.println(code+"\t"+sname+"\t"+sprice+"\t"+scount+"\t"+sdate);
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
		Ex3OracleConnect ex3 = new Ex3OracleConnect();
		ex3.shopWirteData();
	}

}
