package day0103db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex5MysqlExam {

	public class Ex4MysqlJoin {

		static final String MYSQL_DRIVER="com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/study502?serverTimezone=Asia/Seoul";
		String username = "root";
		String password = "1234";

		public Ex4MysqlJoin()
		{
			try {
				Class.forName(MYSQL_DRIVER);
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

		public void bloodWriteDate()
		{
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = """
					select blood,count(*) count,round(avg(age),1) avgage from person
					group by blood order by count;
					""";
			conn = this.getconnection();
			try {
				stmt = conn.createStatement();
				rs=stmt.executeQuery(sql);
				System.out.println("혈액형\t인원수\t평균나이");
				System.out.println("=".repeat(60));

				while(rs.next())
				{
					String blood = rs.getString("blood");
					int count = rs.getInt("count");
					double avgage = rs.getDouble("avgage");

					System.out.println(blood+"\t"+count+"\t"+avgage);
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
			Ex5MysqlExam ex5 = new Ex5MysqlExam();
			ex5.
		}

	}
