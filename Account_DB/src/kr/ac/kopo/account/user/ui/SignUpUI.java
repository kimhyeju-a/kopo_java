package kr.ac.kopo.account.user.ui;

import kr.ac.kopo.account.user.vo.UserVO;

public class SignUpUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		System.out.println("=================================================================");
		System.out.println("\t\t\t회원가입");
		System.out.println("=================================================================");
		
		
		String id = scanStr("\t사용하실 id를 입력하세요.\t: ");
		while(!userService.idCheck(id)) {
			System.out.println("\tID가 이미 존재합니다. ");
			id = scanStr("\t사용하실 id를 입력하세요.\t: ");
		}
		String pwd = scanStr("\t사용하실 비밀번호를 입력하세요.\t: ");
		String name = scanStr("\t사용자 명을 입력하세요.\t: ");
		String phoneNumber = scanStr("\t핸드폰 번호를 입력하세요.\t: ");
		int age = scanInt("\t사용자 나이를 입력하세요.\t: ");
		
		//////////////////////////////////////////////////
		//	사용자 회원 가입 (User db 에 insert)
		UserVO newUser = new UserVO();
		newUser.setId(id);
		newUser.setPassword(pwd);
		newUser.setName(name);
		newUser.setPhoneNumber(phoneNumber);
		newUser.setAge(age);
		
		userService.insertUser(newUser);
		//////////////////////////////////////////////////

		System.out.println("\t\t회원가입을 완료하였습니다.\n");
		Thread.sleep(1000);
	}

}
