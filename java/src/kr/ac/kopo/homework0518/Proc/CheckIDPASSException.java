package kr.ac.kopo.homework0518.Proc;

public class CheckIDPASSException extends Exception {

//	public static final int errorCode = 1;
	private static String [] errMsg = {"", "아이디가 올바르지 않습니다.", "패스워드가 잘못됐습니다."};
	
	public CheckIDPASSException() {
	}

	public CheckIDPASSException(String message) {
		super(message);
	}

	public CheckIDPASSException(int errorCode) {
		this(errMsg[errorCode]);
	}
}
