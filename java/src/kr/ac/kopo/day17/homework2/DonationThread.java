package kr.ac.kopo.day17.homework2;

public class DonationThread extends Thread {
	private Donation donation;
	private int callNum;
	private int total;

	public DonationThread(Donation donation, int callNum) {
		this.donation = donation;
		this.callNum = callNum;
		total = 0;
	}

	public synchronized void run() {
		for(int i = 0; i < 10; i++) {
			total += donation.donate(callNum);
		}
		System.out.println(callNum + "번 콜센터의 최종 모금액 : " + total);
	}
	
	public int getTotal() {
		return total;
	}
}