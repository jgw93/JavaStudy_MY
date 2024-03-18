package JGW_TEST_240318;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ex_240311_jdbc_member_with_swing_oracle.MemberDTO;
import ex_240311_jdbc_member_with_swing_oracle.Member_List;

public class ToolDAO {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USER = "system"; // DB ID
	private static final String PASS = "oracle"; // DB 패스워드
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
    
    /**공구 재고 정보를 얻는 메소드*/
    public ToolDTO getToolDTO(String id){
       
        MemberDTO dto = new ToolDTO();
       
        Connection con = null;       //연결
        PreparedStatement ps = null; //명령
        ResultSet rs = null;         //결과
       
        try {
           
            con = getConn();
            String sql = "select * from TB_MEMBER where id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
           
            rs = ps.executeQuery();
           
            if(rs.next()){
                dto.setId(rs.getString("id"));
                dto.setPwd(rs.getString("Pwd"));
                dto.setName(rs.getString("Name"));
                dto.setTel(rs.getString("tel"));
                dto.setAddr(rs.getString("addr"));
                dto.setBirth(rs.getString("birth"));
                dto.setJob(rs.getString("job"));
                dto.setGender(rs.getString("gender"));
                dto.setEmail(rs.getString("email"));
                dto.setIntro(rs.getString("intro"));
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }      
       
        return dto;    
    }
}