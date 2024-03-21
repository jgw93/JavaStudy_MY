package JGW_TEST_240318;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolProc2 extends JFrame implements ActionListener {
	private JTextField tfToolname;
	private JTextField tfToolserial;
	private JTextField tfInventory;
	private JTextField tfLocation;
	private JTextField tfManager;
	private JButton btnSave;

	public ToolProc2(String toolname, String toolserial, int inventory, String location, String manager) {
		setTitle("재고 관리");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, 300);

		JPanel mainPanel = new JPanel(new BorderLayout());

		JPanel panel = new JPanel(new GridLayout(0, 1)); // 0행으로 지정하여 세로로 정렬

		panel.add(new JLabel("공구명:"));
		tfToolname = new JTextField(20);
		// tfToolname.setEditable(false); // 수정 불가능하도록 설정
		panel.add(tfToolname);

		panel.add(new JLabel("공구 관리 번호:"));
		tfToolserial = new JTextField(20);
		// tfToolserial.setEditable(false);
		panel.add(tfToolserial);

		panel.add(new JLabel("재고:"));
		tfInventory = new JTextField(20);
		panel.add(tfInventory);

		panel.add(new JLabel("위치:"));
		tfLocation = new JTextField(20);
		panel.add(tfLocation);

		panel.add(new JLabel("관리자:"));
		tfManager = new JTextField(20);
		// tfManager.setEditable(false);
		panel.add(tfManager);

		btnSave = new JButton("Save");
		btnSave.addActionListener(this);

		JPanel centerPanel = new JPanel(new GridLayout(0, 1)); // 0행으로 지정하여 세로로 정렬
		centerPanel.add(panel);

		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(btnSave, BorderLayout.SOUTH);

		add(mainPanel);
		setVisible(true);

//		setTitle("재고 관리");
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 창을 닫을 때 창만 닫히도록 설정
//		setSize(400, 300);
//		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSave) {
			saveTool();
		}
	}

	private void saveTool() {
		String toolname = tfToolname.getText();
		String toolserial = tfToolserial.getText();
		int inventory = Integer.parseInt(tfInventory.getText());
		String location = tfLocation.getText();
		String manager = tfManager.getText();

		// 여기에 ToolDAO2를 이용하여 데이터베이스에 저장하는 코드 작성
		ToolDAO2 toolDAO = new ToolDAO2();
		boolean isSuccess = toolDAO.saveTool(toolname, toolserial, inventory, location, manager);

		if (isSuccess) {
			JOptionPane.showMessageDialog(this, "저장 성공!");
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "저장 실패: 데이터베이스에 저장할 수 없습니다.");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new ToolProc2("", "", 0, "", ""));
	}
}