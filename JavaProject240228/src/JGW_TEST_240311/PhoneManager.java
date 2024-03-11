package JGW_TEST_240311;

import java.util.HashMap;
import java.util.Scanner;

public class PhoneManager {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Phone> PhoneManager = new HashMap<>();

		System.out.print("인원수 >> ");
		int members = scanner.nextInt();
		scanner.nextLine();

		for (int i = 0; i < members; i++) {
			System.out.print("이름과 전화번호(번호는 연속적으로 입력), 주소 >> ");
			String input = scanner.nextLine();
			String[] inputArray = input.split(" ");

			if (inputArray.length >= 3) {
				String name = inputArray[0];
				String tel = inputArray[1];
				String address = "";
				for (int j = 2; j < inputArray.length; j++) {
					address += inputArray[j] + " ";
				}
				address = address.trim();

				Phone Phone = new Phone(name, tel, address);
				PhoneManager.put(name, Phone);
			} else {
				System.out.println("잘못된 입력 형식입니다. 다시 입력하세요.");
				i--;
			}
		}

		System.out.println("저장되었습니다...");

		System.out.println(" ");

		while (true) {
			System.out.print("검색할 이름 >> ");
			String searchName = scanner.nextLine();

			if (searchName.equals("exit")) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}

			if (PhoneManager.containsKey(searchName)) {
				Phone Phone = PhoneManager.get(searchName);
				System.out.println(searchName + "의 번호와 주소는 " + Phone.getTel() + ", " + Phone.getAddress() + " 입니다.");
			} else {
				System.out.println(searchName + "은(는) 없습니다.");
			}
		}

		scanner.close();
	}

}
