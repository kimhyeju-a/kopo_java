package kr.ac.kopo.account.manager.service;

import java.util.List;

import kr.ac.kopo.account.manager.dao.ManagerDAO;
import kr.ac.kopo.account.user.vo.UserVO;
import kr.ac.kopo.account.vo.AccountVO;

public class ManagerService {

	private ManagerDAO managerDAO;
	public ManagerService() {
		managerDAO = new ManagerDAO();
	}
	public List<UserVO> mgrUserAll() {
		List<UserVO> list = managerDAO.mgrUserAll();
		return list;
	}
	public boolean mgrUserDelete(int userNo) {
		boolean bool = managerDAO.mgrUserDelete(userNo);
		return bool;
	}
	public List<AccountVO> mgrAccountAll() {
		List<AccountVO> list = managerDAO.mgrAccountAll();
		return list;
	}
	public boolean mgrAccountDelete(String deleteAccount) {
		boolean bool = managerDAO.mgrAccountDelete(deleteAccount);
		return bool;
	}
}
