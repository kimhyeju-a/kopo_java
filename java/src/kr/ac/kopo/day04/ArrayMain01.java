package kr.ac.kopo.day04;

public class ArrayMain01 {
	public static void main(String[] args) {
		
//		int[] arr; //The value of the local variable arr is not used (초기화 된 적이 없음)
//		System.out.println("arr : " + arr); //stack에 잡혀있는 변수는 자동으로 초기화되지 않기 때문에 오류가 난다.
		
		int[] arr = new int[5]; // [0] ~ [4]
		System.out.println("arr : " + arr);//heap영역에 있는 주소값이 출력된다 [arr : [I@15db9742]
		
		System.out.println("1번째 정수 : " + arr[0]); //int는 0으로 초기화
		System.out.println("2번째 정수 : " + arr[1]); //int는 0으로 초기화
		System.out.println("3번째 정수 : " + arr[2]); //int는 0으로 초기화
		System.out.println("4번째 정수 : " + arr[3]); //int는 0으로 초기화
		System.out.println("5번째 정수 : " + arr[4]); //int는 0으로 초기화
//		System.out.println("6번째 정수 : " + arr[5]); //ArrayIndexOutOfBoundsException: 5 예외 발생
		
		//5개의 변수에 10, 20, 30, 40, 50 대입
//		arr[0] = 10;
//		arr[1] = 20;
//		arr[2] = 30;
//		arr[3] = 40;
//		arr[4] = 50;
		for(int i = 0; i < arr.length ; i++) {
			arr[i] = (i+1) * 10;
		}
		System.out.println("<대입후 .. >");
		for(int i = 0; i < arr.length ; i++) {
			System.out.println(i+1 +"번째 정수 : " + arr[i]);
		}
		
//		System.out.println("1번째 정수 : " + arr[0]); //int는 0으로 초기화
//		System.out.println("2번째 정수 : " + arr[1]); //int는 0으로 초기화
//		System.out.println("3번째 정수 : " + arr[2]); //int는 0으로 초기화
//		System.out.println("4번째 정수 : " + arr[3]); //int는 0으로 초기화
//		System.out.println("5번째 정수 : " + arr[4]); //int는 0으로 초기화
	}
}
