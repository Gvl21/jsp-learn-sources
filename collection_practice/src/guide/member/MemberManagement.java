package guide.member;
 
/**
 * AppBase의 기능을 구현한 자식 class
 * AppBase의 기능을 상속받아 제시된 기능을 완성하시오.
 */
public class MemberManagement extends AppBase{

	@Override
	protected void terminate() {
		// TODO application 종료
		isRun = false;
	}

	@Override
	protected void join() {
		// TODO 회원가입
		while(true) {
		String mId = getStringData("아이디를 입력해주세요 > ");
		
		if(!memberIdCheck(mId)) {
			System.out.println("사용할 수 없는 아이디입니다. 다시 입력해주세요");
			continue;
		}
		// 사용할 수 있는 mId
		String pw = getStringData("비밀번호를 입력해주세요 > ");
		String rePw = getStringData("비밀번호를 한번 더 입력해주세요 > ");
		if(!pw.equals(rePw)) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			continue;
		}
		// 회원 가입 처리
		String name = getStringData("이름을 입력해주세요.");
		Member m = new Member(number++, name, mId,pw, System.currentTimeMillis());
		memberList.add(m);
//		number++;
		System.out.println("회원가입이 완료되었습니다.");
		break;
				
		}
		
	}

	@Override
	protected void login() {
		// TODO id 와 password를 비교하여 동일한 회원 정보가 존재할 시 loginMember에 회원정보 저장
		String mId = getStringData("아이디를 입력해주세요 > ");
		String mPw = getStringData("비밀번호를 입력해주세요 > ");
		
		Member member = findMember(new Member(mId, mPw));
		
		if(member == null) {
			System.out.println("일치하는 정보가 없습니다. (로그인 실패)");
		}
	}

	@Override
	protected void select() {
		// TODO 회원 목록 검색 출력
		if(loginMember == null) {
			System.out.println("로그인 이후 사용할 수 있는 메뉴입니다.");
			return;
		}
		//관리자인지 아닌지 구분
		if(loginMember.equals(master)) {
			for(Member m : memberList) {
				
			}
		}
		
		
	}
	

	@Override
	protected void update() {
		// TODO 회원 정보 수정
		
	}

	@Override
	protected void delete() {
		// TODO 회원정보 삭제
		if(master.equals(loginMember)) {
			System.out.println("회원정보를 삭제할 수 없습니다.");
			return;
		}
		String answer = getStringData("정말로 삭제하시겠습니까? y/n");
		switch(answer) {
		case "y" : case "Y" : case "ㅛ":
			deleteMember();
			break;
		default : 
			System.out.println("회원정보 삭제(탈퇴)가 취소되었습니다.");
		}
	}

	@Override
	protected void deleteMember() {
		// TODO 회원 탈퇴
		// equals 비교
		memberList.remove(loginMember);
		loginMember = null;
		System.out.println("회원 멤버 탈퇴");
	}
	
}
