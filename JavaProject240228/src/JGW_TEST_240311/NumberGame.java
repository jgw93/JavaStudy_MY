package JGW_TEST_240311;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int lower = 1;
        int upper = 100;
        int randomNumber = random.nextInt(upper - lower + 1) + lower;
        int anwser;
        int trial = 0;

        System.out.println("=== 숫자맞추기 게임을 시작합니다. ===");
        System.out.println("컴퓨터가 숫자를 생각했습니다.");
        if (randomNumber % 2 == 0) {
            System.out.println("힌트는 짝수입니다.");
        } else {
            System.out.println("힌트는 홀수입니다.");
        }

        do {
            System.out.print("1~100 사이의 값을 입력 >> ");
            anwser = scanner.nextInt();
            trial++;

            if (anwser < lower || anwser > upper) {
                System.out.println("숫자를 다시 입력하세요.");
            } else if (anwser < randomNumber) {
                System.out.println("더 큰 수입니다.");
            } else if (anwser > randomNumber) {
                System.out.println("더 작은 수입니다.");
            } else {
                System.out.println(trial + "회 만에 맞췄습니다.");
                System.out.println("=== 게임을 종료합니다. ===");
            }
        } while (anwser != randomNumber);

        scanner.close();
    }
			

	}

