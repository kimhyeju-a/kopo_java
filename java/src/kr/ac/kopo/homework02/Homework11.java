package kr.ac.kopo.homework02;
/*	  123456789
	0 ********* 9열까지		(9-0열) 
	1 -*******  8열까지		(9-1열)
	2 --*****   7열까지		(9-2열)
	3 ---***    6열까지		(9-3열)
	4 ----*     5열까지 있음	(9-4열)

	밑으로 내려갈수록 열이 1열씩 줄어들음 ==> 9-i열까지 반복
	
 */
public class Homework11 {
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 9-i; j++ ) {
				if( j < i) {
					System.out.print('-');
				}else {
					System.out.print('*');
				}
			}
			System.out.print('\n');
		}
	}
}
