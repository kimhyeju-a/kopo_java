package kr.ac.kopo.day04;

public class ArrayMain03 {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int[] intCopy;
		
		intCopy = new int[arr.length];
		System.arraycopy(arr, 2, intCopy, 0, 3);
//		System.arraycopy(arr, 0, intCopy, 0, arr.length);
		
		/*
		for(int i = 0; i< arr.length; i++) {
			intCopy[i] = arr[i];
		}
		*/
		
		
		/*
		System.out.println("< arr의 모든 정수 출력 >");
		for(int num : arr) {
			System.out.println(num);
		}
		System.out.println("< intCopy의 모든 정수 출력 >");
		for(int num : intCopy) {
			System.out.println(num);
		}

		arr[2] = 100;
		System.out.println("< 변경된 arr의 모든 정수 출력 >");
		for(int num : arr) {
			System.out.println(num);
		}
		System.out.println("< intCopy의 모든 정수 출력 >");
		for(int num : intCopy) {
			System.out.println(num);
		}
		*/
		
		/*
		String[] strArr = {"폴리텍", "자바 ", "교육"};
		String[] copyArr = strArr;
		
		System.out.println("< strArr의 문자열 출력 > ");
		for(String str : strArr) {
			System.out.println(str);
		}
		System.out.println("< copyArr의 문자열 출력 > ");
		for(String str : copyArr) {
			System.out.println(str);
		}
		
		strArr[1] = "hello world";
		System.out.println("< 변경후 strArr의 문자열 출력 > ");
		//폴리텍 helloworld 교육
		for(String str : strArr) {
			System.out.println(str);
		}
		//폴리텍 자바 교육 기대하지만 폴리텍 helloworld교육이 출력된다.
		System.out.println("< copyArr의 문자열 출력 > ");
		for(String str : copyArr) {
			System.out.println(str);
		}
		*/
	}
}
