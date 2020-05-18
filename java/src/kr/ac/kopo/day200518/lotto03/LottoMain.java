package kr.ac.kopo.day200518.lotto03;
/*
 * 로또 방송국
 */
public class LottoMain {

	public static void main(String[] args) {
		MC mc = new MC();
		try {
			mc.ment();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
