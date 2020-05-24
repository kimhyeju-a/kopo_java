package kr.ac.kopo.account.user.ui;

import kr.ac.kopo.account.user.vo.UserVO;

public class SignUpUI extends BaseUI{

	@Override
	public void execute() throws Exception {

		String id = scanStr("사용하실 id를 입력하세요			: ");
		String pwd = scanStr("사용하실 비밀번호를 입력하세요		: ");
		String name = scanStr("사용자 명을 입력하세요			: ");
		String age = scanStr("사용자 나이를 입력하세요			: ");
		String ResidentNo = scanStr("사용자 주민등록 번호를 입력하세요 	:");
		
		//////////////////////////////////////////////////
		//	사용자 회원 가입 (User db 에 insert)
		UserVO newUser = new UserVO();
		newUser.setId(id);
		newUser.setPassword(pwd);
		newUser.setName(name);
		newUser.setAge(age);
		
		userService.insertUser(newUser);
		//////////////////////////////////////////////////

		System.out.println("회원가입을 완료하였습니다.");
	}

}
