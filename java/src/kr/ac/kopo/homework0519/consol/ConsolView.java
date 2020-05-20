package kr.ac.kopo.homework0519.consol;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsolView {
	private Scanner sc;
	private ConsolUtil cu;
//	public static File dirObj = null;
	public ConsolView() {
		sc = new Scanner(System.in);
		cu = new ConsolUtil();
	}
	public void start() {
		ConsolUtil.dirObj = cu.firstDir();
		while(true) {
			startPrint(ConsolUtil.dirObj);
			dirListPrint(ConsolUtil.dirObj);
			cu = new ConsolUtil(ConsolUtil.dirObj);
			System.out.println("[C]폴더생성  [R]이름수정  [D]삭제  [cd]폴더이동  [Q]종료");
			System.out.print("선택 : ");
			String mode = sc.nextLine();
			switch(mode.toUpperCase()) {
			case "C" :
				cu.createDir();
				break;
			case "R" :
				cu.rename();
				break;
			case "D" :
				cu.delete();
				break;
			case "CD" :
				cu.changeDir();
				break;
			case "Q" :
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
	}



	private void startPrint(File dirObj) {
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("\t\t\t"+dirObj + " 폴더 정보"); 
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("이름\t\t\t종류\t\t크기\t\t마지막수정날짜");
		System.out.println("--------------------------------------------------------------------------");
	}

	private void dirListPrint(File dirObj) {
		File[] dirList = dirObj.listFiles();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:s");
		for(File name : dirList) {
			long lastTime = name.lastModified();
			System.out.println(name.getName() + tapCnt(name.getName().length())+checkType(name)+ "\t\t" 
								+(name.length() == 0 ? "":name.length()) +"\t\t"+ sdf.format(new Date(lastTime)));
		}
	}
	
	private String tapCnt(long length) {
		String tap;
		if(length < 8) {
			tap = "\t\t\t";
		}else if(length <16) {
			tap = "\t\t";
		}else if(length <24) {
			tap = "\t";
		}else {
			tap = "";
		}
		return tap;
	}
	
	private String checkType(File name) {
		
		return (name.isDirectory() ? "디렉토리" : "파일");
	}
}
