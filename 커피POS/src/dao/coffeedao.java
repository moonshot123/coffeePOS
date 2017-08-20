package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


import bean.Coffee;


public class coffeedao {
	private String driver = "oracle.jdbc.driver.OracleDriver" ;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe" ;
	private String username = "jspid" ;
	private String password = "jsppw" ;
	private Connection conn = null ;
	
	public coffeedao() {
		try {
			Class.forName(driver) ;			
		} catch (ClassNotFoundException e) {
			System.out.println("클래스가 발견되지 않습니다(jar 파일 누락)"); 
			e.printStackTrace();		
		}
	}

	private Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password) ;
		} catch (SQLException e) {
			System.out.println("커넥션 생성 오류");
			e.printStackTrace();
		}
		return conn ;
	}


	private void closeConnection() {
		try {
			if(conn != null) {conn.close(); }
		} catch (Exception e2) {
			e2.printStackTrace(); 
		}		
	}

	public int coffeeadd(Coffee bean){//콘솔창에서 데이터를 입력받아 객체 생성
		int result =-1;
		
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql = "insert into coffee(coffeename,coffeesize,shot,coffeetemp,price)values(?,?,?,?,?)";
	
		try {
								
			conn = getConnection();
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, bean.getName());
			pstmt.setString(2, bean.getSize());
			pstmt.setString(3, bean.getShot());
			pstmt.setString(4, bean.getTemp());
			pstmt.setInt(5, bean.getPrice());
						
			result = pstmt.executeUpdate();
			conn.commit();	
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();  
			}
		}finally{
			try {
				if(rs != null) {rs.close(); }
				if(pstmt != null) {pstmt.close(); }
				closeConnection() ;
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		
		return result;
	}//coffeeadd
	
	
	
	
	
	
	public  Vector<Coffee> Getsellcount(){// 오늘 판매된 음료수
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = "select coffeename , count(*)  from coffee group by  coffeename   order by count(*) desc" ;
		Vector<Coffee> lists = new Vector<Coffee>();
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql) ; 
			
			rs = pstmt.executeQuery() ;
			
			while(rs.next()){
				Coffee coffee = new Coffee() ;
				coffee.setName(rs.getString("coffeename"));
				coffee.setPrice( rs.getInt("count(*)") ); 
				
				lists.add( coffee ) ;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			try {
				if(rs != null) {rs.close(); }
				if(pstmt != null) {pstmt.close(); }
				closeConnection() ;
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		return lists ;
	}//Getsellcount
	
	
	
	
	
	public Vector<Coffee> GetAllSellList() {//db에서 데이터를 받아서 벡터로 반환하는 메소드
		//모든 상품 목록들을 리턴한다.
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = "select * from coffee" ;
		Vector<Coffee> lists = new Vector<Coffee>();
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql) ; 
			
			rs = pstmt.executeQuery() ;
			
			while(rs.next()){
				Coffee coffee = new Coffee() ;
				coffee.setName(rs.getString("coffeename"));
				coffee.setSize(rs.getString("coffeesize"));
				coffee.setShot(rs.getString("shot"));
				coffee.setTemp(rs.getString("coffeetemp"));
				coffee.setPrice( rs.getInt("price") ); 
				
				lists.add( coffee ) ;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			try {
				if(rs != null) {rs.close(); }
				if(pstmt != null) {pstmt.close(); }
				closeConnection() ;
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		return lists ;
	}//GetAllSellList
		
	
	
	public Object[][] makeArr(Vector<Coffee> lists){//벡터를 받아서 전체를 2차원 배열로 만들어주는 메소드
		
		Object [][] coffeearr = new Object [lists.size()][5]; 
				
				
			for(int i=0; i<lists.size();i++){
				coffeearr[i][0]=lists.get(i).getName();
				coffeearr[i][1]=lists.get(i).getSize();
				coffeearr[i][2]=lists.get(i).getShot();
				coffeearr[i][3]=lists.get(i).getTemp();
				coffeearr[i][4]=lists.get(i).getPrice();
			}	
		
			
		return coffeearr;
		
	}//makeArr
	
	
	
	public Object[][] makelistArr(Vector<Coffee> lists){//벡터를 받아서 판대량을 2차원 배열로 만들어주는 메소드
		
		Object [][] coffeearr = new Object [lists.size()][2]; 
				
				
			for(int i=0; i<lists.size();i++){
				coffeearr[i][0]=lists.get(i).getName();
				coffeearr[i][1]=lists.get(i).getPrice();
			}	
		
			
		return coffeearr;
		
	}//makeArr

	
}
