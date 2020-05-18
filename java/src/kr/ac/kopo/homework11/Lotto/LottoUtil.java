package kr.ac.kopo.homework11.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class LottoUtil {

	Random r = new Random();
	/*
	 * For 문을 이용한 중복 제거	
	 */
	public void gameOne(int gameNum) {
		for(int i = 0; i < gameNum ; i++) {
			int[] lottoArr = new int[7];
			lottoArr[0] = r.nextInt(45) + 1;
			for(int j = 1; j < lottoArr.length; j++) {
				lottoArr[j] = r.nextInt(45) + 1;
				for(int k = j-1 ; k >= 0; k--) {
					if(lottoArr[j] == lottoArr[k]) {
						j--;
						break;
					}
				}
			}
			System.out.println(Arrays.toString(lottoArr));
		}
	}

	/*
	 	Set을 이용한 중복제거
	 	Set
	 		- 순서가 없다.
	 		- 중복을 허용하지 않는다. 
	 */
	public void gameTwo(int gameNum) {
		for(int i = 0; i < gameNum; i++) {
			Set<Integer> lottoSet = new HashSet<>();
			while(lottoSet.size() != 7) {
				lottoSet.add(r.nextInt(45) + 1);
			}
			System.out.println(Arrays.toString(lottoSet.toArray()));
		}
	}
	/*
		ArrayList를 이용한 중복제거
		List 
			- 순서 있음
			- 중복 허용 ==> lottoNum이 lottoList에 없을 경우 (lottoList.contains(lottoNum) != true)에만 넣음
	 */
	public void gameTree(int gameNum) {
		for(int i = 0; i < gameNum; i++) {
			List<Integer> lottoList = new ArrayList<>();
			while(lottoList.size() != 7) {
				int lottoNum = r.nextInt(45) + 1;
				if(lottoList.contains(lottoNum) != true) {
					lottoList.add(lottoNum);
				}
			}
			System.out.println(Arrays.toString(lottoList.toArray()));
		}
	}
	/*
		Map을 이용한 중복제거
		Map
			- 순서 없음
			- 키에 대한 중복 없음 ==> Key와 Value에 똑같은 값을 넣어 중복이 없도록 한다.
	 */
	public void gameFour(int gameNum) {
		for(int i = 0; i < gameNum; i++) {
			Map<Integer, Integer> lottoMap = new HashMap<>();
			while(lottoMap.size() != 7) {
				int lottoNum = r.nextInt(45) + 1;
				lottoMap.put(lottoNum,lottoNum);
			}
			System.out.println(lottoMap.keySet());
		}
	}
	
}
