package ex_240304;

import java.util.Scanner;

public class Ex_03_Class_2_Idol2 {

	public static void main(String[] args) {
		// Idol 클래스 사용
		Scanner scanner = new Scanner(System.in);
		System.out.println("아이돌 그룹명을 입력해주세요.>>");
		String groupNameString = scanner.next();
		
		System.out.println("그룹은 몇명입니까?>>");
		int groupMemberNumber = scanner.nextInt();

		System.out.println("아이돌 그룹멤버를 입력해주세요.(예, 공백으로 구분해서 넣기)>>");
		String[] groupMember = new String[groupMemberNumber];
		for(int i=0; i<groupMember.length; i++) {
			groupMember[i] = scanner.next();
		}
		
		System.out.println("대표 앨범 3개만 입력해주세요.(예, 공백으로 구분해서 넣기)>>");
		String[] groupAlbum = new String[3];
		for(int i=0; i<groupAlbum.length; i++) {
			groupAlbum[i] = scanner.next();
		}
		
		System.out.println("주요 활동 지역 3개만 입력해주세요.(예, 공백으로 구분해서 넣기)>>");
		String[] areaActivity = new String[3];
		for(int i=0; i<areaActivity.length; i++) {
			areaActivity[i] = scanner.next();
		}
		
		// Idol(String groupName, String[] groupMember, String[] groupAlbums)
		// BTS
//		Idol Idol = new Idol(groupNameString, groupMember, groupAlbum,);
//		Idol.introduceMember();
//		Idol.introduceAlbum();
		
		// 블랙핑크라고 만들었고, 아이돌 클래스를 상속을 받았음.
		// 사용하기.
//		BlackPink blackPink = new BlackPink(groupNameString, groupMember, groupAlbum, areaActivity);
//		blackPink.introduceMember();
//		blackPink.introduceAlbum();
//		blackPink.infoActivityArea();
		
		// 다형성 보여주기.
		// 부모 타입으로 받는다. 작은 집 -> 큰 집으로 갈 때는 문제가 안된다.
		// 주의사항, blackPink는 1) 아이돌 이면서, 2) 블랙핑크 임.
		// 하지마느 타입이 부모 or 자식? 부모이기때문에,
		// 이 인스턴스 실행을 하게되면, 바라보는 레퍼런스, 부모를 보게 됩니다.
		// 그러니? 부모의 기능만 구현이 됩니다.
		
		// 그래서, 본인의 자식 클래스를 사용하고 싶다면, 다운 캐스팅
		// 부모 클래스 -> 자식 클래스 다운 캐스팅.
		Idol blackPink = new BlackPink(groupNameString, groupMember, groupAlbum, areaActivity);
		blackPink.introduceMember();
		blackPink.introduceAlbum();
		// areaActivity가 작동하지 않음.
		// 다형성을 이용해서 사용을 하지만, 실제 사용은 부모것만 사용함.
		
		// 부모 타입을 다시, 자식 타입으로 변경을 해서, 원래 자식에서 만들었던 활동 지역 기능을 사용해보기.
		BlackPink blackPink2 = (BlackPink)blackPink;
		blackPink2.infoActivityArea();
		
		// 다형성으로 왜 하나?
		// 재정의를 할 때, 유연한 작업을 하기위해서, 유지보수를 위해서,
		// 상속에서, 모든 클래스들의 최고 부모클래스는 object클래스
		// 암묵적으로 다 상속을 받고 있음.
		// 부모 - 자식 간에 타입 변환을 용이하게 해서, 유지보수를 편하게 하기 위해서.
	
		
		
		scanner.close();

	}

}
