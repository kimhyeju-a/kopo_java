package kr.ac.kopo.homework03;

import java.util.Scanner;

/*
	3. 다음의 결과를 보이는 코드를 작성하시오
	 1번째 정수 : 10
	 2번째 정수 : 5
	 10보다 큰수가 와야합니다
	 2번째 정수 : 12
	 3번째 정수 : 36
	 4번째 정수 : 6
	 10, 12, 36보다 큰수가 와야합니다
	 4번째 정수 : 22
	 10, 12, 36보다 큰수가 와야합니다
	 4번째 정수 : 40
	 5번째 정수 : 67
	
	 < PRINT >
	 10 12 36 40 67
	
	 < REVERSE >
	 76 4 63 21 1 
 */
public class Homework03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		int idx = 0;
		
		for(int i = 0; i < 5; i++) {
			System.out.print(i+1 +"번째 정수 : ");
			arr[i] = sc.nextInt();
			//idx가 0인경우 검사할 필요 없음
			if(i > 0 ) {
				//앞에 있는 수보다 작을 경우 출력
				if(arr[i] < arr[i-1]) {
					for(int k = 0; k < idx ; k++) {
						if(k == idx-1) 
							System.out.println(arr[k]+"보다 큰수가 와야합니다.");
						else
							System.out.print(arr[k]+", ");
					}
					//다시 검색을 하기 위해 i--, idx--를 수행한다.
					idx--;
					i--;
				}
			}
			idx++;
		}
		sc.close();
		
		
		System.out.println("\n< PRINT >");
		for(int i = 0 ; i < 5; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println("\n< REVERSE >");
		//역순 후, 다시 배열로 넣는 코드
		for(int i = 0 ; i < 5; i++) {
			int num = arr[i];
			arr[i] = 0;
			while(num != 0) {
				arr[i] = arr[i] * 10 + num % 10;
				num = num / 10;
			}
			/*
				823의 경우 while 들어갔을때
				arr[i] = 0 * 10 + 3 -> 3 * 10 + 2 -> 32 * 10 + 8 
				
			 */
		}
		for(int i = 0; i < 5; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
