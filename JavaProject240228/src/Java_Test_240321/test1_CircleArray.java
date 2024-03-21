package Java_Test_240321;

import java.util.ArrayList;
import java.util.Scanner;

class Circle {
	private int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	public double getArea() {
		return radius * radius * 3.14;
	}

}

public class test1_CircleArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Circle[] circleArray = new Circle[4];
		for (int i = 0; i < 4; i++) {
			System.out.print((i + 1) + (" 반지름 >> "));
			int radius = scanner.nextInt();
			circleArray[i] = new Circle(radius);
		}
		double totalarea = 0;
		for (int i = 0; i < 4; i++) {
			totalarea += circleArray[i].getArea();
		}
		System.out.println("저장하였습니다...");
		System.out.println("원의 면적 전체 합은 " + totalarea);
		scanner.close();
	}

}
