package kr.ac.kopo.day200518.lotto02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LottoView {
	private Scanner sc;
	
	public LottoView() {
		sc = new Scanner(System.in);
	}
	public void start() {
		
		System.out.print("게임 수를 입력  : ");
		int gameCount = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i <= gameCount ; i++) {
			System.out.println("게임 " + i + " : " + getLottoNums());
		}
	}
	private String getLottoNums() {
		final int LOTTO_MAX = 6;
		Random r = new Random();
		
		//방법5
		List<Integer> lottoNums = new ArrayList<>();
		List<Integer> nums = new ArrayList<>();
		for(int i = 1; i <= 45; i++) {
			nums.add(i);
		}
		//shuffle은 배열을 무작위로 섞어주는 것, Set은 안되고, List만 가능하다.
		Collections.shuffle(nums);
		
		for(int i = 0; i< LOTTO_MAX ; i++) {
			lottoNums.add(nums.get(i));
		}
		//방법 4
		/*
		Set<Integer> lottoNums = new HashSet<>();
		while(lottoNums.size()< LOTTO_MAX) {
			//set은 중복을 알아서 체크해 준다.
			lottoNums.add(r.nextInt(45)+1);
		}
		*/
		
		//방법3
		/*
		 * List는 참조변수만 가능하다.
		 */
		/*
		List<Integer> lottoNums = new ArrayList<>();
//		final int MAX = 6;
		while(lottoNums.size() < LOTTO_MAX) {
			int num = r.nextInt(45) + 1;
			if(!lottoNums.contains(num)) {
				lottoNums.add(num);
			}
		}
		*/
		return Arrays.toString(lottoNums.toArray());
	}
}
