package ex_240308;

public class Ex_01_Wrapper_1 {

	public static void main(String[] args) {
		// Wrapper class 는 기본현 -> 참조형, 변환 해주는 클래스.
		// OOP(Object Oriented Programing)
		// 객체지향의 꽃은 상속, 재사용
		// 반환 타입 -> Integer
		Integer i1 = Integer.valueOf(100);
		// i1. 찍어보면 보이는 시점이, 1) Object 2)Integer 이 보임.
		// 참조형을 출력해보니, 해당 기본형의 정수값 100이 출력.
		// 왜? 참조형 -> 기본형으로 자동 언박싱.
		System.out.println("i1: " + i1);
		Object i2 = Integer.valueOf(100);
		// i2. 찍어보면 보이는 시점이, Object 만 보임.

		// 문자열(참조형) -> Wrapper(참조형) = 언박싱
		Integer i3 = Integer.valueOf("1000");
		System.out.println("i3: " + i3);

		// 실수, -> 통계 할 때. 평점, 4.3
		// -> 정확도, 일치도를 평가할 때, 소수점 7자리~15자리,
		// 실수의 기본형은 double 이고,
		// 작은 집인 float로 다운캐스팅.
		Float f1 = Float.valueOf((float) 3.14);
		System.out.println("float1: " + f1);

		// 주요 많은 메서드들이 있지만, 그중에서 많이 사용이되는
//		 Integer i4 = Integer.valueOf(100);
//		 int num = i4.parseInt("1000");
		// static으로 선언이 된 메서드는, 가급적 접근을 클래스명으로 하는것 원칙으로 함.
		// 인스턴스로 접근 가능하지만 권장하진 않음.
		// 왜? static , 클래스가 로드 될 때 부터 있는 메모리 위치 주소값(참조형)
		// 인스턴스 생성시 할당이 되는 메모리 위치 주소값(참조형)
		String num2 = "10000";
		int num3 = Integer.parseInt(num2);
		System.out.println("i4: " + num3);
		
		// 참조형 -> 기본형으로 메서드 이용하기.
		Integer num4 = Integer.valueOf(10000);
        int num5 = num4.intValue();
        // 자동 언박싱
        System.out.println("Integer num4: " + num4);
        //Wrapper 클래스 메서드 이용해서, 참조형 -> 기본형 변경
        System.out.println("num5: " + num5);
        
        // 배열로, Integer 들을 다 담아보기.
        Integer[] arrayInteger = {i1,num4,i3};
        // 반복자 패턴, iterable 한것들. 반복이 가능한 것들.
        // 화면에서 데이터가 넘어와요 : 프론트 엔드 포인트
        // 현재, 백엔드 에서, 임시 메모리 데이터 담아 두기.
        // 지금, 콘솔로 대신 출력했지만.
        // 결론, 데이터베이스 서버에 전달함.
        for(Integer x:arrayInteger) {
        System.out.println("자동 형변환으로 x 출력: " + x);
        }
	}

}
