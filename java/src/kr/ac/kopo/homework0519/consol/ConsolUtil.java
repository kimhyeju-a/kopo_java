package kr.ac.kopo.homework0519.consol;

import java.io.File;
import java.util.Scanner;


public class ConsolUtil {
	static File dirObj = null;
	private Scanner sc = new Scanner(System.in);

	public ConsolUtil() {
	}

	public ConsolUtil(File dirObj) {
		ConsolUtil.dirObj = dirObj;
	}

	// 루트폴더설정
	public File firstDir() {
		ConsolUtil.dirObj = new File("ioTestHomework");
		boolean bool = ConsolUtil.dirObj.exists();
		if (!bool) {
			ConsolUtil.dirObj.mkdir();
		}
		return ConsolUtil.dirObj;
	}

	// [c]
	public void createDir() {
		System.out.print("mkdir() 폴더명을 입력하세요 : ");
		String mkdirName = sc.nextLine();
		File newDirObj = new File(dirObj.getPath() + "\\" + mkdirName);
		while (true) {
			if (newDirObj.mkdir()) {
				System.out.println(mkdirName + " 생성 완료");
				break;
			} else {
				System.out.println(mkdirName + " 생성 실패");
				System.out.print("mkdir() 폴더명을 입력하세요 : ");
				mkdirName = sc.nextLine();
				newDirObj = new File(dirObj.getName() + "\\" + mkdirName);
			}
		}
	}

	// [R]
	public void rename() {
		System.out.print("변경할 폴더명을 입력하세요 : ");
		String oldName = sc.nextLine();
		File oldDir = new File(dirObj.getPath() + "\\" + oldName);
		if (!oldDir.exists()) {
			System.out.println("파일명을 확인해주세요.");
		} else {
			System.out.print("새로운 폴더명을 입력하세요 : ");
			String newName = sc.nextLine();
			File newDir = new File(dirObj.getPath() + "\\" + newName);
			System.out.println(oldDir.renameTo(newDir) ? "성공" : "실패");
		}

	}

	// [D]
	public void delete() {
		System.out.print("삭제할 폴더명을 입력하세요 : ");
		String deleteName = sc.nextLine();
		File deleteDir = new File(dirObj.getPath() + "\\" + deleteName);
		if (deleteDir.delete()) {
			System.out.println(deleteDir.getName() + " 삭제완료");
		} else {
			System.out.println(dirObj.getName() + " 삭제실패 다시 시도해주세요[하위폴더가 있을 수 있음.]");
		}
	}
	
	// [CD] move를 .과 하위 디렉토리 이동을 묶었습니다!
	public void changeDir() {
		System.out.print("cd [./../하위디렉토리명/경로(isTestHomework/)만가능]");
		System.out.print("cd ");
		String mode = sc.nextLine();
		if (mode.equals(".") || mode.equals("..")) {
			parentMove(mode);

		} else if (!mode.startsWith("isTestHomework")) {
			childMove(mode);

		} else if (mode.startsWith("isTestHomework")) {
			File cdDirObj = new File(mode);
			if (!cdDirObj.exists()) {
				System.out.println("폴더명이 존재하지 않습니다.");
			} else {
				dirObj = cdDirObj;
			}
		} else {
			System.out.println("잘못입력했습니다.");
		}
	}

	private void parentMove(String mode) {
		switch (mode) {
		case ".":
			dirObj = new File(dirObj.getParent());
			break;
		case "..":
			dirObj = firstDir();
			break;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
		}
	}

	private void childMove(String cdDirName) {
		File cdDirObj = new File(dirObj.getPath() + "\\" + cdDirName);
		if (!cdDirObj.exists()) {
			System.out.println("폴더명이 존재하지 않습니다.");
		} else {
			dirObj = cdDirObj;
		}
	}

}
