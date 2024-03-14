package ex_240314_JDBC_TEST2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.AbstractDocument.Content;

public class JDBC_TEST2_DAO {
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final static String USER_ID = "system";
	 private static final String USER_PASS = "oracle";
	
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	
	public static void select() throws ClassNotFoundException, SQLException {
		

		try {
			
			Class.forName(DRIVER);
			

			
			con = DriverManager.getConnection(URL, USER_ID, USER_PASS);
				

			
			String query = "SELECT id,name,content,date_created FROM Test_Board";

		
			pstmt = con.prepareStatement(query);


			
			rs = pstmt.executeQuery();

			
			while (rs.next()) {
				String user_id = rs.getString("id");
				String user_pwd = rs.getString("pwd");
				String user_name = rs.getString("name");
				System.out.println("ID: " + user_id + ", PWD: " + user_pwd + ", NAME: " + user_name);
			}

		} catch (SQLException e) {
	
			e.printStackTrace();
		} finally {
		
			rs.close();
			pstmt.close();
			con.close();
		}
	}

	
	public static void insert(String id, String pwd, String name) throws SQLException {
		
		try {
			Class.forName(DRIVER);
		
			con = DriverManager.getConnection(URL, USER_ID, USER_PASS);
			
			String query = "INSERT INTO Test_Board (ID, NAME, CONTENT, DATE_CREATED)" + "VALUES(?,?,?)";
		
			pstmt = con.prepareStatement(query);
		
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
		
			int resultNum = pstmt.executeUpdate();
			System.out.println("레코드가 " + resultNum + "개 저장되었습니다.");

		
		} catch (Exception e) {

		} finally {
			
			rs.close();
			pstmt.close();
			con.close();
		}
	}


	public static void delete(String id) throws SQLException {
	
		try {
			Class.forName(DRIVER);
		
			con = DriverManager.getConnection(URL, USER_ID, USER_PASS);

			
			String query = "DELETE FROM TEST_JAVA WHERE ID = ?";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);

		
			int resultNum = pstmt.executeUpdate();
			System.out.println("레코드가 " + resultNum + "개 삭제되었습니다.");

		
		} catch (Exception e) {
			
		} finally {
			
			rs.close();
			pstmt.close();
			con.close();
		}
	}


	public static void update(String id, String pwd, String name) throws SQLException {
	
		try {
			Class.forName(DRIVER);
		
			con = DriverManager.getConnection(URL, USER_ID, USER_PASS);

			
			String query = "UPDATE Test_Board SET PWD=?, NAME=? WHERE ID = ?";
		
			pstmt = con.prepareStatement(query);
		
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, content);
			pstmt.setString(4, date_created);

		
			int resultNum = pstmt.executeUpdate();
			System.out.println("레코드가 " + resultNum + "개 수정되었습니다.");

		
		} catch (Exception e) {
			
		} finally {
		
			rs.close();
			pstmt.close();
			con.close();
		}
	}

}

	