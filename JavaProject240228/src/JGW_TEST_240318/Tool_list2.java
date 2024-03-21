package JGW_TEST_240318;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class Tool_list2 extends JFrame implements MouseListener, ActionListener {
	private JTable jTable;

	// 패널은 창에 추가로 붙이는 공간
	JPanel pbtn;
	// 버튼.
	JButton btnInsert;
	JButton btnRefresh; // 새로고침 버튼 추가
	JButton btnDelete; // 삭제 버튼 추가

	public Tool_list2() {
		setTitle("공구 재고 현황");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("공구명");
		model.addColumn("공구 관리 번호");
		model.addColumn("재고");
		model.addColumn("위치");
		model.addColumn("관리자");

		jTable = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(jTable);
		add(scrollPane);

		// displayTools 메서드를 생성자 내에서 호출하도록 변경
		displayTools();

		setVisible(true);

		// 버튼을 붙이는 패널, 캔버스
		pbtn = new JPanel();
		btnInsert = new JButton("재고 관리");
		// 버튼을 붙이는 패널, 버튼 붙이기.
		pbtn.add(btnInsert);
		add(pbtn, BorderLayout.SOUTH);
		btnInsert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 버튼을 클릭했을 때 ToolProc2를 생성하고 표시
				ToolProc2 toolProc2 = new ToolProc2("", "", 0, "", "");
				toolProc2.setVisible(true);
			}
		});

		btnRefresh = new JButton("새로고침"); // 새로고침 버튼 생성
		pbtn.add(btnRefresh);
		btnRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshTable(); // 새로고침 버튼 클릭 시 테이블 갱신
			}
		});

		btnDelete = new JButton("삭제");
		pbtn.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteSelectedRow(); // 삭제 버튼 클릭 시 선택된 행 삭제
			}
		});

		JButton btnLogout = new JButton("로그아웃");
		pbtn.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 로그아웃 버튼을 클릭했을 때
				// 현재 창을 닫고 Sign_in 창을 보여줌
				dispose(); // 현재 창 닫기
				new Sign_in().setVisible(true); // Sign_in 창 열기
			}
		});

		// 테이블의 행을 더블 클릭할 때 수정 창 열기
//		jTable.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				if (e.getClickCount() == 2) { // 더블 클릭했을 때
//					int selectedRow = jTable.getSelectedRow();
//					if (selectedRow != -1) { // 선택된 행이 있을 때
//						String toolname = (String) model.getValueAt(selectedRow, 0);
//						String toolserial = (String) model.getValueAt(selectedRow, 1);
//						int inventory = (int) model.getValueAt(selectedRow, 2);
//						String location = (String) model.getValueAt(selectedRow, 3);
//						String manager = (String) model.getValueAt(selectedRow, 4);
//						new ToolProc2(toolname, toolserial, inventory, location, manager).setVisible(true);
//					}
//				}
//			}
//		});
	}

	public void displayTools() {
		DefaultTableModel model = (DefaultTableModel) jTable.getModel();
		model.setRowCount(0);

		ToolDAO2 toolDAO = new ToolDAO2();
		List<ToolDTO2> tools = toolDAO.getAllTools();

		for (ToolDTO2 tool : tools) {
			model.addRow(new Object[] { tool.getToolname(), tool.getToolserial(), tool.getInventory(),
					tool.getLocation(), tool.getManager() });
		}
	}

	// 테이블 새로고침 메서드
	private void refreshTable() {
		DefaultTableModel model = (DefaultTableModel) jTable.getModel();
		model.setRowCount(0); // 테이블 초기화
		displayTools(); // 데이터 다시 가져와서 테이블에 채우기
	}

	private void deleteSelectedRow() {
		DefaultTableModel model = (DefaultTableModel) jTable.getModel();
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow != -1) { // 선택된 행이 있을 때만 삭제 진행
			String toolname = (String) model.getValueAt(selectedRow, 0);
			ToolDAO2 toolDAO = new ToolDAO2();
			toolDAO.deleteTool(toolname); // 선택된 행의 공구명을 이용하여 데이터베이스에서 해당 데이터 삭제
			JOptionPane.showMessageDialog(this, "삭제 완료");
			refreshTable(); // 테이블 새로고침
		} else {
			JOptionPane.showMessageDialog(this, "삭제할 행을 선택하세요.", "알림", JOptionPane.WARNING_MESSAGE);
		}
	}

	public static void main(String[] args) {
		new Tool_list2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		if (e.getClickCount() == 1) { // 한 번 클릭한 경우
//			int selectedRow = jTable.getSelectedRow();
//			if (selectedRow != -1) { // 선택된 행이 있을 때
//				DefaultTableModel model = (DefaultTableModel) jTable.getModel();
//				String toolname = (String) model.getValueAt(selectedRow, 0);
//				String toolserial = (String) model.getValueAt(selectedRow, 1);
//				int inventory = (int) model.getValueAt(selectedRow, 2);
//				String location = (String) model.getValueAt(selectedRow, 3);
//				String manager = (String) model.getValueAt(selectedRow, 4);
//
//				// 선택된 행의 정보를 이용하여 ToolProc2 수정 창 띄우기
//				ToolProc2 editWindow = new ToolProc2(toolname, toolserial, inventory, location, manager);
//				editWindow.setVisible(true);
//			}
//		}
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
