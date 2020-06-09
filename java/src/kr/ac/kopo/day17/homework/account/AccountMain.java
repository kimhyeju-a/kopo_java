package kr.ac.kopo.day17.homework.account;

import java.util.Random;
/*
 *	교수님 ㅠ_ㅠ 저는 Account와 User는 하나의 객체들로 보고 
 *	ATM(extends Thread)과 ATMAction(deposit, withdraw)을 만들어서 하고 싶었는데...
 *	잘 되지 않았습니다............. 혹시 ..... 나중에 시간되실 때.....
 *
 *	위와 같이 행위들은 class로 따로 만들어서 하는 방식 리뷰해주실 수 있나요..?  
 * 	위와 같은 방법은 좋지 않은 방법인가요 ...?
 */

public class AccountMain {
	public static void main(String[] args) {
		Account ac = new Account("홍길동", 10000);
		User user1 = new User("홍길동", ac);
		User user2 = new User("어머니", ac);
		User user3 = new User("아버지", ac);
		user1.start();
		user2.start();
		user3.start();
	}
}
