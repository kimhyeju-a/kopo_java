package kr.ac.kopo.homework05;

public class Calculator {
	int num1;
	int num2;
	
	Calculator(int num1, int num2){
		this.num1 = num1;
		this.num2 = num2;
		//사칙연산 수행
		add(num1,num2);
		minus(num1,num2);
		multiplication(num1,num2);
		division(num1,num2);
	}
	void add(int num1,int num2) {
		System.out.printf("%-3d + %-3d = %-3d\n", num1, num2, num1+num2);
	}
	void minus(int num1,int num2) {
		System.out.printf("%-3d - %-3d = %-3d\n", num1, num2, num1-num2);
	}
	void multiplication(int num1,int num2) {
		System.out.printf("%-3d * %-3d = %-3d\n", num1, num2, num1*num2);
	}
	//소수점 한자리까지만 출력
	void division(int num1,int num2) {
		System.out.printf("%-3d / %-3d = %.1f\n", num1, num2, (double)num1/num2);
	}
	//만약 소수가 아닌 것을 확인시 바로 false 리턴
	boolean sosu(int num) {
		for(int i = 2; i < num; i++) {
			if(num % 2 == 0)
				return false;
		}
		return true;
	}
}
