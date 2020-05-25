package kr.ac.kopo.account.manager.service;

import java.util.List;

import kr.ac.kopo.account.manager.dao.ManagerDAO;
import kr.ac.kopo.account.user.vo.UserVO;

public class ManagerService {

	private ManagerDAO managerDAO;
	
	public List<UserVO> mgrUserAll() {
		List<UserVO> list = managerDAO.mgrUserAll();
		return list;
	}

}
