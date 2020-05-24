package kr.ac.kopo.exemTest;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "Hello";
		String str3 = new String("Hello");
		if(str1 == str2) {
		    System.out.println("같음");
		} // 같음 나옴
		if(str1 == str3) {
			System.out.println("같음");
		}else {
			System.out.println("다름");
		}
		
		int[][] arr = new int[3][3];
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));			
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j< arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int[] intArr : arr) {
			System.out.println(Arrays.toString(intArr));
		}
	}
}
