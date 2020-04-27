package kr.ac.kopo.day11;

public class ExceptionMain05 {

	public static void main(String[] args) {
		System.out.println("main start");
		for(int i = -2; i < 3 ; i++) {
			System.out.println("for문 진입 ... [ " + i + "]");
			try {
				System.out.println(10 / i);// 0때문에 에러 생김
			} catch(Exception e) {
				e.printStackTrace();
				break;
			}finally {
				System.out.println("for문 종료 ...");
		
			}
		}
		System.out.println("main end");
	}
}
