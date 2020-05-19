package kr.ac.kopo.homework0519;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsolView {
	private Scanner sc;
	private ConsolUtil cu;
	File dirObj = null;
	public ConsolView() {
		sc = new Scanner(System.in);
	}
	public void start() {
		ConsolUtil.dirObj = askFolder();
		while(true) {
			startPrint(ConsolUtil.dirObj);
			dirListPrint(ConsolUtil.dirObj);
			cu = new ConsolUtil(ConsolUtil.dirObj);
			System.out.println("[C]폴더생성  [R]이름수정  [D]삭제  [.]상위폴더이동  [m]하위이동폴더이동  [Q]종료");
			System.out.print("선택 : ");
			String mode = sc.nextLine();
			switch(mode.toUpperCase()) {
			case "C" :
				cu.createDir();
				break;
			case "R" :
//				ConsolUtil.dirObj = cu.rename();
				break;
			case "D" :
				cu.delete();
				break;
			case "." :
				cu.parentMove();
				break;
			case "m" :
				cu.childMove();
				break;
			case "q" :
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
	}

	private File askFolder() {
		System.out.print("검색할 폴더명을 입력하세요 : ");
		String folder = sc.nextLine();
		ConsolUtil.dirObj = new File(folder);
		while(true) {
			if(ConsolUtil.dirObj.exists()) {
				System.out.println("유효한 폴더명 입니다.");
				break;
			}else {
				System.out.println("유효하지 않는 폴더명입니다.");
				System.out.print("검색할 폴더명을 입력하세요 : ");
				folder = sc.nextLine();
				ConsolUtil.dirObj = new File(folder);				
			}
		}
		return ConsolUtil.dirObj;
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
