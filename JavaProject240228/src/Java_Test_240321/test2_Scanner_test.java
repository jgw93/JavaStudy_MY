package Java_Test_240321;

import java.util.Scanner;

public class test2_Scanner_test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("exit")) {
				System.out.println("종료합니다...");
				break;
			}
			String[] words = input.split(",");
			int wordcount = words.length;

			System.out.println("어절 개수는 " + wordcount);

		}
		scanner.close();
	}

}
