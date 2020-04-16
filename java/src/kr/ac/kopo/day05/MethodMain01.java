package kr.ac.kopo.day05;

public class MethodMain01 {
	//피호출자 메소드 
	static void printStar(char c, int num) {
		for(int i = 0; i < num; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	//호출자 메소드
	public static void main(String[] args) {
		printStar('*', 10);
		System.out.println("Hello");
		printStar('#', 5);
		System.out.println("Hi");
		printStar('-', 20);
		System.out.println("GoodBye");
		printStar('!', 12);
	}
}
