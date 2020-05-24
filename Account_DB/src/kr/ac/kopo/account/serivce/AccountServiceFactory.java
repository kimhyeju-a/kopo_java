package kr.ac.kopo.account.serivce;

public class AccountServiceFactory {

	private static AccountService service = null;
	
	public static AccountService getAccoutService() {
		if(service == null) {
			service = new AccountService();
		}
		return service;
	}
}
