package kr.ac.kopo.day03;
//바깥에 있는 for문은 행을 말한다.

public class LoopMain02 {
	
	public static void main(String[] args) {
		
		/*
			*****
			 ****
			  ***
			   **
			    *
			  
		 */
		//방법1 
		/*
		for(int i = 1; i <= 5 ; i++) {
			for(int j = 1; j <= i-1; j++) {
				System.out.print(' ');
			}
			for(int k = i ; k <= 6-i; k++) {
				System.out.print('*');
			}
			System.out.print('\n');
		}
		*/
		
		/*
		 12345
		 *****	i=1
		  ****	i=2
		   ***	i=3
		    **	i=4
		     *	i=5
			  
		 */
		//방법2 
		for(int i = 1; i <= 5 ; i++) {
			for(int j = 1; j <= 5; j++) {
				if(j < i) {
					System.out.print(' ');
				}else {
					System.out.print('*');
				}
			}
			System.out.print('\n');
		}
		
		
		
		/*
			12345
			12345
			12345
			12345
		 */
		/*
		for(int i = 1; i <= 5 ; i++) {
			for(int j = 1; j <= 5 ; j++) {
				System.out.print(j);
			}
			System.out.print('\n');
		}
		*/
		
		/*
			*
			**
			***
			****
			*****
		 */
		/*
		for (int i = 0; i < 5; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print('*');
			}
			System.out.print('\n');
		}
		*/
		
		/*
			*****
		 */
		/*
		for(int i = 0; i < 3 ; i++) {
			for(int j = 1; j <= 5 ; j++) {
				System.out.print('*');
			}
			System.out.print('\n');
		}
		*/
	}

}
