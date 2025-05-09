package Day0106db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import day0103db.ex1OracleConnect;
import db.connect.MysqlConnect;

public class Ex1ShopMysql {
	MysqlConnect mysqlConnect = new MysqlConnect();

	//shop에 상품 추가
	public void insertShop(String sangpum,int su, int danga)
	{
		System.out.println("상품 추가");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into shop (sangpum,su,danga,ipgoday) values (?,?,?,now())";
		
		//db 연결
		conn = mysqlConnect.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql); //sql문 검사
			//? 갯수만큼 데이터를 넣어준다(바인딩)
			//첫번째 물음표부터 1번 2번
			pstmt.setString(1, sangpum);
			pstmt.setInt(2, su);
			pstmt.setInt(3, danga);
			
			//바인딩을 모두 마친 후 실행을 하는데 이때 sql문을 보내면 안됨, 그냥 실행만
			pstmt.execute();
			System.out.println("상품 추가를 하였습니다");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}

	//전체 shop 데이터 출력
	public void writeShop(String sangpum)
	{
		System.out.println("전체 상품 출력");
		System.out.println("인덱스\t상품명\t수량\t단가\t총금액");
		System.out.println("=".repeat(60));
		
		int count=0;
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from shop order by idx";
		
		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(count == 0)
			{
				System.out.println("해당 제품이 존재하지 않습니다");
			}				
			else
			{
				System.out.println(count+"개 삭제되었습니다");
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}
	}

	//상품 삭제
	public void deleteShop(String sangpum)
	{
		
		System.out.println("상품삭제");
				
		Connection conn=null;
		PreparedStatement pstmt = null;
		
		
		// 상품을 삭제하는 SQL문
	     String sql = "delete from shop where sangpum like ?";

	    conn = mysqlConnect.getConnection();
	    try {
	        // 먼저 상품 목록을 조회해서 삭제할 상품이 있는지 확인
	        pstmt = conn.prepareStatement(sql);      	
			pstmt.setString(1, sangpum);
			int n = pstmt.executeUpdate();
			if(n==0)
				System.out.println("["+sangpum+"] 관련 제품이 없습니다");
			else
				System.out.println("총"+n+"개의 ["+sangpum+"] 상품을 삭제했습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
	}

	//상품 조회
	public void seartchSangpum(String sangpum)
	{
		System.out.println("["+sangpum+"] 상품 조회");
		System.out.println("인덱스\t상품명\t수량\t단가\t총금액");
		System.out.println("=".repeat(60));
		
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from shop where sangpum like ? order by idx";
		
		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			//? 자리에 바인딩
			pstmt.setString(1, "%"+sangpum+"%");
			
			rs = pstmt.executeQuery(); //resultset 반환 실행문
			
			int count = 0;
			while(rs.next())
			{
				count++;
				int su = rs.getInt("su");
				int dan = rs.getInt("danga");
				int total = su*dan;
				
				System.out.println(rs.getInt("idx")+"\t"+rs.getString("sangpum")+"\t"+su+"\t"+dan+"\t"+total+"\t"+rs.getString("ipgoday"));
			}
			
			if(count == 0)
				System.out.println("["+sangpum+"] 관련 제품이 없습니다");
			else
				System.out.println("["+sangpum+"] 관련 제품이 3" + count + "개 조회되었습니다" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(rs, pstmt, conn);
		}
	}

	//상품 수정
	public void updateShop(int idx,int su, int danga)
	{
		System.out.println("상품 수정합니다");
		//idx 에 해당하는 su,danga 수정
		//executeUpdate 로 in 타입 반환값 받아서
		//0이면 해당상품 X
		//0 아니면 해당 상품 정보를 수정했음
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update shop set su=?,danga=/ where idx=/";
		
		conn = mysqlConnect.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.setInt(2, danga);
			pstmt.setInt(3, su);
			int count = pstmt.executeUpdate();
			if(count==0)
				System.out.println("해당 인덱스 제품이 없습니다");
			else
				System.out.println("해당 인덱스 상품을 수정했습니다");
			
		} catch (SQLException e) {
			System.out.println("오류 발생 :" +e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mysqlConnect.dbClose(pstmt, conn);
		}
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Ex1ShopMysql ex = new Ex1ShopMysql();

		while(true)
		{
			System.out.println("\t** 상품관리 메뉴 **\n");
			System.out.println("1.상품추가 2.전체출력 3.상품조회 4.상품삭제 5.상품수정 6.종료");
			System.out.println("번호 선택(1-6) : ");
			int menu = Integer.parseInt(sc.nextLine());

			switch(menu)
			{
			case 1 -> {
				System.out.println("상품명을 입력하세요");
				String sang = sc.nextLine();
				System.out.println("수량을 입력하세요");
				int su = Integer.parseInt(sc.nextLine());
				System.out.println("단가를 입력하세요");
				int dan = Integer.parseInt(sc.nextLine());

				ex.insertShop(sang, su, dan);
			}				
			case 2 -> {
				System.out.println("번호입력하세요");
				String sangpum = sc.nextLine();
				ex.writeShop(null);
			}
			case 3 -> {
				System.out.println("검색할 상품명을 입력하세요");
				String sangpum = sc.nextLine();
				ex.seartchSangpum(sangpum);
			}
			case 4 -> {
				System.out.println("삭제할 상품명을 입력하세요");
				String sangpum = sc.nextLine();
				ex.deleteShop(sangpum);
			}
			case 5 -> {
				System.out.println("수정할 상품의 idx를 입력하세요");
				int idx = Integer.parseInt(sc.nextLine());
				System.out.println("수정할 상품의 수량을 입력하세요");
				int danga = Integer.parseInt(sc.nextLine());
				System.out.println("수정할 상품의 단가를 입력하세요");
				int su = Integer.parseInt(sc.nextLine());
				ex.updateShop(idx, danga, su);
			}
			case 6 -> {
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}
			default -> {			
				System.out.println("잘못된 입력");
			}

			}

		}

	}

}
