package JGW_TEST_240318;

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
    
    public Tool_list() {
    	super("공구 재고 관리");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
