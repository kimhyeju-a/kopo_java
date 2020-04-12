package kr.ac.kopo.homework02;
/*	 12345
	1***** 
	2-****
	3--***
	4---**
	5----*
	 12345
	6---**
	7--***
	8-****
	9*****
	
	라고 가정을 했을 때, 
	6행은 10-6-1 열(3열)까지 - 가 출력
	7행은 10-7-1 열(2열)까지 - 가 출력
	8행은 10-7-1 열(1열)까지 - 가 출력
 */
public class Homework10 {
	public static void main(String[] args) {
		for(int i = 1; i <= 9; i++) {
			if(i <= 5) {
				for(int j = 1; j <= 5; j++) {
					if(j < i) {
						System.out.print('-');
					}else {
						System.out.print('*');
					}
				}
			}else {
				for(int j = 1; j <= 5; j++) {
					if(j < 10-i) {
						System.out.print('-');
					}else {
						System.out.print('*');
					}
				}
			}
			System.out.print('\n');
		}
	}
}
