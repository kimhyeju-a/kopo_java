package kr.ac.kopo.day06;

import java.util.Arrays;

public class ExamMethodMain {

	public static void main(String[] args) {
		
		//인스턴스 객체생성
		ExamMethod exam = new ExamMethod();
		
		int sum = exam.getSum(1, 10); 	//두개의 정수의 합이 얼마인지
		int totalSum = exam.getTotalSum(1, 10);	//두 정수 사이의 합
		System.out.println("1 + 10 = " + sum);
		System.out.println("1 ~ 10 의 총합 " + totalSum);
		
		int[] nums = exam.getNums();
		System.out.println("추출된 난수 : " + Arrays.toString(nums));
		
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = exam.getNum();
		// 1 ~ 100 사이의 난수를 size개만큼 추출
		nums = exam.getNums(size);
		
		System.out.println("추출된 난수 : " + Arrays.toString(nums));
		
		System.out.print("1 - 100 사이의 정수 입력 : ");
		int max = exam.getNum();
		
		// 1 ~ max 사이의 난수를 size개만큼 추출
		nums = exam.getNums(max, size);
		System.out.println("추출된 난수 : " + Arrays.toString(nums));
		
	}
	
}
