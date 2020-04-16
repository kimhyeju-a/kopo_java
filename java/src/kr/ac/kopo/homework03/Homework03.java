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
/*	수정 완료!
	혜주씨 과제하느라 고생하셨어요~~
	근데 reverse요... 결과 잘보세요.
	제가 원했던대로 출력이 되지는 않아요.
	조금만 수정해주시면 될거 같습니다

	그리고 작은수 입력시 다시 입력하게 하는 체크문장 코드가 좀 복잡하죠???
	조금더 효율적으로 작성할 수 있는 방법을 생각해봅시다!!!
*/
public class Homework03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		for(int i = 0; i < arr.length;) {
			System.out.print(i+1 +"번째 정수 : ");
			arr[i] = Integer.parseInt(sc.nextLine());
			if(i > 0 &&arr[i-1] >= arr[i]) {
				for(int j = 0; j < i ; j++) {
					//다시보기
					if(j != 0) {
						System.out.print(", ");
					}
					System.out.print(arr[j] + " ");
				}
				System.out.println("보다 큰수를 입력");
			}else {
				i++;
			}
		}

		System.out.println("< PRINT >");
		for(int num : arr) {
			System.out.print(num + "\t");
		}
		System.out.println();
		System.out.println("\n< REVERSE >");
		
		//역순 후, 다시 배열로 넣는 코드
		for(int i = 0 ; i < 5; i++) {
			int num = arr[i];
			arr[i] = 0;
			while(num != 0) {
				arr[i] = arr[i] * 10 + num % 10;
				num = num / 10;
			}

		}
		for(int i = arr.length-1; i >= 0; i--) {
			System.out.print(arr[i]+"\t");
		}
		
		
		/*
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

		}
		for(int i = 0; i < 5; i++) {
			System.out.print(arr[i]+" ");
		}
		
		*/
	}
}
