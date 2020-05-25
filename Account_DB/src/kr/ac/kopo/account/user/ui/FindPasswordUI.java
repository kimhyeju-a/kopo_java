package kr.ac.kopo.account.user.ui;

public class FindPasswordUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("=================================================================");
		System.out.println("\t\t\t비밀번호 찾기");
		System.out.println("=================================================================");

		String phoneNumber = scanStr("\t핸드폰 형식은 [010-0000-0000]입니다.\n\t핸드폰 번호를 입력하세요 :");
		
		String findId = userService.findId(phoneNumber);
		
		System.out.println("\tphone Number [ " + phoneNumber +" ]의 정보와 ");
		System.out.println("\t일치하는 아이디는 [ "+ findId + " ] 입니다.");
		
		String changePassword = scanStr("\t변경하실 비밀번호를 입력해주세요 : ");
		
		if(userService.changePassword(findId,changePassword)) {
			System.out.println("비밀번호 변경에 성공하였습니다.");
		}else {
			System.out.println("비밀번호 변경에 실패하였습니다.");
		}
	}

}
