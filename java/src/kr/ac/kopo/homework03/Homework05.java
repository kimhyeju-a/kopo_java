package kr.ac.kopo.homework03;
/*
	배열을 이용하여 2 - 100 까지의 소수구하기
 */
public class Homework05 {
	public static void main(String[] args) {
		int[] nums = new int[101];
		//0과 1은 소수가 될 수 없으므로 0을 담는다.
		nums[0] = nums[1] = 0;
		
		//2 - 100 사이의 모든 정수를 배열에 담는다.
		for(int i = 2; i <= 100; i++) {
			nums[i] = i;
		}
		
		for(int i = 2; i <= 100; i++) {
			int j = i;
			//2의 배수, 3의배수 ... 를 0으로 만든다.
			while (i*j <= 100) {
				nums[i*j] = 0;
				j += 1;
			}
		}
		//nums[i] == 0이면 소수 이므로 !=0 일 때만 출력한다.
		for(int i = 0; i <= 100; i++) {
			if(nums[i] != 0) {
				System.out.print(nums[i]+ " ");
			}
		}
	}
}
