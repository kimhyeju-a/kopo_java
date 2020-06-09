package kr.ac.kopo.day17.homework.donation;

import java.util.Random;

public class DonationMain {
	public static void main(String[] args) {
		Donation donation = new Donation();
		int total = 0;
		// 두개의 thread가 공유영역을 사용하고 싶다.
		CallCenter c1 = new CallCenter(donation,1);
		CallCenter c2 = new CallCenter(donation,2);
		CallCenter c3 = new CallCenter(donation,3);
		CallCenter c4 = new CallCenter(donation,4);

		c1.start();
		c2.start();
		c3.start();
		c4.start();
		
		try {
			c1.join();
			c2.join();
			c3.join();
			c4.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(int money : donation.getDonationTotal()) {
			total += money;
		}
		System.out.println("국민들이 보내주신 성금 총 액 : " + total);
	}
}
