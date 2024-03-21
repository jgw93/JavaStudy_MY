package Java_Test_240321;

import java.util.HashMap;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class test4_Hashmap2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> drink = new HashMap<>();

		drink.put("밀키스", 700);
		drink.put("코카콜라", 800);
		drink.put("펩시", 1000);
		drink.put("칠성사이다", 1200);

		boolean first = true;

		while (true) {
			if (first) {
				System.out.println("밀키스, 코카콜라, 펩시, 칠성사이다 있습니다.");
				first = false;
			}
			System.out.print("선택 >> ");

			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("그만")) {
				System.out.println("종료합니다...");
				break;
			}
			if (drink.containsKey(input)) {
				int price = drink.get(input);
				System.out.println(input + "의 " + price + "원 입니다.");
			} else {
				System.out.println("해당 음료수는 없습니다.");
			}

		}
		scanner.close();
	}
}
