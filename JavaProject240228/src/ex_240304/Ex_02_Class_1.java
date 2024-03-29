package ex_240304;

public class Ex_02_Class_1 {

	public static void main(String[] args) {
		// 클래스 사용
		// 문법)
		// 클래스명 레퍼런스 변수명 = new 클래스명();
		// new 뒤에 클래스명() => 생성자라고 부름, 해당 인스턴스를 초기화시 사용.
		// 지금은 디폴트 생성자로 만들고, 매개변수를 이용해서 생성자를 만들 계획.
		// 오버로딩이라는 개념도 간단히 언급하고, this 라는 키워드도 간단히 언급 할예정.
		Animal ani1 = new Animal(); // 공장에서 마치 제품을 찍어 내듯이, 만들기, 예를 인스턴스라고 부름.
		Animal ani2 = new Animal(); // 각각의 인스턴스들은 다르다고 봅니다. 프로그래밍 에서
		Animal ani3 = new Animal(); // 각각의 인스턴스들이 가리키는 메모리 위치 주소가 다릅니다.

		// 사용방법, 객체 사용법? -> 점 연산자를 이용해서, 표현, 수납도구에서 꺼내듯이 사용함.
		// 접근지정자를 private 선언을 하면, 이처럼
		// 외부에서 접근이 안됩니다.
		// 그러면 곧 setter/getter 를 소개함.
		// 그래서, 다시 접근 지정자를 private -> public, 생략하면(default)
		ani1.name = "ani1";
		ani1.age = 10;
		ani1.introduceMethod();
		ani1.soundMethod();

		ani2.name = "ani2";
		ani2.age = 10;
		ani2.introduceMethod();
		ani2.soundMethod();

		// 불만사항, 요구사항
		// 1) 클래스 내부에 또다른 클래스가 있는게 거슬림. -> 파일 분리함, 현재 같은 패키지 내부로
		// 2) 인스턴스 생성시 매번 인스턴스에 점을 찍고, 재할당하는 부분, 한번에 하는법?
		// -> 예를 들어서, 선언시 기본값을 미리 할당하고 생성하기.
		// Animal ani4 = new Animal("ani4", 10);
		// 3) 해당 기능들이, 각각의 동물의 이름이나, 나이등을 각각 출력하는 방법?

		// 매개변수 2개인 생성자로 호출후, 동적으로 사용해보기.
		Animal ani4 = new Animal("ani4", 10);
		ani4.introduceMethod();
		ani4.soundMethod();

		// 매개변수 3개인 생성자로 호출후, 동적으로 사용해보기.
		Animal ani5 = new Animal("개", 10, "멍멍");
		ani5.introduceMethod();
		ani5.soundMethod();

		// 매개변수 4개인 생성자로 호출후, 동적으로 사용해보기.
		//
		String[] likeFoodList = {"고기","사료"};
		Animal ani6 = new Animal("똘똘한 개", 5, "똘똘한 멍멍", likeFoodList);
		ani6.introduceMethod();
		ani6.soundMethod();
		// 메서드에 인자값을 굳이 넣을 필요가 없다.
		// 해당 클래스의 멤버로, 좋아하는 음식 리스트를 받아서, 해당 속성에 저장해서,
		// 본인이 받아서 저장해 놓은걸 사용하면 됨. this로 대체
		//ani6.likeFoodList(likeFoodList);
		ani6.likeFoodList();
						

	}

}
