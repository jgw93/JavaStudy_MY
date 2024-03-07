package ex_240307;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
//		Util util = new Util();
		
		Sports swimming = new Swimming("수영", 8, "10분이내 추측", "부산 사직 아시아드");
		swimming.showInfo();
		swimming.showPlayPlace();
		// 시즌 설정
//		Season summer = Season.SUMMER;
//		swimming.setSeason(summer);
//		System.out.println("수영 개막 시즌: " + swimming.getSeason());
		// swimming is Sports, 상속 관계, 부모 타입으로 받아도됨, 다형성
		Util.showSeason(swimming, 2);

		// 시간 설정
		// Date 타입 -> 문자열 타입 변환
//		LocalDate currentDate = LocalDate.now();
//		String createTime = currentDate.toString();
//		swimming.setCreateTime(createTime);
//		System.out.println("수영 등록 시간: " + swimming.getCreateTime());
		Util.showDate();
		
		// 인터페이스에서 정의한 추상메서드 사용.
        // void showInOutPlace(int checkInOutPlace);
        // void showUseItems(String [] items);
        // void showTeamNameOrMember(String[] TeamOrMember);
		// 현재 다형성으로 부모 타입으로 받아서, 현재 보이는 메서드는 부모클래스만 보임.
		// 그래서, 다운캐스팅
		Swimming swimming2 = (Swimming)swimming;
		// 다시, 메서드를 조회 해보면, 자식이 재정의한 메서드가 보임.
		swimming2.showInOutPlace(1);
		// 수영 선수 소개
		String[] members = {"철수", "훈이", "맹구", "흑곰", "1", "2", "3", "4"};
		swimming2.showTeamNameOrMember(members);
		// 수영 아이템 소개
		String[] item = {"수영모", "수영복", "귀마개", "오리발", "수경"};
		swimming2.showUseItems(item);
		
		System.out.println("============================");
		//Baseball 인스턴스 만들기
		Sports baseball = new Baseball("야구", 9, "약 3시간 전후", "사직 야구장");
		baseball.showInfo();
		baseball.showPlayPlace();
		Util.showSeason(baseball, 1);
		Util.showDate();
		
		Baseball baseball2 = (Baseball)baseball;
		// 다시, 메서드를 조회 해보면, 자식이 재정의한 메서드가 보임.
		baseball2.showInOutPlace(1);
		// 수영 선수 소개
		String[] baseballmembers = {"철수", "훈이", "맹구", "흑곰", "1", "2", "3", "4","5"};
		baseball2.showTeamNameOrMember(baseballmembers);
		// 수영 아이템 소개
		String[] baseballitem = {"배트", "야구공", "글러브", "야구모", "유니폼","야구 신발"};
		baseball2.showUseItems(baseballitem);

	
		
	}

}
