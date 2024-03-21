package Java_Test_240321;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class test3_Hashmap {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> accountmap = new HashMap<>();

		System.out.println("<< 통장 관리 프로그램입니다. >>");
		while (true) {
			System.out.print("이름과 금액 입력>> ");
			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("exit")) {
				System.out.println("프로그램을 종료합니다...");
				break;
			}

			String[] tokens = input.split(" ");

			String name = tokens[0];
			int amount = Integer.parseInt(tokens[1]);

			if (accountmap.containsKey(name)) {
				Integer currentBalance = accountmap.get(name);
				accountmap.put(name, currentBalance + amount);
			} else {
				accountmap.put(name, (int) amount);
			}
			System.out.print("(");
			boolean firstEntry = true;
			for (Entry<String, Integer> entry : accountmap.entrySet()) {
				if (!firstEntry) {
					System.out.print(")(");
				}
				System.out.print(entry.getKey() + ">" + entry.getValue() + "원");
				firstEntry = false;
			}
			System.out.println(")");
		}
		scanner.close();
	}

}
