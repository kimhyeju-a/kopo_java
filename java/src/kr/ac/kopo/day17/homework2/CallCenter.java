package kr.ac.kopo.day17.homework2;

public class CallCenter {

	public static void main(String[] args) {
		Donation donation = new Donation();
		
		DonationThread nt01 = new DonationThread(donation, 1);
		DonationThread nt02 = new DonationThread(donation, 2);
		DonationThread nt03 = new DonationThread(donation, 3);
		DonationThread nt04 = new DonationThread(donation, 4);
		
		nt01.start();
		nt02.start();
		nt03.start();
		nt04.start();
		try {
			nt01.join();
			nt02.join();
			nt03.join();
			nt04.join();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		int total = nt01.getTotal() + nt02.getTotal() + nt03.getTotal() + nt04.getTotal();
		System.out.println("총 모금액은 : " + total + "입니다");
	}

}