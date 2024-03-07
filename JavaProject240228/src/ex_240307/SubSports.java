package ex_240307;

public class SubSports extends Sports implements Interface1 {
	// 추가할 멤버
	// 1) 시즌 정보 2) 실내 실외 3) 사용장비 4) 멤버
	private String seasonInfo;
	private String inOrOut;
	private String[] items;
	private String[] members;
	
	

	public SubSports(String sportsName, int sportsMemberCount, String sportsPlayTime, String sportsPlace, 
			String seasonInfo, String inOrOut, String[] items, String[] members) {
		super(sportsName, sportsMemberCount, sportsPlayTime, sportsPlace);
		
	}
	
	// 한번에 모든 값 출력하는 메서드 만들기.
	public void showAllInfo() {
		System.out.println("============등록 후 확인용 출력입니다.============");
		System.out.println("종목 이름 :" + super.getSportsName() + ", 인원수: " + super.getSportsMemberCount() +
				", 경기 시간: " + super.getSportsPlayTime() + ", 경기 장소: " + super.getSportsPlace() + 
				", 시즌 정보: " + this.seasonInfo + ", 실 내외 여부: " + this.inOrOut + ", ");
//		showTeamNameOrMember();
//		showUseItems();
		
	}

	@Override
	public void showInOutPlace(int checkInOutPlace) {
		if (checkInOutPlace == 1) {
			System.out.println("실내 스포츠입니다.");
		} else {
			System.out.println("실외 스포츠입니다.");
		}

	}

	@Override
	public void showUseItems(String[] items) {
		System.out.println("사용 장비: ");
		for (String item : items) {
			System.out.print(item + ", ");
		}
		System.out.println();

	}

	@Override
	public void showTeamNameOrMember(String[] TeamOrMember) {
		System.out.println("팀명 및 팀원소개: ");
		for (String teamOrMember : TeamOrMember) {
			System.out.print(teamOrMember + ", ");
			
		}
		System.out.println();

}
}
