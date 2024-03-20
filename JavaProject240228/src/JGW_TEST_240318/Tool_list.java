package JGW_TEST_240318;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ex_240315.java_board.Boarder_DAO;
import ex_240315.java_board.Boarder_Proc;

public class Tool_list extends JFrame implements MouseListener,ActionListener {
	
	//동기화를 지원 해주는 컬렉션의 리스트
    Vector v;  
    Vector cols;
    // 테이블 기능을 지원해주는 인스턴스
    DefaultTableModel model;
    // 표 형식
    JTable jTable;
    // 스크롤
    JScrollPane pane;
    // 패널은 창에 추가로 붙이는 공간
    JPanel pbtn;
    // 버튼.
    JButton btnInsert;
    
 // 생성자
 	Tool_list() {
 		// 부모 JFrame의 제목을 설정하는 생성자.
 		super("공구재고");
 		// v=getMemberList();
 		// MemberDAO
 		// 데이터베이스에 접근 및 crud 기능이 있음.
 		ToolDAO dao = new ToolDAO();
 		// 디비 내용을 조회한 결과를 받아두기.
 		// 순서 있는 리스트
 		v = dao.getToolList();
 		//
 		System.out.println("v=" + v);
 		// 각 열의 정보를 의미.
 		// cols , 벡터 타입의 리스트
 		cols = getColumn();
 		// Vector v; 데이터베이스에서 조회한 전체 게시글들
 		// Vector cols; 헤더명
 		model = new DefaultTableModel(v, cols);

 		// 자바에서 지원해주는 표 형식.
 		jTable = new JTable(model);
 		// 스크롤 기능을 해당 패널에 추가.
 		pane = new JScrollPane(jTable);
 		// 프레임이라는 창에 , 요소 붙이기.
 		add(pane);

 		// 버튼을 붙이는 패널 , 캔버스
 		pbtn = new JPanel();
 		// 버튼
 		btnInsert = new JButton("글쓰기");
 		// 버튼을 붙이는 패널 , 버튼 붙이기.
 		pbtn.add(btnInsert);
 		add(pbtn, BorderLayout.NORTH);

 		// 이벤트 핸들러 등록,
 		// 인터페이스이고, -> 추상메서드를 가지고 있으니, 필수 재정의 해주기.
 		// 결론, 액션의 역할, 새로운 입력창을 불러오기.
 		jTable.addMouseListener(this); // 리스너 등록
 		btnInsert.addActionListener(this); // 회원가입버튼 리스너 등록

 		setSize(600, 200);
 		setVisible(true);
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	}
    
    private Vector getColumn() {
    	Vector col = new Vector();
		col.add("공구이름");
		col.add("공구번호");
		col.add("재고");
		col.add("위치");
		col.add("관리자");
		return col;
	}// getColumn

	// Jtable 내용 갱신 메서드
	public void jTableRefresh() {

		ToolDAO dao = new ToolDAO();
		DefaultTableModel model = new DefaultTableModel(dao.getToolList(), getColumn());
		jTable.setModel(model);

	}		


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼을 클릭하면
				if (e.getSource() == btnInsert) {
					new ToolProc(this);}
		
	}

	// 리스트 -> 한 게시글 선택 -> 새로운 창 나오고
		// 그 창에 -> 하나의 게시글 정보를 불러오기 -> 해당 화면에 넣기.
		@Override
		public void mouseClicked(MouseEvent e) {
			// mouseClicked 만 사용
			// 클릭시 해당 번호를 가지고 온다.
			int r = jTable.getSelectedRow();
			System.out.println("클릭시 클릭된 행번호 확인: " + r);
			// 테이블에서 선택된 행의 첫번째 컬럼의 값을 가져오는데, 반환 타입 object,
			// object -> Integer -> int, 형변환
			int id = (Integer) jTable.getValueAt(r, 0);
			System.out.println("클릭시 클릭된 id 조회: " + id);
			// System.out.println("id="+id);
			// 인자, 선택된 게시글의 아이디와, Boarder_List 타입의 인스턴스를 전달(this)
			// Boarder_Proc: 글쓰기 사용했던 창. 이 화면을 재사용을해서,
			// 수정 폼으로도 사용하고 있음.
			ToolProc mem = new ToolProc(); // 아이디를 인자로 수정창 생성

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
