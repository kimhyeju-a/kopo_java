package kr.ac.kopo.homework05;

import java.util.Scanner;
/*
	1. 메소드를 이용하여 아이스크림 출력
 */
public class iceCreamMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이스크림 몇개 구입할래? : ");
		int num = Integer.parseInt(sc.nextLine());
		sc.close();
		//iceCream클래스 안의 매소드를 사용하기 위해 ice객체 만듦
		iceCream ice = new iceCream();
		
		
		/*
			클래스에서 바로 
			방법 1. iceCream 클래스의 setIce에서 바로 printIce 호출
			방법 2. main에서 printIce 호출
			
			무슨방법이 더 좋을까요 교수님..? 
			사실 방법1,2 모두 완전히 객체지향적인것 같진 않은데 어떻게 메소드를 만들지 감이 안잡혀  일단 구현만 해놨습니다 ㅠㅠ
		 */
		//iceCream[] 형태의 변수를 선언하여 setIce에서 리턴받은 값저장
		iceCream[] iceSet = ice.setIce(num);	
		ice.printIce(iceSet);
	}
}
