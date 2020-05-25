package kr.ac.kopo.account.manager.ui;

import java.util.List;

import kr.ac.kopo.account.user.vo.UserVO;

public class MgrUserAllSelect extends ManagerBaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("=================================================================");
		System.out.println("\t\t\t관리자 계정입니다.");
		System.out.println("\t\t\t사용자 전체 조회");
		System.out.println("=================================================================");
		
		List<UserVO> list = managerService.mgrUserAll();
	}

}
