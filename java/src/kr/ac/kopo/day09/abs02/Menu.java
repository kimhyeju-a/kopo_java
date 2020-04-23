
package kr.ac.kopo.day09.abs02;

import java.util.Scanner;

public class Menu {
	private Scanner sc;
	public Menu() {
		sc = new Scanner(System.in);
	}
	public void execute() {
		System.out.print("프린터를 선택하세요 v2 (1. LG 2.삼성 3.HP) = >");
		int type = sc.nextInt();
		sc.nextLine();
		
		/*
		if(type == 1) {
			LGPrinter lg = new LGPrinter();
			lg.print();
		} else if(type == 2) {
			SamsungPrinter sam = new SamsungPrinter();
			sam.print();
//			sam.samPrint();
		} else if(type == 3) {
			HPPrinter hp = new HPPrinter();
			hp.print();
		}
		*/
		
		/*
		if(type == 1) {
			Printer lg = new LGPrinter();
			lg.print();
		} else if(type == 2) {
			Printer sam = new SamsungPrinter();
			sam.print();
		} else if(type == 3) {
			Printer hp = new HPPrinter();
			hp.print();
		}
		*/
		
		//상속에 있는 경우 , 자식의 인스턴스 주소값을 부모가 가질 수 있다. 
		//이렇게 쓸 수 있는 이유를 알기 위해 "객체의 형변환"을 알아야한다.
		Printer p = null;
		if(type == 1) {
			p = new LGPrinter();
		} else if(type == 2) {
			p = new SamsungPrinter();
		} else if(type == 3) {
			p = new HPPrinter();
		}
		p.print();
		
		
	}
}
