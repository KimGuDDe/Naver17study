package Day0106db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;

public class PersonModel {
	MysqlConnect connn = new MysqlConnect();
	
	public List<Vector<String>> getAllData(){
		List<Vector<String>> list = new Vector<Vector<String>>();
		Connection conn = connn.getConnection();
		PreparedStatement prep = null;
		ResultSet rs = null;
		String sql = "select * from person order by num desc";
		
		try {
			prep = conn.prepareStatement(sql);
			rs = prep.executeQuery();
			
			while(rs.next())
			{
				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("age"));
				data.add(rs.getString("hp"));
				data.add(rs.getString("blood"));
				
				data.add(String.valueOf("age"));//int -> String 으로 변환해서 추가
				
				//list에 추가
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connn.dbClose(rs, prep, conn);
		}	
		return list;
		
		public void insetPerson(PersonDto dto)
		{
			Connection conn = connn.getConnection();
			PreparedStatement prep = null;
			String sql = "insert into person (num,name,age,hp,blood) values (?,?,?,?,?)";

			
				

				//실행
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				connect.dbClose(pstmt, conn);
			}
		
		}
	}
}
