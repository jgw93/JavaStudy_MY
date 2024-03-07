package ex_240306;

//자식 클래스에서 구현한 경우.
public class Ex_07_interface_subClass_3 extends Idol_abstract implements singer{

	public Ex_07_interface_subClass_3(String groupName, String[] groupMember, String[] groupAlbums) {
		super(groupName, groupMember, groupAlbums);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void song() {
		System.out.println("감미로운 목소리로 노래함.");
		
	}

	@Override
	public void doSign() {
		System.out.println("친절히 사인을 잘해줌.");
		
	}

	@Override
	public void dance() {
		System.out.println("댄스 실력도 수준급 이상임. ");
		
	}

	@Override
	public void introduceActivityArea() {
		System.out.println("한국, 중국, 일본, 아시아 뿐만아니라, 미국에도 진출함.");
		
	}

		
	}

	// 인터페이스를 구현하는 기본 문법
	// 클래스 명 implements 인터페이스 명1,인터페이스 명2,


