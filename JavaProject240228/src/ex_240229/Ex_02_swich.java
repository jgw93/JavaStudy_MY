package ex_240229;

import java.util.Scanner;

public class Ex_02_swich {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("======날씨에 따른 메뉴 선택하기.======");
		System.out.println("1번:맑음, 2번:흐림, 3번:비, 4번:디폴트 숫자를 선택해주세요>>");
		int pickNumber = scanner.nextInt();
		String resultPickMenuString = picLunchMenuWeather(pickNumber);
		System.out.println("오늘 점심은 : "+ resultPickMenuString);

	}
	// 날씨에 따라 메뉴를 정해주는 프로그램 만들기.
	public static String picLunchMenuWeather(int number) {
		switch (number) {
		case 1:
			String menuString = "된장찌개";
			return menuString;
			
		case 2:
			String menuString2 = "칼국수";
			return menuString2;
		
		case 3:
			String menuString3 = "우동";
			return menuString3;
			

		default:
			String menuString4 = "국밥";
			return menuString4;
			
		}
		
	}
	

}
