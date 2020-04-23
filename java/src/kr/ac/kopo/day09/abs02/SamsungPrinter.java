package kr.ac.kopo.day09.abs02;

public class SamsungPrinter extends Printer {

	private String name = "Samsung";
	
	public void samPrint() {
		System.out.println("삼성프린트 ...");
	}

	@Override
	public void print() {
		System.out.println("삼성프린트 ...");		
	}
}
