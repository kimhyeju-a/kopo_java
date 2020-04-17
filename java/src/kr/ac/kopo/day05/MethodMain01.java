package kr.ac.kopo.day05;

public class MethodMain01 {
	//피호출자 메소드 
	static void printStar(char c, int num) {
		for(int i = 0; i < num; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	static int factorial(int n) {
		int result = 1;
		for(int i = n; i <= 1; i--) {
			result = result *i;
		}
		return result;
	}
	//호출자 메소드
	public static void main(String[] args) {
		
		int result = factorial(3);
		System.out.println("3! ==> " + result);
		printStar('*', 10);
		System.out.println("Hello");
		printStar('#', 5);
		System.out.println("Hi");
		printStar('-', 20);
		System.out.println("GoodBye");
		printStar('!', 12);
	}
}
