package ex_240307;

public class Baseball extends Sports implements Interface1 {

	public Baseball(String sportsName, int sportsMemberCount, String sportsPlayTime, String sportsPlace) {
		super(sportsName, sportsMemberCount, sportsPlayTime, sportsPlace);

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