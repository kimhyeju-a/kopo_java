package kr.ac.kopo.homework06;

import java.util.Scanner;

public class IceCreamMarket {
	IceCream[] iceArr;
	Scanner sc;
	
	IceCreamMarket() {
		sc = new Scanner(System.in);
	}
	
	int getInt(String msg) {
		System.out.print(msg);
		int num = sc.nextInt();
		sc.nextLine();
		
		return num;
	}
	
	String getStr(String msg) {
		System.out.print(msg);
		String str = sc.nextLine();
		
		return str;
	}
	
	void open() {
		int cnt = getInt("아이스크림 몇개 구입할래? : ");	
		iceArr = new IceCream[cnt];
		//static변수를 open할때마다 각자의 사용에 맞게 더해준다.
		IceCream.count += cnt;
		IceCream.people++;
		
		for(int i = 0; i < iceArr.length; i++) {
			System.out.println("*** " + (i+1) + "번째 구매정보 입력 ***");
			String name = getStr("아이스크림명 : ");
			int price = getInt("아이스크림가격 : ");
			IceCream.totalPrice += price;
			iceArr[i] = new IceCream(name, price);
		}
		print();
	}
	
	void print() {
		System.out.println("< 총 " + iceArr.length + "개 판매 정보 출력 > ");
		System.out.println("번호\t아이스크림명\t가격\t");
		for(int i = 0; i < iceArr.length; i++) {
			IceCream ice = iceArr[i];
			System.out.printf("%3d\t%-10s\t%5d\n", i+1, ice.getName(), ice.getPrice());
		}
		ask();
	}
	
	//계속 구매할지 물어보고 y/n이 아닌 다른글자를 입력한다면 again()함수로 보내 다시 입력하도록 한다.
	public void ask(){
		System.out.print("계속구매할래?(Y/N) => ");
		String answer = sc.nextLine();
		
		if(answer.equalsIgnoreCase("Y"))
			open();
		else if(answer.equalsIgnoreCase("N"))
			close();
		else
			again();
	}
	
	//y/n이 아닌 다른 글자를 입력했을 때 돌아감
	public void again() {
		System.out.println("잘못입력하셨습니다 Y/N 중에 입력해주세요 ");
		ask();
	}
	
	//N을 입력했을 때 돌아감
	public void close() {
		System.out.println("\n총 " + IceCream.people + "명의 고객이 아이스크림을 구매했습니다.");
		System.out.println("판매된 아이스크림 총개수 : " + IceCream.count + "개");
		System.out.println("총 판매액 : " + IceCream.totalPrice + "개");
	}
}
