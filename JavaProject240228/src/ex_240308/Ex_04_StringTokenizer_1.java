package ex_240308;

import java.util.StringTokenizer;

public class Ex_04_StringTokenizer_1 {

	public static void main(String[] args) {
		// query의 형식은 HTML이 웹 브라우저에서 get 방식으로 서버에 전달하면
		// 동적인 파라미터라고 함
		String query = "name=jgw &addr=Busan &age=31";
		StringTokenizer st = new StringTokenizer(query, "&");

		// 분리된 문자열의 전체 갯수 구하기.
		int n = st.countTokens();
		System.out.println("분리된 문자열의 전체 갯수 int n = st.countTokens(): " + n);
		showStringTokenizer(st);
//		System.out.println("while 문으로, 값의 존재 유무 확인 후, 다음 토큰 값 호출 메서드로 확인.");
//		while (st.hasMoreElements()) {
//			String nexString = st.nextToken();
//			System.out.println("nexString 출력하기. : " + nexString);
//		}
		
        
		StringTokenizer st2 = new StringTokenizer(query, "&=");
		showStringTokenizer(st2);
//		System.out.println("while 문으로, 값의 존재 유무 확인 후, 다음 토큰 값 호출 메서드로 확인.");
//		while (st2.hasMoreElements()) {
//			String nexString = st2.nextToken();
//			System.out.println("nexString 출력하기. : " + nexString);
//		}
		
		String query3 = "\"apple\":\"사과\",\"banana\":\"바나나\",\" grape\":\"포도\"";
		System.out.println(query3);
		StringTokenizer st3 = new StringTokenizer(query3, ",");
		showStringTokenizer(st3);

	}
	
	// 전역 메소드, 입력 : StringTokenizer 타입, 단순 출력만 하는걸로.
	public static void showStringTokenizer(StringTokenizer StringTokenizer) {
		System.out.println("while 문으로, 값의 존재 유무 확인 후, 다음 토큰 값 호출 메서드로 확인.");
		while (StringTokenizer.hasMoreElements()) {
			String nexString = StringTokenizer.nextToken();
			System.out.println("nexString 출력하기. : " + nexString);
		}
			
	}
}