package JGW_TEST_240318;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Sign_in extends JFrame implements ActionListener {
	// 데이터베이스 연결 정보
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle 데이터베이스 URL
	static final String USER = "system"; // 데이터베이스 사용자 이름
	static final String PASS = "oracle"; // 데이터베이스 비밀번호
	;

	private JTextField emailField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JButton signUpButton;

	public Sign_in() {
		setTitle("로그인");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2));

		panel.add(new JLabel("이메일:"));
		emailField = new JTextField();
		panel.add(emailField);

		panel.add(new JLabel("비밀번호:"));
		passwordField = new JPasswordField();
		panel.add(passwordField);

		loginButton = new JButton("로그인");
		loginButton.addActionListener(this);
		panel.add(loginButton);
		
		signUpButton = new JButton("회원가입");
        signUpButton.addActionListener(this);
        panel.add(signUpButton);

		add(panel);
	}

	@Override
	
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // 로그인 버튼 클릭 시 로그인 기능 수행
            performLogin();
        } else if (e.getSource() == signUpButton) {
            // 회원가입 버튼 클릭 시 회원가입 창 띄우기
            new Sign_up().setVisible(true);
        }
    }
	
	public void performLogin() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				// JDBC 드라이버 로딩
				Class.forName(JDBC_DRIVER);

				// 데이터베이스 연결
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				// 입력 받은 이메일과 비밀번호
				String email = emailField.getText();
				String password = new String(passwordField.getPassword());

				// SQL 문 실행을 위한 PreparedStatement 객체 생성
				String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, email);
				pstmt.setString(2, password);

				// SQL 실행 및 결과셋 받기
				rs = pstmt.executeQuery();

				// 결과셋에 데이터가 있다면 로그인 성공
				if (rs.next()) {
					JOptionPane.showMessageDialog(this, "로그인 성공!");
				} else {
					JOptionPane.showMessageDialog(this, "로그인 실패: 이메일 또는 비밀번호가 일치하지 않습니다.");
				}

			} catch (SQLException | ClassNotFoundException se) {
				se.printStackTrace();
			} finally {
				// 자원 해제
				try {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Sign_in loginFrame = new Sign_in();
			loginFrame.setVisible(true);
		});
	}
}
