package kr.ac.kopo.homework0519;

import java.io.File;
import java.util.Scanner;

public class ConsolUtil {
	public static File dirObj = null;
	private Scanner sc = new Scanner(System.in);
	
	public ConsolUtil(File dirObj) {
		
	}

	public void createDir() {
		System.out.print("mkdir() 폴더명을 입력하세요 : ");
		String mkdirName = sc.nextLine();
		File newDirObj = new File(dirObj.getName()+"\\"+mkdirName);
		while(true) {			
			if(newDirObj.mkdir()) {
				System.out.println(mkdirName + " 생성 완료");
				break;
			}else {
				System.out.println(mkdirName + " 생성 실패");
				System.out.print("mkdir() 폴더명을 입력하세요 : ");
				mkdirName = sc.nextLine();
				newDirObj = new File(dirObj.getName()+"\\"+mkdirName);
			}
		}
	}

//	public File rename() {
//		System.out.println("현재 폴더명은 " + dirObj.getName());
//		boolean bool = dirObj.exists();
//		System.out.println(bool ? "있음" : "없음");
//		System.out.print("renameTo() 변경할 폴더명을 입력하세요 : ");
//		String renameName = sc.nextLine();
//		File newDirObj = new File(renameName);
//		bool = dirObj.renameTo(newDirObj);
//		return dirObj;
//	}

	public void delete() {
		if(dirObj.delete()) {
			System.out.println(dirObj.getName() + " 삭제완료");
		}else {
			System.out.println(dirObj.getName() + " 삭제실패 다시 시도해주세요");
		}
	}

	public void parentMove() {
		
	}

	public void childMove() {
		// TODO Auto-generated method stub
		
	}

}
