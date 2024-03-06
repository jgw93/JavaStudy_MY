package ex_240306;

import ex_240304.Idol;

public class Ex_01_trt_class_boygroup_inheritance_1 extends Idol{
    // 상속 기본 문법
	// 자식 클래스 extends 부모 클래스
	// 주의사항,
	// 반드시 부모 클래스가 초기화가 되어야한다.
	public Ex_01_trt_class_boygroup_inheritance_1(String groupName, String[] groupMember, String[] groupAlbums) {
		super(groupName, groupMember, groupAlbums);
		
	}
	
	// 자식 클래스에서, 추가로 1) 변수 2) 메서드를 구성하지않았는데
	// 오버라이딩 테스트
	// 해당 메서드는, 부모에도 존재, 자식에도 존재합니다, 우선순위는 자식입니다.
	// 가상 메서드라고 합니다.
	public void introduceAlbum() {
		for(String Album : this.groupAlbums) {
			System.out.println(this.groupName + "의 오버라이딩한 앨범: " + Album + "입니다.");
		}
	System.out.println("부모 클래스의 멤버 접근 super.groupName: " + super.groupName);
	System.out.println("자식 클래스에서, 부모 클래스의 메서드를 정적(수동) 호출: ");
	super.introduceAlbum();
	

	}
}
