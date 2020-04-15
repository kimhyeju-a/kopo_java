package kr.ac.kopo.day04;

import java.util.Arrays;

public class ArrayMain02 {
	public static void main(String[] args) {
		//"폴리텍", "자바", "교육" 3개의 문자열을 저장하는 배열 strArr 생성
		//stack : 	heap : 
//		String[] strArr = {"폴리텍", "자바", "교육"};
		String[] strArr = new String[5]; //데이터 안넣은 상태로 출력시 null출력
		int loc = 0;
		
		strArr[loc++] = "폴리텍";
		strArr[loc++] = "자바";
		strArr[loc++] = "광명";
		strArr[loc++] = new String("교육"); // 위의 선언과의 차이점은 문자열 배울때 배움 
		
		/*
			배열의 모든 요소를 출력하는 3가지 방식
			1. index를 이용한 출력
			2. 1.5버전의 for문을 이용한 출력 foreach문
				for( 자료형 변수명 : 배열 ) {}
			3. Arrays.toString() 메소드를 이용한 출력
				Arrays.toString(배엶명) ==> "[첫번째요소, 두번째요소, 세번째요소, ..., 마지막요소]" 하나의 문자열을 만든다.
		 */
		System.out.println("< index를 이용한 출력 > ");
		for(int i = 0; i < strArr.length ; i++) {
			System.out.println(strArr[i]);
		}
		
		System.out.println("< 1.5버전의 for문을 이용한 출력 > ");
		for(String str : strArr) {
			System.out.println(str);
		}
		
		System.out.println("< Arrays.toString() 메소드를 이용한 출력 > ");
		System.out.println(Arrays.toString(strArr)); //배열을 하나의 문자열로 출력함
	}
}
