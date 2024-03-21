package JGW_TEST_240318;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ToolDAO2 {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "system";
	private static final String PASS = "oracle";

	public boolean saveTool(String toolname, String toolserial, int inventory, String location, String manager) {
		// 입력값이 유효한지 검사
		if (toolname.isEmpty() || toolserial.isEmpty() || location.isEmpty() || manager.isEmpty()) {
			// 빈칸이 있을 경우 저장 실패
			return false;
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false; // 저장 성공 여부를 나타내는 변수

		try {
			// JDBC 드라이버 로딩
			Class.forName(DRIVER);

			// 데이터베이스 연결
			con = DriverManager.getConnection(URL, USER, PASS);

			// SQL 문 실행을 위한 PreparedStatement 객체 생성
			String sql = "INSERT INTO tools (toolname, toolserial, inventory, location, manager) VALUES (?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, toolname);
			pstmt.setString(2, toolserial);
			pstmt.setInt(3, inventory);
			pstmt.setString(4, location);
			pstmt.setString(5, manager);

			// SQL 실행
			int affectedRows = pstmt.executeUpdate();

			// 저장이 성공했으면 affectedRows 값이 1 이상이 됨
			if (affectedRows > 0) {
				isSuccess = true; // 저장 성공
			}
		} catch (SQLException | ClassNotFoundException se) {
			se.printStackTrace();
		} finally {
			// 자원 해제
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return isSuccess; // 저장 성공 여부 반환
	}

	// TOOLS 테이블에 대한 CRUD 메서드 작성
	public List<ToolDTO2> getAllTools() {
		List<ToolDTO2> tools = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM TOOLS");
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				ToolDTO2 tool = new ToolDTO2();
				tool.setToolname(rs.getString("toolname"));
				tool.setToolserial(rs.getString("toolserial"));
				tool.setInventory(rs.getInt("inventory"));
				tool.setLocation(rs.getString("location"));
				tool.setManager(rs.getString("manager"));
				tools.add(tool);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tools;
	}

	public boolean deleteTool(String toolname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean isSuccess = false;

		try {
			// JDBC 드라이버 로딩
			Class.forName(DRIVER);

			// 데이터베이스 연결
			conn = DriverManager.getConnection(URL, USER, PASS);

			// SQL 문 실행을 위한 PreparedStatement 객체 생성
			String sql = "DELETE FROM tools WHERE toolname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, toolname);

			// SQL 실행
			int affectedRows = pstmt.executeUpdate();

			// 삭제가 성공했으면 affectedRows 값이 1 이상이 됨
			if (affectedRows > 0) {
				isSuccess = true; // 삭제 성공
			}
		} catch (SQLException | ClassNotFoundException se) {
			se.printStackTrace();
		} finally {
			// 자원 해제
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return isSuccess; // 삭제 성공 여부 반환
	}
}
