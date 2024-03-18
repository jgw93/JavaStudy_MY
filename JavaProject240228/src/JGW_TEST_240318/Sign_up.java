package JGW_TEST_240318;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sign_up extends JFrame {
    // 데이터베이스 연결 정보
    static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String URL = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle 데이터베이스 URL
    static final String USER = "system"; // 데이터베이스 사용자 이름
    static final String PASS = "oracle"; // 데이터베이스 비밀번호

    private JTextField usernameField, emailField, passwordField;

    public Sign_up() {
        setTitle("회원가입");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("사용자 이름:");
        panel.add(usernameLabel);
        usernameField = new JTextField();
        panel.add(usernameField);

        JLabel emailLabel = new JLabel("이메일:");
        panel.add(emailLabel);
        emailField = new JTextField();
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("비밀번호:");
        panel.add(passwordLabel);
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton signUpButton = new JButton("회원가입");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });
        panel.add(signUpButton);
        
        JButton loginButton = new JButton("로그인");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 로그인 창 열기
                Sign_in signIn = new Sign_in();
                signIn.setVisible(true);
                // 현재 회원가입 창 닫기
                dispose();
            }
        });
        panel.add(loginButton);
        
        add(panel);
        setVisible(true);
    }

    private void signUp() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // JDBC 드라이버 로딩
            Class.forName(DRIVER);

            // 데이터베이스 연결
            conn = DriverManager.getConnection(URL, USER, PASS);

            // 사용자가 입력한 정보 가져오기
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();

            // 회원가입을 위한 SQL 쿼리 실행
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다.");

        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(this, "회원가입에 실패하였습니다.");
        } finally {
            // 자원 해제
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Sign_up();
            }
        });
    }
}
