package Java_Test_240321;

import java.util.HashMap;
import java.util.Scanner;

public class test5_Hashmap3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Integer> nations = new HashMap<String, Integer>();
		
		System.out.println("나라 이름과 인구를 5개 입력하세요. (예: Korea 5000)");
		
		for (int i = 0; i < 5; i++) {		
			System.out.print("나라 이름, 인구 >> ");
			String input = scanner.nextLine();
			String[] tokens = input.split(" ");
			String country = tokens[0];
			int population = Integer.parseInt(tokens[1]);
			nations.put(country, population);
		}

		// 가장 인구가 적은 나라 검색 및 출력
		String leastPopulatedCountry = null;
		int minPopulation = Integer.MAX_VALUE;
		for (HashMap.Entry<String, Integer> entry : nations.entrySet()) {
			if (entry.getValue() < minPopulation) {
				leastPopulatedCountry = entry.getKey();
				minPopulation = entry.getValue();
			}
		}

		if (leastPopulatedCountry != null) {
			System.out.println("제일 인구가 적은 나라는 (" + leastPopulatedCountry + ", " + minPopulation + ")");
		} else {
		}

		scanner.close();
	}

}
