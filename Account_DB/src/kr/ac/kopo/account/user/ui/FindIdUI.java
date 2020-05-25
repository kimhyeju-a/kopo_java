package kr.ac.kopo.account.user.ui;

public class FindIdUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("=================================================================");
		System.out.println("\t\t\t아이디 찾기");
		System.out.println("=================================================================");

		String phoneNumber = scanStr("\t핸드폰 형식은 [010-0000-0000]입니다.\n\t핸드폰 번호를 입력하세요 :");
		System.out.println();
		String findId = userService.findId(phoneNumber);
		
		System.out.println("\tphone Number [ " + phoneNumber +" ]의 정보와 ");
		System.out.println("\t일치하는 아이디는 [ "+ findId + " ] 입니다.");
		
		
	}

}
