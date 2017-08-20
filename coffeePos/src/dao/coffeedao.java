package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.print.attribute.standard.PresentationDirection;

import bean.Coffee;
import bean.Stock;


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

	public int coffeeadd(Coffee bean){//서버에 판매정보 저장
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
	
	
	public int stockorder(Stock stock){// 이건재고 데이터 업데이트
		int result =0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update stock set wondu=?, milk=?, sirup=?, berry=?, mango=?, green=?, black=?, choco=?" ;
		
		try {
			conn = getConnection() ;
			conn.setAutoCommit(false);

			pstmt = conn.prepareStatement(sql); 
						
			pstmt.setInt(1, stock.getWondu());
			pstmt.setInt(2, stock.getMilk());
			pstmt.setInt(3, stock.getSirup());
			pstmt.setInt(4, stock.getBerry());
			pstmt.setInt(5, stock.getMango());
			pstmt.setInt(6, stock.getGreen());
			pstmt.setInt(7, stock.getBlack());
			pstmt.setInt(8, stock.getChoco());
								
			result = pstmt.executeUpdate() ;
			conn.commit();
									
		}catch (SQLException e) {
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
	}//coffeestock
	
	
	
	
	
	
	public  Vector<Coffee> Getsellcount(){// 오늘 판매된 음료
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
		return lists;
	}//Getsellcount
	
	
	public Stock getstock(){//서버에서 재고데이터 가져오기
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql = "select * from stock" ;		
		Stock stock=null;
		try {
			conn = getConnection() ;
			pstmt = conn.prepareStatement(sql) ; 
			
			rs = pstmt.executeQuery() ;
			
			while(rs.next()){
				stock = new Stock() ;
				
				stock.setWondu(rs.getInt("wondu"));
				stock.setMilk(rs.getInt("milk"));
				stock.setSirup(rs.getInt("sirup"));
				stock.setBerry(rs.getInt("berry"));
				stock.setMango(rs.getInt("mango"));
				stock.setGreen(rs.getInt("green"));
				stock.setBlack(rs.getInt("black"));
				stock.setChoco(rs.getInt("choco"));
				
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
		return stock ;
	}//getstock
	
	
	/*
	public void stockorder(){ //재고주문
		
		
		
	}//stockorder
	
	*/
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
				coffee.setPrice(rs.getInt("price")); 
				
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

	
	public Object[][] makestocklistArr(Stock lists){//스탁을 받아서 오브젝트로 만들어줌
		
		Object [][] coffeearr = new Object [1][8]; 
				
			coffeearr[0][0]=lists.getWondu();
			coffeearr[0][1]=lists.getMilk();
			coffeearr[0][2]=lists.getSirup();
			coffeearr[0][3]=lists.getBerry();
			coffeearr[0][4]=lists.getMango();
			coffeearr[0][5]=lists.getGreen();
			coffeearr[0][6]=lists.getBlack();
			coffeearr[0][7]=lists.getChoco();
			
		return coffeearr;
		
	}//makestocklistArr
	
	
	
	
}
