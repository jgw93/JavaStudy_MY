package ex_240308;

public class Ex_03_StringBuffer_1 {

	public static void main(String[] args) {
		String str3 = new String("HELLO");
		String str4 = new String("HELLO");
		String str3concat = str3.concat(" world");
		String str4concat = str4.concat(" world");
		System.out.println(" str3.concat(\" world\"): " + str3.concat(" world"));
		System.out.println(" str4.concat(\" world\"): " + str4.concat(" world"));
		System.out.println("===============str3,str4========= 기존문자열의 메모리 위치값==");
		System.out.println("str3 System.identityHashCode: " + System.identityHashCode(str3));
		System.out.println("str4 System.identityHashCode: " + System.identityHashCode(str4));
		System.out.println("===============str3,str4========= 합친문자열의 메모리 위치값==");
		System.out.println("str3concat System.identityHashCode: " + System.identityHashCode(str3concat));
		System.out.println("str4concat System.identityHashCode: " + System.identityHashCode(str4concat));
		
		System.out.println("======================================");
		// 문제접을 개선한, StringBuffer을 활용해보기.
		// 테스트 : 기존 문자열에 붙이는 concat 메소드를 이용해서
		// 기존 사용하던 메모리 위치 주소값을 계속 활용하는지 여부
		StringBuffer str1 = new StringBuffer("HELLO");
		
		System.out.println("HELLO 뒤에 붙이기 전 주소값 : 확인");
		System.out.println("str1.append (\" world\"): " + str1);
		System.out.println("str1(\" world\"): "
                + System.identityHashCode(str1));
		System.out.println("HELLO 뒤에 붙힌 뒤 주소값 : 확인");
		System.out.println("str1.append (\" world\") System.identityHashCode: "
		                    + System.identityHashCode(str1));
		
		str1.append(" world");
		
		// 메서드 기능 간단히 확인.
		// 012345678910
		// HELLO world
		str1.insert(5, " my");
		// StringBuffer에 따로 toString이 정의가 되어서, 바로 인스턴스 변수로 출력이 가능.
		System.out.println("str1.insert(5, \" my\"): " + str1);
		
		// 결과 문자열
		// 01234567891234
		// HELLO my world
		str1.replace(1, 5, "I");
		System.out.println("str1.replace(1, 5, \"I\"): " + str1);

	}

}
