package JGW_TEST_240318;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ex_240315.java_board.Boarder_DAO;
import ex_240315.java_board.Boarder_DTO;
import ex_240315.java_board.Boarder_List;
import ex_240315.java_board.Boarder_Proc;

public class ToolProc extends JFrame implements ActionListener{
	
	ToolDTO temp_dto;
	
	
	// 글쓰기 창,
		// 게시글의 상세보기 창.

		JPanel p;
//		작성자(자동)-> 임시 수동입력, 제목, 내용
		JTextField tfInventory, tfLocation;
		// 본문의 내용
		JTextArea tfContent;
		JButton btnInsert, btnCancel, btnUpdate, btnDelete; // 글쓰기, 취소, 수정 , 삭제 버튼

		GridBagLayout gb;
		GridBagConstraints gbc;
		Tool_list Tool_list;

		public ToolProc() { // 글쓰기용 생성자

			createUI(); // UI작성해주는 메소드
			btnUpdate.setEnabled(false);
			btnUpdate.setVisible(false);
			btnDelete.setEnabled(false);
			btnDelete.setVisible(false);

		}// 생성자

		public ToolProc(Tool_list Tool_list) { // 가입용 생성자

			createUI(); // UI작성해주는 메소드
			btnUpdate.setEnabled(false);
			btnUpdate.setVisible(false);
			btnDelete.setEnabled(false);
			btnDelete.setVisible(false);
			this.Tool_list = Tool_list;

		}// 생성자

		public ToolProc(String id, Tool_list Tool_list) { // 수정/삭제용 생성자
			createUI();
			// 수정하기 위한 화면으로 사용해서, 글쓰기 버튼 기능 비활성화.
			btnInsert.setEnabled(false);
			// 화면에서 안보이게 설정
			btnInsert.setVisible(false);
			
			// 작성자는 읽기 전용
			tfInventory.setEnabled(false);
			this.Tool_list = Tool_list;

			System.out.println("id=" + id);


			ToolDAO dao = new ToolDAO();
			// 하나의 게시글을 조회하는 기능.
			// 박스에, 해당 게시글 아이디로 조회해서, 조회된 내용을 박스에 담아두기.
			ToolDTO vMem = dao.getToolDTO(id);
			
			// 상세보기 할 때, 조회한 게시글을 임시로 담아둘 인스턴스에 할당하기.
			temp_dto = vMem;
			
			viewData(vMem);

		}// id를 가지고 생성

		// 순서5
		// 화면에 붙이기.
		private void viewData(ToolDTO vMem) {

			String toolname = vMem.getToolname();
			String toolsireal = vMem.getToolserial();
			String inventory = vMem.getInventory();
			String location = vMem.getLocation();
			String manager = vMem.getManager();

			// 화면에 세팅, 수정 폼에
			tfInventory.setText(String.valueOf(inventory));
			tfLocation.setText(location);

		}// viewData
		
		private void createUI() {
			this.setTitle("글쓰기 폼");
			// 표 형태의 배치 관리자. 4 x 2, 행 x 열
			gb = new GridBagLayout();
			// 정렬 형태를 지정.
			setLayout(gb);
			// 표 형태의 옵션, 가로, 세로 크기, 또는 전체를 가득 채우기 등.
			gbc = new GridBagConstraints();
			// 가로, 세로 가득 채우기.
			gbc.fill = GridBagConstraints.BOTH;
			// 크기
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;

			// 작성자
			JLabel bId = new JLabel("작성자 : ");
			tfInventory = new JTextField(20);
			// 그리드백에 붙이기
			gbAdd(bId, 0, 0, 1, 1);
			gbAdd(tfInventory, 1, 0, 3, 1);

			// 제목
			JLabel bPwd = new JLabel("제목 : ");
			tfLocation = new JTextField(20);
			gbAdd(bPwd, 0, 1, 1, 1);
			gbAdd(tfLocation, 1, 1, 3, 1);

			// 내용
			JLabel bIntro = new JLabel("내용: ");
			tfContent = new JTextArea(5, 20); // 행 : 열
			JScrollPane pane = new JScrollPane(tfContent);
			gbAdd(bIntro, 0, 9, 1, 1);

			gbAdd(pane, 1, 9, 3, 1);

			// 버튼
			JPanel pButton = new JPanel();
			btnInsert = new JButton("글쓰기");
			btnUpdate = new JButton("수정");
			btnDelete = new JButton("삭제");
			btnCancel = new JButton("취소");
			pButton.add(btnInsert);
			pButton.add(btnUpdate);
			pButton.add(btnDelete);
			pButton.add(btnCancel);
			gbAdd(pButton, 0, 10, 4, 1);

			// 버튼에 감지기를 붙이자
			btnInsert.addActionListener(this);
			btnUpdate.addActionListener(this);
			btnCancel.addActionListener(this);
			btnDelete.addActionListener(this);

			setSize(350, 500);
			setVisible(true);
			// setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //프로그램종료
			setDefaultCloseOperation(DISPOSE_ON_CLOSE); // dispose(); //현재창만 닫는다.

		}// createUI

		// 그리드백레이아웃에 붙이는 메소드
		private void gbAdd(JComponent c, int x, int y, int w, int h) {
			gbc.gridx = x;
			gbc.gridy = y;
			gbc.gridwidth = w;
			gbc.gridheight = h;
			gb.setConstraints(c, gbc);
			gbc.insets = new Insets(2, 2, 2, 2);
			add(c, gbc);
		}// gbAdd

		public static void main(String[] args) {
			new ToolProc();
		}

		// 1. 글쓰기 이벤트 핸들러 추가하기.
		@Override
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource() == btnInsert) {
				insertBoarder();
				System.out.println("insertMember() 호출 종료");
			} else if (ae.getSource() == btnCancel) {
				this.dispose(); // 창닫기 (현재창만 닫힘)
				// system.exit(0)=> 내가 띄운 모든 창이 다 닫힘
			} else if (ae.getSource() == btnUpdate) {
				// 업데이트 할 때, 인자값으로, 현재 선택된 게시글의 모든 정보가 담겨있는 박스 전달.
				// Boarder_DTO를 전달
				// 상세 보기로 클릭시, 박스에 담아두었던 게시글의 내용을 임시박스에 담아서 전달
				// 수정을 할려면 제목,내용만 변경하면 되고 나머지 기존내용은 불러옴.
				UpdateBoarder(temp_dto);
			} else if (ae.getSource() == btnDelete) {
				// int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?");
				int x = JOptionPane.showConfirmDialog(this, "정말 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);

				if (x == JOptionPane.OK_OPTION) {
					// 전역으로 설정된, 선택된 id를 가져오기.
					//deleteBoarder(selectedRowNumber);
				} else {
					JOptionPane.showMessageDialog(this, "삭제를 취소하였습니다.");
				}
			}

			// jTable내용 갱신 메소드 호출
			Tool_list.jTableRefresh();
		}
		
		// 글쓰기 기능
		private void insertBoarder() {

			// 화면에서 사용자가 입력한 내용을 얻는다.
			// 화면에서 입력받은, 작성자, 제목, 내용을 담고 있는 모델 박스(DTO)
			// 임시 메모리에 저장이 되어있는것 -> DB 로 전달.
			ToolDTO dto = getViewData();
			// DAO(Data Access Object), 디비로 전달하는 도구. (글쓰기, 수정, 삭제도 할 예정)
		    ToolDAO dao = new ToolDAO();
			// 디비에 저장하고, 리턴 완료 true
			boolean ok = dao.insertBoarder(dto);

			if (ok) {

				JOptionPane.showMessageDialog(this, "글쓰기 성공.");
				// 종료.
				dispose();

			} else {

				JOptionPane.showMessageDialog(this, "글쓰기 실패.");
			}
		}
			// insertMember
			
			// 기능: 하나의 게시글의 조회하는 목적.
			// 게시글 작성시, 화면에 있는 글을 가지고 온다.
			public ToolDTO getViewData() {

				// 화면에서 사용자가 입력한 내용을 얻는다.
				ToolDTO dto = new ToolDTO();
				// JTextField tfWriter, tfSubject;
				// 본문의 내용
				// JTextArea tfContent;
				String writer = tfInventory.getText();
				String subject = tfLocation.getText();
				// 등록 날짜, 시간 자동
				String regDate = LocalDate.now().toString();
				String regTime = LocalTime.now().toString();
				String regDateTimeString = regDate + regTime;
				// String regDate2 = regDate.toString();
				// 조회수 카운트, 자동
				int viewsCount = 0;

				// 입력 받은 값을 넣는 작업.
				// dto : 게시글 하나 작성하기 위해 필요한 내용을 담고 있다.
				//dto.setInventory(tfInventory);
				//dto.setLocation(tfLocation);
				

				// 임시로 모델 박스에, 화면에서 입력받은 내용을 메모리에 임시저장.

				return dto;
			}
			
			// 수정하기 용으로 사용할 메서드,
			public ToolDTO getViewUpdateData(ToolDTO toolDTO) {

				// 화면에서 사용자가 입력한 내용을 얻는다.
				ToolDTO dto = new ToolDTO();
				// JTextField tfWriter, tfSubject;
				// 본문의 내용
				// JTextArea tfContent;
				String inventory = tfInventory.getText();
				String Location = tfLocation.getText();
				// 등록 날짜, 시간 자동
				String UpdateDate = LocalDate.now().toString();
				String UpdateTime = LocalTime.now().toString();
				String UpdateDateTimeString = UpdateDate + UpdateTime;

				// 입력 받은 값을 넣는 작업.
				// dto : 게시글 하나 작성하기 위해 필요한 내용을 담고 있다.
				//toolDTO.setInventory(inventory);
				//toolDTO.setLocation(Location);
				// 우리가 자동으로 넣어주기로 함.
				//toolDTO.setRegDate(UpdateDateTimeString);

				// 임시로 모델 박스에, 화면에서 입력받은 내용을 메모리에 임시저장.

				return toolDTO;
			}

			// 게시글 삭제 기능
			private void deleteBoarder(int id) {

				// 디비에 crud 작업시 사용되는 도구함, 삭제 사능 가져와서 사용하기.

				// System.out.println(mList);
				ToolDAO dao = new ToolDAO();

				boolean ok = dao.deleteBoarder(id);

				if (ok) {
					JOptionPane.showMessageDialog(this, "삭제완료");
					dispose();

				} else {
					JOptionPane.showMessageDialog(this, "삭제실패");

				}

			}// deleteMember

			// 수정하기.
			// Boarder_DTO boarder_DTO 박스에, 기존 게시글의 정보가 들어있다.
			private void UpdateBoarder(ToolDTO toolDTO) {

				// 1. 화면의 정보를 얻는다.
				// 수정 중이라서, 변경된 데이터를 가져와서, -> 박스 모델 담아서(Boarder_DTO dto 담기)
				ToolDTO dto = getViewUpdateData(temp_dto);
				// 화면에서 제목, 내용이 변경된 박스모델.
				// 2. 그정보로 DB를 수정
				ToolDAO dao = new ToolDAO();
				// 실제 디비에 반영하는 메서드.
				boolean ok = dao.updateBoarder(dto);

				if (ok) {
					JOptionPane.showMessageDialog(this, "수정되었습니다.");
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "수정실패: 값을 확인하세요");
				}
			

		}

		
	}

	


