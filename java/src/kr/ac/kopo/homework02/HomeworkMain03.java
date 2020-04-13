package kr.ac.kopo.homework02;

public class HomeworkMain03 {
	public static void main(String[] args) {
		
		int step = 3;
		for(int dan = 2; dan <= 9; dan = dan + step) {
			for(int i = 0; i <= 9; i++) {
				for(int j = dan ; j <= 9 && j < dan + step ; j++) {
					if(i == 0)
						System.out.printf("*** %d단 ***\t", j);
					else
						System.out.printf("%d * %d = %d\t", j, i, j * i);
				}
				System.out.println();
			}
			System.out.println();
		}
		
		/*
		for(int dan = 2; dan <= 9; dan = dan +3) {
			for(int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\t", dan, i, dan * i);
				System.out.printf("%d * %d = %d\t", dan+1, i, (dan+1) * i);
				if(dan + 2 <= 9) {
					System.out.printf("%d * %d = %d\t", dan+2, i, (dan+2) * i);					
				}
				System.out.println();
			}
			System.out.println();
		}
		*/
	}
}
