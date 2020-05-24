package kr.ac.kopo.account.user.service;

public class UserServiceFactory {

	private static UserService service = null;
	
	public static UserService getUserService() {
		if(service == null) {
			service = new UserService();
		}
		return service;
	}
}
