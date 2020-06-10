package kr.ac.kopo.day17.homework.donation;

public class CallCenter extends Thread {
	private Donation donation;
	private int callNum;

	public CallCenter(Donation donation, int callNum) {
		this.donation = donation;
		this.callNum = callNum;
	}

	@Override
	public synchronized void run() {
		for (int i = 0; i < 10; i++) {
			donation.call(callNum);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
