package kr.ac.kopo.homework01;

// 6. 알파벳이 모두 몇 자 인지 화면에 출력하시오 

public class Homework6 {
	public static void main(String[] args) {
		//a~z + A~Z = 52자
		int small = 'z' - 'a' + 1;
		int big = 'Z' - 'A' + 1;
		int total = small + big ; 
		System.out.println("개수 : " + total);
	}
}
