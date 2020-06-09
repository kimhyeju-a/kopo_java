package kr.ac.kopo.day17.homework.donation;

import java.util.Random;

public class Donation {
	private int money;
	private int donationTotal[] = { 0, 0, 0, 0 };
	private int cnt[] = {0,0,0,0};
	private Random r = new Random();

	public synchronized void call(int callNum) {
		try {
			notify();
			int idx = callNum-1;
			money = 1000 * (r.nextInt(10) + 1);
			System.out.println(callNum + "번콜센터 : " + money + "원을 받았습니다.");
			donationTotal[idx] += money;
			++cnt[callNum-1];
			if(cnt[idx] == 10) {
				System.out.println(callNum + "번 콜센터에서의 총 모금액 : " + donationTotal[idx]);
			}
			Thread.sleep(10);
			notifyAll(); // 떙!
		} catch (Exception e) {
		}
	}

	public int[] getDonationTotal() {
		return donationTotal;
	}

	public void setDonationTotal(int[] donationTotal) {
		this.donationTotal = donationTotal;
	}
	
}
