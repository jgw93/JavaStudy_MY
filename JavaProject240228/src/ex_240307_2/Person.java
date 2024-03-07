package ex_240307_2;

public class Person {
	public String name;
	public int age;

	public Person() {

	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	// toString 정의하면, 해당 인스턴스를 출력시
	// 재정의한 문자열이 옵니다.
	// 주의사항.
	// 모든 클래스는 Object 클래스 상속 받았다.
	// 상속 받은 클래스 Person 은, Object의 멤버, 메서드를 모두 가지고 있다.
	// toString() Object의 메서드, 객체를 문자열로 변환을 해주는 기능.
	// 그대로 사용 안함.
	// 왜? 실제로 데이터를 비교하지, 객체의 메모리 위치 주솟값을 비교 안함.
	// 재정의 하면, 부모에도 toString(), 자식에도 toString()가 있어요.
	// 누가 더 우선이냐? 자식이 우선이다. (가상메서드)

	public String toString() {
		return "제이름: " + this.name + " 나이는: " + this.age + " 입니다.";
	}
	// 2번째, equals는 Object에도 있지만, 객체를 비교해서 많이 사용 안함.
	// 그래서, 재정의를 하고, 우리는 이름이 같으면 같다고 가정하고 재정의한다.

	public boolean equals(Object obj) {
		// 담을 때, 모델 타입을 정해서 담아 놓으면,
		// 여러모로 작업 할 때 편하다. 지금처럼, 해당 형을 확인하고
		// 하는 작업을 할 필요가 없다.
		if (obj instanceof Person) {
			Person p = (Person) obj;
			if (p.name.equals(name)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Person person1 = new Person("장규원", 31);
		Person person2 = new Person("장규원2", 31);

		Person person3 = new Person("장규원", 31);
		Person person4 = new Person("장규원", 31);

		System.out.println("person hashCode1: " + person1.hashCode());
		System.out.println("person hashCode2: " + person2.hashCode());
		System.out.println("person toString1: " + person1.toString());
		System.out.println("person toString2: " + person2.toString());
		System.out.println("========================================");
		System.out.println("person1.equals(person2): " + person1.equals(person2));
		System.out.println("person3.equals(person4): " + person3.equals(person4));
		// 실제 데이터를 이용해서 작업함.
		// 비지니스 로직, 데이터로 작업을 함

	}

}
