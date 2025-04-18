package inter.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import db.connect.MysqlConnect;
import inter.data.InterDto;
import shop.data.ShopRepleDto;


public class InterDao {

		MysqlConnect db=new MysqlConnect();
		
		public void insertInter(InterDto dto)
		{
			Connection conn=null;
			PreparedStatement pstmt=null;
			String sql="insert into inter (num,iname,writeday,imessage) values (?,?,now(),?)";
			
			conn=db.getNaverCloudConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				//바인딩
				pstmt.setInt(1, dto.getNum());
				pstmt.setString(2, dto.getIname());
				pstmt.setString(3, dto.getImessage());
				
				//실행
				pstmt.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
		}
		
		public List<InterDto> getAllInters(int order)
		{
			List<InterDto> list=new Vector<InterDto>();
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			String sql="";
			if(order==1)
				sql="select * from inter order by num";
			else if(order==2)
				sql="select * from inter order by iname desc";
						
			
			conn=db.getNaverCloudConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					InterDto dto=new InterDto();
					
					dto.setNum(rs.getInt("num"));
					dto.setIname(rs.getString("iname"));
					dto.setImessage(rs.getString("imessage"));
										
					list.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt, conn);
			}		
			return list;
		}	
		
}
