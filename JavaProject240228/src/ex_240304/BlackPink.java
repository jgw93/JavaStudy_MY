package ex_240304;

// 상속 예제,
// 부모 클래스: Idol, 자식 클래스: BlcakPink
// 기본 문법: 자식클래스 extends 부모클래스
// 주의 사항
// 부모로부터 상속을 받아서, 재사용을 하기 위해서는 반드시 부모가 초기화가 되어야 한다.
// 상속은 단일 상속만 가능, 인터페이스는 다중 구현이 가능함.

public class BlackPink extends Idol {
	// 추가할 필드 1) 주요 활동지역
	public String[] activityAreas;
	

	public BlackPink(String groupName, String[] groupMember, String[] groupAlbums, String[] activityArea) {
		// this : 본인 클래스(인스턴스)를 가리키는 예약어
		// super : 부모 클래스를 가리키는 예약어
		super(groupName, groupMember, groupAlbums);
		// TODO Auto-generated constructor stub
		this.activityAreas = activityArea;
	}
	
	// 기능, 주요 활동하는 지역을 알려주는 기능.
	public void infoActivityArea() {
		for(String activityArea : this.activityAreas) {
			System.out.println("주요 활동 지역은 " + activityArea + "입니다.");
		}
		
	}

}
