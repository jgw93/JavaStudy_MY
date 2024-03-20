package JGW_TEST_240318;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import ex_240311_jdbc_member_with_swing_oracle.MemberDTO;
import ex_240311_jdbc_member_with_swing_oracle.Member_List;
import ex_240315.java_board.Boarder_DTO;
import ex_240315.java_board.Boarder_List;

public class ToolDAO {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "system"; // DB ID
	private static final String PASS = "oracle"; // DB 패스워드
	
	// 공구의 정보들을 출력하는 리스트
	Tool_list tList;

	public ToolDAO() {

	}
	public ToolDAO(Tool_list tList){
        this.tList = tList;
        System.out.println("DAO=>"+tList);

}
	/**DB연결 메소드*/
    public Connection getConn(){
        Connection con = null;
       
        try {
            Class.forName(DRIVER); //1. 드라이버 로딩
            con = DriverManager.getConnection(URL,USER,PASS); //2. 드라이버 연결
           
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        return con;
    }
    
    
    /**공구리스트 출력*/
    public Vector getToolList(){
       
        Vector data = new Vector();  //Jtable에 값을 쉽게 넣는 방법 1. 2차원배열   2. Vector 에 vector추가
       
           
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try{
           
            con = getConn();
            String sql = "select * from TOOLS order by toolname asc";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
           
            while(rs.next()){
                String toolname = rs.getString("toolname");
                String toolserial = rs.getString("toolserial");
                int inventory = rs.getInt("inventory");
                String location = rs.getString("location");
                String manager = rs.getString("manager");
            
               
                Vector row = new Vector();
                row.add(toolname);
                row.add(toolserial);
                row.add(inventory);
                row.add(location);
                row.add(manager);
               
                data.add(row);             
            }//while
        }catch(Exception e){
            e.printStackTrace();
        }
        return data;
    }//getToolList()
    
    /** DB데이터 다시 불러오기 */
	public void boarderSelectAll(DefaultTableModel model) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = getConn();
			String sql = "select * from TOOLS order by toolname dsc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			// DefaultTableModel에 있는 데이터 지우기
			for (int i = 0; i < model.getRowCount();) {
				model.removeRow(0);
			}

			while (rs.next()) {
				// 각 행마다, 컬럼들이 6개씩 있음.
				Object data[] = { rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), };

				// 테이블에 각행을 각각 추가함.
				model.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> boarderSelectAll fail");
		} finally {

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	/** 게시글 등록 */
	public boolean insertBoarder(ToolDTO dto) {

		// 상태 변수로 사용 중, 글쓰기 메서드가 완료가 되면, true 변경 할 예정.
		boolean ok = false;

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령

		try {

			con = getConn();
			String sql = "insert into TOOLS(" + "toolname,toolserial,inventory,location,manager)"
					+ "values(TOOLS.NEXTVAL,?,?,?,?)";
			// dto 에 각 게시글의 내용들이 담겨 있는 모델 박스라 생각하기.
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getToolname());
			ps.setString(2, dto.getToolserial());
			ps.setString(3, dto.getInventory());
			ps.setString(4, dto.getManager());
			
			int r = ps.executeUpdate(); // 실행 -> 저장

			if (r > 0) {
				System.out.println("수정 성공");
				ok = true;
			} else {
				System.out.println("수정 실패");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}// ToolInventory
	
	/** 한사람의 회원 정보를 얻는 메소드 
	 * @param Toolname */
	public ToolDTO getToolDTO(String Toolname) {

		// 임시로 메모리에 담아둘 공간.
		ToolDTO dto = new ToolDTO();

		Connection con = null; // 연결
		PreparedStatement ps = null; // 명령
		ResultSet rs = null; // 결과

		try {

			con = getConn();
			String sql = "select * from TOOLS where toolname=?";
			// sql 을 전달하는 기능
			ps = con.prepareStatement(sql);
			// ? 동적 매개변수에 값을 넣기
			ps.setString(1, Toolname);
			// 조회시 사용하는 메서드
			rs = ps.executeQuery();
			// 하나의 게시글을 받아와서, 각 컬럼을 반복문으로 순회하면서, 값을 가져오기.
			// 가져온 데이터를 DTO 하는 게시글을 담는 박스에 담기.
			if (rs.next()) {
				dto.setToolname(rs.getString("Toolname"));
				dto.setToolserial(rs.getString("Toolserial"));
				dto.setInventory(rs.getString("Inventory"));
				dto.setLocation(rs.getString("Location"));
				dto.setManager(rs.getString("Manager"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	// 게시글 삭제
	// 예전에는, 탈퇴 여부 상태 변수를 이용해서, 회원정보를 가지고 있었다면,
	// 이제는 개인정보처리방침리 변경이 되러서, 회원이 요청, 탈퇴시,
	// 해당 데이터를 어떻게 처리할지는 명확히 명시 해야함.
	// 나의 정보를 모두 삭제 가능하게 해줘야하고,
	// 게시글, 로그인 후 -> 작성,
	// 내가 작성한 글만, 수정, 삭제 할수있음.
	// 로그인, 회원가입 없어서, 단순 삭제만 구현중.

	public boolean deleteBoarder(int id) {

		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = getConn();
			String sql = "delete from TOOLS where toolname=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			int r = ps.executeUpdate(); // 실행 -> 삭제

			if (r > 0)
				ok = true; // 삭제됨;

		} catch (Exception e) {
			System.out.println(e + "-> 오류발생");
		}
		return ok;
	}

	// 게시글 수정.
	public boolean updateBoarder(ToolDTO vMem) {
		System.out.println("dto=" + vMem.toString());
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {

			con = getConn();
			String sql = "update TOOL set inventory=?, location=?";
					

			ps = con.prepareStatement(sql);

			ps.setString(1, vMem.getInventory());
			ps.setString(2, vMem.getLocation());
			
			

			int r = ps.executeUpdate(); // 실행 -> 수정
			// 1~n: 성공 , 0 : 실패

			if (r > 0)
				ok = true; // 수정이 성공되면 ok값을 true로 변경

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}



}