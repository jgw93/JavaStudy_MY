package ex_240314;

import java.io.FileWriter;
import java.io.InputStreamReader;

public class Ex_02_FileIo_String_2_Inout_Console_Output_file {

	public static void main(String[] args) {
		// 문자를 읽을 때, 사용하는 도구
		// System.in : 표준 입력, 키보드로 입력된 내용을 1차로 저장하는 공간. (바이트로 읽기)
		// InputStreamReader : 한번 더 문자로 읽어서, InputStreamReader, 인스턴스에 담기
		// 메모리 임시 공간에 저장.
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);

		// 출력 -> 파일에 출력하기.(파일 쓰기)
		// 쓰기를 위한 도구가 필요.
		FileWriter fileWriter = null;
		// inputStreamReader 에서 문자를 읽어서, 유니코드 정수값으로 담아둘 임시 변수. c
		int c;
		try {
			// 출력 대상 경로 지정.
			fileWriter = new FileWriter("c:\\temp_240314\\test_240314.txt");
			// while 반복문으로, 메모리에 저장된 문자들을 계속 읽어서,
			while ((c = inputStreamReader.read()) != -1) {
				// 파일에 쓰기 작업하기.
				fileWriter.write(c);
			}
			// 작업이 끝나면, 자원 반납
			inputStreamReader.close();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("입출력 오류가 발생했음.");
		}
	}

}
