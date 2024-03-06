package ex_240306;

// 정의
public interface Ex_05_interface_1 {
	
	// 인터페이스? 접점
	// 특정의 표준, 규격이라고 보면됨.
	// 예) 110v 변환하는 컨버터
	// 예2) JDBC 라고 해서, 자바와 데이터베이스를 연결하는 인터페이스.
	// DB회사에서, JDBC 인터페이스의 규격에 맞게 클래스를 작성 하면,
	// 개발자는 인터페이스 규격, 표준은 그대로 두고.
	// 해당 DB의 클래스만 교체해서 사용을 함.
	// 특징.
	// 다중 상속이 가능.
	// 추상 클래스 처럼, 추상 메서드, 상수로 구성이되고,
	// jdk 버전이 올라서, 기본, private, static 등 메서드들도 같이 구성이 되게끔 추가 되었음.
	// 인터페이스도, 추상 클래스처럼, 실제 사용보다는, 설계도로서 사용을 하는게 목적임.
	// 규모가 작으면, 추상 클래스, 인터페이스를 안쓰는 경우도 있지만
	// 보통은 유지보수등을 생각하면, 실무에서 많이 사용하는편
	
	// 구성품
	// 1) 상수 2) 추상메서드 3) 디폴트 기본 메서드(일반 메서드) 4) private 메서드 5) static 메서드
	public final int MAX = 100;
	abstract public void showInfo();
	public default void introduceInfo() {
		System.out.println("디폴트 메서드 입니다.");
		introducehobby();
		introduceMember();
	}
	private void introducehobby() {
		System.out.println("private 메서드 입니다.");
		
	}
	public static void introduceMember() {
		System.out.println("스태틱 메서드 입니다.");
	}
		
	
	

}
