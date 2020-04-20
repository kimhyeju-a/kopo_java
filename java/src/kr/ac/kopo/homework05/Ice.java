package kr.ac.kopo.homework05;

public class Ice {
	
	String name;
	int price;
	
	Ice() {}
	Ice(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	
	String getName() {
		return name;
	}
	
	int getPrice() {
		return price;
	}
}
