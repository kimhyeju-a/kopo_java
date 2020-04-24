package kr.ac.kopo.homework08;

import java.util.Random;
import java.util.Scanner;

public class Menu {

	private Scanner sc;
	Random r = new Random();
	
	Menu(){
		sc = new Scanner(System.in);
	}
	
	public void execute() {
		while (true) {
			System.out.print("도형을 선택하세요(1. 직사각형, 2. 정사각형, 3.삼각형, 4.원, 5.종료) ==> ");
			int ch = sc.nextInt();
			//ch가 5 이면 종료
			if(ch == 5) {
				System.out.println("종료");
				break;
			}
			Shape shape = null;
			switch (ch) {
			//호출과 동시에 생성자 호출
			case 1:
				shape = new Rectangle(rand(), rand());
				break;
			case 2:
				shape = new Square(rand());
				break;
			case 3:
				shape = new Triangle(rand(),rand());
				break;
			case 4:
				shape = new Circle(rand());
				break;
			default:
				System.out.println("잘못 입력했습니다. 다시 입력하세요");
				execute();
			}
			shape.area();
			shape.print();
		}
	}
	
	//매번 r.nextInt(11) + 2 를 써주기 힘드므로 메소드로 만듦
	public int rand() {
		return r.nextInt(9) + 2;
	}
}
