package kr.ac.kopo.homework02;

/*	  123456789
	1 *-------*
	2 **-----**
	3 ***---***
	4 ****-****
	5 *********
	6 ****-****
	7 ***---***
	8 **-----**
	9 *-------*

 */
public class Homework12 {
	public static void main(String[] args) {
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <=9; j++) {
				/* 
					5행기준으로 자름 1~5
					1행 : 1열, 9열에 *			==> 1(j<=i) 9(j>=10-i)
					2행 : 1,2열 / 8,9 열에 *	==> 1,2(j<=i) 8,9(j>=10-i)
					3행 : 1,2,3열 / 7,8,9 열에 *==> 1,2,3(j<=i) 7,8,9(j>=10-i)
					...
				*/
				if(i <= 5) {
					if(j > i) {
						if(j >= 10-i) {
							System.out.print('*');
						}
						else {							
							System.out.print('-');
						}
					}else {
						System.out.print('*');
					}
				}
				/*
					6행	: 1,2,3,4열 / 6,7,8,9열에 *	==> 1,2,3,4(j <= 10-i) 6,7,8,9(i<=j)
					7행	: 1,2,3열 / 7,8,9,열에 *		==> 1,2,3 (j<=10-i), 7,8,9(i<=j)
					8행	: 1,2열 / 8,9열에 *			==> ...
					...
				 */
				else{
					if(j < i) {
						if(j <= 10-i) {
							System.out.print('*');
						}
						else {							
							System.out.print('-');
						}
					}else {
						System.out.print('*');
					}
				}
			}
			System.out.print('\n');
		}
	}
}
