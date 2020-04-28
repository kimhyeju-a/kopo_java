package kr.ac.kopo.homework10;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {
	Scanner sc = new Scanner(System.in);
	static int[] lottoNum = new int[7];
	static int lottoIdx = 0;

	public void lottoStart() {
		//로또번호 7개를 받을때 까지 반복문
		while (lottoIdx < 7) {
			try {
				System.out.print("좋아하는 로또 번호를 입력하세요. : ");
				int num = sc.nextInt();
				//만약 num이 1-45 가 아니면 예외처리
				if (num < 1 || num > 45) {
					throw new LottoNumberException("1 - 45 만 가능합니다. " + num + "은 불가능");
				}
				// 사용자가 입력하는 LottoNum
				lottoNum[lottoIdx++] = num;
				// 임의로 지정하는 Lotto번호
				for (int i = 0; i < lottoIdx; i++) {
					if (i > 0) {
						System.out.print("," + lottoNum[i]);
					} else {
						System.out.print(lottoNum[i]);

					}
				}
				System.out.println("를 포함한 Lotto 번호 ");
				int Idx = lottoIdx;
				while (Idx != 7) {
					Random r = new Random();
					lottoNum[Idx++] = r.nextInt(45) + 1;
				}
				System.out.println(Arrays.toString(lottoNum));
			} catch (Exception e) {
				/*
				 * 좋아하는 로또 번호를 입력하세요. : at kr.ac.kopo.homework10.Lotto.lottoStart(Lotto.java:17)
				 * 예외처리문이랑 출력문이랑 윗줄과 같이 나올때가있는데 이거를 고치는 법은 무엇일까요..? 제가 원하는 출력문은
				 * 
				 * at kr.ac.kopo.homework10.Lotto.lottoStart(Lotto.java:17) at
				 * kr.ac.kopo.homework10.Lotto.lottoStart(Lotto.java:31) at
				 * kr.ac.kopo.homework10.LottoMain.main(LottoMain.java:9) 좋아하는 로또 번호를 입력하세요 :
				 * 
				 * 입니다 ㅠㅠㅠㅠ
				 */
				System.out.println(e.getMessage());
				e.printStackTrace();
				lottoStart();
			}
		}
	}
}
