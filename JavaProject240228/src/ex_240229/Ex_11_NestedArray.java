package ex_240229;

public class Ex_11_NestedArray {

	public static void main(String[] args) {
		// 이중 배열
		// 기본 정의는 배열의 정의랑 같고, []하나가 더 추가 됩니다.
		// int array [][] = new int [2][2];
		// int [][] array = new int [2][2];
		// int[][] array = { {0,0} , {0,1}
		// {1,0} , {1,1} }
		int[][] array1 = new int[2][2];
		// 반복문으로 임의로 이중 배열 생성.
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				array1[i][j] = j;
			}
		}
		int[][] array2 = { { 1, 2 }, { 3, 4 } };

		// 출력
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(array2[i][j]);
				System.out.print('\t');
			}
			System.out.println();
		}
		int[][] array = { { 1, 0 }, { 0, 1 } };
		// 출력
				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 2; j++) {
						System.out.print(array[i][j]);
						System.out.print('\t');
					}
					System.out.println();

	}

	}
}
