package kr.ac.kopo.day05;
//main 을 가지고있는 클래스를 실행하는 것은 JVM이 실행한다.
//보통의 class는 객체를 만들어야 한다.
//main 메소드를 가지고 있는 클래스를 실행클래스라 부른다.
public class CarMain {
	public static void main(String[] args) {
		//힙영역에 자동차 한대를 만들었다. new 하는 순간 자동 초기화가 이루어 진다.
		Car c = new Car();
		System.out.println("c : " + c); //참조 주소값을 출력한다.
		System.out.println("브랜드명 : " + c.name + ", 가격 : " + c.price + "만원"); // 자동초기화가 이루어져 null,0이 출력
		
		c.name = "sonata"; //String이므로 값을 가리키고 있음
		c.price = 2500; // int형이므로 값을 가지고 있음
		
		Car c2 = new Car();
		System.out.println("c 브랜드명 : " + c.name + ", 가격 : " + c.price + "만원");
		//default 값을 출력한다.
		System.out.println("c2 브랜드명 : " + c2.name + ", 가격 : " + c2.price + "만원");
		
		c2.name = "모닝";
		c2.price = 1100;
		System.out.println("c2 브랜드명 : " + c2.name + ", 가격 : " + c2.price + "만원");
	}
}
