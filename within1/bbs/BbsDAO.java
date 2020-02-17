package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BbsDAO {
	    
	private Connection conn;            // DB에 접근하는 객체
	//private PreparedStatement pstmt;    // 마찰이 일어나지 않도록 지워준다
	private ResultSet rs;                // DB data를 담을 수x 있는 객체  (Cmd + shift + 'o') -> auto import
	    
	public BbsDAO(){ 
		try {
			String dbURL = "jdbc:mysql://localhost:3306/BBS?serverTimezone=UTC";
	        String dbID = "root";
	        String dbPassword = "789789";
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public String getDate() { // 현재 서버의 시간을 넣어주는 함수 
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery(); // 쿼리 실행 	
			if (rs.next()) {
				return rs.getString(1); // 현재의 날짜를 반환
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ""; // database error
	}
	    

	public int getNext() { // 현재 게시판의 번호를 매겨주는 함수 
		String SQL = "SELECT bbsID FROM BBS ORDER BY bbsID DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery(); // 쿼리 실행 	
			if (rs.next()) {
				return rs.getInt(1) + 1; // 현재의 날짜를 반환
			}
			return 1; // 첫번쨰 게시글인 경우
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1; // database error
	}
	
	public int write(String bbsTitle, String userID, String bbsContent) {
		String SQL = "INSERT INTO BBS VALUE (?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, bbsTitle);
			pstmt.setString(3, userID);
			pstmt.setString(4, getDate());
			pstmt.setString(5, bbsContent);
			pstmt.setInt(6, 1); // available 이 삭제되지 않은 상태 
			rs = pstmt.executeQuery(); // 쿼리 실행 	
			if (rs.next()) {
				return rs.getInt(1) + 1; // 현재의 날짜를 반환
			}
			return 1; // 첫번쨰 게시글인 경우
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1; // database error
	}
	       
}
