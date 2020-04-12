package kr.ac.kopo.homework02;
/*
	5. 다음의 설명을 보고 코드를 작성하세요.
	달팽이가 100M 깊이의 우물을 빠졌습니다
	달팽이는 1시간에 5M속도로 움직입니다
	올라온 높이가 50M미만일땐 1시간에 1M씩 미끌어지고
	50M이상일때 1시간에 2M씩 미끌어집니다
	달팽이가 총 몇시간만에 탈출하는지를 코드로 작성하세요.

 */
public class Homework05 {
	public static void main(String[] args) {
		//달팽이가 올라간 높이 total 과 , 시간 time 변수 선언
		int total = 0;
		int time = 0;
		
		while(total < 100) {
			time ++;
			//일단 5M 올라간후 50M보다 적은지 많은지 검사
			total += 5;
			//50 미만일 경우
			if(total < 50) {
				total -= 1;
			}
			//50이상일 경우
			else {
				total -= 2;
			}
			System.out.printf("[%d시간후] 달팽이가 올라간 총 높이 : %dM \n", time, total);
		}
	}
}
