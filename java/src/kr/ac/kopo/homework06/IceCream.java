package kr.ac.kopo.homework06;

public class IceCream {
	String 		name;
	int 		price;
	
	static int 	count;		// 몇 개를 구입했는지
	static int 	people;		// 몇 명이 구입했는지
	static int 	totalPrice;	// 총 판매액
	
	IceCream() {}
	IceCream(String name, int price){
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
