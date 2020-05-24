package kr.ac.kopo.account.user.service;

public class UserSequence {
	
	private static int userNo = 1;
	
	public static int getBoardSequence() {
		return userNo++;
	}
}
