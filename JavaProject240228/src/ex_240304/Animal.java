package ex_240304;

//클래스 정의
public class Animal {
	// 하나의 클래스에는, 각각 한개씩 원래 사용을함.
	// 지금은 예시로, 클래스안에 또 다른 클래스를 보여주기용.
	// 파일 분리함.

	// 클래스 : 설계도면, 공장.
	// 실체, 제품 : 인스턴스라고 부른다.

	// 구성 : 1) 멤버(변수), 2) 메서드(기능)

	// private를 사용하면, 외부 접근이 안되서, 추후 setter/getter로 접근 하는 방법 알려줄 예정.
	// 그래서, 현재는 public 으로 변경하기.
	// private String name;
	// private int age;
	public String name;
	public int age;
	public String soundType;
	// 동물이 좋아하는 음식.
	public String[] favoriateFood;

	// 생성자가, 매개변수가 2개인 생성자가 정의가 안되있음.
	// Animal ani4 = new Animal("ani4", 10); 이런식으로 초기화를 할려고 하니, 없음.
	// Animal ani4 = new Animal(); : 매개변수가 없는 생성자를 "디폴트 생성자"라고 부름.

	// 디폴트 생성자는, 생성자가 아무것도 없다면 시스템에서 알아서 만들어줌.
	// 하지만, 개발자가, 다른 생성자를 하나라도 만들게 되면, 시스템에서 안 만들어줌.
	// 생성자는 정의를
	// 클래스명()
	// 매개변수가 2개인 생성자를 만듬. -> 결론, 디폴트 생성자를 시스템이 알아서 안 만들어줌.

	// 디폴트 생성자를 만들기.
	
	// 오버로드의 예, 생성자 버전으로, 각각 이름은 동일하지만, 매개변수 정의가 다르고,
	// 결론, 각각 다 다르다.
	public Animal() {

	}

	public Animal(String name, int age) {
		// 생성자 호출시, 입력 받은 이름, 나이등을 현재의 인스턴스의 값으로 교체를 하는데,
		// 현재 우리가 어디에 속해 있냐면. ? 해당 클래스에 속해 있음. Animal,
		// this를 사용하는데, 무엇을 가리키냐? 현재 클래스의 인스턴스를 가리킴.
		this.name = name;
		this.age = age;
	}

	public Animal(String name, int age, String soundType) {

		this.name = name;
		this.age = age;
		this.soundType = soundType;
	}

	// 매개변수가 4개인, 생성자를 만들기.
	public Animal(String name, int age, String soundType, String[] likefoods) {

		this.name = name;
		this.age = age;
		this.soundType = soundType;
		this.favoriateFood = likefoods;
	}

	// 메서드 : 1) 소개하는 기능, 2) 소리 기능.
	// 추가 : 좋아하는 음식을 출력하는 기능.

	public void introduceMethod() {
		// System.out.println("안녕하세요. 현재는 더미로 작업중, 곧 동적으로 할 예정.");
		System.out.println("안녕하세요. 제 이름: " + this.name + ", 나이: " + this.age);
	}

	public void soundMethod() {
		// System.out.println("현재는, 더미로 소리를 냅니다. 나중에는 동적으로 할 예정.");
		System.out.println("제 소리는: " + this.soundType);
	}
    // String[] likeFoodList, 매개변수 이 부분은 this로 변경해보기.
	//public void likeFoodList(String[] likeFoodList) {
	//	for(int i=0; i<likeFoodList.length; i++)
	//		System.out.println("좋아하는 음식: "+ i + "번: " + likeFoodList[i]);		
    //	}
	
	public void likeFoodList() {
			for(int i=0; i<this.favoriateFood.length; i++)
			System.out.println("좋아하는 음식: "+ i + "번: " + this.favoriateFood[i]);
	}
}

	



