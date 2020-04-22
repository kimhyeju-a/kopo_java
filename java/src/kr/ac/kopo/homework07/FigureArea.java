package kr.ac.kopo.homework07;

import java.util.Random;
import java.util.Scanner;

//도형 클래스를 상속받아 가로, 세로, 반지름 값을 저장
public class FigureArea extends Figure {
	// 상수 final처리
	final double PI = 3.141592;

	private int ch; // 무슨 도형 면적할것인지
	private double area; // 도형의 면적을 담는 변수, 삼각형과 원을 저장하기 위해 실수형으로 선언

	Random r = new Random();
	Scanner sc;

	FigureArea() {
		sc = new Scanner(System.in);
	}

	public void channel() {
		while (true) {
			System.out.print("도형을 선택하세요(1. 직사각형, 2. 정사각형, 3.삼각형, 4.원, 5.종료) ==> ");
			ch = sc.nextInt();
			//ch가 5 이면 종료
			if(ch == 5) {
				end();
				break;
			}
			switch (ch) {
			case 1:
				rect();
				print("직사각형");
				break;
			case 2:
				square();
				print("정사각형");
				break;
			case 3:
				triangle();
				print("삼각형");
				break;
			case 4:
				circle();
				print("원");
				break;
			default:
				again();
			}
		}
	}

	public double rect() {
		setHorizontal(r.nextInt(9) + 2);
		setVertical(r.nextInt(9) + 2);

		area = getHorizontal() * getVertical();
		return area;
	}

	public double square() {
		int num = r.nextInt(9) + 2;
		// 정사각형은 가로세로 같으니 num을 넘겨줌
		setHorizontal(num);
		setVertical(num);

		area = getHorizontal() * getVertical();
		return area;
	}

	public double triangle() {
		setHorizontal(r.nextInt(9) + 2);
		setVertical(r.nextInt(9) + 2);

		area = (double) getHorizontal() * getVertical() / 2;
		return area;
	}

	public double circle() {
		setRound(r.nextInt(9) + 2);
		int num = getRound();
		area = num * num * PI;
		return area;
	}

	public void end() {
		System.out.println("시스템 종료!!!");
	}

	public void again() {
		System.out.println("잘못 입력하셨습니다. 다시 입력해주세요 \n");
		channel();
	}
	
	public void print(String msg) {
		// 각 도형에 맞게 조건문 작성
		String printMsg = "";
		if(msg.equals("직사각형")) {
			printMsg = "가로 : " +this.getHorizontal() + ", 세로 : " + this.getVertical();
		}else if(msg.equals("정사각형")){
			printMsg = "가로 : " + this.getHorizontal();
		}else if(msg.equals("삼각형")) {
			printMsg = "가로 : " + this.getHorizontal() + ", 높이 : " + this.getVertical();
		}else {
			printMsg = "반지름 : " + this.getRound();
		}
		System.out.println(printMsg + " 의 " + msg + " 은/는 " + this.area + "입니다.\n");
	}
}
