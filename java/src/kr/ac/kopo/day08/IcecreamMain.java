package kr.ac.kopo.day08;

public class IcecreamMain {

	public static void main(String[] args) {
		
		Icecream ice = new Icecream("비비빅", 1000);
		//아이스크림 가격 800원으로 수정 private 이므로 set이라는 메소드를 사용하여 변경
		ice.setPrice(800);
		System.out.println("아이스크림명 : " + ice.getName());
		System.out.println("아이스크림가격 : " + ice.getPrice() + "원");
	}
}
