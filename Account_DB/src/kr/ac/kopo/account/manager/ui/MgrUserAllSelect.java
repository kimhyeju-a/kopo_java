package kr.ac.kopo.account.manager.ui;

import java.util.List;

import kr.ac.kopo.account.ui.CheckAccountException;
import kr.ac.kopo.account.user.vo.UserVO;

public class MgrUserAllSelect extends ManagerBaseUI {

	@Override
	public void execute() throws Exception {
		List<UserVO> list = managerService.mgrUserAll();
		System.out.println("=================================================================");
		System.out.println("\t\t\t관리자 계정입니다.");
		System.out.println("\t\t\t사용자 전체 조회");
		System.out.println("=================================================================");
		System.out.println("번호\t유저번호\tID\t나이\t전화번호\t\t가입일");

		int i = 1;
		if(list.isEmpty()) {
			throw new CheckAccountException("\t보유하고 있는 계좌번호가 없습니다.");
		} else {
			for(UserVO user : list) {
				System.out.println((i++)+"\t"+user.getUserNo() +"\t" + user.getId() + "\t" + user.getAge() +"\t"+ user.getPhoneNumber() + "\t" + user.getRegDate());
			}
		}
	}

}
