package kr.ac.kopo.account.user.service;

import kr.ac.kopo.account.user.dao.UserDAO;
import kr.ac.kopo.account.user.vo.UserVO;

public class UserService {

	private UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	public void insertUser(UserVO newUser) {
		userDAO.insertUser(newUser);
	}
	
	public void loginUser(String name, String password) {
		userDAO.loginUser(name, password);
	}

	public boolean idCheck(String id) {
		boolean bool = userDAO.idCheck(id);
		return bool;
	}

	public String findId(String phoneNumber) {
		String findId = userDAO.findId(phoneNumber);
		return findId;
	}

	public boolean changePassword(String findId,String changePassword) {
		boolean changePwd = userDAO.changePassword(findId, changePassword);
		return changePwd;
	}
}
